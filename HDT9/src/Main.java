/**
 * Universidad del Valle
 * @author Carlos RÃ¡xtum 19721
 * @author Jose Hurtarte
 * 
 */
import java.io.*;
import java.util.*; 

public class Main {

     public static void main(String [] args) throws FileNotFoundException, IOException {

     	BufferedReader br = new BufferedReader(new FileReader("Spanish.txt"));   
        StringBuilder sb = new StringBuilder(); 
        String type;
        MyMap imp = null; //implementacion que escogera el Factory       
        Factory factory = new Factory();

       // SplayTree<Node<Association<String, String>>> rbt = new SplayTree<>(); //agregar splay tree

        Scanner teclado = new Scanner(System.in);
        int ciclo =0;
        try{
            while (ciclo ==0)
            {
               System.out.println("\n ¿Que implementacion desea utilizar?:");
               System.out.println("1. HashMap");
               System.out.println("2. Splay Tree");
               System.out.println("3. Salir");
                String entryTree = teclado.nextLine();
                switch(entryTree)
                {
                    case "1":
                        imp = Factory.getMyMap("HashMap1");
                        break;
                    case "2":
                        imp = Factory.getMyMap("SplayTree");
                        break;
                    case "3":
                        ciclo = 1;
                        break;
                }
                if(ciclo == 0){
                    while ((type=br.readLine())!=null) {
                       String palabraIngles;
                        String palabraEspanol;
                        sb.append(type);
                        sb.append(System.lineSeparator()); 
                        type = type + " "; //Concatenado para que el ultimo valor sea leido sin problemas                                           //por substring
                        for(int i=1;i<type.length();i++){
                            String iter = type.substring((i-1), i); 
                            if(iter.equals("\t"))
                            {                               
                                if(type.contains(",")){
                                    palabraEspanol = type.substring(i, type.indexOf(",")).toLowerCase();
                                }else if(type.contains(";")){
                                    palabraEspanol = type.substring(i, type.indexOf(";")).toLowerCase();
                                }else{
                                    palabraEspanol = type.substring(i, type.length()-1).toLowerCase(); //se obtiene la subcadena luego de ","
                                }                               
                                palabraIngles = type.substring(0, i-1).toLowerCase(); //se obtiene la subcadena antes de ","                              
                                
                                
                                
                                imp.put(palabraIngles, palabraEspanol);// ME DA ERROR
                               
                                
                                
                                
                            }
                        }
                    }
                     //Traduccion del documento.
                    File archivo = new File ("texto.txt");
                    FileReader fr = new FileReader (archivo);
                    BufferedReader br1 = new BufferedReader(fr);
                    String linea = "";
                    Scanner scanner = new Scanner(fr);
                    String palabra = "";
                    while (scanner.hasNextLine()) {
                        linea += scanner.nextLine();                       
                        palabra = linea.replaceAll("\n", " ");
                    }
                    fr.close();
                    br1.close();
                    String palabras[] = palabra.split(" ");
                    String resultado = "";
                    String word;
                    for(String p: palabras){
                        word = p.toLowerCase();
                        if (imp.containsKey(word))
                            resultado += ((String) imp.get(word)).toUpperCase() + " ";
                        else
                            resultado+= " *"+word.toUpperCase() + "* ";
                        }
                    System.out.println("----------------------------------");
                    System.out.println("Traduccion:");
                    System.out.println(resultado);
                    System.out.println("----------------------------------");
                    ciclo = 1;
                }
            }
        } finally{
            br.close();
        }
    }
}
