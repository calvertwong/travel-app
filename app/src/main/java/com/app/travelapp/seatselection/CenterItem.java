package com.app.travelapp.seatselection;

public class CenterItem extends AbstractItem {

    public CenterItem(String label, String status) {
        super(label, status);
    }


    @Override
    public int getType() {
        return TYPE_CENTER;
    }

}
