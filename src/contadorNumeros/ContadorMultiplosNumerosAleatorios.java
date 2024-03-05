package contadorNumeros;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class ContadorMultiplosNumerosAleatorios {

	private static Random random = new Random();
	
	private static boolean esPrimo(int numero) {
		int inicio = 2;
		boolean esPrimo = true;
		while((esPrimo) && (inicio!= numero)) {
			if(numero % inicio == 0)
				esPrimo = false;
			inicio++;			
		}
		return esPrimo;
	}
	
	private static Integer[] generarMultiplos(int hastaDonde) {
		List<Integer> multiplos = new ArrayList<>();
		for(int i = 2; i <= hastaDonde;i++) {
			if(esPrimo(i)) {
				multiplos.add(i);
			}
		}
		Integer[] arrayMultiplo = new Integer[multiplos.size()];
		multiplos.toArray(arrayMultiplo);
		return arrayMultiplo;
		
		
	}
	
	public static Set<Integer> generarNumerosAleatorios() {
		Set<Integer> numerosAleatorios = new HashSet<>();
		while(numerosAleatorios.size()<100) {
			numerosAleatorios.add(random.nextInt(1000)+1);
		}
		return numerosAleatorios;
	}
		
	public static void conteoDeMultiplosHastaDonde(Set<Integer> listaDeNumeros, int hastaDonde) {
		Map<Integer,Integer> multiplosFrecuencia = new TreeMap<>();
		Integer [] multiplos2 = generarMultiplos(hastaDonde);
		listaDeNumeros.forEach(s->{
			for(int multiplo : multiplos2) {
				if(s%multiplo==0) {
					multiplosFrecuencia.compute(multiplo,(key,value)->value==null?1:value+1);
				}
			}
		});	
		multiplosFrecuencia.forEach((key,value)-> System.out.printf("Multiplo: %d Frecuencia: %d\n",key,value));
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		Set<Integer> numerosAleatorios = generarNumerosAleatorios();				
		conteoDeMultiplosHastaDonde(numerosAleatorios, 60);
		
		
		
		
	}
}
