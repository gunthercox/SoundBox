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
			
			// THIS IS HORRIBLE BECAUSE IT IS COMPLETELY HARDCODED
			
			switch (key) {
			
			case KeyEvent.VK_ENTER:
				toneGenerator.playNote(100);
				break;
			
			case KeyEvent.VK_0:
				toneGenerator.playNote(0);
				break;
			
			case KeyEvent.VK_1:
				toneGenerator.playNote(1);
				break;
			
			case KeyEvent.VK_2:
				toneGenerator.playNote(2);
				break;
				
			case KeyEvent.VK_3:
				toneGenerator.playNote(3);
				break;
				
			case KeyEvent.VK_4:
				toneGenerator.playNote(4);
				break;
				
			case KeyEvent.VK_5:
				toneGenerator.playNote(5);
				break;
				
			case KeyEvent.VK_6:
				toneGenerator.playNote(6);
				break;
				
			case KeyEvent.VK_7:
				toneGenerator.playNote(7);
				break;
				
			case KeyEvent.VK_8:
				toneGenerator.playNote(8);
				break;
				
			case KeyEvent.VK_9:
				toneGenerator.playNote(9);
				break;
				
			case KeyEvent.VK_A:
				toneGenerator.playNote(10);
				break;
				
			case KeyEvent.VK_B:
				toneGenerator.playNote(11);
				break;
				
			case KeyEvent.VK_C:
				toneGenerator.playNote(12);
				break;
				
			case KeyEvent.VK_D:
				toneGenerator.playNote(13);
				break;
				
			case KeyEvent.VK_E:
				toneGenerator.playNote(14);
				break;
				
			case KeyEvent.VK_F:
				toneGenerator.playNote(15);
				break;
				
			case KeyEvent.VK_G:
				toneGenerator.playNote(16);
				break;
				
			case KeyEvent.VK_H:
				toneGenerator.playNote(17);
				break;
				
			case KeyEvent.VK_I:
				toneGenerator.playNote(18);
				break;
				
			case KeyEvent.VK_J:
				toneGenerator.playNote(19);
				break;
				
			case KeyEvent.VK_K:
				toneGenerator.playNote(20);
				break;
				
			case KeyEvent.VK_L:
				toneGenerator.playNote(21);
				break;
				
			case KeyEvent.VK_M:
				toneGenerator.playNote(22);
				break;
				
			case KeyEvent.VK_N:
				toneGenerator.playNote(23);
				break;
				
			case KeyEvent.VK_O:
				toneGenerator.playNote(24);
				break;
				
			case KeyEvent.VK_P:
				toneGenerator.playNote(25);
				break;
				
			case KeyEvent.VK_Q:
				toneGenerator.playNote(26);
				break;
				
			case KeyEvent.VK_R:
				toneGenerator.playNote(27);
				break;
				
			case KeyEvent.VK_S:
				toneGenerator.playNote(28);
				break;
				
			case KeyEvent.VK_T:
				toneGenerator.playNote(29);
				break;
				
			case KeyEvent.VK_U:
				toneGenerator.playNote(30);
				break;
				
			case KeyEvent.VK_V:
				toneGenerator.playNote(31);
				break;
				
			case KeyEvent.VK_W:
				toneGenerator.playNote(32);
				break;
				
			case KeyEvent.VK_X:
				toneGenerator.playNote(33);
				break;
				
			case KeyEvent.VK_Y:
				toneGenerator.playNote(34);
				break;
				
			case KeyEvent.VK_Z:
				toneGenerator.playNote(35);
				break;
				
				default:
					toneGenerator.playNote(60);
			
			}
		}

}
