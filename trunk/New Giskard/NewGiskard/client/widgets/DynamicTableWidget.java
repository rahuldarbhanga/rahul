/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 11:51:04 AM
 */
package com.wissen.NewGiskard.client.widgets;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.wissen.NewGiskard.client.data.ColumnData;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 10-Aug-2010 Description:- This is The Widget To Display The Invoice Table To The Screen.
 */
public class DynamicTableWidget extends Composite {

    private final Grid      grid        = new Grid();

    private VerticalPanel   panel       = new VerticalPanel();

    private HorizontalPanel buttonPanel = new HorizontalPanel();

    private Button          addButton   = new Button("Add");

    private Button          delButton   = new Button("Delete");

    private Button          editButton  = new Button("Edit");

    private final int       rowCount    = 10;

    private int             selectedRow;

    /**
     * Constructor Of widget Which Sets The Header And Data Of The Columns.
     * 
     */

    public DynamicTableWidget(String[] header, List<ColumnData[]> colmData) {

        initTable(header);
        initContent(colmData);
        initButtons();
        panel.add(grid);
        panel.add(buttonPanel);

        initWidget(panel);

    }

    private void initContent(List<ColumnData[]> colmData) {

        int i = 0;
        int j = 1;

        for (ColumnData[] datas : colmData) {
            for (i = 0; i <= 4; i++) {
                grid.setText(j, i, datas[i].getValues());
            }
            j++;
        }
    }

    /**
     * Initializes The Buttons On The Widget.
     * 
     */

    private void initButtons() {

        buttonPanel.add(addButton);
        buttonPanel.add(delButton);
        buttonPanel.add(editButton);
        addButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {

                addButtonClick();

            }
        });
        delButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {

                delButtonClick();
            }

        });
        editButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {

                editButtonClick();
            }

        });

    }

    private void addButtonClick() {

        // showDialog();

    }

    private void delButtonClick() {

    }

    private void editButtonClick() {

    }

    /*private void showDialog() {
        DialogBox dialogBox = new DialogBox();
        dialogBox.add(new Label("OK"));
        dialogBox.setHeight("300");
        dialogBox.center();
        dialogBox.show();
    }
    */

    /**
     * Sets Up The Header Row With The Given String Array Of Header.
     * 
     */
    public void initTable(String[] headers) {
        grid.resize(rowCount + 1, headers.length);
        grid.addStyleName("dynamicTableWidget");
        for (int i = 0, n = headers.length; i < n; i++) {
            //columnData = (ColumnData) headers.get(i);
            grid.setText(0, i, headers[i]);
            grid.getCellFormatter().addStyleName(0, i, "dynamicTableHeader");

        }
        grid.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                if (grid.getCellForEvent(event).getRowIndex() != 0) {
                    grid.getRowFormatter().removeStyleName(selectedRow, "selectedRow");
                    selectedRow = grid.getCellForEvent(event).getRowIndex();
                    grid.getRowFormatter().setStyleName(selectedRow, "selectedRow");
                }

                //Window.alert(" " + grid.getCellForEvent(event).getCellIndex() + " " + grid.getCellForEvent(event).getRowIndex());
            }
        });
    }
}
