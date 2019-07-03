package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server {

    ServerSocket serverSocket;
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Tweet> tweets = new ArrayList<>();
    static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    void start() throws IOException {
        while (true) {
            clientHandlers.add(new ClientHandler(serverSocket.accept()));
        }
    }
}
