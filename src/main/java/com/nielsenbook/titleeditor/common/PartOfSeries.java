package com.nielsenbook.titleeditor.common;

public enum PartOfSeries {
	YES("Yes"),NO("No"),NOT_YET_CONFIRMED("Not yet Confirmed");
	
	private String label;
	
	private PartOfSeries(final String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
