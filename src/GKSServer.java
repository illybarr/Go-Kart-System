import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GKSServer extends Thread {

    //Driver drivers[] = new Driver[12];
    ArrayList<Driver> drivers = new ArrayList<Driver>();

    private ServerSocket serverSocket;

    public GKSServer() throws IOException {
        serverSocket = new ServerSocket(8765);
    }

    public void run() {
        while(true) {
            try {
                System.out.println("Waiting for employee terminal to connect on port " +
                        serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();

                System.out.println(server.getRemoteSocketAddress() + " just connected to the server.");
                //DataInputStream in = new DataInputStream(server.getInputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));

                while (true) {
                    //System.out.println(in.readLine().toString());
                    int command = Integer.valueOf(in.readLine().toString());
                    DataOutputStream out = new DataOutputStream(server.getOutputStream());
                    out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()
                            + "\nGoodbye!");

                    switch(command) {
                        case 1:
                            drivers.add(new Driver(in.readLine().toString()));
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
