import javax.sound.midi.*;
import java.util.Scanner;
import javax.sound.sampled.*;
import javax.swing.JFrame;

/**
 * 
 * @author Gunther Cox
 * @version 0.0.1
 * @title Album01 Track01
 *
 */

public class toneGenerator implements Runnable{
	
	//public static int[] notes1 = new int[]{ 60, 62, 64, 65, 67, 69, 71, 72, 72, 71, 69, 67, 65, 64, 62, 60 };
	//public static int[] notes2 = new int[]{ 21, 21, 21,  128,  128, 21,  21,  21, 128, 64,  21,  21,  21, 128, 64, 21, 21,  21, 128 };
	//public static int[] notes3 = new int[]{127,64,127,64,127,64,127,64,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,127,127,64,127,64,127,64,127,64,127,64};
	
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
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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