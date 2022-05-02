package com.nielsenbook.titleeditor.ui.enums;

public enum Pages {

	PUBLICATION("Publication",0),//
	TITLE_AND_SERIES("TitleAndSeries",1),//
	EDITION_AND_LANGUAGE("EditionAndLanguage",2),//
	CONTRIBUTORS("Contributors",3),//
	FORMAT("Format",4),//
	PHYSICAL("Physical",5),//
	DESCRIPTIVE("Descriptive",6);
	
	private String description;
	private Integer index;
	
	private Pages(final String description, final Integer index) {
		this.description = description;
		this.index = index;
	}
	
	public String getDescription() {
		return description;
	}

	public Integer getIndex() {
		return index;
	}

	
}
