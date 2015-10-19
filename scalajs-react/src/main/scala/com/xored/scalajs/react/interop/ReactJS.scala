/*
 * Copyright 2014 Xored Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xored.scalajs.react.interop

import scala.scalajs.js
import js.annotation.JSName
import org.scalajs.dom.html
import com.xored.scalajs.react.ReactDOM

/**
 * Interop with react.js
 */
@js.native
@JSName("React")
object ReactJS extends js.Object {
  def createClass[State, Props, T](spec: js.Dictionary[T]): ReactComponentClass[State, Props] = js.native

  def renderToString(dom: ReactDOM): String = js.native

  def renderToStaticMarkup(dom: ReactDOM): String = js.native

  def createFactory[State, Props](spec: ReactComponentClass[State, Props]): ReactComponentClass[State, Props] = js.native

  def DOM: js.Dynamic = js.native
}

@js.native
@JSName("ReactDOM")
object ReactJSDOM extends js.Object {

  def render[C <: ReactDOM](component: C, container: html.Element): C = js.native
}