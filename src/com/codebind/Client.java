package com.codebind;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    static Socket socket;
    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;

    Client(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    public static void print(String str) {
        try {
            dataOutputStream.writeUTF(str);
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
