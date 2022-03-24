package com.coffee.model;


public class Account {

    private int __id_account;
    private String username_account, email_account, password_account;
    public Account(){
    }

    public int get__id_account() {
        return __id_account;
    }

    public void set__id_account(int __id_account) {
        this.__id_account = __id_account;
    }

    public String getUsername_account() {
        return username_account;
    }

    public void setUsername_account(String username_account) {
        this.username_account = username_account;
    }

    public String getEmail_account() {
        return email_account;
    }

    public void setEmail_account(String email_account) {
        this.email_account = email_account;
    }

    public String getPassword_account() {
        return password_account;
    }

    public void setPassword_account(String password_account) {
        this.password_account = password_account;
    }
}
