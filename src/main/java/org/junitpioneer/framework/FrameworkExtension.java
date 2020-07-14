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

import io.framework.Frame;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class FrameworkExtension implements BeforeEachCallback, AfterEachCallback, ParameterResolver {

	static final Namespace NAMESPACE = Namespace.create(FrameworkExtension.class);
	static final String STORE_KEY = "ASSERT";

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		return parameterContext.getParameter().getType() == FrameworkAssert.class;
	}

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		FrameworkAssert frameworkAssert = new FrameworkAssert();
		Frame.getSingletonInstance().addFramingListener(frameworkAssert);
		context.getStore(NAMESPACE).put(STORE_KEY, frameworkAssert);
	}

	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		return extensionContext.getStore(NAMESPACE).get(STORE_KEY, FrameworkAssert.class);
	}

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		FrameworkAssert frameworkAssert = context.getStore(NAMESPACE).get(STORE_KEY, FrameworkAssert.class);
		Frame.getSingletonInstance().removeFramingListener(frameworkAssert);
	}

}
