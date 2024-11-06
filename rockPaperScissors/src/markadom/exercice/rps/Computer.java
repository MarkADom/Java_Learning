package markadom.exercice.rps;

public class Computer {

    public static Computer getResult(Game randomOption, Game randomOptionPlayer) {
        System.out.println("Computes move: " + randomOption + "\n" + "Player move is: " + randomOptionPlayer);
        if (randomOptionPlayer.equals(randomOption)) {
            Player.Tie();
            System.out.println("It´s a Tie");
        } else if (randomOption.equals(Game.ROCK) && randomOptionPlayer.equals(Game.SCISSORS)) {
            Player.Loose();
            System.out.println("YOU LOOSE!!! Rock crushes Scissors.");
        } else if (randomOption.equals(Game.SCISSORS) && randomOptionPlayer.equals(Game.PAPER)) {
            Player.Loose();
            System.out.println("YOU LOOSE!!! Scissor cuts Paper.");
        } else if (randomOption.equals(Game.PAPER) && randomOptionPlayer.equals(Game.ROCK)) {
            Player.Loose();
            System.out.println("YOU LOOSE!!! Paper covers Rock.");
        } else if (randomOptionPlayer.equals(Game.ROCK) && randomOption.equals(Game.SCISSORS)) {
            Player.Win();
            System.out.println("YOU WIN!!! Rock crushes Scissors.");
        } else if (randomOptionPlayer.equals(Game.SCISSORS) && randomOption.equals(Game.PAPER)) {
            Player.Win();
            System.out.println("YOU WIN!!! Scissor cuts Paper.");
        } else if (randomOptionPlayer.equals(Game.PAPER) && randomOption.equals(Game.ROCK)) {
            Player.Win();
            System.out.println("YOU WIN!!! Paper covers Rock.");
        } else {
            System.out.println("Invalid user input.");


        }
        return null;
    }
}





