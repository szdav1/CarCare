package com.silentsoft.util.appdata;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class RuntimeOnlyLog {
	private static final List<Log> logs = new ArrayList<>();

	public static void appendLog(final Log log) {
		if (logs.contains(log))
			return;

		logs.add(log);
	}

	public static boolean contains(final Log log) {
		return logs.contains(log);
	}
}
