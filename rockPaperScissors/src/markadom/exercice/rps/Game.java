package markadom.exercice.rps;

public enum Game {
    ROCK,
    SCISSORS,
    PAPER;

    // Create random enum attributes.
    public static Game getRandom() {
        return values()[(int) (Math.random() * values().length)];


    }

}

