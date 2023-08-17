package application;

import javafx.beans.property.SimpleStringProperty;

public class DataItem {
        private String[] values;

    public DataItem(String[] values) {
        this.values = values;
    }

    // Provide methods to access values by index
    public String getValue(int index) {
        return values[index];
    }

    // Properties for JavaFX PropertyValueFactory
    public SimpleStringProperty valueProperty(int index) {
        return new SimpleStringProperty(values[index]);
    }
    }