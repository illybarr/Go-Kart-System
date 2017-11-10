import java.io.*;
import java.net.Socket;

public class GKSClient {

    static Socket client;

    public static void main(String[] args) {
        try {
            client = new Socket("localhost", 8765);
            System.out.println(client.isConnected());

            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            System.out.println("Server says " + in.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
