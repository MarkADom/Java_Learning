public class Player {

    public int numbplayer = 0;

    public int numberplayer() {

        numbplayer = (int) Math.ceil(Math.random() * 10);

        System.out.println("É o numero " + numbplayer + "?");
        return numbplayer;
    }
}
