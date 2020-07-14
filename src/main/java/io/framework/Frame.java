/*
 * Copyright 2015-2020 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package io.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Frame {

	private static final Frame SINGLETON_INSTANCE = new Frame();

	public static Frame getSingletonInstance() {
		return SINGLETON_INSTANCE;
	}

	private final List<Consumer<Object>> listeners;

	private Frame() {
		listeners = new ArrayList<>();
	}

	public void frameTheThing(Object thing) {
		listeners.forEach(listener -> listener.accept(thing));
	}

	public void addFramingListener(Consumer<Object> listener) {
		listeners.add(listener);
	}

	public void removeFramingListener(Consumer<Object> listener) {
		listeners.remove(listener);
	}

}
