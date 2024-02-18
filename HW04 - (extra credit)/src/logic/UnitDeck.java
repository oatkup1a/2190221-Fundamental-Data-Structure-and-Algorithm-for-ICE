package logic;

import java.util.ArrayList;

public class UnitDeck {
	private ArrayList<CardCounter> cardsInDeck;
	private String deckName; 

	public UnitDeck(String deckName) {
		cardsInDeck = new ArrayList<>();
		this.deckName = deckName;
	}
	
	public void addCard(UnitCard newCard, int count) {
		if (count <= 0) {
			return;
			
		} else if (!existsInDeck(newCard)) {
			CardCounter c = new CardCounter(newCard, count);
			cardsInDeck.add(c);
			
		} else if (existsInDeck(newCard)) {
			for (CardCounter cardC : cardsInDeck) {
				if ((cardC.getCard()).equals(newCard)) {
					int updatedCount = cardC.getCount() + count;
					cardC.setCount(updatedCount);
				}
			}
		}
	}

	public void removeCard(UnitCard toRemove, int count) {
		if (count < 0) {
			return;
		}
		
		for (CardCounter cardC : cardsInDeck) {
			if (cardC.getCard().equals(toRemove)) {
				int updatedCount = cardC.getCount() - count;
				if (updatedCount <= 0) {
					cardsInDeck.remove(cardC);
				} else {
					cardC.setCount(updatedCount);
				}
				break;
			}
		}
		
	}
	
	public int cardCount() {
		int n = 0;
		for (CardCounter cardC : cardsInDeck) {
			n += cardC.getCount();
		}
		return n;
	}
	
	public boolean existsInDeck(UnitCard card) {
		boolean cardExist = false;
		for (CardCounter cardC : cardsInDeck) {
			if (cardC.getCard().equals(card)) {
				cardExist = true;
				break;
			}
		}
		return cardExist;
	}
	
	public boolean equals(UnitDeck other) {
		return (this.deckName == other.deckName);
	}
	
	public String getDeckName() {
		if (deckName.isBlank()) {
			deckName = "Untitled Deck";
		}
		return deckName;
	}
	
	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}
	
	public ArrayList<CardCounter> getCardsInDeck() {
		return cardsInDeck;
	}
	
	public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
	}
}
