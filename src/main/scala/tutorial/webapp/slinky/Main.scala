package tutorial.webapp.slinky

import org.scalajs.dom
import slinky.hot
import slinky.web.ReactDOM
import tutorial.webapp.slinky.components._
import scala.scalajs.js.annotation.{JSExportTopLevel, JSImport}
import scala.scalajs.{LinkingInfo, js}

//@JSImport("resources/index.css", JSImport.Default)
//@js.native
//object IndexCSS extends js.Object

object Main {
//  val css = IndexCSS

  @JSExportTopLevel("main")
  def main(): Unit = {
    if (LinkingInfo.developmentMode) {
      hot.initialize()
    }

    val container = Option(dom.document.getElementById("main")).getOrElse {
      val elem = dom.document.createElement("div")
      elem.id = "main"
      dom.document.body.appendChild(elem)
      elem
    }

    ReactDOM.render(App(), container)
  }
}
