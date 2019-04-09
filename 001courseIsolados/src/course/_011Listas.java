package course;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _011Listas {

	public static void main(String[] args) {
		
		// "List<Integer> listExemplo;" -> EXEMPLO DE COMO CRIAR UMA LIST
		// DIFERENTE DO VETOR, A LISTA N�O ACEITA TIPOS PRIMITIVOS, TEM QUE SER A WRAPPER CLASS
		
		List<String> list = new ArrayList<>(); // CRIANDO E INSTANCIANDO A LISTA. 
		// PARA INSTANCIAR TEM QUE USAR UMA CLASSE QUE IMPLEMEMENTA A INTERFACE. NESSE CASO O ARRAYLIST
		// ESSA CLASSE ARRAYLIST � BEM OTIMIZADA, PEGA TANTO CARACTERISTICAS DO VETOR QUANTO DA LISTA
		
		list.add("Maria");
		list.add("Alex");
		list.add("Bob");
		list.add("Ricardo");
		list.add("Matheus");
		list.add("Leila");
		list.add("Anna");
		list.add("Donald");
		list.add(2, "Marco"); // ESSA SINTAXE ADICIONA O 'MARCO' NA POSI��O '2'!
				
		System.out.println("Tamanho da lista: " + list.size());
		System.out.println("---------------------");
		
		System.out.println("Elementos da lista: ");
		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("---------------------");
		System.out.println("Elementos da lista ap�s remover o Ricardo: ");
		list.remove("Ricardo");
		for (String x : list) {
			System.out.println(x);
		}
		
		//REMO��O DA LISTA DE ELEMENTOS QUE ATENDAM A UM PREDICADO
		System.out.println("---------------------");
		System.out.println("Elementos da lista ap�s remover os nomes que come�am com 'M': ");
		list.removeIf(x -> x.charAt(0) == 'M'); // ISSO � UMA FUN��O LAMBDA. LEITURA = REMOVER TODO STRING X TAL QUE x.charAt(0) SEJA IGUAL A M
		for (String x : list) {
			System.out.println(x);
		}
		
		System.out.println("---------------------");
		System.out.println("Elementos da ap�s remover o elemento na posi��o 2: ");
		list.remove(2);
		for (String x : list) {
			System.out.println(x);
		}
		
		System.out.println("---------------------");
		System.out.println("Index of Bob: " + list.indexOf("Bob"));
		System.out.println("Index of Naila (elemento que n�o existe na lista!): " + list.indexOf("Naila"));
		
		System.out.println("---------------------");
		System.out.println("Elementos da lista exclu�dos todos os elementos excetos aqueles que come�am com 'A' : ");
		
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList()); // � CRIADA UMA NOVA LISTA
		// PARA FILTRAR PRIMEIRO TEM QUE CONVERTER A LISTA PARA UM STREAM, FAZER A OPERA��O LAMBDA, E DEPOIS CONVERTER DE NOVO PARA UMA LISTA
		
		for (String x : result) {
			System.out.println(x);
		}

		// COMO BUSCAR NA LISTA O PRIMEIRO ELEMENTO QUE ATENDA A UM PREDICADO
		System.out.println("---------------------");
		System.out.println("Primeiro elemento da lista que come�a com J: ");
		String name = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);
		System.out.println(name);
		
		System.out.println("---------------------");
		System.out.println("Primeiro elemento da lista que come�a com A: ");
		name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
		System.out.println(name);
		
	
	}

}
