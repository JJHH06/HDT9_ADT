import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/**
 * 
 * @author Jose Hurtarte 
 * @author Carlos Raxtum
 *
 */
public class DictionaryManager{  //se utilizo esta clase para probar elevar el nivel de abstraccion un poquito y no tener sobrecargada la Main

	private Factory<String,String> factory= new Factory<String,String>();
	private MyMap<String,String> diccionario;
	
	
	/**
	 * 
	 * @param decision de implementacion
	 */
	public DictionaryManager(String decision) {
		this.diccionario = factory.getMyMap(decision);
	}
	
	/**
	 * llena el diccionario (arbol o mapa)
	 */
	public void fillDictionary() {
		String barra = File.separator;
		String dir = System.getProperty("user.dir");
		File archivo = new File (dir + barra + "Spanish.txt");
		FileReader fr;
		String linea = "";

		try {
			fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			String[] listaLinea = null;

			while((linea = br.readLine()) != null){
				
				
				if(!(Character.toString(linea.charAt(0)).equals("#"))) {
					
					//Con esto se separan todos los posibles valores de definicion
					listaLinea = linea.split("(;)|(,)|(\\[)|(\\()|(\t)");
					
					//Se utilizan los primeros 2 ya que son los unicos separados
					diccionario.put(listaLinea[0], listaLinea[1]);
				}
				
				
			}
		}
		
		catch (Exception e) {
		}

	}
	/**
	 * traduce la frase
	 * @return la frase ya traducida
	 */
	public String translation() {
		
		
		String barra = File.separator;
		String dir = System.getProperty("user.dir");
		File archivo = new File (dir + barra + "datos.txt");
		FileReader fr;
		String linea = "";
		String listaLinea = "";
		try {
		fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
		
		
		while((linea = br.readLine()) != null){
		listaLinea = linea;
		}
		}
		catch (Exception e) {
		}
		
		
		
		listaLinea = listaLinea.replaceAll("\\.", "");
		String[] words = listaLinea.split(" ");
		String resultado = "";
		String word = "";
		for (String palabra : words) {
			word = diccionario.get(palabra);
			if(word != null) {
				resultado += " "+ word.toLowerCase();
				
			}
			else if(word == null) {
				resultado += "*"+palabra+"*";
			}
			
		}
		return resultado+".";
		
		
	}
	
	

}