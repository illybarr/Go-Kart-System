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

            System.out.println("------ Menu ------");
            System.out.println("1: Create new driver");
            System.out.println("2: Assign kart to driver");
            System.out.println("3: Schedule driver for race");
            System.out.println("4: Create race from database of existing members");
            System.out.println("Enter a menu option: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int command = Integer.parseInt(in.readLine());

            out.writeUTF("\nYou have chosen option" + command);
            //String optionEntered = in.readLine();
            //out.writeUTF(" 1 Hello from " + client.getLocalSocketAddress());
            //System.out.println(" 2 Server says " + serverIn.readUTF());
            
            
            //String arguments = Integer.toString(command);
            
            switch(command)
            {
                case 4:
                    out.writeUTF("\nThe drivers will be chosen from a database of existing members.\n");
                    VerifyLiability checkLiable = new VerifyLiability();
                    out.writeUTF("All drivers have accepted liability.");
                    checkLiable.verifyLiability();
           
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
