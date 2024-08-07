package com.silentsoft.util.config;

import javax.swing.UIManager;

import com.silentsoft.app.dialogs.ErrorMessage;
import com.silentsoft.app.run.AppInstance;
import com.silentsoft.util.appdata.AppData;
import com.silentsoft.util.appdata.Log;
import com.silentsoft.util.appdata.RuntimeOnlyLog;
import com.silentsoft.util.config.xml.LanguageXMLParser;
import com.silentsoft.util.config.xml.SettingsXMLParser;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Configurator {
	private static void fetchSettings() {
		try {
			SettingsXMLParser settingsXMLParser = new SettingsXMLParser();
			Settings.init(settingsXMLParser.parseXMLFile(AppData.XMLData.SETTINGS_XML_PATH));
		}
		catch (Exception exc) {
			AppInstance.errorDialog.displayErrorMessage(exc, ErrorMessage.SETTINGS_LOADING_ERROR, Log.CONFIGURATION_ERROR);
		}
	}

	private static void fetchLanguage() {
		if (RuntimeOnlyLog.contains(Log.CONFIGURATION_ERROR))
			return;

		try {
			LanguageXMLParser languageXMLParser = new LanguageXMLParser();
			Language.init(languageXMLParser.parseXMLFile(AppData.XMLData.LANGUAGES_FOLDER_PATH+Settings.get(AppData.XMLData.LANGUAGE_SETTING)));
		}
		catch (Exception exc) {
			AppInstance.errorDialog.displayErrorMessage(exc, ErrorMessage.LANGUAGE_LOADING_ERROR, Log.CONFIGURATION_ERROR);
		}
	}

	public static void setLookAndFeel() {
		if (RuntimeOnlyLog.contains(Log.CONFIGURATION_ERROR))
			return;

		try {
			UIManager.setLookAndFeel(Settings.get(AppData.XMLData.LOOK_AND_FEEL_SETTING));
		}
		catch (Exception exc) {
			AppInstance.errorDialog.displayErrorMessage(exc, ErrorMessage.LOOK_AND_FEEL_ERROR, Log.CONFIGURATION_ERROR);
		}
	}

	public static void configure() {
		fetchSettings();
		fetchLanguage();
		setLookAndFeel();
	}
}
