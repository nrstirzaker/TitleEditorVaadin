package com.nielsenbook.titleeditor.ui.flow;

import com.nielsenbook.titleeditor.ui.NavButtonBar;
import com.nielsenbook.titleeditor.ui.WizardForm;
import com.nielsenbook.titleeditor.ui.WizardPage;
import com.nielsenbook.titleeditor.ui.enums.PageDirection;
import com.nielsenbook.titleeditor.ui.enums.PageFlow;
import com.nielsenbook.titleeditor.ui.enums.Pages;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class WizardFormFlowEngine {

	private static WizardFormFlowEngine INSTANCE;
	private FormLayout form;
	private WizardFormFlowEngine() {
		super();
		this.form = new WizardForm();
		
	}
	
	
	public WizardFormFlowEngine getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new WizardFormFlowEngine(); 
		}
		return INSTANCE;
	}
	
	public FormLayout getForm(final Pages currentPage, final PageDirection pageDirection) {
		
		Pages pageToGoTo;
		
		if (pageDirection == PageDirection.NEXT) {
			pageToGoTo = PageFlow. currentPage.nextPage();	
		}else {
			pageToGoTo = currentPage.previousPage();	
		}
		
		if (pageToGoTo == null) {
			return form;
		}
		
		
		WizardPage newPage = WizardPageContainer.getInstance().getPage( pageToGoTo );
		
		this.form.
		
	}
	
}
