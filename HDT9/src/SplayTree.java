import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/*
 * Clase obtenida de http://volodk.blogspot.com/2013/12/splay-tree.html
 * 
 * fue ligeramente modificada para poder implementar bien la interfaz
 * 
 * 
 */
/**
 * 
 * @author Volodymyr_Krasnikov
 * @author Jose Hurtarte
 * @author Carlos Raxtum
 *
 * @param <K>, tipo de dato de la llave
 * @param <V>, tipo de dato del valor
 */

public class SplayTree<K extends Comparable<K>, V> implements MyMap<K, V>{
   
	/*
	 * clase interna nodo para guardar los datos de cada arbol
	 */
    class Node {
        K key;
        V value;
        Node left, right, parent;
        public Node(K key, V value, Node parent, Node left, Node right)
        { 
            this.key = key;  this.value = value;
            this.parent = parent; this.left = left; this.right = right;
        }
        @Override public String toString() { return String.format("%s", key); }
    }
   
    Node root;
   
    // interface
   
    /**
     * 
     * @param key, llave a insertar en el nodo
     * @param value, valor a insertar en el nodo
     * realiza una simplificacion para el insert de 2 datos
     */
    public void insert(K key, V value){
        root = insert(root, null, key, value);
    }
   /**
    * 
    * @param key, llave de dato a eliminar
    * 
    */
    public void delete(K key){
        root = delete(root, key);
    }
   /**
    * 
    * @param key, llave del dato a buscar
    * @return valor del dato buscado
    */
    public V find(K key){
            Node n = find(root, key);
        if( n == null ){
            return null;
        } else {
             root = n;
           return n.value;
        }
    }
   /**
    * devuelve la altura maxima de la raiz
    */
    public int size(){ return size(root); }
   /**
    * 
    * @param tree, arbol splay
    * @return altura del splay
    */
    public int size(Node tree){
        if(tree == null) return 0;
        else return 1 + size(tree.left) + size(tree.right);
    }
   
    /**
     * 
     * @param tree, arbol binario
     * @return altura de un nodo para ser mandada a otros metodos
     */
    int height(Node tree){
        if(tree == null) return 0;
        else return 1 + Math.max(height(tree.left), height(tree.right));
    }
   
    /**
     * 
     * @param curr, dato del valor actual
     * @param key, llave a buscar
     * @return nodo buscado
     */
    Node find(Node curr, K key){
        if( curr == null ) return null;
       
        if( eq(key, curr.key) ) return curr;
       
        if( lt(key, curr.key)){
            Node n = find(curr.left, key);
            if( n != null ){    // splay up
                curr.left = n;
                return rotateRight(curr);
            }
            return null;
        }
        else {
            Node n = find(curr.right, key);
            if(n != null){ // splay up
                curr.right = n;
                return rotateLeft(curr);
            }
            return null;
        }
       
    }
   
    boolean isBST(Node curr){
        if( curr == null )
            return true;
        return isBST(curr.left) && ( gt(curr, curr.left) && le(curr, curr.right) ) && isBST(curr.right);
    }
   /**
    * 
    * @param tree, arbol splay
    * @return vaor minimo del splay
    */
    Node min(Node tree){
        if( tree != null && tree.left != null )
            return min(tree.left);
        return tree;
    }
   /**
    * 
    * @param tree arbol splay
    * @return valor maximo del splay
    */
    Node max(Node tree){
        if(tree != null && tree.right != null)
            return max(tree.right);
        return tree;
    }
   /**
    * 
    * @param curr, dato actual del nodo
    * @param parent, padre del nodo
    * @param key, valor de la llave para nuevo nodo
    * @param value, valor a insertr en el nuevo nodo
    * @return nodo insertado
    */
    Node insert(Node curr, Node parent, K key, V value){
        if( curr == null ){
            return new Node(key, value, parent, null, null);
        } else {
            if( lt(key, curr.key) )
            {
                curr.left = insert(curr.left, curr, key, value);
                return rotateRight(curr); // splay up
            }
            else if( eq(key, curr.key) )
            {
                curr.value = value;
                return curr;
            }
            else
            {
                curr.right = insert(curr.right, curr, key, value);
                return rotateLeft(curr); // splay up
            }
        }
    }
   
