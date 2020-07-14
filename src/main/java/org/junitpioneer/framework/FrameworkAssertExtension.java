/*
 * Copyright 2015-2020 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junitpioneer.framework;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junitpioneer.jupiter.PioneerAnnotationUtils;

public class FrameworkAssertExtension implements AfterEachCallback {

	@Override
	public void afterEach(ExtensionContext context) {
		FrameworkAssert frameworkAssert = context
				.getStore(FrameworkExtension.NAMESPACE)
				.get(FrameworkExtension.STORE_KEY, FrameworkAssert.class);
		PioneerAnnotationUtils
				.findClosestEnclosingAnnotation(context, AssertThatFrameWasFramed.class)
				.map(AssertThatFrameWasFramed::value)
				.ifPresent(frameworkAssert::wasFramed);
	}

}
