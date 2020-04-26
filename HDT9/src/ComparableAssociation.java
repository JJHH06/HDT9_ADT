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
public class ComparableAssociation<K extends Comparable<K>> implements Comparable<K>, Map.Entry<K, K> {
	
	
    private K key;
    private K value;
    
    
    

    public ComparableAssociation(K k, K v) {
		// TODO Auto-generated constructor stub
    	
    	this.value = v;
    	
    	this.key = k;
	}
    
    @Override
    public int compareTo(K comparingKey) {  //es para comparar las llaves 
        return key.compareTo(comparingKey);
    }
    
    
    
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public K getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public K setValue(K value) {
		this.value = value;
		// TODO Auto-generated method stub
		return value;
	}

	


	
}
