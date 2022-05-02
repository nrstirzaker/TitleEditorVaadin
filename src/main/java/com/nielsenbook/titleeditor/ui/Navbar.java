package com.nielsenbook.titleeditor.ui;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.nielsenbook.titleeditor.entity.Book;
import com.nielsenbook.titleeditor.entity.BookRepository;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class Navbar implements KeyNotifier {

	private static final long serialVersionUID = 8489376518733510057L;
	private BookRepository repository;
    private Book book;
    
	private BookRepository bookRepository;	
	private final Map<NavMenu,SelectableMenuItem>  navLabelMap; 
    

	
	
    @Autowired   
    public  Navbar(final BookRepository repository) {
    	this.repository = bookRepository;
    	navLabelMap = new HashMap<NavMenu, SelectableMenuItem>();
    }
    
    public Tabs generateTabs() {
    	
    	NavRequiredLabel publication = new NavRequiredLabel(NavMenu.PUBLICATION);    	
    	NavRequiredLabel titleAndSeries = new NavRequiredLabel(NavMenu.TITLE_AND_SERIES);
    	NavRequiredLabel editionAndLanguage = new NavRequiredLabel(NavMenu.EDITION_AND_LANGUAGE);
    	NavLabel contributors = new NavLabel(NavMenu.CONTRIBUTORS);
    	NavRequiredLabel format = new NavRequiredLabel(NavMenu.FORMAT);
    	NavLabel physical = new NavLabel(NavMenu.PHYSICAL);
    	NavLabel descriptive = new NavLabel(NavMenu.DESCRIPTIVE);
    	
    	navLabelMap.put(NavMenu.PUBLICATION,publication);
    	navLabelMap.put(NavMenu.TITLE_AND_SERIES,titleAndSeries);
    	navLabelMap.put(NavMenu.EDITION_AND_LANGUAGE,editionAndLanguage);    	
    	navLabelMap.put(NavMenu.CONTRIBUTORS,contributors);
    	navLabelMap.put(NavMenu.FORMAT,format);
    	navLabelMap.put(NavMenu.PHYSICAL,physical);
    	navLabelMap.put(NavMenu.DESCRIPTIVE,descriptive);

    	Tabs tabs = new Tabs(publication,titleAndSeries,editionAndLanguage,contributors,format,physical,descriptive);
    	tabs.addSelectedChangeListener(event -> {
    		NavLabel selectedTab = (NavLabel)tabs.getSelectedTab();
    		NavMenu navMenu = selectedTab.getNavMenu();
    		
    	});
    	//Tabs tabs = new Tabs(new Tab(NavMenu.PUBLICATION.getLabel()),new Tab(NavMenu.TITLE_AND_SERIES.getLabel()));//,titleAndSeries,editionAndLanguage,contributors,format,physical,descriptive);
    	tabs.setOrientation(Tabs.Orientation.VERTICAL);
    	return tabs;
    }
    
    public void selectMenuItem(final NavMenu navLabel) {
    	 for (NavMenu navMenuKey : navLabelMap.keySet()) {
    		 Tab menuItem = (Tab)navLabelMap.get(navMenuKey); 
    		 if (navMenuKey == navLabel) {
    			 menuItem.setSelected(true);
    		 }else {
    			 menuItem.setSelected(false);
    		 }
    		 
    	 }
    }
    
    public interface ChangeHandler {
        void onChange();
    }
}