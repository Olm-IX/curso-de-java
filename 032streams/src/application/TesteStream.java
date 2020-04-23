// https://www.oracle.com/technetwork/pt/articles/java/streams-api-java-8-3410098-ptb.html

package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TesteStream {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

//		.stream() - Criando a stream a partir de uma coleção
		Stream<Integer> st1 = list.stream();

//		.toArray() - Operação terminal que converte a stream em um vetor
		System.out.println(Arrays.toString(st1.toArray()));
//			output:
//				[3, 4, 5, 10, 7]

//		A stream só pode ser percorrida uma vez, se tentar uma segunda vez irá lançar uma exceção
//		System.out.println(st1.toArray()); // IllegalStateException
//		Stream<Integer> st2 = st1;
//		System.out.println(st2.toArray()); //  // IllegalStateException

//		.map() - Operação intermediária que transforma a lista a partir de uma função. 
//		Gera uma outra Stream onde cada elemento será o elemento original multiplicado por 10
		Stream<Integer> st3 = list.stream().map(x -> x * 10);
		System.out.println(Arrays.toString(st3.toArray()));
//			output:
//				[30, 40, 50, 100, 70]

//		Stream.of() - Outra forma de se criar a Stream, inserindo manualmente os elementos
		Stream<String> st4 = Stream.of("Cthulhu", "Nyarlathotep", "Shub-Niggurath");
		System.out.println(Arrays.toString(st4.toArray()));
//			output:
//				[Cthulhu, Nyarlathotep, Shub-Niggurath]

//		Stream.iterate() - os parâmetros são o primeiro elemento, e a função de iteração/geração dos próximos elementos
		Stream<Integer> st5 = Stream.iterate(0, x -> x + 2);
//		Essa Stream é potencialmente infinita! Irá somando 2 indefinidamente. Precisaremos de uma função short-circuit para 
//		cortar a execução, como o .limit()

//		.limit() - operação intermediária que cria novo Stream com o 10 elementos. 
//		.toArray() - operação terminal que devolve um vetor com os elementos do Stream
		System.out.println(Arrays.toString(st5.limit(10).toArray()));
//			output:
//				[0, 2, 4, 6, 8, 10, 12, 14, 16, 18]

//		Montando a sequência Fibonnaci com Stream!
		Stream<Long> fibo = Stream.iterate(new long[] { 0L, 1L }, p -> new long[] { p[1], p[0] + p[1] }).map(p -> p[0]);
//		O primeiro elemento é um vetor de long com dois elementos. A função retorna um novo vetor de dois elementos, sendo
//		o primeiro elemento o segundo elemento do vetor anterior, e o segundo elemento a soma dos dois elementos do
//		vetor anterior. O .map() retorna outra Stream com primeiro elemento do vetor.
		System.out.println(Arrays.toString(fibo.limit(10).toArray()));
//			output:
//				[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]

//		Somando todos os elementos pares da Strem
//		.reduce() - o elemento inicial é o elemento neutro da operação, e uma função
//		que recebe dois argumentos e devolve um resultado
//		Integer sum = list.stream().filter(x -> x % 2 == 0).reduce(0, (x, y) -> x + y); // Somatório
//		Integer sum = list.stream().filter(x -> x % 2 == 0).reduce(1, (x, y) -> x * y); // Produtório
		Integer sum = list.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum); 
		System.out.println(sum);
//			output:
//				14

		List<Integer> newList = list.stream()
				.filter(x -> x % 2 != 0) // operação intermediária (predicado)
				.map(x -> x * 10) // operação intermediária (função)
				.collect(Collectors.toList()); // operação terminal
		System.out.println(newList.toString());
//			output
//				[30, 50, 70]
	}
}
