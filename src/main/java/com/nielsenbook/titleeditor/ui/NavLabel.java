package com.nielsenbook.titleeditor.ui;

import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.tabs.Tab;


public class NavLabel extends Tab implements SelectableMenuItem{

	private static final long serialVersionUID = -4556152805710807033L;
	private NavMenu navMenu;
	
	protected NavLabel() {
		super();
	}
	
	public NavLabel(final NavMenu navMenu) {
		this();	
		this.navMenu = navMenu;
		final H6 h6 = new H6(navMenu.getLabel());
		this.add(h6);
	}
	
	@Override
	public void setSelectedStyle() {
		this.setClassName("menuItemSelected");
	}
	
	@Override
	public void setDefaultStyle() {
		this.setClassName("menuItemDefault");
	}

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
        	setSelectedStyle();
        }else {
        	setDefaultStyle();
        }
    }
    
    public NavMenu getNavMenu() {
    	return this.navMenu;
    }
	
}
