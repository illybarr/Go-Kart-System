import java.io.*;
import java.net.Socket;

public class GKSClient {

    private static Socket client;

    public static void main(String[] args) {
        try {
            client = new Socket("localhost", 8765);

            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            InputStream inFromServer = client.getInputStream();
            DataInputStream serverIn = new DataInputStream(inFromServer);

            //out.writeUTF("Hello from " + client.getLocalSocketAddress());

            //System.out.println("Server says " + serverIn.readUTF());

            // TODO Include the menu system as a loop

            System.out.println("------ Menu ------");
            System.out.println("1: Create new driver");
            System.out.println("2: Assign kart to driver");
            System.out.println("3: Schedule driver for race");
            System.out.println("4: Load drivers from file");
            System.out.println("5: Exit");
            System.out.println("Enter a menu option: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


            // TODO Only accept numbers, retry if not a number
            int command = Integer.parseInt(in.readLine());
            String arguments = Integer.toString(command);

            switch(command) {
                case 1:
                    System.out.println("Enter the drivers name: ");
                    arguments = arguments + "\n" + in.readLine();
                    System.out.println("Enter a phone number: ");
                    arguments = arguments + "\n" + in.readLine();
                    out.writeBytes(arguments);
                    break;
                case 2:
                    System.out.println("Enter the drivers id number: ");
                    arguments = arguments + "\n" + in.readLine();
                    System.out.println("Enter a race id: ");
                    arguments = arguments + "\n" + in.readLine();
                    out.writeBytes(arguments);
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Loading drivers from file...");
                    out.writeBytes(arguments);
                    break;
            }

            //out.writeUTF(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
