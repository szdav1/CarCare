package com.silentsoft.util.config;

import java.util.HashMap;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Settings {
	private static final HashMap<String, String> map = new HashMap<>();

	public static void init(final HashMap<String, String> map) {
		Settings.map.clear();
		Settings.map.putAll(map);
	}

	public static String get(final String key) {
		return map.get(key);
	}
}
