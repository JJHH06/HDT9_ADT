import java.util.LinkedHashMap;
/**
 * @author Carlos Ráxtum 19721
 * @author Jose Hurtarte
 *
 * @param <K> es el tipo de la key
 * @param <V> es el tipo del valor
 *
 * Utilizacion de linkedhasmap
 */
public class LinkedHashMap1<K, V> implements MyMap<K, V>{

    protected LinkedHashMap<K,V> map = new LinkedHashMap<>();

    /**
     * Mete un valor al diccionario
     * @param keyValue es la llave que se quiere introducir al diccionario
     * @param value es el valor que se quiere introducir al diccionario
     */
    public void put(K keyValue, V value) {
        map.put(keyValue, value);
    }

    /**
     * Regresa el valor que guarda una llava
     * @param key llave de quien se quiere el valor
     * @return el valor de la llave
     */
    public V get(K key){
        return map.get(key);
    }

    /**
     * Muestra si la llave esta en la coleccion
     * @param key la llave que se quiere averiguar
     * @return true si existe la llave y false si no existe
     */
    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    /**
     * Actualiza los daos de una entrada
     * @param key es la llave en donde se quiere actualizar el valro
     * @param oldValue valor anterior
     * @param newValue nuevo anterior
     */
    public void replace(K key, V oldValue, V newValue){
        map.replace(key, oldValue, newValue);
    }

    /**
     * Consiguie el tamaño de la coleccion
     * @return el tamaño de la colección
     */
    public int size(){
        return map.size();
    }
}