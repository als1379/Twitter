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
                    case "follow":
                        follow();
                        break;
                    case "unfollow":
                        unfollow();
                        break;
                    case "like":
                        like();
                        break;
                    case "unlike":
                        unlike();
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void unlike() throws IOException {
        int tweetId = dataInputStream.readInt();
        for (Tweet t : Server.tweets) {
            if (t.id == tweetId) {
                ////////////////////////////////////////////////////
            }
        }
    }

    private void like() throws IOException {
        int tweetId = dataInputStream.readInt();
        for (Tweet t : Server.tweets) {
            if (t.id == tweetId) {
                ////////////////////////////////////////////////////
            }
        }
    }

    private void unfollow() throws IOException { /////////////////////////////////////
        String username = dataInputStream.readUTF();
        for (User u : Server.users) {
            if (u.username.equals(user.username)) {
                continue;
            }
            if (u.username.equals(username)) {

            }
        }
    }

    private void follow() throws IOException { ///////////////////////////////////////
        String username = dataInputStream.readUTF();
        for (User u : Server.users) {
            if (u.username.equals(user.username)) {
                continue;
            }
            if (u.username.equals(username)) {

            }
        }
    }

    /**
     * method to add new tweet
     */
    private void tweet() {

    }

    /**
     * method to take all tweets from server for timeline
     */
    private void getTweets() {

    }

    private void signup() throws IOException {

        String name = dataInputStream.readUTF();
        String username = dataInputStream.readUTF();
        String password = dataInputStream.readUTF();
        String email = dataInputStream.readUTF();

        boolean userExist = false;

        for (User u : Server.users) {
            if (user.username.equals(username)) {
                userExist = true;
            }
        }
        if (userExist) {
            dataOutputStream.writeBoolean(false);
            dataOutputStream.flush();
        } else {
            dataOutputStream.writeBoolean(true);
            dataOutputStream.flush();
            user = new User(name, username, password, email);
            Server.users.add(user);
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
                    user = u;
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
