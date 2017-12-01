import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class GKSServer extends Thread {

    ArrayList<Race> races = new ArrayList<Race>();
    ArrayList<Driver> drivers = new ArrayList<Driver>();

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
                            assignDriverToRace(Integer.valueOf(request[1]), Integer.parseInt(request[2]));
                            break;
                        case 4:
                            Race race = new Race();
                            races.add(race);
                            outToClient.writeUTF(String.valueOf(race.getId()) + '\n' + race.getStartTimeSttring());
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            System.out.println("Emplpyee Terminal has disconnected..");
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

    private void assignDriverToRace(int driverId, int raceId) {
        int driverIndex = -1;
        int raceIndex = -1;

        for(Driver d : drivers) {
            if(d.getId() == driverId)
                driverIndex = drivers.indexOf(d);
        }
        if(driverIndex == -1) {
            System.out.println("Driver could not be foudnd");
            return;
        }

        for(Race r : races) {
            if(r.getId() == raceId)
                raceIndex = races.indexOf(r);
        }
        if(raceIndex == -1) {
            System.out.println("Race could not be foudnd");
            return;
        }

        drivers.get(driverIndex).setAssignedRace(races.get(raceIndex));
        races.get(raceIndex).addDriver(drivers.get(driverIndex));
        System.out.println("Assigned driver with ID "+ driverId + " to race with ID " + raceId);
    }
}
