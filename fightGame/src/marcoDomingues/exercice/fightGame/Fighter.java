package marcoDomingues.exercice.fightGame;

public class Fighter {

    //Attributes

    private String name;
    private String nationality;
    private int age;
    private float high;
    private float weight;
    private String category;
    private int wins;
    private int defeats;
    private int draws;

    //Methods

    public void presentation() {
        System.out.println("-----------------------------------------");
        System.out.println("Its time to fight!!! On the right corner " + this.getName());
        System.out.println("Coming from " + this.getNationality());
        System.out.print("with " + this.getAge() + " years old and " + this.getHigh() + "m" );
        System.out.println(" weighing " + this.getWeight());
        System.out.println(this.getWins() + " victories");
        System.out.println(this.getDefeats() + " defeats");
        System.out.println(this.getDraws() + " draws");
    }

    public void status() {
        System.out.println(this.getName() + " its a " + this.getCategory());
        System.out.println("Win " + getWins() + " times.");
        System.out.println("Lose" + getDefeats() + " times.");
        System.out.println("Drew " + getDraws() + " times.");
    }

    public void winFight() {
        this.setWins((this.getWins() + 1));

    }

    public void loseFight() {
        this.setDefeats(this.getDefeats() + 1);
    }

    public void tieFight() {
        this.setDraws(this.getDraws() + 1);

    }

    //Special Methods


    public Fighter(String name, String nationality, int age, float high, float weight, int wins, int defeats, int draws) {
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.high = high;
        this.setWeight(weight);
        this.wins = wins;
        this.defeats = defeats;
        this.draws = draws;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
        this.setCategory();
    }

    public String getCategory() {
        return category;
    }

   private void setCategory() {
        if (this.weight < 52.2) {
            this.category = "Light";
        } else if (this.weight <= 83.9) {
            this.category = "Medium";
        } else if (this.weight <= 120.2) {
            this.category = "Heavy";
        } else {
            this.category = "Invalid";
        }
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }
}
