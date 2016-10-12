package userInterface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainUI extends JPanel implements ActionListener {
	static final long serialVersionUID = 1L;
	private JButton playChess;
	private JLabel message;
	
	/**
	 * Creates starting menu screen, sets 
	 * window size, background color, and
	 * other initialization stuff.
	 */
	public MainUI() {
		setLayout(null);
		setPreferredSize(new Dimension(700, 600));
		setBackground(new Color(242, 232, 172));
		
		playChess = new JButton("Play chess");
		playChess.addActionListener(this);
		playChess.setBounds(310, 265, 100, 30);
		
		message = new JLabel("Chess+", JLabel.CENTER);
        message.setBounds(185, 220, 350, 35);
        message.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        
        add(playChess);
        add(message);
	}
	
	/**
	 * If buttons are pressed, do
	 * the corresponding action.
	 */
	public void actionPerformed(ActionEvent evt) {
		Object src = evt.getSource();
		if (src == playChess) { 
			message.setText("Feature not implemented yet.");
			playChess.setLocation(590, 20);
		}
	}
	
	/**
	 * Main routine allows ChessPlus to be run
	 * as an application. It creates the window 
	 * that allows users to use the program.
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame("Chess+");
		MainUI userInterface = new MainUI();
		window.setContentPane(userInterface);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
	} //main
	
} //class
