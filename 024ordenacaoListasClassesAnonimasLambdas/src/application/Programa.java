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

		// M�todo 1: Utilizando o m�todo sort() da lista, e criando uma classe que
		// implementa a interface Comparator

		// Apenas por pragmatismo irei criar a classe aqui mesmo. Mas repare que esta
		// classe serve apenas para encapsular um �nico m�todo! N�o � uma motiva��o
		// muito
		// forte para criar uma classe nova...
		class NomeDoClienteComparator implements Comparator<Conta> {

			@Override
			public int compare(Conta conta1, Conta conta2) {
				// Organizando pelo nome do Cliente
				// Se na ordem alfab�tica a primeira conta estiver antes da segunda, retorna -1.
				// Se forem iguais, retorna zero. Se estiver depois, retorna +1;
				return conta1.getCliente().getNome().compareTo(conta2.getCliente().getNome());
			}

		}

		// Esse m�todo precisa de um Comparator como argumento, que ir� determinar as
		// regras da compara��o
		System.out.println("ORGANIZADO POR NOME DO CLIENTE- Usando o sort() e o Comparator (exemplo sem forEach)");
		lista.sort(new NomeDoClienteComparator());

		
		System.out.println(lista);

		// Para desorganizar a lista de novo
		Collections.shuffle(lista);

		// -------------------------------------------------------------------------------------

		// M�todo 2: Utilizando a classe Collections e a Ordem Natural, utilizando
		// a interface Comparable

		// D� para utilizar tamb�m usando um Comparator como argumento
		Collections.sort(lista, new NomeDoClienteComparator());

		Collections.shuffle(lista);

		// Ou ent�o passar s� a lista e implementar, na classe Conta, a interface
		// Comparable, tornando assim poss�vel que a classe defina sua pr�pria ordem!
		System.out.println("\nORGANIZADO POR N�MERO DA CONTA - Usando Collections.sort() e o Comparator (usando forEach!)");
		Collections.sort(lista);

		// Esse m�todoo forEach j� funciona com uma express�o Lambda
		lista.forEach((conta) -> System.out.println(conta));

		Collections.shuffle(lista);

		// -------------------------------------------------------------------------------------

		// M�todo 3: Jeito mais enxuto de definir o Comparator em Collections.sort() e lista.sort();
		
		// comparing(), m�todo est�tico de Comparator, que j� recebe o crit�rio de ordena��o, no caso
		// abaixo � usando o retorno do m�todo getSaldo
		lista.sort(Comparator.comparing(Conta::getSaldo)); //= Collections.sort(lista, Comparator.comparing(Conta::getSaldo));
		System.out.println("\nORGANIZADO POR SALDO DA CONTA - Usando o sort() mais compacto");
		lista.forEach((conta) -> System.out.println(conta));
				
		Collections.shuffle(lista);
		// -------------------------------------------------------------------------------------

		// M�todo 4: Utilizando classes an�nimas

		// S�o classes sem nomes, que implementam uma interface ou estendem uma classe.
		// � poss�vel escrever o c�digo dessas classes no meio do programa,
		// no momento em que for instancia-la

		System.out.println("\nORGANIZADO POR NOME DO CLIENTE- Usando o sort() e o Classes An�nimas");
		lista.sort(new Comparator<Conta>() {
			@Override
			public int compare(Conta conta1, Conta conta2) {
				return conta1.getCliente().getNome().compareTo(conta2.getCliente().getNome());
			}
		});

		lista.forEach((conta) -> System.out.println(conta));

		// Por�m essas classes an�nimas s�o de dif�cil leitura, pois o c�digo da classe
		// fica misturado com o c�digo do programa! O c�digo pode acabar ficando
		// confuso e bagun�ado...

		Collections.shuffle(lista);

		// -------------------------------------------------------------------------------------

		// M�todo 5: Utilizando os lambdas!

		// � parecido com uma classe an�nima, por�m apagando tudo o que n�o for
		// essencial para a classe, e usando a setinha "->".
		// Assim: (parametros) -> corpo do m�todo, a��o a ser feita, retorno.

		lista.sort((Conta conta1, Conta conta2) -> {
			return Double.compare(conta1.getSaldo(), conta2.getSaldo());
		});

		Collections.shuffle(lista);

		// Se a implementa��o tiver mais de uma linha, � necess�rio utilizar
		// as chaves e a palavra "return", como feito acima. Por�m, se tiver
		// apenas uma linha � poss�vel abreviar mais, como escrito abaixo.

		System.out.println("\nORGANIZADO POR SALDO DA CONTA - Usando o sort() e Lambda!");
		lista.sort((Conta conta1, Conta conta2) -> Double.compare(conta1.getSaldo(), conta2.getSaldo()));

		lista.forEach((conta) -> System.out.println(conta));

	}

}
