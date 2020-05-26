package io.loustler.massemble.fp.zio

import zio.ULayer
import zio.duration._
import zio.test.environment.{TestEnvironment, testEnvironment}
import zio.test.{RunnableSpec, TestAspect, TestExecutor, TestRunner}

trait DefaultTestSpec[R <: DefaultTestSpec.Env] extends RunnableSpec[R, Any] {
  protected def layer: ULayer[R]

  protected final def defaultLayer: ULayer[TestEnvironment] = testEnvironment

  override def aspects: List[TestAspect[Nothing, R, Nothing, Any]] = List(TestAspect.timeoutWarning(60.seconds))

  override def runner: TestRunner[R, Any] = TestRunner(TestExecutor.default(layer))
}
object DefaultTestSpec {
  type Env = TestEnvironment with Env
}