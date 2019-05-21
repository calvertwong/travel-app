package com.app.travelapp.authentication;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class LogResponse {
    @SerializedName("msg")

    private String msg;
    @SerializedName("userid")

    private String userid;
    @SerializedName("firstname")

    private String firstname;
    @SerializedName("lastname")

    private String lastname;
    @SerializedName("email")

    private String email;
    @SerializedName("mobile")

    private String mobile;
    @SerializedName("appapikey ")

    private String appapikey;

    public LogResponse(String msg, String userid, String firstname, String lastname, String email, String mobile, String appapikey) {
        this.msg = msg;
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mobile = mobile;
        this.appapikey = appapikey;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAppapikey() {
        return appapikey;
    }

    public void setAppapikey(String appapikey) {
        this.appapikey = appapikey;
    }
}
