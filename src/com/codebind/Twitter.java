package com.codebind;

import java.io.IOException;

public class Twitter {

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 12065);
        StartPage start = new StartPage();
        start.Start();
    }

}
