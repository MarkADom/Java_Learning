package org.academiadecodigo.notorBIOS.genieExercise;

import java.sql.SQLOutput;

public class RecyclableDemon extends Genie{

    public RecyclableDemon() {
        super();
        System.out.println("AHAHAHA THE DEMON");
        makeWishDemon(10);
    }

    public void makeWishDemon(int wishes) {
           int counter = wishes;
           while (counter > 0 ) {
               counter--;
               System.out.println("WISH KIND OF CONCEDED");
           }

    }
    @Override
    public void hello() {


    }

    }

