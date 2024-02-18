
public class ZoomaList extends CDLinkedList {
	int score = 0;

	public ZoomaList() {
		super();
	}

	public ZoomaList(CDLinkedList l) {
		header = l.header;
		size = l.size;
	}

	public void insert(int value, Iterator p) throws Exception {
		//fill code 
		if (p == null || !(p instanceof DListIterator)) {
			return;
			
		} else if (size == 0 || size == 1) { //0 or 1 data => surely insert
			super.insert(value, p);
			
		} else {
			super.insert(value, p);
			
			if (((DListIterator)p).currentNode != header) {
				
				DListIterator left = (DListIterator)p;
				left.next();
				DListIterator right = new DListIterator(((DListIterator)p).currentNode);
				
				while (left.currentNode.data == right.currentNode.data) {
					if (left.currentNode.data == header.data) {
						left.currentNode = right.currentNode;
					} else {
						right.currentNode = left.currentNode;
					}
					
					int repeat = -1;
					
					while (left.currentNode.data == value) { //Move to the left til value is not found
						left.currentNode = left.currentNode.previousNode;
						repeat++;
					}
					
					while (right.currentNode.data == value) { //Move to the right til value is not found
						right.currentNode = right.currentNode.nextNode;
						repeat++;
					}
					
					if (repeat >= 3) { //If insertion causes >=3, remove the numbers
						this.removeBetween(left, right, repeat);
						score += repeat;
						value = left.currentNode.data;
					} else {
						break;
					}
				}
			}
		}
	}

	
	public void removeBetween(DListIterator left, DListIterator right, int inc) {
		//fill code
		if (left.currentNode == right.currentNode) {
			return;
		}
		left.currentNode.nextNode = right.currentNode;
		right.currentNode.previousNode = left.currentNode;
		size -= inc;
	}

}
