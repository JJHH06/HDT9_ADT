

/**
 * 
 * @author Jose Hurtarte
 * @author Carlos Raxtum
 *
 * @param <K>, tipo de dato de la llave que se utiliza para comparar
 * @param <V>, tipo de dato del valor 
 */

/*
 * Inspirada en la clase privada que traia la clase original, sin
 * embargo hecha mayormente por nosotros
 */
public class Nodo<K extends Comparable<K>, V>{
        
        public Nodo<K, V>  left, right; 
        public ComparableAssociation<K, V> data;

        public Nodo(K key, V value) {
            data = new ComparableAssociation<K,V>(key,value);
        }
    }
