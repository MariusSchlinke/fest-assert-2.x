/*
 * Created on Dec 22, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010-2012 the original author or authors.
 */
package org.fest.assertions.test;

/**
 * @author Alex Ruiz
 * @author Yvonne Wang
 * @author Nicolas François
 */
public final class ErrorMessages {
  public static String arrayIsEmpty() {
    return "The given array should not be empty";
  }

  public static String iterableIsEmpty() {
    return "The given iterable should not be empty";
  }

  public static String entriesToLookForIsEmpty() {
    return "The array of entries to look for should not be empty";
  }

  public static String isNotArray(Object o) {
    return String.format("The object <%s> should be an array", o);
  }

  public static String offsetValueIsNotPositive() {
    return "The value of the offset should be greater than zero";
  }

  public static String valuesToLookForIsEmpty() {
    return "The array of values to look for should not be empty";
  }

  private ErrorMessages() {}
}
