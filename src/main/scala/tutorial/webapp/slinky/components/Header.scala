package tutorial.webapp.slinky.components

import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html.{div, id}

@react class Header extends StatelessComponent {

  type Props = Unit

  override def render(): ReactElement = {
    div(id := "header")("Todo Application")
  }
}
