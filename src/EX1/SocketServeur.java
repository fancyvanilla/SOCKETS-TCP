package EX1;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class SocketServeur {
    public static void main(String argv[]) {
        int port = 0;
        Scanner keyb = new Scanner(System.in);
// Lire un numéro de port d'écoute du serveur
        System.out.print("Port d'écoute : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le paramètre n'est pas un entier.");
            System.err.println("Usage : java ServeurUDP port-serveur");
            System.exit(-1);
        }
        try {
// Créer un socket serveur et le mettre en écoute
            ServerSocket serverSocket = new ServerSocket(port);
// Accepter une connexion et créer le socket serveur

            Socket socket = serverSocket.accept();

// Lire et écrire vers le client
            ObjectOutputStream output =
                    new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input =
                    new ObjectInputStream(socket.getInputStream());
// Lire un message du client
            String chaine = (String) input.readObject();
            System.out.println(" recu : " + chaine);
// Préciser l'adresse IP et le numéro de port du client
            System.out.println(" ca vient de : " + socket.getInetAddress() +
                    ":" + socket.getPort());
// Ecrire un message au client
            output.writeObject(new String("bien recu"));
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}