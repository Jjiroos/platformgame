# Platform Game

Bienvenue dans Platform Game, un jeu de plateforme développé en pur Java.
Ce jeu a était développé en suivant le tutoriel de https://github.com/KaarinGaming/PlatformerTutorial

## Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre machine :

- Java Development Kit (JDK) 17 ou version ultérieure
- Un IDE (comme IntelliJ IDEA, Eclipse, ou NetBeans) ou simplement un terminal pour exécuter les commandes

## Installation

1. **Cloner le repository :**

   Ouvrez votre terminal et exécutez la commande suivante pour cloner le repository :

   ```sh
   git clone https://github.com/Jjiroos/platformgame.git
   ```

Ensuite, naviguez dans le dossier du projet :

   ```sh
   cd platformgame
   ```

2. **Importer le projet dans votre IDE :**

    - Si vous utilisez un IDE comme IntelliJ IDEA, Eclipse ou NetBeans, utilisez l'option d'importation de projet et sélectionnez le dossier `platformgame` que vous avez cloné.

3. **Configurer le projet :**

    - Assurez-vous que votre IDE utilise la bonne version du JDK (version 17 ou ultérieure).

## Compilation et exécution

### Utilisation d'un IDE

1. **Compiler le projet :**

    - Utilisez la fonction de compilation de votre IDE pour compiler le projet.

2. **Exécuter le jeu :**

    - Trouvez la classe principale avec la méthode `main`. Cela sera généralement une classe appelée quelque chose comme `Main` ou `GameLauncher`.
    - Faites un clic droit sur cette classe et sélectionnez `Run`.

### Utilisation du terminal

1. **Compiler le projet :**

   Naviguez dans le dossier du projet et exécutez la commande suivante pour compiler les fichiers `.java` :

   ```sh
   javac -d bin src/**/*.java
   ```

   Cette commande compile tous les fichiers `.java` dans le dossier `src` et place les fichiers `.class` dans le dossier `bin`.

2. **Exécuter le jeu :**

   Une fois la compilation terminée, exécutez le jeu avec la commande suivante :

   ```sh
   java -cp bin com.example.Main
   ```

   Remplacez `com.example.Main` par le nom de la classe principale contenant la méthode `main`.

## Contribution

Les contributions sont les bienvenues ! Si vous souhaitez contribuer au développement du jeu, veuillez suivre ces étapes :

1. **Fork le repository**
2. **Créez une branche pour votre fonctionnalité (git checkout -b feature/AmazingFeature)**
3. **Commit vos modifications (git commit -m 'Add some AmazingFeature')**
4. **Push la branche (git push origin feature/AmazingFeature)**
5. **Ouvrez une Pull Request**

## License

Ce projet est sous licence MIT. Voir le fichier [LICENSE](LICENSE) pour plus de détails.

---

Merci d'avoir téléchargé et joué à Platform Game ! Si vous avez des questions ou des suggestions, n'hésitez pas à ouvrir une issue ou à me contacter directement.

Bon jeu !
```