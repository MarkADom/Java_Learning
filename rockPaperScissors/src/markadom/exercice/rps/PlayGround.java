package markadom.exercice.rps;


public class PlayGround {
    public static void main(String[] args) {
        int i;
        for (i = 1; i <= 3; i++) {
            System.out.println("--> ROUND " + i + " <--");
            Game randomOption = Game.getRandom();
            Game randomOptionPlayer = Game.getRandom();
            Computer gameResult = Computer.getResult(randomOption, randomOptionPlayer);
        }

    }
}








