import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serversocket = new ServerSocket(9999);
        System.out.println("Waiting for client...");

        while (true) {
            Socket socket = serversocket.accept();
            System.out.println("Client connected.");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            output.writeUTF("Ready to receive your message");

            String msg;
            do {
                msg = input.readUTF();
                System.out.println("Received from client: " + msg);
                output.writeUTF("server: i got -> " + msg);
            } while (!msg.equalsIgnoreCase("bye"));

            System.out.println("Client disconnected.");
            socket.close();
        }
    }
}
