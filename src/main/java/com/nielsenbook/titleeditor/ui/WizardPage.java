package com.nielsenbook.titleeditor.ui;

import com.nielsenbook.titleeditor.ui.enums.Pages;

public interface WizardPage {

	public Pages nextPage();
	public Pages previousPage();
	public NavMenu getNavMenu();
	
}
