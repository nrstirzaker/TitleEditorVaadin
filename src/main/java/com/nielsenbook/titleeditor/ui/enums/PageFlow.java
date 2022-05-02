package com.nielsenbook.titleeditor.ui.enums;

public enum PageFlow {

	
	PUBLICATION(null,Pages.TITLE_AND_SERIES),//
	TITLE_AND_SERIES(Pages.PUBLICATION,Pages.EDITION_AND_LANGUAGE),//
	EDITION_AND_LANGUAGE(Pages.TITLE_AND_SERIES,Pages.CONTRIBUTORS),//
	CONTRIBUTORS(Pages.EDITION_AND_LANGUAGE,Pages.FORMAT),//
	FORMAT(Pages.CONTRIBUTORS,Pages.PHYSICAL),//
	PHYSICAL(Pages.FORMAT,Pages.DESCRIPTIVE),//
	DESCRIPTIVE(Pages.PHYSICAL,null);
	
	
	private Pages previous;
	private Pages next;
	
	private PageFlow(final Pages previous, final Pages next) {
		this.previous = previous;
		this.next = next;
	}
	
	public Pages getPrevious() {
		return previous;
	}
	
	public Pages getNext() {
		return next;
	}

	public static PageFlow convert(final Pages page) {
		
		PageFlow output = PageFlow.PUBLICATION;
		switch(page) {
		case PUBLICATION:
			output = PageFlow.PUBLICATION;
			break;
		case TITLE_AND_SERIES:
			output = PageFlow.TITLE_AND_SERIES;
			break;
		case EDITION_AND_LANGUAGE:
			output = PageFlow.EDITION_AND_LANGUAGE;
			break;
		case CONTRIBUTORS:
			output = PageFlow.CONTRIBUTORS;
			break;
		case FORMAT:
			output = PageFlow.FORMAT;
			break;
		case PHYSICAL:
			output = PageFlow.PHYSICAL;
			break;
		case DESCRIPTIVE:
			output = PageFlow.DESCRIPTIVE;
			break;
		}
		
		return output;
	}
	
}
