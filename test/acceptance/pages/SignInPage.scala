/*
 * Copyright 2016 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package acceptance.pages

import acceptance.WebPage

object SignInPage extends WebPage {

  override val url: String = "http://localhost:9000/api-gatekeeper/login"
  override def isCurrentPage : Boolean = find(cssSelector("h1")).fold(false)(_.text == "Sign in")

  def signInBtn = find(className("button")).get

  def userField = textField("userName")

  def passwordField = pwdField("password")

  def signIn(): Unit = {
    click on signInBtn
  }

  def signIn(username: String, password: String) = {
    userField.value = username
    passwordField.value = password
    click on signInBtn
  }

}
