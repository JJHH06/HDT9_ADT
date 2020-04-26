import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMapTest {

	@Test
	void testHashMap() {
	 Factory<String,String> factory= new Factory<String,String>();
	 MyMap<String,String> diccionario = factory.getMyMap("1");
	 diccionario.put("super", "super");
	 diccionario.put("hermano", "bruh");
	 diccionario.put("casa", "house");
	 diccionario.put("edificio", "building");
	 
	 assertEquals("bruh", diccionario.get("hermano"));
		
	}
	
	@Test
	void testSplayTree() {
	 Factory<String,String> factory= new Factory<String,String>();
	 MyMap<String,String> diccionario = factory.getMyMap("2");
	 diccionario.put("super", "super");
	 diccionario.put("hermano", "bruh");
	 diccionario.put("casa", "house");
	 diccionario.put("edificio", "building");
	 
	 assertEquals("bruh", diccionario.get("hermano"));
		
	}

}
