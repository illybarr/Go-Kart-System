import java.io.*;
import java.net.Socket;

public class GKSClient {

    private static Socket client;

    public static void main(String[] args) {
        try {
            client = new Socket("localhost", 8765);

            // Set connection out to server
            OutputStream outStream = client.getOutputStream();
            DataOutputStream serverOut = new DataOutputStream(outStream);

            // Set connection in from server
            InputStream inStream = client.getInputStream();
            DataInputStream serverIn = new DataInputStream(inStream);

            // Set up reader to catch input from user input
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                // TODO Include the menu system as a loop

                System.out.println("------ Menu ------");
                System.out.println("1: Create new Driver");
                System.out.println("2: Assign Kart to Driver");
                System.out.println("3: Schedule Driver for Race");
                System.out.println("4: Create new Race");
                System.out.println("5: Load drivers from file");
                System.out.println("6: List Race Information");
                System.out.println("7: List Driver");
                System.out.println("8: Exit");
                System.out.print("Enter a menu option: ");

                // TODO Only accept numbers, retry if not a number
                int command = Integer.parseInt(consoleReader.readLine());
                String request = Integer.toString(command); // Create request to be built and sent to server

                String[] response;

                switch (command) {
                    case 1:
                        System.out.print("Enter the drivers name: ");
                        request = request + "\n" + consoleReader.readLine();
                        System.out.print("Enter a phone number: ");
                        request = request + "\n" + consoleReader.readLine();
                        serverOut.writeUTF(request); // Send request to server
                        System.out.println("Created Driver with ID of " + serverIn.readUTF()); // Wait for retrieval of driver ID number
                        System.out.println();
                        break;
                    case 2:
                        System.out.print("Enter the Kart number: ");
                        request = request + "\n" + consoleReader.readLine();
                        System.out.print("Enter the drivers ID number: ");
                        request = request + "\n" + consoleReader.readLine();
                        serverOut.writeUTF(request); // Send request to server
                        response = serverIn.readUTF().split("\\r?\\n"); // Parse request data
                        System.out.println("Assigned Driver with ID of " + response[0] + " to Kart number " + response[1]);
                        System.out.println();
                        break;
                    case 3:
                        System.out.print("Enter the drivers ID number: ");
                        request = request + "\n" + consoleReader.readLine();
                        System.out.print("Enter a race ID: ");
                        request = request + "\n" + consoleReader.readLine();
                        serverOut.writeUTF(request);
                        System.out.println();
                        break;
                    case 4:
                        serverOut.writeUTF(request);
                        response = serverIn.readUTF().split("\\r?\\n"); // Parse request data
                        System.out.println("Created new Race with ID of " + response[0] + " and starting time of " + response[1]);
                        System.out.println();
                        break;
                    case 5:
                        System.out.println("\nThe drivers will be chosen from a database of existing members.\n");
                        VerifyLiability checkLiable = new VerifyLiability();
                        serverOut.writeUTF(request);
                        serverOut.writeUTF("All drivers have accepted liability.");
                        checkLiable.verifyLiability();
                        break;
                    case 6:
                        serverOut.writeUTF(request);
                        break;
                    case 7:
                        break;
                    case 8:
                        System.out.println("Quitting the Empolyee Terminal...");
                        System.exit(0);
                        break;
                }
            }

            //out.writeUTF(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
