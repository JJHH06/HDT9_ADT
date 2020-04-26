/**
 * @author Carlos Ráxtum 19721
 * @author Jose Hurtarte
 *
 * Se encarga de mandar una instancia de un
 * map<k,v> en el que ambos son strings
 */
public class Factory{

    /**
     * Devuelve una instancia de un map
     *
     * @param mapType es la instancia que quiere
     * @return una instancia de un mapa
     */
    public static MyMap<String, String> getMyMap(String mapType){

        switch (mapType){
 //           case "1":
//                return new nombre SplayTree<>();//llamar splay tree
            case "2":
                return new HashMap1<>();
        }
		return null;

    }

}