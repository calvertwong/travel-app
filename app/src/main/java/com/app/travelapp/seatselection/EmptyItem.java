package com.app.travelapp.seatselection;

public class EmptyItem extends AbstractItem {

    public EmptyItem(String label, String status) {
        super(label, status);
    }


    @Override
    public int getType() {
        return TYPE_EMPTY;
    }

}
