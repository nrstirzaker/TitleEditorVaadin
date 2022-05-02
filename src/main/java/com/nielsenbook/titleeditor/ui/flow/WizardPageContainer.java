package com.nielsenbook.titleeditor.ui.flow;

import java.util.HashMap;
import java.util.Map;

import com.nielsenbook.titleeditor.ui.WizardPage;
import com.nielsenbook.titleeditor.ui.enums.Pages;

public class WizardPageContainer {

	
	private static final Map<Pages,WizardPage> container = new HashMap<Pages,WizardPage>(); 
	private static WizardPageContainer INSTANCE;
	private static final BookEditorFactory factory = BookEditorFactory.getInstance();
	
	private WizardPageContainer(){
		super();
		container.put(Pages.PUBLICATION,factory.createPage(Pages.PUBLICATION));
		container.put(Pages.TITLE_AND_SERIES,factory.createPage(Pages.TITLE_AND_SERIES));
	}
	
	public static WizardPageContainer getInstance() {
		if (INSTANCE == null) {
			 INSTANCE = new WizardPageContainer();
		}
		return INSTANCE;
	}
	
	public WizardPage getPage(final Pages page) {
		return container.get(page);
	}
}
