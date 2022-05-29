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
    appendPar(document.body, "Basic Fantasy Character Generator")

//    val name = document.createElement("input")
//    name.setAttribute("id", "nameTextBox")
//    name.setAttribute("type", "text")
//    name.setAttribute("placeholder", "character name")
//    document.body.appendChild(name)

    val rollButton = document.createElement("button")
    rollButton.textContent = "roll"
    rollButton.addEventListener("click", { (e: dom.MouseEvent) =>
      addClickedMessage()
    })
    document.body.appendChild(rollButton)

  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  @JSExportTopLevel("addClickedMessage")
  def addClickedMessage(): Unit = {
    val nameTextBox = document.getElementById("nameTextBox").asInstanceOf[html.Input]
    val nameText: String  = nameTextBox.value

    appendPar(document.body, s"name text box: $nameText")
  }
}
