public class Computer {

    private static int computerNumber = 0;

    public Computer() {
        computerNumber = (int) Math.ceil(Math.random() * 10);
        System.out.println("O número do systema é " + computerNumber);
    }

    public boolean getnumberPlayers(int numero) {
        return computerNumber == numero;
    }
}




