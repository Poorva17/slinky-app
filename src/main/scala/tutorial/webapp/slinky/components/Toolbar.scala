package tutorial.webapp.slinky.components

import org.scalajs.dom.raw.{Event, HTMLInputElement}
import slinky.core.Component
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._
import tutorial.webapp.slinky.actions.AddTodo
import tutorial.webapp.slinky.state.AppCircuit

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("resources/images/add.png", JSImport.Default)
@js.native
object AddTodoImg extends js.Object

@react class Toolbar extends Component {

  type Props = Unit

  case class State(text: String)

  override def initialState = State(text = "")

  def handleChange(e:Event):Unit ={
    val eventValue = e.target.asInstanceOf[HTMLInputElement].value
    setState(_.copy(eventValue))
  }

  val handleChange1 : (Event => Unit) = (e) => {
    val eventValue = e.target.asInstanceOf[HTMLInputElement].value
    setState(_.copy(eventValue))
  }

  override def render(): ReactElement = {
    form(id := "toolbar", onSubmit := (e => {
      e.preventDefault()
      if (!state.text.trim.isEmpty) {
        AppCircuit.dispatch(AddTodo(state.text))
        setState(_.copy(""))
      }
    }))(
      input(id := "input-box",
        placeholder := "what needs to be done?",
        onChange := (e => {
          setState(State(text = e.target.asInstanceOf[HTMLInputElement].value))
        }),
        value := state.text),
      button(id := "add-button")(
        img(src := "resources/images/add.png")
      )
    )
  }
}
