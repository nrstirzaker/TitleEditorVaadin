package com.nielsenbook.titleeditor.ui;



import org.springframework.beans.factory.annotation.Autowired;

import com.nielsenbook.titleeditor.common.PartOfSeries;
import com.nielsenbook.titleeditor.entity.Book;
import com.nielsenbook.titleeditor.entity.BookRepository;
import com.nielsenbook.titleeditor.ui.enums.PageFlow;
import com.nielsenbook.titleeditor.ui.enums.Pages;
import com.nielsenbook.titleeditor.ui.flow.WizardPageContainer;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class BookEditorTitleAndSeries extends FormLayout implements KeyNotifier, WizardPage{

	private static final long serialVersionUID = 7888071521759964005L;
	private BookRepository repository;
    private Book book;
    
	private BookRepository bookRepository;	
	private TextField leadingArticle;
	private TextField mainTitle;
	private TextField subTitle;
	private NumberField yearStatement;
	private TextField multiPartTitle;
	private NumberField volumeNumber;
	private Select<PartOfSeries> partOfSeries;
  
    @Autowired
    public  BookEditorTitleAndSeries(final BookRepository repository) {
    	this.repository = bookRepository;
 
    
    	leadingArticle = new TextField("Leading Article of Title");
    	
    	mainTitle = new TextField("Main Title");
    	mainTitle.setRequiredIndicatorVisible(true);
    	
    	subTitle = new TextField("Sub-Title");
    	
    	yearStatement = new NumberField("Year Statement");
    	multiPartTitle = new TextField("Title of Part for Multi-Part Work");
    	volumeNumber = new NumberField("Part or Volume Number");
    	
    	partOfSeries = new Select<PartOfSeries>();
    	partOfSeries.setLabel("Is this title part if a series?");
    	partOfSeries.setItems(PartOfSeries.values());
    	partOfSeries.setRequiredIndicatorVisible(true);
    	
    	add(leadingArticle,mainTitle,subTitle,yearStatement,multiPartTitle,volumeNumber,partOfSeries);
    	
    }
    

    
    public interface ChangeHandler {
        void onChange();
    }



	@Override
	public Pages nextPage() {
		return PageFlow.TITLE_AND_SERIES.getNext();
	}



	@Override
	public Pages previousPage() {
		return PageFlow.TITLE_AND_SERIES.getPrevious();
	}
	
	@Override
	public NavMenu getNavMenu() {
		return NavMenu.TITLE_AND_SERIES;
	}
}