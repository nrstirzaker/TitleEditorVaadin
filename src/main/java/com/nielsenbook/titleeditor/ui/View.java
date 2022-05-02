package com.nielsenbook.titleeditor.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.RouterLayout;

public class View extends Div implements RouterLayout{

	private static final long serialVersionUID = -7287179294541870581L;

	public View() {
        getElement().getStyle().set("height", "100%");
    }
}
