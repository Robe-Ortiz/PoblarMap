package contadorLetras;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class contadorFrecuenciaLetras {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Introducir texto: ");
		System.out.print("-> ");
		String texto = input.nextLine();
		
		texto = texto.replaceAll("\\p{Punct}","");
		texto = texto.replaceAll("[¡¿]", "");
		texto = texto.toLowerCase();
		texto = texto.replace(" ", "");
		char[] letras = texto.toCharArray();
		
		Map<Character,Integer> caracterFrecuencia = new TreeMap<>();
		
		for(Character letra : letras){
			caracterFrecuencia.compute(letra,(key,value)-> value==null?1:value+1);
		}
		
		caracterFrecuencia.forEach((key,value)->System.out.printf("Letra %s, Frecuencia %d\n",key,value));	
		input.close();
	}
}
