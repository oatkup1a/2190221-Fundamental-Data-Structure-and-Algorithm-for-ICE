package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		
		//TODO: Fill Code
		for (UnitCard c : list) {
			if (c.equals(card)) {
				return true;
			}
		}
		return false;
		
	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		
		//TODO: Fill Code
		for (UnitDeck d : list) {
			if (d.equals(deck)) {
				return true;
			}
		}
		return false;

	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		
		//TODO: Fill Code
		for (UnitDeck d : deckList) {
			if (d.existsInDeck(cardToTest)) {
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<UnitCard> getCardsFromFile(String filename) {
		
		File fileToRead = new File(filename);
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();

		//TODO: Fill Code
		try {
			
			Scanner scanner = new Scanner(fileToRead);
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(",");
				
				try {
					
					if (parts.length != 5) { //if the line does not have 5 components
						System.out.println("File contains string with incorrect format!");
		                return null;
		            }
					
					String name = parts[0].trim();
		            int bloodCost = Integer.parseInt(parts[1].trim());
		            int power = Integer.parseInt(parts[2].trim());
		            int health = Integer.parseInt(parts[3].trim());
		            String flavorText = parts[4].trim();
		            
		            UnitCard card = new UnitCard(name, bloodCost, power, health, flavorText);	
		            cardsFromFile.add(card);
		            
				} catch (NumberFormatException e) { //if parsing fails, catch exception
					System.out.println("File contains string with incorrect format!");
					scanner.close();
                    return null;
				}
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file!");
	        return null;
	    }
		
		return cardsFromFile;
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}
