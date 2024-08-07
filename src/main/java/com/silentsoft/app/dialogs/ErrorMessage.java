package com.silentsoft.app.dialogs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
	SETTINGS_LOADING_ERROR("Couldn't load the application's settings XML file."),
	LANGUAGE_LOADING_ERROR("Couldn't load the specified language XML file."),
	LOOK_AND_FEEL_ERROR("Couldn't set the specified look and feel for the application.");

	private final String message;
}
