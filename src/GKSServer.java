import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GKSServer extends Thread {

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
                DataInputStream in = new DataInputStream(server.getInputStream());

                while (true) {
                    System.out.println(in.readUTF());
                    DataOutputStream out = new DataOutputStream(server.getOutputStream());
                    out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()
                            + "\nGoodbye!");
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
