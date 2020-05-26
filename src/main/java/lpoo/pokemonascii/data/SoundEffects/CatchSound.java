package lpoo.pokemonascii.data.SoundEffects;
import javax.sound.sampled.FloatControl;

public class CatchSound extends SoundEffect {

    public CatchSound() {
        super("catchPokemon.wav");
    }

    @Override
    public void play() {
        super.play();
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-20.0f); // Reduce volume by 20 decibels.
    }
}
