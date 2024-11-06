public class SandBox {


    public static void main(String[] args) {

        Computer systemNum = new Computer();
        Player playerNum = new Player();

        int numero = playerNum.numberplayer();

        while (systemNum.getnumberPlayers(numero) != true) {
            System.out.println("Errado!");
            numero = playerNum.numberplayer();
        }
        System.out.println("O numero é " + numero + ", acertas-te!");
    }
}

