import com.webfm.game.GuessGame;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static char scanLetter(String question) {
        final var scanner = new Scanner(System.in);
        Character letter = null;
        do {
            System.out.println(question);
            var input = scanner.nextLine();
            if (input.length() == 1) {
                letter = input.charAt(0);
            }
        } while(letter == null);
        return letter;
    }

    public static void main(String[] args) {

        final var random = new Random();
        final var words = "belgique france animal perruche perruque limitation voiture automobile ananas".split(" ");
        var wordToGuess = words[random.nextInt(words.length)];
        var game = new GuessGame(wordToGuess, 10);

        System.out.println("Début du jeu du pendu !");

        while(true) {
            System.out.println(game);
            final var letter = scanLetter("Entrez une lettre : ");

            game.guessLetter(letter);

            if(game.isLost()) {
                System.out.println(game);
                System.out.println("Perdu !");
            }

            if(game.isWon()) {
                System.out.println(game);
                System.out.println("Gagné !");
            }

            if(game.isLost() || game.isWon()) {
                var replayAnswer = scanLetter("Voulez-vous rejouer ? (O/N)");
                if(replayAnswer == 'y' || replayAnswer == 'Y' || replayAnswer == 'o' || replayAnswer == 'O') {
                    wordToGuess = words[random.nextInt(words.length)];
                    game = new GuessGame(wordToGuess, 10);
                } else {
                    break;
                }
            }
        }


    }

}