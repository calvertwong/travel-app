package com.app.travelapp.data.model;

class RegisterUser {
    private String registerFirstName, registerLastName, registerAddress, registerEmail, registerMobile, registerPassword;

    public RegisterUser(String registerFirstName, String registerLastName, String registerAddress, String registerEmail, String registerMobile, String registerPassword) {
        this.registerFirstName = registerFirstName;
        this.registerLastName = registerLastName;
        this.registerAddress = registerAddress;
        this.registerEmail = registerEmail;
        this.registerMobile = registerMobile;
        this.registerPassword = registerPassword;
    }

    public String getRegisterFirstName() {
        return registerFirstName;
    }

    public void setRegisterFirstName(String registerFirstName) {
        this.registerFirstName = registerFirstName;
    }

    public String getRegisterLastName() {
        return registerLastName;
    }

    public void setRegisterLastName(String registerLastName) {
        this.registerLastName = registerLastName;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getRegisterEmail() {
        return registerEmail;
    }

    public void setRegisterEmail(String registerEmail) {
        this.registerEmail = registerEmail;
    }

    public String getRegisterMobile() {
        return registerMobile;
    }

    public void setRegisterMobile(String registerMobile) {
        this.registerMobile = registerMobile;
    }

    public String getRegisterPassword() {
        return registerPassword;
    }

    public void setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword;
    }
}
