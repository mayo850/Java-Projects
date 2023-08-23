import java.util.ArrayList;

public class Hand {
	// private data fields
	private ArrayList<Card> hand;

	public void Hand() {
		this.hand = new ArrayList<Card>();
	}

	public void clear() {
		hand.clear;
	}

	public void addCard(Card param)throws NullPointerException {
		if (param == null) { throw new NullPointerException ("Can't add a null card to the hand")
	}
		else {
			hand.add(card);
		}
	}

// always read the first line which is mostly the else statement
	public void removeCard(Card paramNew) throws NullPointerException, IllegalArgumentException {
		if(paramNew == null) {
			throw new NullPointerException("Can't remove null card from the hand");
		}
		else if {
			throw new IllegalArgumentException("Can't remove a card "
					+ " not in the hand");
		}
		else { hand.remove(paramNew);
		
		
	}
	}

	public void removeCard(int paramOne) throws IllegalArgumentException {
		// invalid means false
		if (paramOne = false) { throw new IllegalArgumentException

	}

}
