package userInterface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainUI extends JPanel implements ActionListener {
	static final long serialVersionUID = 1L;
	private JButton playChessButton;
	private JLabel message;
	private JButton menuButton;
	
	/**
	 * Creates starting menu screen, sets 
	 * window size, background color, and
	 * other initialization stuff.
	 */
	public MainUI() {
		setLayout(null);
		setPreferredSize(new Dimension(700, 600));
		setBackground(new Color(242, 232, 172));
		
		playChessButton = new JButton("Play chess");
		playChessButton.addActionListener(this);
		playChessButton.setBounds(310, 270, 100, 30);
		
		message = new JLabel("Chess+", JLabel.CENTER);
		message.setBounds(185, 225, 350, 35);
        message.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        
        add(playChessButton);
		add(message);
	} //end constructor
	
	/**
	 * Removes everything and restores the main menu.
	 */
	public void showMenu() {
		removeAll();
		add(playChessButton);
		add(message);
        validate();
        repaint();
	} //end showMenu
	
	/**
	 * Adds the back to main menu button and removes
	 * main menu components from the window.
	 */
	public void putMenuButton() {
		remove(playChessButton);
		remove(message);
		
		menuButton = new JButton("Menu");
		menuButton.setBounds(590, 20, 100, 30);
		menuButton.addActionListener(this);
		
		add(menuButton);
		validate();
		repaint();
	} //end putMenuButton
	
	/**
	 * If buttons are pressed, do the corresponding action.
	 */
	public void actionPerformed(ActionEvent evt) {
		Object src = evt.getSource();
		if (src == playChessButton) {			//If play chess is pressed, remove main menu and put chess board
			putMenuButton();					//Also add menu button to allows users to go back to main menu
				userInterface.ChessUI chessBoard = new userInterface.ChessUI();
				add(chessBoard);
		}
		else if (src == menuButton)				//If menu is pressed, remove everything and restore the main menu
			showMenu();
	} //end actionPerformed
	
	
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
	} //end main
	
} //end class MainUI
