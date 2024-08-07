package com.silentsoft.util;

import java.io.FileReader;
import java.net.URL;

import com.silentsoft.util.appdata.AppData;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResourceHandler {
	public static String get(final String path) {
		URL url = ResourceHandler.class.getResource(path);

		if (url == null)
			return "";

		try (FileReader fileReader = new FileReader(url.getFile())) {
			return url.getFile();
		}
		catch (Exception exc) {
			String prefix = AppData.RUNNING_OS_NAME.toLowerCase().contains("windows") ? "/" : "";

			return new StringBuilder()
				.append("resources/main")
				.append(path)
				.toString();
		}
	}
}
