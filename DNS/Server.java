import java.util.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws Exception {
        
       try {
        
        ServerSocket ss = new ServerSocket(7878);
        Socket socket = ss.accept();

        HashMap<String, String> dnsTable = new HashMap<String, String> ();
        dnsTable.put("google.com", "8.8.8.8")

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String domain = in.readUTF();

        System.out.println("Client sents " + domain);
        out.writeUTF("8.8.8.8");

       } catch (Exception e) {
        // TODO: handle exception
        System.out.println(e);
       }

    }
}