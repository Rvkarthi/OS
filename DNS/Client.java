import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Client {
    
    public static void main(String[] args) throws Exception {
        
        try {
            
            Socket socket = new Socket("localhost",7878);
            Scanner scan = new Scanner(System.in);

            // user input
            System.out.println("enter the domain name: ");
            String domain = scan.nextLine();

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // sents input to server
            out.writeUTF(domain);
            
            // receive the data from server
            String ip = in.readUTF();

            // show the received data
            System.out.println("ip : " + ip);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

    }


}
