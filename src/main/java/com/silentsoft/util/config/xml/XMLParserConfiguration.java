package com.silentsoft.util.config.xml;

import com.silentsoft.util.appdata.AppData;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum XMLParserConfiguration {
	SETTINGS_PARSER(AppData.ConfigurationData.SETTINGS_NODE_NAME),
	LANGUAGE_PARSER(AppData.ConfigurationData.LANGUAGE_NODE_NAME, AppData.ConfigurationData.LANGUAGE_ATTRIBUTE_NAME);

	private final String nodeName;
	private final String attributeName;

	XMLParserConfiguration(String nodeName) {
		this.nodeName = nodeName;
		this.attributeName = "";
	}
}
