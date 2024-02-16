# Exercices de Sockets Java

Ce projet contient une série d'exercices démontrant la mise en œuvre de connexions client-serveur en Java, chaque exercice développant les concepts du précédent.

## Exercice 1 : Connexion Socket Simple

Dans le premier exercice, nous établissons une connexion socket de base entre un client et un serveur. Le client et le serveur communiquent en échangeant des messages simples.

### Fichiers :
- `src/EX1/SocketClient.java` : Code côté client pour la connexion socket.
- `src/EX1/SocketServeur.java` : Code côté serveur pour la connexion socket.

## Exercice 2 : Objets Sérialisables

Dans le deuxième exercice, nous améliorons la communication en utilisant le concept de sérialisation. Le client envoie un objet voiture au serveur. Le serveur modifie l'objet et le renvoie au client.

### Fichiers :
- `src/EX2/Client.java` : Code côté client pour l'envoi d'un objet sérialisable (voiture) au serveur.
- `src/EX2/Server.java` : Code côté serveur pour la réception et la modification de l'objet Voiture.

## Exercice 3 : Échange de Données Utilisateur avec Hachage

Le troisième exercice implique l'établissement d'une connexion où le serveur reçoit et traite les données utilisateur (nom et âge) du client. Le serveur répond avec un hachage servant d'identifiant utilisateur.

### Fichiers :
- `src/EX3/Client.java` : Code côté client pour l'envoi de données utilisateur au serveur.
- `src/EX3/Server.java` : Code côté serveur pour la réception des données utilisateur, la génération d'un hachage et la réponse.

