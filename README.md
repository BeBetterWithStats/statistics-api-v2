
# Présentation

Description de l'API BBWS



# Les outils
1. [API Studio](http://www.apistudio.io) pour créer un swagger de son API
2. [Kong](http://www.getkong.org) pour gérer votre API (accès, log, money)
3. [3scale](http://www.3scale.io) equivalent de Kong gratuit jusqu'à 50 000 requetes jour
4. [Readme](http://www.readme.io) site *hyper cher* permettant de partager la documentation d'utiisation de votre API
5. [Jersey](https://jersey.github.io/)
6. [Glassfish](https://javaee.github.io/glassfish/) et son [outil Eclipse] (http://download.eclipse.org/glassfish-tools/1.0.0/repository/)
7. [Tomcat](https://tomcat.apache.org/download-90.cgi) et prendre le tar.gz et ajouter le catalina-ws.jar



# Importation du projet
1. Créer une arborescence \<root\>/Documents/Developpement/Bbws/
2. `git config --global user.name bebetterwithstats@gmail.com`
3. `git clone <mettre_ici_url_du_git_project>`
4. Se positionner en ligne de commande dans le répertoire nouvelement créé
5. `mvn eclipse:eclipse`

# Modification d'un projet
1. 


# Initialiation du projet si le projet est vide
1. `mvn archetype:generate`
2. choisir 1685 ou 1682 ou 593 ou 7 // 593 a été utilisé la première fois


# Lancer / Executer l'application
1. `mvn exec:java`
2. pour tester
   - ouvrir le navigateur et taper `http://localhost:8080/`
   - dans un terminal `curl -X GET "localhost:8080/"`
   - le message suivant devrait s'afficher
   > Welcome on the <b>Be Better With Statistics</b> API !<br>


# Documentation ElasticSearchAPI
- [Récupérer les JAR](https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/_maven_repository.html)
- [Documentation utilisation de l'API](https://www.elastic.co/guide/en/elasticsearch/client/java-api/current/index.html)
- Delete all index : curl -X DELETE "localhost:9200/baseball-eu"
- [Exemple de POST depuis une classe java](https://jersey.github.io/documentation/latest/client.html#client.ex.formpost)



# TODO list
- [x] Gérer l'absence de query param player pour la route `/pa`
- [x] Aout de l'attribut sort
- [x] Revoir la route `pa?&player=` en `pa?search=`
- [x] Filtrer l'output ES pour ne restituer que les attributs nécessaires pour l'instant
- [ ] Bug sur les joueurs possédant le meme prénom
- [x] Renommer le queryParam `sort` en mode `sort_by`
- [ ] Gérer le queryParam `sort` en mode liste
- [ ] Clean code pour déporter les appels elasticSearch dans la couche service plutot que les classes ressources
- [ ] Revoir les IF/ELSE pour que les erreurs ne soient renvoyées que par les ELSE
- [ ] Revoir la nature des exceptions renvoyées par la couche Service


# Normes de code
- les urls des API sont Kebab case (ex : `list-of-something`)
- les attributs du JSON sont Lower Camel case (ex : `playerName`)
- les attributs ElasticSearch sont Snake case (ex : `player_name`)

- les paramètres d'une fonction ou méthode doivent etre préfixés par 'p_'
- les variables associées ux listes ou tableaux doivent etre écrites au pluriel
- dans une boucle, les incréments des listes ou tableaux doivent porté le meme nom que la liste mais au singulier
- dans une boucle, les variables qui s'incrémentent doivent etre préfixées du symbole '_' et autant de fois qu'il y a de boucles imbriquées. Sont dispensés de cette règle, les incréments d'un caractère (i, j, ...) ou les mots clés `index` ou `key` ou `iterator`
- les noms des méthodes doivent etre en anglais
- les uri doivent etre en anglais
