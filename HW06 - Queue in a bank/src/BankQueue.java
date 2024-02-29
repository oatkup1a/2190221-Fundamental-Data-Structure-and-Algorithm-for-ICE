
public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
		double queueAmount = counters.length + 1; //1 is special
		double customer = 0;
		for (int i=0;i<counters.length;i++) {
			customer += counters[i].size();
		}
		int neededQueueLength = (int)Math.round(customer / queueAmount);
		
		for (int i=0;i<counters.length;i++) {
			
			int rearrangeAmount = neededQueueLength;
			
			//Move front elements to the back at the amount of NQL
			while (rearrangeAmount > 0) {
				counters[i].insertLast(counters[i].front());
				counters[i].removeFirst();
				rearrangeAmount--;
			}
			
			int removeAmount = counters[i].size() - neededQueueLength;
			
			//Insert and remove the unmoved elements in the counter while checking if special is full
			while (removeAmount > 0) {
				
				if (special.size() == neededQueueLength) {
					
					//If special is full, move all unmoved elements to the back of counter
					while (removeAmount > 0) {
						counters[i].insertLast(counters[i].front());
						counters[i].removeFirst();
						removeAmount--;
					}
					return;
				}
				special.insertLast(counters[i].front());
				counters[i].removeFirst();
				System.out.println(counters[i].front());
				removeAmount--;
			}
		}
		
		//Handle if special queue still has no data
		if (special.isEmpty()) {
			special.insertLast(counters[counters.length-1].back());
			counters[counters.length-1].removeLast();
		}
	}
}
