package marcoDomingues.exercice.remoteControl;

import java.rmi.Remote;

public class RemoteControl implements Control {
    //Attributes
    private int volume;
    private boolean on;
    private boolean play;

    //Special Methods

    public RemoteControl() {
        this.volume = 50;
        this.on = false;
        this.play = false;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean getOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public boolean getPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    //Abstract Methods

    @Override
    public void on() {
        this.setOn(true);
    }

    @Override
    public void off() {
        this.setOn(false);
    }

    @Override
    public void openMenu() {
        System.out.println("<------MENU------>");
        System.out.println("The device is: " + this.getOn());
        System.out.println("Play Mode: " + this.getPlay());
        System.out.print("Volume: " + this.getVolume());
        for (int i = 0; i <= this.getVolume(); i += 10) {
            System.out.print("|");
        }
        System.out.println("");
    }

    @Override
    public void closMenu() {
        System.out.println("Closing Menu...");

    }

    @Override
    public void moreVolume() {
        if (this.getOn()) {
            this.setVolume(this.getVolume() + 5);
        }
    }

    @Override
    public void lessVolume() {
        if (this.getOn()) {
            this.setVolume(this.getVolume() - 5);
        }

    }

    @Override
    public void mute() {
        if (this.getOn() && this.getVolume() > 0) {
            this.setVolume(0);
        }
    }

    @Override
    public void unmute() {
        if (this.getOn() && this.getVolume() == 0){
            this.setVolume(50);
        }
    }

    @Override
    public void play() {
        if(this.getOn() && !(this.getPlay())){
            this.setPlay(true);
        }
    }

    @Override
    public void pause() {
        if (this.getOn() && this.getPlay()){
            this.setPlay(false);
        }

    }


}
