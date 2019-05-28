package com.app.travelapp.utils;

import java.util.List;

public class SelectedSeatClass {
    private List<String> selectedSeatList;

    public SelectedSeatClass(List<String> selectedSeatList) {
        this.selectedSeatList = selectedSeatList;
    }

    public SelectedSeatClass() {

    }

    public List<String> getSelectedSeatList() {
        return selectedSeatList;
    }

    public void setSelectedSeatList(List<String> selectedSeatList) {
        this.selectedSeatList = selectedSeatList;
    }
}
