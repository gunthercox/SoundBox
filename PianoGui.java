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

		JEditorPane text = new JTextPane();
		add(text);
		text.addKeyListener(this);
		text.requestFocusInWindow();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Piano");
		setSize(800, 600);
		setLocationRelativeTo(null);
	}

	// KEYBOARD EVENTS
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
	    int key = e.getKeyCode();
	    toneGenerator.playNote(key);
	}

}
