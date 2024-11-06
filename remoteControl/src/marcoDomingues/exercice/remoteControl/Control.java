package marcoDomingues.exercice.remoteControl;

public interface Control {
    public abstract void on();
    public abstract void off();
    public abstract void openMenu();
    public abstract void closMenu();
    public abstract void moreVolume();
    public abstract void lessVolume();
    public abstract void mute();
    public abstract void unmute();
    public abstract void play();
    public abstract void pause();
}
