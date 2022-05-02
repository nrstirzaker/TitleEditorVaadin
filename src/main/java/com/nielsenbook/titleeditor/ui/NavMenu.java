package com.nielsenbook.titleeditor.ui;

public enum NavMenu {

	PUBLICATION("Publication"),
	TITLE_AND_SERIES("Title and Series"),
	EDITION_AND_LANGUAGE("Edition and Language"),
	CONTRIBUTORS("Contributors"),
	FORMAT("Format"),
	PHYSICAL("Physical"),
	DESCRIPTIVE("Descriptive");
			
	private String label;
	
	private NavMenu(final String label) {
		this.label = label;
	}
	
	
	public String getLabel() {
		return label;
	}
}
