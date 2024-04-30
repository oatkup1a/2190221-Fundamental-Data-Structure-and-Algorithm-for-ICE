public class CDLinkedList {
	DListNode header;
	int size;
	static final int HEADERVALUE = -9999999;

	public CDLinkedList() {
		header = new DListNode(HEADERVALUE);
		makeEmpty();// necessary, otherwise next/previous node will be null
	}

	public boolean isEmpty() {
		return header.nextNode == header;
	}

	public boolean isFull() {
		return false;
	}

	/** make the list empty. */
	public void makeEmpty() {
		header.nextNode = header;
		header.previousNode = header;
		size = 0;
	}

	// put in new data after the position of p.
	public void insert(int value, Iterator p) throws Exception {
		if (p == null || !(p instanceof DListIterator))
			throw new Exception();
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();

		DListIterator p3 = new DListIterator(p2.currentNode.nextNode);
		DListNode n = new DListNode(value, p3.currentNode, p2.currentNode);
		p2.currentNode.nextNode = n;
		p3.currentNode.previousNode = n;
		size++;
	}

	// return position number of value found in the list.
	// otherwise, return -1.
	public int find(int value) throws Exception {
		DListIterator itr = new DListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			int v = itr.next();
			index++;
			if (itr.currentNode == header)
				return -1;
			if (v == value)
				return index; // return the position of value.
		}
		return -1;
	}

	// return data stored at kth position.
	public int findKth(int kthPosition) throws Exception {
		if (kthPosition < 0 || kthPosition > size - 1)
			throw new Exception();// exit the method if the position is
		// beyond the first/last possible
		// position, throwing exception in the process.
		DListIterator itr = new DListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			int v = itr.next();
			index++;
			if (itr.currentNode == header)
				throw new Exception();
			if (index == kthPosition)
				return v;
		}
		throw new Exception();
	}

	// Return iterator at position before the first position that stores value.
	// If the value is not found, return null.
	public Iterator findPrevious(int value) throws Exception {
		if (isEmpty())
			return null;
		Iterator itr1 = new DListIterator(header);
		Iterator itr2 = new DListIterator(header);
		int currentData = itr2.next();
		while (currentData != value) {
			currentData = itr2.next();
			itr1.next();
			if (((DListIterator) itr2).currentNode == header)
				return null;
		}
		return itr1;
	}

	// remove content at position just after the given iterator. Skip header if
	// found.
	public void remove(Iterator p) {
		if (isEmpty())
			return;
		if (p == null || !(p instanceof DListIterator))
			return;
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			return;
		if (p2.currentNode.nextNode == header)
			p2.currentNode = header;
		if (p2.currentNode.nextNode == null)
			return;
		DListIterator p3 = new DListIterator(p2.currentNode.nextNode.nextNode);
		p2.currentNode.nextNode = p3.currentNode;
		p3.currentNode.previousNode = p2.currentNode;
		size--;
	}

	// remove the first instance of the given data.
	public void remove(int value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	// remove data at position p.
	// if p points to header or the list is empty, do nothing.
	public void removeAt(Iterator p) throws Exception {
		if (isEmpty() || p == null || !(p instanceof DListIterator) || ((DListIterator) p).currentNode == null
				|| ((DListIterator) p).currentNode == header)
			return;

		DListIterator p2 = (DListIterator) (findPrevious(p));
		remove(p2);

	}

	// Print each contact out, one by one.
	// To be completed by students.
	public void printList() throws Exception {
		Iterator itr = new DListIterator(header);
		while (itr.hasNext()) {
			Object data = itr.next();

			System.out.println(data);

		}
	}

	public int size() throws Exception {
		return size;
	}

	// return iterator pointing to location before position.
	public Iterator findPrevious(Iterator position) throws Exception {
		if (position == null)
			return null;
		if (!(position instanceof DListIterator))
			return null;
		if (((DListIterator) position).currentNode == null)
			return null;

		DListIterator p = ((DListIterator) position);
		DListIterator p2 = new DListIterator(p.currentNode.previousNode);
		return p2;

	}





	// write the sort method below
	public void sort() throws Exception { // any sorting will do BUT you must use only 'this' list. No array or any other data structures allowed!!!
		insertionSort();
		//selectionSort();
		//bubbleSort();
		//quickSort(new DListIterator(header.nextNode), new DListIterator(header.previousNode));
	}
	
	public void insertionSort() throws Exception {
		DListIterator itr = new DListIterator(header);
		for (int i=0;i<size;i++) {
			itr.next();
			DListIterator c = new DListIterator(header);
			for (int j=0;j<i;j++) {
				c.next();
				if (c.currentNode.data > itr.currentNode.data) {
					int temp = itr.currentNode.data;
					remove(temp);
					c.previous();
					insert(temp, c);
				}
			}
		}
	}
		
	public void selectionSort() throws Exception {
		DListIterator rightItr = new DListIterator(header);
		for (int i=0;i<size;i++) {
			DListIterator itr = new DListIterator(header);
			DListIterator maxItr = new DListIterator(header);
			for (int j=0;j<size-i;j++) {
				itr.next();
				if (itr.currentNode.data > maxItr.currentNode.data) {
					maxItr.currentNode = itr.currentNode;
				}
			}
			rightItr.previous();
			int temp = maxItr.currentNode.data;
			maxItr.currentNode.data = rightItr.currentNode.data;
			rightItr.currentNode.data = temp;
		}
	}
		
	public void bubbleSort() throws Exception {
		DListIterator itr = new DListIterator(header);
		DListIterator itr2 = new DListIterator(itr.currentNode.nextNode);
		for (int i=0;i<=size-1;i++) {
			for (int j=0;j<size-1;j++) {
				itr.next();
				itr2.next();
				if (itr.currentNode.data > itr2.currentNode.data) {
					int temp = itr.currentNode.data;
					itr.currentNode.data = itr2.currentNode.data;
					itr2.currentNode.data = temp;
				}
			}
			itr.currentNode = header;
			itr2.currentNode = header.nextNode;
		}
	}

	public void merge(DListIterator s1, DListIterator f1, DListIterator s2, DListIterator f2) throws Exception {
		while (s1.currentNode != f1.currentNode) {
			while (s2.currentNode != f2.currentNode) {
				if (s2.currentNode.data > s1.currentNode.data) {
					int temp = s1.currentNode.data;
//					this.remove();
					s2.previous();
					this.insert(temp, s2);
				}
			}
		}
	}

	public void quickSort(DListIterator s, DListIterator f) throws Exception {
		if (s.currentNode == f.currentNode || f.currentNode == header || s.currentNode == header) {
			System.out.println("exit: " + s.currentNode.data +" " + f.currentNode.data);
			return;
		}
		DListIterator pivot = new DListIterator(f.currentNode); // The first data is pivot
		DListIterator itr = new DListIterator(s.currentNode);
		DListIterator noLTP = new DListIterator(s.currentNode);
		System.out.println(s.currentNode.data);
		System.out.println(f.currentNode.data);
		printList();
		while (itr.currentNode != f.currentNode) {
			if (itr.currentNode.data  <= pivot.currentNode.data) {
				noLTP.next();
			}
			itr.next();
			System.out.println("itr " + itr.currentNode.data);
			System.out.println("LTP " +noLTP.currentNode.data);
		}
		int temp = pivot.currentNode.data;
		pivot.currentNode.data = noLTP.currentNode.data;
		noLTP.currentNode.data = temp;
		pivot.currentNode = noLTP.currentNode;
//		printList();
		quickSort(s, new DListIterator(pivot.currentNode.previousNode));
		quickSort(new DListIterator(pivot.currentNode.nextNode), f);
	}

}