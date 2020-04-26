/**
 * Universidad del Valle
 * @author Carlos Ráxtum
 * @author Jose Hurtarte
 * 
 */

import java.util.*; 

public class Main {

     public static void main(String [] args){

 		System.out.println("Que implementacion deseas");
 		System.out.println("1. SplayTree");
 		System.out.println("2. HashMap");
 		System.out.println();
 		
 		Scanner scan = new Scanner(System.in);
 		String eleccion;
 		eleccion = scan.nextLine();
 		
 		DictionaryManager diccionario = new DictionaryManager(eleccion); //manda a llamar al factory de mapa
 		diccionario.fillDictionary(); //se llena el diccionario
 		if(eleccion.equals("1")) {
 			System.out.println("Implementacion SplayTree\n");
 			System.out.println("Resultado de la traduccion de datos.txt: \n");
 			System.out.println(diccionario.translation()); // se traduce con splaytree
 		}
 		else {
 			System.out.println("Implementacion HashMap/n");
 			System.out.println("Resultado de la traduccion de datos.txt: \n");
 			System.out.println(diccionario.translation());// se traduce con hashmap
 		}
 		

    }
}
