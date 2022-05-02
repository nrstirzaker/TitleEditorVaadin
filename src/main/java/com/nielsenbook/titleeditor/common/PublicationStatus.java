package com.nielsenbook.titleeditor.common;

public enum PublicationStatus {
	FORTHCOMING("Forthcoming"),ACTIVE("Active");
	
	private String label;
	
	PublicationStatus(final String label){
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
