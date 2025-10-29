import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) throws Exception {
        
        Socket socket =  new Socket("localhost",9999);
        System.out.println("connected to server");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        Scanner scan = new Scanner(System.in);

        String got = "",  sent = "";
        while(true)
        {
            System.out.print("client : ");
            sent = scan.nextLine();
            if(sent.equalsIgnoreCase("bye"))
                break;
            out.writeUTF(sent);
            got = in.readUTF();
            System.out.println("server : "+got);
        }
        socket.close();
        in.close();
        out.close();
        scan.close();
    }
}