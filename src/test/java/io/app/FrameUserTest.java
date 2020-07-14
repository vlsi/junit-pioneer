/*
 * Copyright 2015-2020 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package io.app;

import io.framework.Frame;

import org.junit.jupiter.api.Test;
import org.junitpioneer.framework.AssertThatFrameWasFramed;
import org.junitpioneer.framework.FrameworkAssert;
import org.junitpioneer.framework.Frameworked;

@Frameworked
class FrameUserTest {

	@Test
	@AssertThatFrameWasFramed(false)
	void testFraming(FrameworkAssert frameworkAssertThat) {
		// given
		FrameUser frameUser = new FrameUser(Frame.getSingletonInstance());

		// when
		frameUser.useTheThing();

		// then
		//		frameworkAssertThat.wasFramed();
	}

}
