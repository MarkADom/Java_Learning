package org.academiadecodigo.notorBIOS.genieExercise;

public class MagicLamp {
    private String lampName;
    private int lampRubs;
    private int maxGenius;


    public MagicLamp(String lampName, int maxGenius) {
        this.lampName = lampName;
        this.maxGenius = maxGenius;

    }

    public String getLampName() {
        return lampName;
    }

    public int getLampRubs() {
        return lampRubs;
    }

    public int setLampRubs() {
        return lampRubs;
    }


    public Genie rubbed() {
        int genius = (int) (Math.random() * 2);
        if (genius == 0 && lampRubs < maxGenius) {
            Genie friendly = new FriendlyGenie();
            friendly.hello();
            lampRubs++;
            return friendly;
        }
        if (genius == 1 && lampRubs < maxGenius) {
            Genie grumpy = new GrumpyGenie();
            grumpy.hello();
            lampRubs++;
            return grumpy;
        }
        Genie demon = new RecyclableDemon();
        demon.hello();
        return demon;
    }
}



