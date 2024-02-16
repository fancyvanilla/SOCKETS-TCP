package EX3;

import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        int port = 0;
        String host = "";
        int age=0;
        String name="";
        Scanner keyb = new Scanner(System.in);

        System.out.print("Server Name: ");
        host = keyb.next();
        System.out.print("Server Port: ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("The second parameter is not an integer.");
            System.exit(-1);
        }
        System.out.print("Name of the person: ");
        name = keyb.next();
        System.out.print("Age of the person: ");
        try {
            age = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("The age should be an integer.");
            System.exit(-1);
        }
        try {
            InetAddress adr = InetAddress.getByName(host);
            Socket socket = new Socket(adr, port);

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            Person person = new Person(age, name);

            output.writeObject(person);

            int clientId = input.readInt();
            System.out.println("Received client ID: " + clientId);

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}
