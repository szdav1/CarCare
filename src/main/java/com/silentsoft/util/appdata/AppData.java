package com.silentsoft.util.appdata;

import javax.swing.UIManager;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppData {
	public static final String RUNNING_OS_NAME = System.getProperty("os.name");
	public static final String DEFAULT_LOOK_AND_FEEL_NAME = UIManager.getLookAndFeel().getName();

	public static final class XMLData {
		public static final String SETTINGS_FOLDER_PATH = "/settings/";
		public static final String LANGUAGES_FOLDER_PATH = "/languages/";
		public static final String SETTINGS_XML_PATH = SETTINGS_FOLDER_PATH+"Settings.xml";
		public static final String LOOK_AND_FEEL_SETTING = "LookAndFeel";
		public static final String LANGUAGE_SETTING = "Language";
	}

	public static final class ConfigurationData {
		public static final String SETTINGS_NODE_NAME = "ApplicationSettings";
		public static final String LANGUAGE_NODE_NAME = "Words";
		public static final String LANGUAGE_ATTRIBUTE_NAME = "for";
	}

	public static final class AdminData {
		public static final String ADMIN_KEY = "--as-admin";
	}
}
