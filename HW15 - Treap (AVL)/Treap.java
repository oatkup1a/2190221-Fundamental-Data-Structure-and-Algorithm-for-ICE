public class Treap {
	TreapNode root;
	int size;
	
	public Treap() {
		root = null;
		size = 0;
	}
	
	public TreapNode insert(int v, int h) {
		TreapNode t = root;
		TreapNode n = new TreapNode(v, h);
		
		if (insertTree(n) == null) return null;
		if (root == n) {
			return n;
		}
		while (n.heapValue < n.parent.heapValue) {
			percolateUp(n);
			if (root == n) break;
		}
		
		return n;
	}
	
	public TreapNode insertTree(TreapNode t) {
		int v = t.bstValue;
		TreapNode parent = null;
		TreapNode temp = root;

		// This first part is almost the same as find,
		// but it has an extra pointer called parent.
		while (temp != null && temp.bstValue != v) {
			if (v < temp.bstValue) {
				parent = temp;
				temp = temp.left;

			} else {
				parent = temp;
				temp = temp.right;

			}
		}

		if (temp == null) {
			if (parent == null) {
				root = t;
			} else if (v < parent.bstValue) {
				parent.left = t;
			} else {
				parent.right = t;
			}
			size++;
			t.parent = parent;
			return t;
		} else {
			// we do nothing since
			// we don't want to add duplicated data.
			return null;
		}
	}
	
	public void percolateUp(TreapNode t) {
		if (t == null) return;
		TreapNode parent = t.parent;
		if (t.bstValue > root.bstValue) {
			if (parent == root) {
				rotateRightChild(parent);
				root = t;
			} else if (t.bstValue < t.parent.bstValue) {
				t.parent.parent.right = rotateLeftChild(parent);
			} else {
				t.parent.parent.right = rotateRightChild(parent);
			}
		} else if (t.bstValue < root.bstValue) {
			if (parent == root) {
				rotateLeftChild(parent);
				root = t;
			} else if (t.bstValue < t.parent.bstValue) {
				if (isLeftChild(parent)) {
					parent.parent.left = rotateLeftChild(parent);
				} else {
					parent.parent.right = rotateLeftChild(parent);
				}
			} else {
				if (isLeftChild(parent)) {
					parent.parent.left = rotateRightChild(parent);
				} else {
					parent.parent.right = rotateRightChild(parent);
				}
			}
		}
	}
	
	public TreapNode rotateLeftChild(TreapNode n) {
		TreapNode l = n.left;
		TreapNode lr = n.left.right; // can be null
		n.left = lr;
		if (lr != null) {
			lr.parent = n;
		}
		l.right = n;
		l.parent = n.parent;
		n.parent = l;


		return l;
	}

	public TreapNode rotateRightChild(TreapNode n) {
		TreapNode r = n.right;
		TreapNode rl = n.right.left; // can be null
		n.right = rl;
		if (rl != null) {
			rl.parent = n;
		}
		r.left = n;
		r.parent = n.parent;
		n.parent = r;


		return r;
	}
	
	public boolean isLeftChild(TreapNode t) {
		if(t.parent.left == t) return true;
		return false;
	}
}
