# Game Of Life | Jeu de la Vie
[![License: WTFPL](https://img.shields.io/badge/License-WTFPL-brightgreen.svg)](http://www.wtfpl.net/about/) ![Generic badge](https://img.shields.io/badge/Language-Java-orange.svg)

>Ce projet est une implémentation du [Jeu de la Vie](https://fr.wikipedia.org/wiki/Jeu_de_la_vie) de créé par John Conway utilisant un affichage graphique Java.

## Installation

Télécharger la dernière release puis l'extraire. Un fois dans le dossier source : 

 1. Sur Windows lancez **GameOfLife.exe** .
 
 3. Ou alors exécutez la commande suivante : 
	 `cd JarFile && java -jar GameOfLife-1.0-SNAPSHOT.jar`

## Guide d'utilisation

Au démarrage le jeu vous demandera d'entrer une **largeur de cellule** (qui correspond à la taille de chaque cellule) ainsi qu'une **largeur de fenêtre** (en pixels) afin de dessiner la fenêtre en conséquence.

Une fois la fenêtre initialisée vous pourrez utiliser le **clic gauche** de la souris pour inverser l'état d'une cellule.
>Une cellule vivante est représentée par une case noire.
[![GIF-29-03-2021-14-13-47.gif](https://s4.gifyu.com/images/GIF-29-03-2021-14-13-47.gif)](https://gifyu.com/image/YTbf)

## Répertoire des touches

| [SPACE] | [T] | [X] | [R] | [Left Click] | [Right Click] |
|----|---|---|---|---|---|
| Activer / Désactiver la génération automatique | Changer la vitesse de génération  | Fermer le programme | Réinitialiser le jeu | Inverser l'état d'une cellule | Génération manuelle d'un tour |

>Il est préférable de stopper la génération automatique avant de réinitialiser le jeu. 

## Exemples de départs intéressants

 1. **Le canon à planeurs**

	 ![GIF-29-03-2021-14-33-38.gif](https://s4.gifyu.com/images/GIF-29-03-2021-14-33-38.gif)

 2. Autre structure "déchets sur la route"
	
	![GIF-29-03-2021-14-46-56.gif](https://s4.gifyu.com/images/GIF-29-03-2021-14-46-56.gif)
