import javax.sound.midi.*;
import java.nio.ByteBuffer;
import javax.sound.sampled.*;

/**
 * 
 * @author Gunther Cox
 * @version 0.0.1
 * @title Album01 Track01
 *
 */

public class toneGenerator implements Runnable{
	
	public static int[] notes1 = new int[]{ 60, 62, 64, 65, 67, 69, 71, 72, 72, 71, 69, 67, 65, 64, 62, 60 };
	public static int[] notes2 = new int[]{ 21, 21, 21,  128,  128, 21,  21,  21, 128, 64,  21,  21,  21, 128, 64, 21, 21,  21, 128 };
	public static int[] notes3 = new int[]{127,64,127,64,127,64,127,64,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,127,127,64,127,64,127,64,127,64,127,64};
	
	private static int[] noteArray;
	
	// CONSTRUCTOR: THESE ARGUMENTS WILL BE PASSED TO THE THREAD
	public toneGenerator(int[] noteArray) {
		this.noteArray = noteArray;
	}

	public static void main(String[] args) throws InterruptedException, LineUnavailableException {
		
		// AUDIO SAMPLE RATE
		final int RATE = 44100;
		
		// AUDIO SAMPLE SIZE IN BYTES
		final int SIZE = 2;
		
		// FREQUENCY OF THE SINE WAVE IN HZ
		double frequency = 440;
		
		SourceDataLine line;

		//Position through the sine wave as a percentage (i.e. 0 to 1 is 0 to 2*PI)
		double fCyclePosition = 0;   
		
		// ARRAYS FOR NOTES
		
		int[] notes = new int[100];
		for (int i = 0; i < notes.length; i++) {
			notes[i] = i;
		}
		
		(new Thread(new toneGenerator(notes1))).start();
		
		//Thread.sleep(4000);
		(new Thread(new toneGenerator(notes2))).start();
		
		
		(new Thread(new toneGenerator(notes3))).start();
		
		// SINGLE TONE EXAMPEL   

		//Open up audio output, using 44100hz sampling rate, 16 bit samples, mono, and big endian byte ordering
		/*AudioFormat format = new AudioFormat(RATE, 16, 1, true, true);
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		if (!AudioSystem.isLineSupported(info)){
			System.out.println("Line matching " + info + " is not supported.");
			throw new LineUnavailableException();
		}

		line = (SourceDataLine)AudioSystem.getLine(info);
		line.open(format);  
		line.start();

		// Make our buffer size match audio system's buffer
		ByteBuffer cBuf = ByteBuffer.allocate(line.getBufferSize());   

		// Output for roughly 5 seconds
		int ctSamplesTotal = RATE * 5;


		//On each pass main loop fills the available free space in the audio buffer
		//Main loop creates audio samples for sine wave, runs until we tell the thread to exit
		//Each sample is spaced 1/SAMPLING_RATE apart in time
		while (ctSamplesTotal > 0) {
			double fCycleInc = frequency / RATE;  // Fraction of cycle between samples

			cBuf.clear();     // Discard samples from previous pass

			// Figure out how many samples we can add
			int ctSamplesThisPass = line.available() / SIZE;   
			for (int i=0; i < ctSamplesThisPass; i++) {
				cBuf.putShort((short)(Short.MAX_VALUE * Math.sin(2 * Math.PI * fCyclePosition)));

				fCyclePosition += fCycleInc;
				if (fCyclePosition > 1)
					fCyclePosition -= 1;
			}

			//Write sine samples to the line buffer.  If the audio buffer is full, this will 
			// block until there is room (we never write more samples than buffer will hold)
			line.write(cBuf.array(), 0, cBuf.position());            
			ctSamplesTotal -= ctSamplesThisPass;     // Update total number of samples written 

			//Wait until the buffer is at least half empty  before we add more
			while (line.getBufferSize() / 2 < line.available())   
				Thread.sleep(1);                                             
		}

		//Done playing the whole waveform, now wait until the queued samples finish 
		//playing, then clean up and exit
		line.drain();                                         
		line.close();
		*/

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

}