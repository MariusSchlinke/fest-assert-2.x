/*
 * Created on Dec 15, 2010
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
package org.fest.assertions.internal.booleanarrays;

import static org.fest.assertions.error.ShouldEndWith.shouldEndWith;
import static org.fest.assertions.test.BooleanArrays.*;
import static org.fest.assertions.test.ErrorMessages.*;
import static org.fest.assertions.test.FailureMessages.actualIsNull;
import static org.fest.assertions.test.TestData.someInfo;
import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import org.fest.assertions.core.AssertionInfo;
import org.fest.assertions.internal.BooleanArrays;
import org.fest.assertions.internal.BooleanArraysBaseTest;

/**
 * Tests for <code>{@link BooleanArrays#assertEndsWith(AssertionInfo, boolean[], boolean[])}</code>.
 * 
 * @author Alex Ruiz
 * @author Joel Costigliola
 */
public class BooleanArrays_assertEndsWith_Test extends BooleanArraysBaseTest {

  @Override
  @Before
  public void setUp() {
    super.setUp();
    actual = newArray(true, false, false, true);
  }

  @Test
  public void should_throw_error_if_sequence_is_null() {
    thrown.expectNullPointerException(valuesToLookForIsNull());
    arrays.assertEndsWith(someInfo(), actual, null);
  }

  @Test
  public void should_throw_error_if_sequence_is_empty() {
    thrown.expectIllegalArgumentException(valuesToLookForIsEmpty());
    arrays.assertEndsWith(someInfo(), actual, emptyArray());
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    arrays.assertEndsWith(someInfo(), null, newArray(true));
  }

  @Test
  public void should_fail_if_sequence_is_bigger_than_actual() {
    AssertionInfo info = someInfo();
    boolean[] sequence = { true, false, false, true, true, false };
    try {
      arrays.assertEndsWith(someInfo(), actual, sequence);
    } catch (AssertionError e) {
      verifyFailureThrownWhenSequenceNotFound(info, sequence);
      return;
    }
    expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_fail_if_actual_does_not_end_with_sequence() {
    AssertionInfo info = someInfo();
    boolean[] sequence = { true, false };
    try {
      arrays.assertEndsWith(someInfo(), actual, sequence);
    } catch (AssertionError e) {
      verifyFailureThrownWhenSequenceNotFound(info, sequence);
      return;
    }
    expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_fail_if_actual_ends_with_first_elements_of_sequence_only() {
    AssertionInfo info = someInfo();
    boolean[] sequence = { false, false };
    try {
      arrays.assertEndsWith(info, actual, sequence);
    } catch (AssertionError e) {
      verifyFailureThrownWhenSequenceNotFound(info, sequence);
      return;
    }
    expectedAssertionErrorNotThrown();
  }

  private void verifyFailureThrownWhenSequenceNotFound(AssertionInfo info, boolean[] sequence) {
    verify(failures).failure(info, shouldEndWith(actual, sequence));
  }

  @Test
  public void should_pass_if_actual_ends_with_sequence() {
    arrays.assertEndsWith(someInfo(), actual, newArray(false, true));
  }

  @Test
  public void should_pass_if_actual_and_sequence_are_equal() {
    arrays.assertEndsWith(someInfo(), actual, newArray(true, false, false, true));
  }
}
