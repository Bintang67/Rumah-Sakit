package com.bintang.rumahsakit;

public class Member {
    public int id;
    public String name;
    public String username;

    public Member(int id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
    }

    @Override
    public String toString() {
        return name + " (@" + username + ")";
    }
}