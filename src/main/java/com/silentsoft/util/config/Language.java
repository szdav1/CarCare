package com.silentsoft.util.config;

import java.util.HashMap;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Language {
	private static final HashMap<String, String> map = new HashMap<>();

	public static void init(final HashMap<String, String> map) {
		Language.map.clear();
		Language.map.putAll(map);
	}

	public static String get(final String key) {
		if (!map.containsKey(key))
			return "Lookup Failed!";

		return map.get(key);
	}
}
