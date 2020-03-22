package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import entities.Cliente;
import entities.Conta;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		List<Conta> lista = new ArrayList<Conta>();

		// Conta (agencia, conta, saldo, Cliente)

		Conta c1 = new Conta(22, 22, 333.0, new Cliente("Nico"));
		Conta c2 = new Conta(22, 55, 444.0, new Cliente("Guilherme"));
		Conta c3 = new Conta(22, 33, 111.0, new Cliente("Paulo"));
		Conta c4 = new Conta(22, 11, 222.0, new Cliente("Ana"));
		Conta c5 = new Conta(22, 88, 666.0, new Cliente("Maria"));
		Conta c6 = new Conta(22, 99, 777.0, new Cliente("Bruno"));

		// Adicionando as contas na lista de Contas
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		lista.add(c4);
		lista.add(c5);
		lista.add(c6);

		// ORDENANDO AS LISTAS

		// -------------------------------------------------------------------------------------

		// Método 1: Utilizando o método sort() da lista, e criando uma classe que
		// implementa a interface Comparator

		// Apenas por pragmatismo irei criar a classe aqui mesmo. Mas repare que esta
		// classe serve apenas para encapsular um único método! Não é uma motivação
		// muito
		// forte para criar uma classe nova...
		class NomeDoClienteComparator implements Comparator<Conta> {

			@Override
			public int compare(Conta conta1, Conta conta2) {
				// Organizando pelo nome do Cliente
				// Se na ordem alfabética a primeira conta estiver antes da segunda, retorna -1.
				// Se forem iguais, retorna zero. Se estiver depois, retorna +1;
				return conta1.getCliente().getNome().compareTo(conta2.getCliente().getNome());
			}

		}

		// Esse método precisa de um Comparator como argumento, que irá determinar as
		// regras da comparação
		System.out.println("ORGANIZADO POR NOME DO CLIENTE- Usando o sort() e o Comparator (exemplo sem forEach)");
		lista.sort(new NomeDoClienteComparator());

		
		System.out.println(lista);

		// Para desorganizar a lista de novo
		Collections.shuffle(lista);

		// -------------------------------------------------------------------------------------

		// Método 2: Utilizando a classe Collections e a Ordem Natural, utilizando
		// a interface Comparable

		// Dá para utilizar também usando um Comparator como argumento
		Collections.sort(lista, new NomeDoClienteComparator());

		Collections.shuffle(lista);

		// Ou então passar só a lista e implementar, na classe Conta, a interface
		// Comparable, tornando assim possível que a classe defina sua própria ordem!
		System.out.println("\nORGANIZADO POR NÚMERO DA CONTA - Usando Collections.sort() e o Comparator (usando forEach!)");
		Collections.sort(lista);

		// Esse métodoo forEach já funciona com uma expressão Lambda
		lista.forEach((conta) -> System.out.println(conta));

		Collections.shuffle(lista);

		// -------------------------------------------------------------------------------------

		// Método 3: Jeito mais enxuto de definir o Comparator em Collections.sort() e lista.sort();
		
		// comparing(), método estático de Comparator, que já recebe o critério de ordenação, no caso
		// abaixo é usando o retorno do método getSaldo
		lista.sort(Comparator.comparing(Conta::getSaldo)); //= Collections.sort(lista, Comparator.comparing(Conta::getSaldo));
		System.out.println("\nORGANIZADO POR SALDO DA CONTA - Usando o sort() mais compacto");
		lista.forEach((conta) -> System.out.println(conta));
				
		Collections.shuffle(lista);
		// -------------------------------------------------------------------------------------

		// Método 4: Utilizando classes anônimas

		// São classes sem nomes, que implementam uma interface ou estendem uma classe.
		// É possível escrever o código dessas classes no meio do programa,
		// no momento em que for instancia-la

		System.out.println("\nORGANIZADO POR NOME DO CLIENTE- Usando o sort() e o Classes Anônimas");
		lista.sort(new Comparator<Conta>() {
			@Override
			public int compare(Conta conta1, Conta conta2) {
				return conta1.getCliente().getNome().compareTo(conta2.getCliente().getNome());
			}
		});

		lista.forEach((conta) -> System.out.println(conta));

		// Porém essas classes anônimas são de difícil leitura, pois o código da classe
		// fica misturado com o código do programa! O código pode acabar ficando
		// confuso e bagunçado...

		Collections.shuffle(lista);

		// -------------------------------------------------------------------------------------

		// Método 5: Utilizando os lambdas!

		// É parecido com uma classe anônima, porém apagando tudo o que não for
		// essencial para a classe, e usando a setinha "->".
		// Assim: (parametros) -> corpo do método, ação a ser feita, retorno.

		lista.sort((Conta conta1, Conta conta2) -> {
			return Double.compare(conta1.getSaldo(), conta2.getSaldo());
		});

		Collections.shuffle(lista);

		// Se a implementação tiver mais de uma linha, é necessário utilizar
		// as chaves e a palavra "return", como feito acima. Porém, se tiver
		// apenas uma linha é possível abreviar mais, como escrito abaixo.

		System.out.println("\nORGANIZADO POR SALDO DA CONTA - Usando o sort() e Lambda!");
		lista.sort((Conta conta1, Conta conta2) -> Double.compare(conta1.getSaldo(), conta2.getSaldo()));

		lista.forEach((conta) -> System.out.println(conta));

	}

}
