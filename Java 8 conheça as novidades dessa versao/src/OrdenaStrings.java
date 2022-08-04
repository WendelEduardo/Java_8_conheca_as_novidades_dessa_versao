import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> palavras = new ArrayList<String>();
		palavras.add("Alura online");
		palavras.add("Editora casa do código");
		palavras.add("Coleum");

		Collections.sort(palavras);
		System.out.println(palavras);

		// Comparator<String> comparador = new comparadorPorTamanho();

		//palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		palavras.sort(Comparator.comparing(String::length));
		System.out.println(palavras);

		//Consumer<String> consumidor = p -> System.out.println(p);
		//palavras.forEach(consumidor);
		
		//palavras.forEach(p -> System.out.println(p));
		palavras.forEach(System.out::println);
		
		
	}

}
/*
 * class comparadorPorTamanho implements Comparator<String>{
 * 
 * @Override public int compare(String s1, String s2) { if(s1.length() <
 * s2.length()) { return -1; }else if(s1.length() > s2.length()){ return 1;
 * }else { return 0; } }
 * 
 * }
 */