---
# <div align="center">FlappyBird Game, using OOP and Thread</div>
---
| ![](https://i.ibb.co/N3KgkxN/menu.png) | ![](https://i.ibb.co/vvnWz8M/current.png) |
| :------------------------------------: | :---------------------------------------: |
|                 *Menu*                 |                 *Playing*                 |
---



**How to compile and run:**

1. *First download the project with the git address.*
2. *Enter the project folder and run the following command:*

```java
javac -d . -cp "src/main/java/br/ucsal/flappybird/element/*.java" src/main/java/br/ucsal/flappybird/*.java
```

3. *Run this command:*

   3.1. *Tutorial on how to install Maven: [Windows](http://charlesmms.azurewebsites.net/2017/09/04/instalando-maven-no-windows-10/) - [Linux](https://www.vivaolinux.com.br/dica/Instalar-o-Maven-no-Ubuntu) - [Mac](https://loiane.com/2015/05/instalando-maven-no-mac-os-yosemite/).*

```java
 mvn package
```

4. *Start the game by running this command:*

```java
java -jar target/jogo-flappy-bird-jar-with-dependencies.jar
```

