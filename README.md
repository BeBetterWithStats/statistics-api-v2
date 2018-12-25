
# Présentation

Description de l'API BBWS

## Installation
1. GitBash et GitHub
2. Eclipse
3. Visual Studio Code
4. Notepad++ (PC) ou Sublime Text (Mac)
5. Installer le JDK 8u181 ou version supérieur mais en restant en version 8
6. Intaller Curl executable (PC uniquement) car sur MAC OS celui est déjà installé
7. Installer [ElasticSearch](https://www.elastic.co/) 
    1. Dézipper le fichier .tar.gz
    2. Copier coller le répertoire elastice-search- dans le répertoire application de MACOSX
8. Installer Maven
9. Sur MAC uniquement, configurer le fichier /users/alexandrelods/.bashprofile pour ajouter la commande maven a. Ouvrir le fichier .bashprofile ou le créer s'il n'existe pas b. Si le fichier n'existait pas, ajouter la ligne. Sinon passez cette étape et rendez vous à l'étape c - export PATH=/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin c. Ajouter les lignes à la fin du fichier - export M2_HOME=/Users/alexandrelods/Applications/apache-maven-3.5.4 - export PATH=$PATH:$M2_HOME/bin d. Fermer toutes les fenetres du terminal et relancer e. vérifier que la commande mvn -versionrenvoie un résultat
10. Installer [npm & nodeJS](https://nodejs.org/en/)
11. installer [angularCLI](https://cli.angular.io/) en tapant `npm install -g @angular/cli` (pour MAC OS, préfixer la commande de sudo)
12. Installer [angular matérial](https://material.angular.io/components/categories) en tapant `ng add @angular/material`

## Les outils
1. [API Studio](http://www.apistudio.io) pour créer un swagger de son API
2. [Kong](http://www.getkong.org) pour gérer votre API (accès, log, money)
3. [3scale](http://www.3scale.io) equivalent de Kong gratuit jusqu'à 50 000 requetes jour
4. [Readme](http://www.readme.io) site *hyper cher* permettant de partager la documentation d'utiisation de votre API
5. [Jersey](https://jersey.github.io/)
6. [Glassfish](https://javaee.github.io/glassfish/) et son [outil Eclipse] (http://download.eclipse.org/glassfish-tools/1.0.0/repository/)
7. [Tomcat](https://tomcat.apache.org/download-90.cgi) et prendre le tar.gz et ajouter le catalina-ws.jar



## Importation du projet
1. Créer une arborescence \<root\>/Documents/Developpement/Bbws/
2. `git config --global user.name bebetterwithstats@gmail.com`
3. `git clone <mettre_ici_url_du_git_projet>`
4. Se positionner en ligne de commande dans le répertoire nouvelement créé
5. `mvn eclipse:eclipse`

## Modification d'un projet
1. 


## Initialiation du projet API si le projet est vide
1. `mvn archetype:generate`
2. choisir 1685 ou 1682 ou 593 ou 7 // 593 a été utilisé la première fois


## Initialiation du projet SPA si le projet est vide
1. `ng new <mettre_ici_le_nom_du_projet>`
2. choisir 1685 ou 1682 ou 593 ou 7 // 593 a été utilisé la première fois


## Lancer / Executer l'application
1. `mvn exec:java`
2. pour tester
   - ouvrir le navigateur et taper `http://localhost:8080/api/`
   - dans un terminal `curl -X GET "localhost:8080/api/"`
   - le message suivant devrait s'afficher
   > Welcome on the <b>Be Better With Statistics</b> API !<br>


## Normes de code
- les urls des API sont Kebab case (ex : `list-of-something`)
- les attributs du JSON sont Lower Camel case (ex : `playerName`)
- les attributs ElasticSearch sont Snake case (ex : `player_name`)

- les paramètres d'une fonction ou méthode doivent etre préfixés par 'p_'
- les variables associées ux listes ou tableaux doivent etre écrites au pluriel
- dans une boucle, les incréments des listes ou tableaux doivent porté le meme nom que la liste mais au singulier
- dans une boucle, les variables qui s'incrémentent doivent etre préfixées du symbole '_' et autant de fois qu'il y a de boucles imbriquées. Sont dispensés de cette règle, les incréments d'un caractère (i, j, ...) ou les mots clés `index` ou `key` ou `iterator`
- les noms des méthodes doivent etre en anglais
- les uri doivent etre en anglais


## Documentation ElasticSearchAPI
- [Récupérer les JAR](https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/_maven_repository.html)
- [Documentation utilisation de l'API](https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/index.html)
- Delete all index : curl -X DELETE "localhost:9200/baseball-eu"
- [Exemple de POST depuis une classe java](https://jersey.github.io/documentation/latest/client.html#client.ex.formpost)



# TODO list
- [x] Gérer l'absence de query param player pour la route `/pa`
- [x] Aout de l'attribut sort
- [x] Revoir la route `pa?&player=` en `pa?search=`
- [x] Filtrer l'output ES pour ne restituer que les attributs nécessaires pour l'instant
- [x] Renommer le queryParam `sort` en mode `sort_by`
- [x] Clean code pour déporter les appels elasticSearch dans la couche service plutot que les classes ressources
- [x] Revoir les IF/ELSE pour que les erreurs ne soient renvoyées que par les ELSE
- [x] Revoir la nature des exceptions renvoyées par la couche Service
- [x] Revoir la valorisation du champs created
- [?] Bug sur les joueurs possédant le meme prénom
- [ ] Gérer le queryParam `sort` en mode liste
- [ ] Dans la methode add de la classe PAService, il faut controler la valeur de certains parametres
- [ ] Dans la river, on ne devrait pas etre OUT AT FIRST et EMPTY, ce qui correspond à un pickoff // controle mis en place dans le filtre en attendant
- [ ] Mettre un nom d'équipe pour les remplacants
- [ ] Ajouter la notion de bunt
- [ ] Ajouter la notion de sac fly
- [ ] Rendre le nombre de résultat en paramêtre sur la ressource `pa?search=xxx&limit=10`
- [ ] Renommer la ressource `pa` en `plateappearances` ou `pas``
- [ ] Créer une ressource permettant d'avoir la fiche individuelle d'un joueur (walk, avg, sh/sf, pull/push)
 