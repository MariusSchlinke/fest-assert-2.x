/*
 * Created on Jan 29, 2011
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
 * Copyright @2011-2012 the original author or authors.
 */
package org.fest.assertions.api;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.File;

import org.fest.assertions.description.Description;
import org.fest.assertions.internal.Files;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link FileAssert#doesNotExist()}.
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class FileAssert_doesNotExist_Test {
  private Files files;
  private FileAssert assertions;

  @Before
  public void setUp() {
    files = mock(Files.class);
    assertions = new FileAssert(mock(File.class), mock(Description.class));
    assertions.files = files;
  }

  @Test
  public void should_verify_that_actual_does_not_exist() {
    assertions.doesNotExist();
    verify(files).assertDoesNotExist(assertions.description, assertions.actual);
  }

  @Test
  public void should_return_this() {
    FileAssert returned = assertions.doesNotExist();
    assertSame(assertions, returned);
  }
}
