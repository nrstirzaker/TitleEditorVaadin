package com.nielsenbook.titleeditor.ui;

import com.nielsenbook.titleeditor.ui.enums.Pages;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public abstract class NavButtonBar extends HorizontalLayout{

	private static final long serialVersionUID = 3469686641466652995L;
	private Button saveAndNext;
	private Button saveAndQuit;
	private Button previous;
	private Pages currentPage;

	
	public NavButtonBar() {
		

    	saveAndNext = new Button("Save and Next");
    	saveAndQuit = new Button("Save and Quit");
    	previous = new Button("Previous");
    	
    	saveAndNext.addClickListener(this::showNextPage);
    	previous.addClickListener(this::showPreviousPage);
    	currentPage = Pages.PUBLICATION;
    	add(saveAndNext,saveAndQuit,previous);

		
	}
	
	protected Pages getCurrentPage() {
		return currentPage;
	}
	
    protected abstract void showNextPage(final ClickEvent<Button> event);
    
    protected abstract void showPreviousPage(final ClickEvent<Button> event);

	
}
