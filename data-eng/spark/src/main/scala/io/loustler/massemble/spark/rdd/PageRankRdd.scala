package io.loustler.massemble.spark.rdd

import io.loustler.massemble.spark.builder.SparkContextBuilder
import org.apache.spark.HashPartitioner
import org.apache.spark.rdd.RDD

/**
  * 효과적으로 RDD가 파티셔닝되고 네트워크 통신을 최소화하기 위해 여러가지 일을 함
  *
  * 1. `links RDD`가 `ranks`와 매 주기마다 조인된다. links는 고정된 데이터 세트이므로 시작지점에서 바로 `partitionBy`를 적용하였고,
  *    그 덕분에 `links`는 네트워크 셔플링 할 필요가 없다. `links`는 `ranks`가 가지고 있는 Double 타입 데이터 대신 이웃리스트를 갖고 있으므로
  *     바이트 사이즈가 `ranks`보다 매우 클 확률이 높으므로, 이 최적화는 단순하게 페이지 랭크를 구현할 때보다 네트워크 트래픽을 크게 절약해준다.
  * 2. 같은 이유로 `links`에 대해 `persist`로 미리 호출하여 알고리즘이 반복되는 동안 메모리에 올려둔다
  * 3. `ranks`를 처음 만들 때 부모 RDD `links`의 파티셔닝을 유지하기 위해 `map`이 아닌 `mapValues`를 사용하여 초기 조인에 대한 부담감을 줄인다
  * 4. 루프 내에서 `reduceByKey` 다음에 `mapValues`를 호출했다. `reduceByKey`의 결과는 이미 해시 파티셔닝되어 있고, `mapValues`를 사용해
  *    이를 유지함으로써 다음 차례의 반복 주기에서 매핑된 결과와 `links`의 조인을 더 효율적으로 만든다.
  *
  * partitionBy가 `Key`를 이용해서 파티셔닝을 하게 되므로 key가 변경이 되면 파티셔닝을 다시 진행함. 따라서 key에는 영향을 주지 않는 `mapValues`와
  * 같은 것을 사용
  */
object PageRankRdd {

  def main(args: Array[String]): Unit = {
    val sc = SparkContextBuilder.default("PageRankRDD")

    val links: RDD[(String, Seq[String])] = sc
      .objectFile[(String, Seq[String])]("path")
      .partitionBy(new HashPartitioner(100))
      .persist()

    var ranks: RDD[(String, Double)] = links.mapValues(_ => 1.0d)

    for (i <- 0 until 10) {
      val contributions: RDD[(String, Double)] = links.join(ranks).flatMap {
        case (pageId, (links, rank)) =>
          links.map(dest => (dest, rank / links.size))
      }

      ranks = contributions
        .reduceByKey {
          case (x, y) => x + y
        }
        .mapValues(v => 0.15 + (0.85 * v))
    }

    ranks.saveAsTextFile("ranks")
  }
}
