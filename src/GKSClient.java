import java.io.*;
import java.net.Socket;

public class GKSClient {

    static Socket client;

    public static void main(String[] args) {
        try {
            client = new Socket("localhost", 8765);

            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            InputStream inFromServer = client.getInputStream();
            DataInputStream serverIn = new DataInputStream(inFromServer);

            //out.writeUTF("Hello from " + client.getLocalSocketAddress());

            //System.out.println("Server says " + serverIn.readUTF());

            System.out.println("------ Menu ------");
            System.out.println("1: Create new driver");
            System.out.println("2: Assign kart to driver");
            System.out.println("3: Schedule driver for race");
            System.out.println("Enter a menu option: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            out.writeUTF(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
