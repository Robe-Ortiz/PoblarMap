package contadorNumeros;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class ContadorMultiplosNumerosAleatorios {

	private static Random random = new Random();
	private static int[] multiplos = {2,3,5,7,11,13,17};
	
	
	
	public static Set<Integer> generarNumerosAleatorios() {
		Set<Integer> numerosAleatorios = new HashSet<>();
		while(numerosAleatorios.size()<100) {
			numerosAleatorios.add(random.nextInt(1000)+1);
		}
		return numerosAleatorios;
	}
	
	
	public static void conteoDeMultiplos(Set<Integer> listaDeNumeros) {
		Map<Integer,Integer> multiplosFrecuencia = new TreeMap<>();		
		listaDeNumeros.forEach(s->{
			for(int multiplo : multiplos) {
				if(s%multiplo==0) {
					multiplosFrecuencia.compute(multiplo,(key,value)->value==null?1:value+1);
				}
			}
		});	
		multiplosFrecuencia.forEach((key,value)-> System.out.printf("Multiplo: %d Frecuencia: %d\n",key,value));
	}
	
	
	
	public static void main(String[] args) {
		
		
		Set<Integer> numerosAleatorios = generarNumerosAleatorios();				
		conteoDeMultiplos(numerosAleatorios);
		
	}
	
	
	
	
}
