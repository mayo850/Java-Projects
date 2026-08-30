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
		SwingUtilities.invokeLater(VideoPokerGui::new);
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

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == this.quitButton) {
			Window window = SwingUtilities.getWindowAncestor(this.display);
			if (window != null) {
				window.dispose();
			}
			return;
		}
		if (source == this.dealButton) {
			deal();
		} else if (source == this.drawButton) {
			draw();
		}
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (!this.drawButton.isEnabled()) {
			return;
		}
		int index = this.display.indexOfCard(event.getX(), event.getY());
		if (index >= 0) {
			this.face[index] = !this.face[index];
			this.display.update();
		}
	}

	private void deal() {
		try {
			int requestedBet = Integer.parseInt(this.betField.getText().trim());
			if (requestedBet <= 0 || requestedBet > this.money) {
				throw new IllegalArgumentException();
			}
			this.bet = requestedBet;
		} catch (IllegalArgumentException exception) {
			this.guideLabel.setText("Enter a whole-number bet between 1 and $" + this.money + ".");
			return;
		}

		this.money -= this.bet;
		this.deck.shuffle();
		for (int i = 0; i < NUM_CARDS; i++) {
			this.cards[i] = this.deck.dealCard();
			this.face[i] = true;
		}
		this.moneyLabel.setText("You have $" + this.money);
		this.guideLabel.setText("Click cards to hold them, then click DRAW.");
		this.dealButton.setEnabled(false);
		this.drawButton.setEnabled(true);
		this.betField.setEnabled(false);
		this.display.update();
	}

	private void draw() {
		for (int i = 0; i < NUM_CARDS; i++) {
			if (!this.face[i]) {
				this.cards[i] = this.deck.dealCard();
				this.face[i] = true;
			}
		}
		int rank = getPokerRank();
		int winnings = this.bet * payoutFor(rank);
		this.money += winnings;
		this.moneyLabel.setText("You have $" + this.money);
		this.guideLabel.setText(winnings > 0 ? "You won $" + winnings + "." : "No payout this round.");
		this.dealButton.setEnabled(this.money > 0);
		this.drawButton.setEnabled(false);
		this.betField.setEnabled(this.money > 0);
		this.display.update();
	}

	private int payoutFor(int rank) {
		switch (rank) {
			case PokerRank.ROYAL_FLUSH:
				return 250;
			case PokerRank.STRAIGHT_FLUSH:
				return 50;
			case PokerRank.FOUR_OF_A_KIND:
				return 25;
			case PokerRank.FULL_HOUSE:
				return 9;
			case PokerRank.FLUSH:
				return 6;
			case PokerRank.STRAIGHT:
				return 4;
			case PokerRank.TRIPLE:
				return 3;
			case PokerRank.TWO_PAIR:
				return 2;
			case PokerRank.PAIR:
				return 1;
			default:
				return 0;
		}
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
