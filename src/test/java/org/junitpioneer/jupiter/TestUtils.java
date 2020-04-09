/*
 * Copyright 2015-2020 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junitpioneer.jupiter;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;

import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.engine.test.event.ExecutionEventRecorder;

public class TestUtils {

	static List<Map<String, String>> reportEntries(ExecutionEventRecorder recorder) {
		return recorder
				.eventStream()
				.flatMap(executionEvent -> executionEvent.getPayload(ReportEntry.class).stream())
				.map(ReportEntry::getKeyValuePairs)
				.collect(toList());
	}

}
