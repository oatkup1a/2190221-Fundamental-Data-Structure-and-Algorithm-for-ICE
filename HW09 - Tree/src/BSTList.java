import java.util.ArrayList;

public class BSTList {
	BSTNodeList root;
	int size;

	public BSTList() {
		root = null;
		size = 0;
	}

	public BSTList(BSTNodeList root, int size) {
		this.root = root;
		this.size = size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void makeEmpty() {
		root = null;
		size = 0;
	}

	public BSTNodeList find(Comparable v) {
		BSTNodeList temp = root;

		//Check for node that corresponds to the first element
		while (temp != null && temp.dataList.get(0).first != ((Pairdata) v).first) {
			if (((Pairdata) v).first < temp.dataList.get(0).first) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		
		//Now we will check whether the dataList contains v
		if (temp == null) {
			return null;
		} else if (temp != null && temp.dataList.get(0).first == ((Pairdata) v).first) {
			if (!temp.dataList.contains(v)) {
				return null;
			}
		}

		return temp;
	}

	public BSTNodeList insert(Comparable v) {
		BSTNodeList temp = root;
		BSTNodeList parent = null;

		//Check for node that corresponds to the first element
		while (temp != null && temp.dataList.get(0).first != ((Pairdata) v).first) {
			if (((Pairdata) v).first < temp.dataList.get(0).first) {
				parent = temp;
				temp = temp.left;
			} else {
				parent = temp;
				temp = temp.right;
			}
		}

		//Case if v is not found related to any nodes, create a new node
		if (temp == null) {
			BSTNodeList n = new BSTNodeList(new ArrayList<Pairdata>(), temp, temp, parent);
			n.dataList.add((Pairdata) v);
			if (parent == null) {
				root = n;
			} else if (((Pairdata) v).first < parent.dataList.get(0).first) {
				parent.left = n;
			} else {
				parent.right = n;
			}
			size++;
			return n;
	
		//Add v to dataList and also check for duplicates
		} else if (!temp.dataList.contains(v)) {
			temp.dataList.add((Pairdata)v);
			size++;
		}

		return temp;
	}

	public BSTNodeList findMin(BSTNodeList n) {
		BSTNodeList temp = n;
		if (temp == null)
			return null;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

}
