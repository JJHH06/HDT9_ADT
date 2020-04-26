/* Clase sacada del libro y
   ligeramente modificada 
	para que se pudiera 
	implementar en esta 
	Hoja de Trabajo
*/
import java.util.Map;
/** 
 * @author, Jose Hurtarte
 * @author, Carlos Raxtum
 * @author, 2001 duane a. bailey
 */
public class ComparableAssociation<K extends Comparable<K>, V> implements Map.Entry<K, V>{
    private K key;
    private V value;
    
    
    

    public ComparableAssociation(K k, V v) {
		// TODO Auto-generated constructor stub
    	
    	this.value = v;
    	
    	this.key = k;
	}
    
    
    public int compareTo(K comparingKey) {  //es para comparar las llaves 
        return key.compareTo(comparingKey);
    }
    
    
    
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public V setValue(V value) {
		this.value = value;
		// TODO Auto-generated method stub
		return value;
	}
}
