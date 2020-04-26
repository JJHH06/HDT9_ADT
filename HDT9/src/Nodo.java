
public class Nodo<K extends Comparable<K>, V>{
        
        public Nodo<K, V>  left, right;   // left and right subtrees
        public ComparableAssociation<K, V> data;

        public Nodo(K key, V value) {
            data = new ComparableAssociation<K,V>(key,value);
        }
    }
