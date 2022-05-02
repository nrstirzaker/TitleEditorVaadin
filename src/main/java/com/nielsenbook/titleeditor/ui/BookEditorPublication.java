package com.nielsenbook.titleeditor.ui;



import org.springframework.beans.factory.annotation.Autowired;

import com.nielsenbook.titleeditor.common.PublicationStatus;
import com.nielsenbook.titleeditor.entity.Book;
import com.nielsenbook.titleeditor.entity.BookRepository;
import com.nielsenbook.titleeditor.ui.enums.PageDirection;
import com.nielsenbook.titleeditor.ui.enums.PageFlow;
import com.nielsenbook.titleeditor.ui.enums.Pages;
import com.nielsenbook.titleeditor.ui.flow.WizardFormFlowEngine;
import com.nielsenbook.titleeditor.ui.flow.WizardPageContainer;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class BookEditorPublication extends FormLayout implements KeyNotifier,WizardPage {

	private static final long serialVersionUID = -7178156692505415997L;
	private BookRepository repository;
    private Book book;
    
	private BookRepository bookRepository;	
	private DatePicker publicationDate;
	private Select<PublicationStatus> publicationStatus;

  
    @Autowired
    public  BookEditorPublication(final BookRepository repository) {
    	this.repository = bookRepository;
 
    	publicationStatus = new Select<PublicationStatus>();
    	publicationStatus.setLabel("Publication Date");
    	publicationStatus.setItems(PublicationStatus.values());
    	publicationStatus.setRequiredIndicatorVisible(true);
    	
    	publicationDate = new DatePicker("Publication Date");
    	publicationDate.setRequired(true);
    	
    	add(publicationStatus,publicationDate);
    	
    }
    
    
    public interface ChangeHandler {
        void onChange();
    }


	@Override
	public Pages nextPage() {
		return PageFlow.PUBLICATION.getNext();
	}


	@Override
	public Pages previousPage() {
		return PageFlow.PUBLICATION.getPrevious();
	}


	@Override
	public NavMenu getNavMenu() {
		return NavMenu.PUBLICATION;
	}
}