package com.nielsenbook.titleeditor.ui;

import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Span;

public class NavRequiredLabel extends NavLabel {

	private static final long serialVersionUID = -7552866589050891436L;
	private NavMenu navMenu;

	protected NavRequiredLabel() {
		super();
	}
	
	protected NavRequiredLabel(final NavMenu navMenu) {
		this();	
		this.navMenu = navMenu;
		final H6 h6 = new H6(navMenu.getLabel());
		final Span star = new Span(" *");
		star.setClassName("star");
		h6.add(star);
		this.add(h6);
	}
	
	public NavMenu getNavMenu() {
		return this.navMenu;
	}
	
}
