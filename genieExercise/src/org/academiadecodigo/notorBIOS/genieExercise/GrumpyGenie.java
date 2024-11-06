package org.academiadecodigo.notorBIOS.genieExercise;

public class GrumpyGenie extends Genie{

    public GrumpyGenie() {
        super();
        System.out.println("Hello im the Grumpy Genie");
        makeWishGrumpy(1);
    }

    public void makeWishGrumpy(int wishes) {
            int counter = wishes;
            while (counter > 0) {
                counter--;
                System.out.println("Wish conceded");
            }
    }

    @Override
    public void hello() {

    }
}




