import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class GKSServer extends Thread {

    ArrayList<Driver> drivers = new ArrayList<Driver>();
    ArrayList<Race> races = new ArrayList<Race>();

    private ServerSocket serverSocket;

    public GKSServer() throws IOException {
        serverSocket = new ServerSocket(8765);
    }

    public void run() {
        while(true) {
            try {
                System.out.println("Waiting for employee terminal to connect on port " + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();

                System.out.println(server.getRemoteSocketAddress() + " just connected to the server.");

                // Set up stream from client to server
                DataInputStream inFromClient = new DataInputStream(server.getInputStream());
                //BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));

                // Set up stream from server to client
                DataOutputStream outToClient = new DataOutputStream(server.getOutputStream());

                while (true) {

                    // Wait for request from client
                    String request[] = inFromClient.readUTF().split("\\r?\\n"); // Parse request data

                    int command = Integer.valueOf(request[0]); // Get the first argument in the request
                    switch(command) {
                        case 1:
                            if(drivers.add(new Driver(request[1], Long.parseLong(request[2]))))
                                outToClient.writeUTF(String.valueOf(drivers.get(drivers.size()-1).getId()));
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            // Call method to load drivers from file
                            break;
                        case 5:
                            break;
                    }

                }
                //server.close();
            }
            catch (IOException e) {

            }

        }
    }

    public static void main(String[] args) {
        System.out.println("Starting server...");
        Thread t = null;
        try {
            t = new GKSServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server started.");
        t.start();
    }
}
