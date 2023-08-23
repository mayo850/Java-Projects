/**
 * @author 
 * @assignment CSC212-ProgramGUI
 * @version (put the data here)
 * 
 * Description:
 * 
 * Citations of Assistance (who and what):
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VideoPokerGui extends MouseAdapter implements ActionListener {

	// main method
	public static void main (String []args) {
		VideoPokerGui gui = new VideoPokerGui();
	}
	
	
	
	private static final int FRAME_HEIGHT = 300;
	private static final int FRAME_WIDTH = 540;
	private static final int START_AMOUNT = 100;
	private static final int DEFAULT_BET = 10;

	public static final int NUM_CARDS = 5;
	
	// data fields
	private PokerCard[] cards;
	private PokerDeck deck;
	private boolean[] face;
	
	private int money;
	private int bet;
	
	private CardPanel display;
	private JLabel moneyLabel;
	private JLabel guideLabel;
	private JLabel betLabel;
	private JTextField betField;
	private JButton dealButton;
	private JButton drawButton;
	private JButton quitButton;
	
	public VideoPokerGui()  {
		money = START_AMOUNT;
		bet = DEFAULT_BET;
		deck = new PokerDeck();
		cards = new PokerCard[NUM_CARDS];
		face = new boolean [NUM_CARDS];
		
		JPanel south = this.createSouthPanel();
		JPanel north = this.createNorthPanel();
		this.display = new CardPanel (this.cards, this.face);
		
		this.display.addMouseListener(this);
		
		JFrame frame = new JFrame("Video Poker--Jacks or Better");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(north, BorderLayout.NORTH );
		frame.add(south, BorderLayout.SOUTH);
		frame.add(this.display, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}
	
	public JPanel createNorthPanel() {
		JPanel north = new JPanel(new GridLayout(2,1));
		north.setBackground(Color.GREEN);
		this.moneyLabel = new JLabel("You have $" + money);
		this.moneyLabel.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		this.guideLabel = new JLabel("Let's Play. Click DEAL to begin.");
		this.guideLabel.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		north.add(this.moneyLabel);
		north.add(this.guideLabel);
		
		return north;
	}
	
	public JPanel createSouthPanel() {
		JPanel south = new JPanel(new FlowLayout());
		this.betLabel = new JLabel("Your bet: ");
		this.betField = new JTextField(NUM_CARDS);
		this.betField.setText("" + this.bet);
		this.dealButton = new JButton("DEAL");
		this.drawButton = new JButton("DRAW");
		this.drawButton.setEnabled(false);
		this.quitButton = new JButton("QUIT");
		this.dealButton.addActionListener(this);
		this.drawButton.addActionListener(this);
		this.quitButton.addActionListener(this);
		south.add(this.betLabel);
		south.add(this.betField);
		south.add(this.dealButton);
		south.add(this.drawButton);
		south.add(this.quitButton);
		
		return south;
		
	}
	
	
	

	/**
	 * DON'T CHANGE THIS METHOD
	 * 
	 * Evaluates a hand of five poker cards.  The return value is the hand's "rank",
	 * which is one of the following constants:  PokerRank.NOTHING, PokerRank.PAIR,
	 * PokerRank.TWO_PAIR, PokerRank.TRIPLE, PokerRank.STRAIGHT, PokerRank.FLUSH, 
	 * PokerRank.FULL_HOUSE, PokerRank.FOUR_OF_A_KIND, PokerRank.STRAIGHT_FLUSH, or 
	 * PokerRank.ROYAL_FLUSH.  Note that PokerRank.PAIR is only returned for a pair 
	 * of Jacks or better.  PokerRank.NOTHING is returned for a hand that is less 
	 * than a pair of Jacks, which gets no payout in this game.
	 * 
	 * @return the rank of the hand
	 */
	private int getPokerRank() {
	    PokerRank ranker = new PokerRank();
	    for (int i = 0; i < NUM_CARDS; i++) {
	        ranker.add(cards[i]);
	    }
	    int rank = ranker.getHandType();
	    if (rank == PokerRank.PAIR) {
	           // if it's not at least a pair of Jacks, return NOTHING rather than PAIR
	        PokerCard card = ranker.getCards().get(0);
	        if ( card.getValue() < PokerCard.JACK ) {
	            rank = PokerRank.NOTHING;
	        }
	    }
	    return rank;
	}

}
