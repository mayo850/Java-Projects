import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hand<T> {
	// private data fields
	private final List<T> hand;

	public Hand() {
		this.hand = new ArrayList<>();
	}

	public void clear() {
		hand.clear();
	}

	public void addCard(T param)throws NullPointerException {
		hand.add(Objects.requireNonNull(param, "Can't add a null card to the hand"));
	}

// always read the first line which is mostly the else statement
	public void removeCard(T paramNew) throws NullPointerException, IllegalArgumentException {
		Objects.requireNonNull(paramNew, "Can't remove null card from the hand");
		if (!hand.remove(paramNew)) {
			throw new IllegalArgumentException("Can't remove a card "
					+ " not in the hand");
		}
	}

	public void removeCard(int paramOne) throws IllegalArgumentException {
		// invalid means false
		if (paramOne < 0 || paramOne >= hand.size()) {
			throw new IllegalArgumentException("Card index is out of range: " + paramOne);
		}
		hand.remove(paramOne);
	}

}
