import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.MidiChannel;

import javax.sound.midi.MidiUnavailableException;

import javax.sound.sampled.*;

import java.util.Scanner;

/**
 * 
 * @author Gunther Cox
 * @version 0.0.1
 * @title Album01 Track01
 *
 */

public class toneGenerator implements Runnable {

	private static int[] noteArray;
	private static int singleNote;
	
	// CONSTRUCTORS: THESE ARGUMENTS WILL BE PASSED TO THE THREAD
	
	public toneGenerator(int[] noteArray) {
		this.noteArray = noteArray;
	}
	
	public toneGenerator(int singleNote) {
		this.singleNote = singleNote;
	}

	public static void main(String[] args) throws InterruptedException, LineUnavailableException {
			
			PianoGui gui = new PianoGui();
			gui.setTitle("Essay Generator");
			gui.setSize(800, 600);
			gui.setLocationRelativeTo(null);
			gui.setVisible(true);

	}
	
	public static void keyboardNote(int note) {
		(new Thread(new toneGenerator(note))).start();
	}
	
	// THREADED METHOD TO PLAY MIDI TONES
	public void run() {
		
		try {
			Synthesizer synthesizer = MidiSystem.getSynthesizer();
			synthesizer.open();
			MidiChannel channel = synthesizer.getChannels()[0];

			for (int note : noteArray) {
				channel.noteOn(note, 100);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					break;
				} finally {
					channel.noteOff(note);
				}
			}
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}	
	}
	
	public static void playNote(int note) {
		try {
			Synthesizer synthesizer = MidiSystem.getSynthesizer();
			synthesizer.open();
			MidiChannel channel = synthesizer.getChannels()[0];

				channel.noteOn(note, 200);
				try {
					Thread.sleep(600);
				} catch (InterruptedException e) {
				} finally {
					channel.noteOff(note);
				}
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}	
	}

}
