package com.app.travelapp.sqlite;

public class CheckOrder {
    private String routeName;
    private int busid;
    private float fare;
    private float coupondiscount;
    private float servicetax;
    private String journydate;
    private String boardingtime;
    private String droppingtime;
    private float duration;
    private int passengerid;
    private String passengeremail;
    private int passengermobile;
    private int selectedseat;
    private String passengername;
    private int passengerage;
    private String passengergender;


    public CheckOrder(String routeName, int busid, float fare, float coupondiscount, float servicetax, String journydate, String boardingtime, String droppingtime, float duration, int passengerid, String passengeremail, int passengermobile, int selectedseat, String passengername, int passengerage, String passengergender) {
        this.routeName = routeName;
        this.busid = busid;
        this.fare = fare;
        this.coupondiscount = coupondiscount;
        this.servicetax = servicetax;
        this.journydate = journydate;
        this.boardingtime = boardingtime;
        this.droppingtime = droppingtime;
        this.duration = duration;
        this.passengerid = passengerid;
        this.passengeremail = passengeremail;
        this.passengermobile = passengermobile;
        this.selectedseat = selectedseat;
        this.passengername = passengername;
        this.passengerage = passengerage;
        this.passengergender = passengergender;
    }


    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public int getBusid() {
        return busid;
    }

    public void setBusid(int busid) {
        this.busid = busid;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    public float getCoupondiscount() {
        return coupondiscount;
    }

    public void setCoupondiscount(float coupondiscount) {
        this.coupondiscount = coupondiscount;
    }

    public float getServicetax() {
        return servicetax;
    }

    public void setServicetax(float servicetax) {
        this.servicetax = servicetax;
    }

    public String getJournydate() {
        return journydate;
    }

    public void setJournydate(String journydate) {
        this.journydate = journydate;
    }

    public String getBoardingtime() {
        return boardingtime;
    }

    public void setBoardingtime(String boardingtime) {
        this.boardingtime = boardingtime;
    }

    public String getDroppingtime() {
        return droppingtime;
    }

    public void setDroppingtime(String droppingtime) {
        this.droppingtime = droppingtime;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public int getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(int passengerid) {
        this.passengerid = passengerid;
    }

    public String getPassengeremail() {
        return passengeremail;
    }

    public void setPassengeremail(String passengeremail) {
        this.passengeremail = passengeremail;
    }

    public int getPassengermobile() {
        return passengermobile;
    }

    public void setPassengermobile(int passengermobile) {
        this.passengermobile = passengermobile;
    }

    public int getSelectedseat() {
        return selectedseat;
    }

    public void setSelectedseat(int selectedseat) {
        this.selectedseat = selectedseat;
    }

    public String getPassengername() {
        return passengername;
    }

    public void setPassengername(String passengername) {
        this.passengername = passengername;
    }

    public int getPassengerage() {
        return passengerage;
    }

    public void setPassengerage(int passengerage) {
        this.passengerage = passengerage;
    }

    public String getPassengergender() {
        return passengergender;
    }

    public void setPassengergender(String passengergender) {
        this.passengergender = passengergender;
    }
}
