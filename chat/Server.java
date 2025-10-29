import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serversocket = new ServerSocket(9999);
        System.out.println("server is started");

        Socket socket = serversocket.accept();
        System.out.println("client is connected");

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        Scanner scan  = new Scanner(System.in);

        String got ="", sent = "";
        while(true)
        {
            got = input.readUTF();
            if(got.equalsIgnoreCase("bye"))
                break;
            System.out.println("client: "+ got);
            System.out.print("server: ");
            sent = scan.nextLine();
            output.writeUTF(sent);
        }

        System.out.println("client is disconnected");
        socket.close();
        serversocket.close();
        input.close();
        output.close();
        scan.close();
    }
}
