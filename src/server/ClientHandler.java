package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class ClientHandler extends Thread{

    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    User user;

    ClientHandler(Socket socket) throws IOException {
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        start();
    }

    @Override
    public void run() {
        String command;
        try {
            while (true) {
                command = dataInputStream.readUTF().toLowerCase();  // command to lowercase
                switch (command) {
                    case "login":
                        login();
                        break;
                    case "signup":
                        signup();
                        break;
                    case "tweet":
                        tweet();
                        break;
                    case "gettweets":
                        getTweets();
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void signup() throws IOException {
        String username = dataInputStream.readUTF();
        String password = dataInputStream.readUTF();
        boolean userExist = false;

        for (User u : Server.users) {
            if (user.username.equals(username)) {
                userExist = true;
            }
        }
    }

    private void login() throws IOException {
        String username = dataInputStream.readUTF();
        String password = dataInputStream.readUTF();
        boolean userExist = false;

        for (User u : Server.users) {
            if (u.username.equals(username)) {
                if (u.password.equals(password)) {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.flush();
                    user = new User(username, password);        ////////////// mitoni name va email ro bardari?
                } else {
                    dataOutputStream.writeBoolean(false);
                    dataOutputStream.flush();
                    dataOutputStream.writeUTF("wrong password");
                    dataOutputStream.flush();
                }
                userExist = true;
                break;
            }
        }

        if (! userExist) {
            dataOutputStream.writeBoolean(false);
            dataOutputStream.flush();
            dataOutputStream.writeUTF("user doesn't exists");
            dataOutputStream.flush();
        }
    }
}
