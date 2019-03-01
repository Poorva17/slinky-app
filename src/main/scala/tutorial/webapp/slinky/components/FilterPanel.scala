package tutorial.webapp.slinky.components

import slinky.core.Component
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._
import tutorial.webapp.slinky.actions.ApplyFilter
import tutorial.webapp.slinky.models.{All, Completed, NotCompleted}
import tutorial.webapp.slinky.state.{AppCircuit, RootModel}

@react class FilterPanel extends Component{

  override type Props = Unit

  override type State = RootModel

  override val initialState = RootModel(Seq.empty)

//  override def componentWillMount(): Unit = {
//    //todo: check what is the best place to subscribe
//    AppCircuit.subscribe(AppCircuit.zoom(identity)){modelRO =>
//      setState(modelRO())
//    }
//  }

  override def render(): ReactElement = {
    val todos = state.todoItems
//    val filter = state.filter
    val all = todos.length
    val completed = todos.count(_.done)
    val active = todos.count(!_.done)

    div(id := "summary")(
      span(
//        className := (if(filter == All) "active-filter" else "disabled"),
        onClick := (_=> AppCircuit.dispatch(ApplyFilter(All)))
      )(s"All: $all"),
      span(
//        className := (if(filter == Completed) "active-filter" else "disabled"),
        onClick := (_=> AppCircuit.dispatch(ApplyFilter(Completed)))
      )(s"Completed: $completed"),
      span(
//        className := (if(filter == NotCompleted) "active-filter" else "disabled"),
        onClick := (_=> AppCircuit.dispatch(ApplyFilter(NotCompleted)))
      )(s"Not Completed: $active")
    )
  }
}
