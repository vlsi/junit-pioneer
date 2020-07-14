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

import java.util.function.Consumer;

import org.opentest4j.AssertionFailedError;

public class FrameworkAssert implements Consumer<Object> {

	private boolean wasFramed;

	public void wasFramed(boolean wasFramed) {
		if (this.wasFramed != wasFramed)
			throw new AssertionFailedError();
	}

	@Override
	public void accept(Object o) {
		wasFramed = true;
	}

}
