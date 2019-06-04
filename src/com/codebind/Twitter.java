package com.codebind;

import java.util.ArrayList;
public class Twitter {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Tweet> tweets = new ArrayList<>();
    public static void main(String[] args) {
        StartPage start = new StartPage();
        start.Start();
    }

}
