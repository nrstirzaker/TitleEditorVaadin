package com.nielsenbook.titleeditor.ui.flow;

import org.springframework.beans.factory.annotation.Autowired;

import com.nielsenbook.titleeditor.entity.BookRepository;
import com.nielsenbook.titleeditor.ui.BookEditorPublication;
import com.nielsenbook.titleeditor.ui.BookEditorTitleAndSeries;
import com.nielsenbook.titleeditor.ui.WizardPage;
import com.nielsenbook.titleeditor.ui.enums.Pages;

public class BookEditorFactory {
	
	private static BookEditorFactory INSTANCE;
	@Autowired
	private BookRepository repository;
	
	private BookEditorFactory() {
		super();
	}
	
	public WizardPage createPage(final Pages page) {
		switch (page) {
		case PUBLICATION:
			return new BookEditorPublication(repository);
		case TITLE_AND_SERIES:
			return new BookEditorTitleAndSeries(repository);
		}
		return null;
		
	}
	
	public static BookEditorFactory getInstance() {
		if (INSTANCE == null) {
			 INSTANCE = new BookEditorFactory();			
		}
		return INSTANCE;
	}
		

}
