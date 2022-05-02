package com.nielsenbook.titleeditor.ui;

import com.nielsenbook.titleeditor.entity.BookRepository;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route(value = "/", layout = View.class)
@CssImport("/css/style.css")
public class MainLayout extends AppLayout {
	
	private static final long serialVersionUID = -7824320888349973425L;
	private BookRepository bookRepository;
	private WizardPage currentEditor;
	private Navbar navbar;
	private NavButtonBar navButtonBar;
	private FormLayout layout;
	
	public MainLayout(final BookRepository bookRepository, final Navbar navbar, final BookEditorPublication editor) {
		
		this.bookRepository = bookRepository;
		this.currentEditor = editor;
		this.navbar = navbar;
		layout = new FormLayout();
		
		addToNavbar(new DrawerToggle());

		addToDrawer(navbar.generateTabs());
		navButtonBar = new NavButtonBar(this);
		changeView(editor);
	}
	
	public void changeView(final WizardPage editor) {
		layout.remove((Component)currentEditor);
		layout.add((Component)editor, navButtonBar);
		currentEditor = editor;
		navbar.selectMenuItem(editor.getNavMenu());
		setContent(layout);

	}

}
