package tutorial.webapp

import utest._
import org.scalajs.dom.document
import org.scalajs.dom.ext._

object TutorialTest extends TestSuite {
  // Initialize App
  TutorialApp.setupUI()

  def tests: Tests = Tests {
    test("HelloWorld") {
      assert(document.querySelectorAll("p").count(_.textContent == "Hello World") == 1)
    }
  }
}
