/*
Pivoting data1

Result:
 category | JAN | FEB | MAR | APR | MAY
----------+-----+-----+-----+-----+-----
 Fashion  | 201 | 228 | 346 | 543 |   0
 Food     | 420 | 333 | 490 | 527 |   0
 Beauty   |  93 | 232 | 182 | 262 |   0
*/
SELECT "category",
       SUM(CASE WHEN SUBSTRING("date"::TEXT, 1, 7) = '2020-01' THEN "count" ELSE 0 END) AS "JAN",
       SUM(CASE WHEN SUBSTRING("date"::TEXT, 1, 7) = '2020-02' THEN "count" ELSE 0 END) AS "FEB",
       SUM(CASE WHEN SUBSTRING("date"::TEXT, 1, 7) = '2020-03' THEN "count" ELSE 0 END) AS "MAR",
       SUM(CASE WHEN SUBSTRING("date"::TEXT, 1, 7) = '2020-04' THEN "count" ELSE 0 END) AS "APR",
       SUM(CASE WHEN SUBSTRING("date"::TEXT, 1, 7) = '2020-05' THEN "count" ELSE 0 END) AS "MAY"
FROM data1
GROUP BY "category";


/*
Unpivoting data1

FROM

 category | JAN | FEB | MAR | APR | MAY
----------+-----+-----+-----+-----+-----
 Fashion  | 201 | 228 | 346 | 543 |   0
 Food     | 420 | 333 | 490 | 527 |   0
 Beauty   |  93 | 232 | 182 | 262 |   0

Result:
 category | count | year_month
----------+-------+------------
 Fashion  |   201 | 2020-01
 Food     |   420 | 2020-01
 Beauty   |    93 | 2020-01
 Fashion  |   228 | 2020-02
 Food     |   333 | 2020-02
 Beauty   |   232 | 2020-02
 Fashion  |   346 | 2020-03
 Food     |   490 | 2020-03
 Beauty   |   182 | 2020-03
 Fashion  |   543 | 2020-04
 Food     |   527 | 2020-04
 Beauty   |   262 | 2020-04
 Fashion  |     0 | 2020-05
 Food     |     0 | 2020-05
 Beauty   |     0 | 2020-05

*/
WITH pivotted AS (
  SELECT "category",
       SUM(CASE WHEN SUBSTRING("date"::TEXT, 1, 7) = '2020-01' THEN "count" ELSE 0 END) AS "JAN",
       SUM(CASE WHEN SUBSTRING("date"::TEXT, 1, 7) = '2020-02' THEN "count" ELSE 0 END) AS "FEB",
       SUM(CASE WHEN SUBSTRING("date"::TEXT, 1, 7) = '2020-03' THEN "count" ELSE 0 END) AS "MAR",
       SUM(CASE WHEN SUBSTRING("date"::TEXT, 1, 7) = '2020-04' THEN "count" ELSE 0 END) AS "APR",
       SUM(CASE WHEN SUBSTRING("date"::TEXT, 1, 7) = '2020-05' THEN "count" ELSE 0 END) AS "MAY"
  FROM data1
  GROUP BY "category"
)
SELECT "category", "JAN" AS "count", '2020-01' AS "year_month" FROM pivotted
UNION ALL
SELECT "category", "FEB" AS "count", '2020-02' AS "year_month" FROM pivotted
UNION ALL
SELECT "category", "MAR" AS "count", '2020-03' AS "year_month" FROM pivotted
UNION ALL
SELECT "category", "APR" AS "count", '2020-04' AS "year_month" FROM pivotted
UNION ALL
SELECT "category", "MAY" AS "count", '2020-05' AS "year_month" FROM pivotted;