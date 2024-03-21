
public class HashIterator implements Iterator {

	OpenAddressing h; // the associated hash table
	int currentPos;   // position in the table's array that is currently marked.

	
	//Create an iterator that marks the leftmost actual data in the hash table.
	//Assume actual data are not 0 and DELETED.
	//If there are no actual data in the table, set currentPos to -1.
	public HashIterator(OpenAddressing o) {
		h = o;
		int i = 0;
		for (; i < o.array.length; i++) {
			if (o.array[i] != 0 && o.array[i] != OpenAddressing.DELETED) {
				currentPos = i;
				break;
			}
		}
		if (i >= o.array.length) {
			currentPos = -1;
		}
	}

	@Override
	public boolean hasNext() {
		int i = currentPos + 1;
		for (; i < h.array.length; i++) {
			if (h.array[i] != 0 && h.array[i] != OpenAddressing.DELETED) {
				return true;
			}
		}
		return false;


	}

	@Override
	public boolean hasPrevious() {
		int i = currentPos - 1;
		for (; i >= 0; i--) {
			if (h.array[i] != 0 && h.array[i] != OpenAddressing.DELETED) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int next() throws Exception {
		if (hasNext()) {
			int i = currentPos + 1;
			for (; i < h.array.length; i++) {
				if (h.array[i] != 0 && h.array[i] != OpenAddressing.DELETED) {
					currentPos = i;
					break;
				}
			}
			return h.array[currentPos];
			
		} throw new Exception();
		
	}

	@Override
	public int previous() throws Exception {
		if (hasPrevious()) {
			int temp = currentPos;
			int i = currentPos - 1;
			for (; i >= 0; i--) {
				if (h.array[i] != 0 && h.array[i] != OpenAddressing.DELETED) {
					currentPos = i;
					return h.array[temp];
				}
			}
		} throw new Exception();
	}

	@Override
	public void set(int value) {
		// does not do anything,
		//because it will break hash table definition

	}

}
