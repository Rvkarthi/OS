import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient
{
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost",9999);
        System.out.println("hello world");
        System.out.println("connected to server");

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        Scanner scan = new Scanner(System.in);

        String serverMessage = input.readUTF();
        System.out.println(serverMessage);

        String line;
        do {
            System.out.println("client: ");
            line = scan.nextLine();
            output.writeUTF(line);
            System.out.println(input.readUTF());
              
        } while (!line.equalsIgnoreCase("bye"));
        socket.close();
        scan.close();
        System.out.println("Disconnected.");
    }
}