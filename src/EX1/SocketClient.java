package EX1;
import java.io.*;
import java.net.*;
import java.util.Scanner;
class SocketClient {
    public static void main(String argv[]) {
        int port = 0;
        String host = "";
        Scanner keyb = new Scanner(System.in);
// lire le nom et le numéro de port de serveur auquel le client va se connecter
        System.out.print("Nom du serveur : ");
        host = keyb.next();
        System.out.print("Port du serveur : ");
        try {
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Le second paramètre n'est pas un entier.");
            System.exit(-1);
        }
// utliser Try-Catch en cas de connexion échouée
        try {
//récupérer l'adresse du serveur
            InetAddress adr = InetAddress.getByName(host);
//se connecter au serveur et créer un socket client
            Socket socket = new Socket(adr, port);
// lire et écrire vers le serveur
            ObjectOutputStream output =
                    new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input =
                    new ObjectInputStream(socket.getInputStream());
// écrire un message au serveur
            output.writeObject(new String("ma première socket"));
// recevoir un message de serveur
            String chaine = (String) input.readObject();
            System.out.println(" recu du serveur : " + chaine);
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}