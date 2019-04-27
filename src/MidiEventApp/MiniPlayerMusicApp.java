package MidiEventApp;

import javax.sound.midi.*;

public class MiniPlayerMusicApp {

    public void play() {

        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            ShortMessage c = new ShortMessage();
            c.setMessage(128, 1, 20, 100);
            MidiEvent noteC = new MidiEvent(c, 2);
            track.add(noteC);



            ShortMessage a = new ShortMessage();
            a.setMessage(192, 1, 102, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 3);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
