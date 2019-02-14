package com.gmail.tarasov1998.demoapplication;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private List<Integer> id = new ArrayList<>();
    private List<String> name = new ArrayList<>();
    private List<String> username = new ArrayList<>();
    private List<String> email = new ArrayList<>();
    private List<String> phone = new ArrayList<>();
    private List<String> catchPhrase = new ArrayList<>();
    private List<String> website = new ArrayList<>();
    private List<Integer> avatar = new ArrayList<>();

    public int getId(int index) {
        return id.get(index);
    }

    public void setId(int i) {
        id.add(i);
    }

    public String getName(int index) {
        return name.get(index);
    }

    public void setName(String n) {
        name.add(n);
    }

    public String getUsername(int index) {
        return username.get(index);
    }

    public void setUsername(String u) {
        username.add(u);
    }

    public String getEmail(int index) {
        return email.get(index);
    }

    public void setEmail(String e) {
        email.add(e);
    }

    public String getPhone(int index) {
        return phone.get(index);
    }

    public void setPhone(String p) {
        phone.add(p);
    }

    public String getCatchPhrase(int index) {
        return catchPhrase.get(index);
    }

    public void setCatchPhrase(String c) {
        catchPhrase.add(c);
    }

    public String getWebsite(int index) {
        return website.get(index);
    }

    public void setWebsite(String w) {
        website.add(w);
    }

    public int getAvatar(int index) {
        return avatar.get(index);
    }

    public void setAvatar(int a) {
        avatar.add(a);
    }



}
