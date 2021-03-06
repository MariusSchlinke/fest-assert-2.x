/*
 * Created on Oct 18, 2010
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2010-2011 the original author or authors.
 */
package org.fest.assertions.error;

import static org.fest.util.Dates.parse;

import java.util.Date;

import org.fest.assertions.internal.*;

/**
 * Creates an error message indicating that an assertion that verifies that a {@link Date} is before another one failed.
 * 
 * @author Joel Costigliola
 */
public class ShouldBeBefore extends BasicErrorMessageFactory {

  /**
   * Creates a new </code>{@link ShouldBeBefore}</code>.
   * @param actual the actual value in the failed assertion.
   * @param other the value used in the failed assertion to compare the actual value to.
   * @param comparisonStrategy the {@link Comparison} used to evaluate assertion.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldBeBefore(Date actual, Date other, Comparison comparisonStrategy) {
    return new ShouldBeBefore(actual, other, comparisonStrategy);
  }

  /**
   * Creates a new </code>{@link ShouldBeBefore}</code>.
   * @param actual the actual value in the failed assertion.
   * @param other the value used in the failed assertion to compare the actual value to.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldBeBefore(Date actual, Date other) {
    return new ShouldBeBefore(actual, other, EqualityComparison.instance());
  }

  /**
   * Creates a new </code>{@link ShouldBeBefore}</code>.
   * @param actual the actual value in the failed assertion.
   * @param year the year to compare the actual date's year to.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldBeBefore(Date actual, int year) {
    Date januaryTheFirstOfGivenYear = parse(year + "-01-01");
    return new ShouldBeBefore(actual, januaryTheFirstOfGivenYear, EqualityComparison.instance());
  }

  private ShouldBeBefore(Date actual, Date other, Comparison comparisonStrategy) {
    super("expected:<%s> to be strictly before:<%s>%s", actual, other, comparisonStrategy);
  }
}
