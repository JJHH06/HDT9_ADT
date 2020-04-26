/*implementacion basica obtenida de la pagina web de archivos
 * del libro Algorithms, 4th Edition, de Robert Sedgewick
 * https://algs4.cs.princeton.edu/home/
 */
/* Esta clase se modifico para poder relizar una implementacion
 * con ComparableAssociation mediante una clase nodo.
 * Tambien se modificaron unas llamadas al nodo izquierdo y derecho
*/

/**
 * 
 * @author Jose Hurtarte
 * @author Carlos Ractum
 * @author Robert Sedgewick, Algorithms 4th edition
 *
 * @param <Key>, Tipo de dato de la llave del ComparableAssociaion contenido en el nodo
 * @param <Value>, Tipo de dato del valor contenido dentro del ComparableAssociation en el nodo
 */
public class SplayTree<Key extends Comparable<Key>, Value> implements MyMap<Key, Value> {
//<K extends Comparable<K>, V>
	
    private Nodo<Key,Value> root;   // root of the BST

    

    public boolean contains(Key key) {
        return get(key) != null;
    }

    // return value associated with the given key
    // if no such value, return null
    @Override
    public Value get(Key key) {
        root = splay(root, key);
        int cmp = key.compareTo(root.data.getKey());
        if (cmp == 0) return root.data.getValue();
        else          return null;
    }    

    @Override
    public void put(Key key, Value value) {
        // splay key to root
        if (root == null) {
            root = new Nodo<Key,Value>(key, value);
            return;
        }
        
        root = splay(root, key);

        int cmp = key.compareTo(root.data.getKey());
        
        // Insert new node at root
        if (cmp < 0) {
            Nodo<Key,Value> n = new Nodo<Key,Value>(key, value);
            n.left = root.left;
            n.right = root;
            root.left = null;
            root = n;
        }

        // Insert new node at root
        else if (cmp > 0) {
            Nodo<Key,Value> n = new Nodo<Key,Value>(key, value);
            n.right = root.right;
            n.left = root;
            root.right = null;
            root = n;
        }

        // It was a duplicate key. Simply replace the value
        else {
            root.data.setValue(value);
        }

    }
    
   /***************************************************************************
    *  Splay tree deletion.
    ***************************************************************************/
    /* This splays the key, then does a slightly modified Hibbard deletion on
     * the root (if it is the node to be deleted; if it is not, the key was 
     * not in the tree). The modification is that rather than swapping the
     * root (call it node A) with its successor, it's successor (call it Node B)
     * is moved to the root position by splaying for the deletion key in A's 
     * right subtree. Finally, A's right child is made the new root's right 
     * child.
     */
    public void remove(Key key) {
        if (root == null) return; // empty tree
        
        root = splay(root, key);

        int cmp = key.compareTo(root.data.getKey());
        
        if (cmp == 0) {
            if (root.left == null) {
                root = root.right;
            } 
            else {
                Nodo<Key,Value> x = root.right;
                root = root.left;
                splay(root, key);
                root.right = x;
            }
        }

        // else: it wasn't in the tree to remove
    }
    
    
   /***************************************************************************
    * Splay tree function.
    * **********************************************************************/
    // splay key in the tree rooted at Node h. If a node with that key exists,
    //   it is splayed to the root of the tree. If it does not, the last node
    //   along the search path for the key is splayed to the root.
    private Nodo<Key,Value> splay(Nodo<Key,Value> h, Key key) {
        if (h == null) return null;

        int cmp1 = key.compareTo(h.data.getKey());

        if (cmp1 < 0) {
            // key not in tree, so we're done
            if (h.left == null) {
                return h;
            }
            int cmp2 = key.compareTo(h.left.data.getKey());
            if (cmp2 < 0) {
                h.left.left = splay(h.left.left, key);
                h = rotateRight(h);
            }
            else if (cmp2 > 0) {
                h.left.right = splay(h.left.right, key);
                if (h.left.right != null)
                    h.left = rotateLeft(h.left);
            }
            
            if (h.left == null) return h;
            else                return rotateRight(h);
        }

        else if (cmp1 > 0) { 
            // key not in tree, so we're done
            if (h.right == null) {
                return h;
            }

            int cmp2 = key.compareTo(h.right.data.getKey());
            if (cmp2 < 0) {
                h.right.left  = splay(h.right.left, key);
                if (h.right.left != null)
                    h.right = rotateRight(h.right);
            }
            else if (cmp2 > 0) {
                h.right.right = splay(h.right.right, key);
                h = rotateLeft(h);
            }
            
            if (h.right == null) return h;
            else                 return rotateLeft(h);
        }

        else return h;
    }


   /***************************************************************************
    *  Helper functions.
    ***************************************************************************/

    // height of tree (1-node tree has height 0)
    public int height() { return height(root); }
    private int height(Nodo<Key,Value> x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    @Override
    public int size() {
        return size(root);
    }
    
    private int size(Nodo<Key,Value> x) {
        if (x == null) return 0;
        else return 1 + size(x.left) + size(x.right);
    }
    
    // right rotate
    private Nodo<Key,Value> rotateRight(Nodo<Key,Value> h) {
        Nodo<Key,Value> x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

    // left rotate
    private Nodo<Key,Value> rotateLeft(Nodo<Key,Value> h) {
        Nodo<Key,Value> x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }

	@Override
	public boolean containsKey(Key key) {
		// TODO Auto-generated method stub
		return contains(key);
	}

	@Override
	public void replace(Key key, Value oldValue, Value newValue) {
		// TODO Auto-generated method stub
		put(key, newValue); //Se hace esto ya que la implementacion ya reemplaza si hay repetidos en put
		
	}
    
}