package com.nielsenbook.titleeditor.ui;

import com.nielsenbook.titleeditor.ui.enums.PageFlow;
import com.nielsenbook.titleeditor.ui.enums.Pages;
import com.nielsenbook.titleeditor.ui.flow.WizardPageContainer;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class WizardForm extends FormLayout {

	private NavButtonBar navButtonBar = new NavButtonBar() {

		@Override
		protected void showNextPage(ClickEvent<Button> event) {

			Pages currentPage = getCurrentPage();
			Pages pageToShow = PageFlow.convert(currentPage).getNext();
			changeToPage(pageToShow);
		}

		@Override
		protected void showPreviousPage(ClickEvent<Button> event) {

			Pages currentPage = getCurrentPage();
			Pages pageToShow = PageFlow.convert(currentPage).getPrevious();
			changeToPage(pageToShow);
			
		}
		
	};
	private HorizontalLayout horizontalLayout = new HorizontalLayout();
	private Pages currentPage;
	
	private static final long serialVersionUID = -8888217450177288067L;
	
	public WizardForm() {
		
		WizardPageContainer container = WizardPageContainer.getInstance(); 
		for(Pages page : Pages.values()) {
			horizontalLayout.add((Component)container.getPage(page));
		}
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.add(horizontalLayout,navButtonBar);

		makeOnePageVisible(Pages.PUBLICATION);
		
	}

	private void makeOnePageVisible(final Pages pageToSwitch) {

		
		for(Pages page : Pages.values()) {
			
			if (page == pageToSwitch) {
				Component firstPageComponent = horizontalLayout.getComponentAt(page.getIndex());
				firstPageComponent.getElement().setVisible(true);
			}else {
				Component pageComponent = horizontalLayout.getComponentAt(page.getIndex());
				pageComponent.getElement().setVisible(false);				
			}
			
		}
	}
	
	public void changeToPage(final Pages page) {
		this.currentPage = page;
		makeOnePageVisible(page);
	}

	
}
