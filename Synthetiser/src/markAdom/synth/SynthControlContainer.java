package markAdom.synth;

import javax.swing.*;
import java.awt.*;

public class SynthControlContainer extends JPanel {

    protected boolean on;
    private Synthesizer synth;

    public SynthControlContainer(Synthesizer synth) {
        this.synth = synth;
    }

    public boolean isOn() {
        return on;
    }

    public boolean setOn(boolean on) {
        this.on = on;
        return on;
    }

    @Override
    public Component add(Component component) {
        component.addKeyListener(synth.getKeyAdapter());
        return super.add(component);
    }
}
