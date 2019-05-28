package com.app.travelapp.seatselection;

public abstract class AbstractItem {

    public static final int TYPE_CENTER = 0;
    public static final int TYPE_EDGE = 1;
    public static final int TYPE_EMPTY = 2;

    private String label;
    private String status;


    public AbstractItem(String label, String status) {
        this.label = label;
        this.status = status;
    }


    public String getLabel() {
        return label;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    abstract public int getType();


}
