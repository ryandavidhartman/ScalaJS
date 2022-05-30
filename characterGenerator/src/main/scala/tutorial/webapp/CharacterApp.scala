package tutorial.webapp

import org.scalajs.dom
import org.scalajs.dom.{document, html}

import scala.scalajs.js.annotation.JSExportTopLevel

object CharacterApp {
  def main(args: Array[String]): Unit = {
    document.addEventListener("DOMContentLoaded", { (e: dom.Event) =>
      setupUI()
    })
  }

  def setupUI(): Unit = {

    val rollButton = document.getElementById("roll_ability_scores").asInstanceOf[html.Button]
    rollButton.addEventListener("click", { (e: dom.MouseEvent) =>
      addRollScores()
    })

  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  @JSExportTopLevel("addRollHandler")
  def addRollScores(): Unit = {
    val str_select = document.getElementById("character_strength_select").asInstanceOf[html.Select]
    str_select.selectedIndex = 0

  }
}
