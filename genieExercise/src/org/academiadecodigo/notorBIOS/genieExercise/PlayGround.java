package org.academiadecodigo.notorBIOS.genieExercise;

public class PlayGround {
    public static void main(String[] args) {

       MagicLamp lampOne = new MagicLamp("Golden Lamp", 3);

       Genie aladin = lampOne.rubbed();



       lampOne.rubbed();
       lampOne.rubbed();
       lampOne.rubbed();
       lampOne.rubbed();


       aladin.makeWish(3);

    }
}