    /**
     * 
     * @param curr, nodo actual
     * @param key, llave actual
     * @return nodo eliminado del arbol
     */
    Node delete(Node curr, K key){
       if( find(root, key) == null){
           return null;
       } else {
           return root = delete(root);
       }
    }
   /**
    * 
    * @param curr, nodo a birrar
    * @return nodo eliminado
    */
    Node delete(Node curr)
    {
        if( curr.left == null && curr.right == null )
        {
            Node p = curr.parent;
            if(p.left == curr) p.left = null;
            if(p.right == curr) p.right = null;
            return p;
        }
        else if( curr.left == null && curr.right != null)
        {
            Node p = curr.parent;
            if(p.left == curr) p.left = curr.right;
            if(p.right == curr) p.right = curr.right;
            return p;
        }
        else if(curr.left != null && curr.right == null)
        {
            Node p = curr.parent;
            if(p.left == curr) p.left = curr.left;
            if(p.right == curr) p.right = curr.left;
            return p;
        }
        else
        {
            Node repl = max(curr.left);
            curr.key = repl.key;
            curr.value = repl.value;
            delete(repl);
            return curr;
        }
    }
   /**
    * 
    * @param old, nodo a mover
    * @return un movimiento de rotacion zig 
    */
    Node rotateLeft(Node old){
        Node newRoot = old.right;
        old.right = newRoot.left;
        if (old.right != null) old.right.parent = old;
       
        newRoot.parent = old.parent;
        if( old.parent != null ){
            if( old.parent.left == old ) old.parent.left = newRoot;
            if( old.parent.right == old ) old.parent.right = newRoot;
        }
        newRoot.left = old;
        old.parent = newRoot;
       
        return newRoot;
    }
   /**
    * 
    * @param old, nodo a mover
    * @return rotacion zag del nodo
    */
    Node rotateRight(Node old){
        Node newRoot = old.left;
        old.left = newRoot.right;
        if (old.left != null) old.left.parent = old;
       
        newRoot.parent = old.parent;
        if( old.parent != null ){
            if( old.parent.left == old ) old.parent.left = newRoot;
            if( old.parent.right == old ) old.parent.right = newRoot;
        }
        newRoot.right = old;
        old.parent = newRoot;
       
        return newRoot;
    }
   
    
    /*
     * De aqui en adelante hay comparaciones para la realizacion de movimientos
     */
    boolean lt(Node n1, Node n2){
        return n2 == null ? true : lt(n1.key, n2.key);
    }
   
    boolean lt(K key1, K key2){
        return key1.compareTo(key2) < 0;
    }
   
    boolean le(Node n1, Node n2){
        return n2 == null ? true : le(n1.key, n2.key);
    }
   
    boolean le(K key1, K key2){
        return key1.compareTo(key2) <= 0;
    }
   
    boolean gt(Node n1, Node n2){
        return n2 == null ? true : gt(n1.key, n2.key);
    }
   
    boolean gt(K key1, K key2){
        return key1.compareTo(key2) > 0;
    }
   
    boolean ge(Node n1, Node n2){
        return n2 == null ? true : ge(n1.key, n2.key);
    }
   
    boolean ge(K key1, K key2){
        return key1.compareTo(key2) >= 0;
    }
   
    boolean eq(K key1, K key2){
        return key1.compareTo(key2) == 0;
    }

    /**
     * Implementacion de put en splay tree
     */
	@Override
	public void put(K keyValue, V value) {
		insert(keyValue, value);
		// TODO Auto-generated method stub
		
	}

	/**
	 * implementacion de get en splay tree
	 */
	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return find(key);
	}

	@Override
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void replace(K key, V oldValue, V newValue) {
		// TODO Auto-generated method stub
		
	}
}