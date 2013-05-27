import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;


public class PianoGui extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;
	public PianoGui() {
		
		setLayout(new BorderLayout());
		
		JTextArea prompt = new JTextArea("Enter your name:");
		JEditorPane text = new JTextPane();
		
		//prompt.add(text);
		add(text);
		text.addKeyListener(this);
		
		text.requestFocusInWindow();
		
	}
	
	// KEYBOARD EVENTS
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			if (key == KeyEvent.VK_ENTER) {
				toneGenerator.playNote(28);
			}
		}

}
