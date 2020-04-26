/**
 * @author Carlos Ráxtum 
 * @author Jose Hurtarte
 *
 * Se encarga de mandar una instancia de un
 * map<k,v> en el que ambos son strings
 */
public class Factory<Key extends Comparable<Key>, Value>{

    /**
     * Devuelve una instancia de un map
     *
     * @param mapType es la instancia que quiere
     * @return una instancia de un mapa
     */
    public MyMap<Key,Value> getMyMap(String mapType){
    	
    	switch (mapType) {
        case "1":
          return new SplayTree<Key,Value>();//llamar splay tree
          
        default:
          return new HashMap1<Key,Value>();
      }
    	
    }

}