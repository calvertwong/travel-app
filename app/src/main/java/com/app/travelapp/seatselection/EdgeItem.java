package com.app.travelapp.seatselection;

public class EdgeItem extends AbstractItem {

    public EdgeItem(String label, String status) {
        super(label, status);
    }



    @Override
    public int getType() {
        return TYPE_EDGE;
    }

}
