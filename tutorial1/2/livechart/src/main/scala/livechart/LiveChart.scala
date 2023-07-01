package livechart

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom

import scala.main

// import javascriptLogo from "/javascript.svg"
@js.native @JSImport("/javascript.svg", JSImport.Default)
val javascriptLogo: String = js.native

@main
def LiveChart(): Unit =
    renderOnDomContentLoaded(
        dom.document.getElementById("app"),
        Main.appElement()
    )
end LiveChart

object Main:
    def appElement(): Element =
        div(
            a(href := "https://vitejs.dev", target := "_blank",
                img(src := "/vite.svg", className := "logo", alt := "Vite logo"),
            ),
            a(href := "https://developer.mozilla.org/en-US/docs/Web/JavaScript", target := "_blank",
                img(src := javascriptLogo, className := "logo vanilla", alt := "JavaScript logo"),
            ),
            h1("Hello Laminar!"),
            div(className := "card",
                button(tpe := "button"),
            ),
            p(className := "read-the-docs",
                "Click on the Vite logo to learn more",
            ),
        )
    end appElement
end Main

def setupCounter(element: dom.Element): Unit =
    var counter = 0

    def setCounter(count: Int): Unit =
        counter = count
        element.innerHTML = s"count is $counter"

    element.addEventListener("click", e => setCounter(counter + 1))
    setCounter(0)
end setupCounter

def counterButton(): Element =
    val counter = Var(0)
    button(
        tpe := "button",
        "count is ",
        child.text <-- counter,
        onClick --> { event => counter.update(c => c + 1)},
    )
end counterButton
