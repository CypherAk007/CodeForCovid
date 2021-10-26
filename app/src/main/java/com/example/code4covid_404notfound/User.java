package com.example.code4covid_404notfound;

public class User {
    private String mName;
    private String mAge;

    public boolean isVal() {
        return val;
    }

    public void setVal(boolean val) {
        this.val = val;
    }

    private boolean val;


    private String mContact;
    public User(){}
    public User(boolean val){
        this.val = val;
    }


    public User(String mName, String mAge, String phone) {
        this.mName = mName;
        this.mAge = mAge;
        this.mContact = phone;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAge() {
        return mAge;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }

    public String getmContact() {
        return mContact;
    }

    public void setmContact(String mContact) {
        this.mContact = mContact;
    }
}
