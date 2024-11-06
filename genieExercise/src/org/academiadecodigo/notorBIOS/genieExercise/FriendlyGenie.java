package org.academiadecodigo.notorBIOS.genieExercise;

public class FriendlyGenie extends Genie {

    private String friendly;

    public FriendlyGenie() {
        super();
        System.out.println("Hello im the Friendly Genie");
        makeWishFriendly(3);


    }

    public void makeWishFriendly(int wishes) {
        int counter = wishes;
        while (counter > 0){
            counter--;
            System.out.println("Wish conceded");

        }

    }




    @Override
    public void hello() {
    }
}
