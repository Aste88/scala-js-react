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

package com.xored.scalajs.react.internal

import java.util.concurrent.atomic.AtomicInteger

import scala.scalajs.js
import com.xored.scalajs.react.ReactDOM

class ReactDOMBuffer extends scala.collection.mutable.ArrayBuffer[ReactDOM] {

  private val EMPTY_STRING = js.Any.fromString("")

  def &+(o: Any): ReactDOMBuffer = {

    o match {
      case null | _: Unit | EMPTY_STRING => // ignore
      // just js.Object
      case n if o.getClass.equals(null) => super.+=(n.asInstanceOf[ReactDOM])
      // in ScalaJS Long is iterable
      case x: scala.Long => super.+=(x.toString.asInstanceOf[ReactDOM])
      case it: Iterator[_] => it foreach &+
      case ns: Iterable[_] => this &+ ns.iterator
      case na: Array[_] => this &+ na.iterator
      case n => super.+=(n.asInstanceOf[ReactDOM])
    }

    this
  }
}
