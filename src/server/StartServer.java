package server;

public class StartServer {

    public static void main(String[] args) {
        Server server = new Server(12065);
        server.start();
    }
}
