package EX3;

import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;

public class Serveur {
    public static void main(String[] args) {
        int port = 0;
        Scanner keyb = new Scanner(System.in);
        System.out.print("Port d'écoute : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le paramètre n'est pas un entier.");
            System.err.println("Usage : java ServeurUDP port-serveur");
            System.exit(-1);
        }
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());

                Person person = (Person) input.readObject();

                int clientId = generateClientId(person.getAge(), person.getName());

                output.writeInt(clientId);
                output.flush();

                clientSocket.close();
            }

        } catch (Exception e) {
            System.err.println("Server error: " + e);
        }
    }
    private static int generateClientId(int age, String name) {
        try {
            String dataToHash = age + name;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(dataToHash.getBytes());

            return Math.abs(Arrays.hashCode(hash));

        } catch (Exception e) {
            System.err.println("Error generating client ID: " + e);
            return -1;
        }
    }
}
