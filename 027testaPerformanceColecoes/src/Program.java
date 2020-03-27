import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Program {

	public static void main(String[] args) {

//		Performance para criação da coleção de 100 mil elementos
//		output: 
//		ArrayList: 5
//		LinkedList: 4
//		HashSet: 10
		System.out.println("Cria e adiciona elementos em coleção de 100 mil elementos:");
		long start1 = System.currentTimeMillis();
		List<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 1; i <= 100000; i++) {
			arrayList.add(i);
		}
		long finish1 = System.currentTimeMillis();
		System.out.println("ArrayList: " + (finish1 - start1));

		long start2 = System.currentTimeMillis();
		List<Integer> linkedList = new ArrayList<Integer>();
		for (int i = 1; i <= 100000; i++) {
			linkedList.add(i);
		}
		long finish2 = System.currentTimeMillis();
		System.out.println("LinkedList: " + (finish2 - start2));

		long start3 = System.currentTimeMillis();
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 1; i <= 100000; i++) {
			set.add(i);
		}
		long finish3 = System.currentTimeMillis();
		System.out.println("HashSet: " + (finish3 - start3));

		
		
//		Performance para buscar o valor 99 mil
//		output
//		ArrayList: 3
//		LinkedList: 2
//		HashSet: 0
		System.out.println(System.lineSeparator() + "Performance para buscar o elemento 99.000 // .contais(99000):");
		start1 = System.currentTimeMillis();
		arrayList.contains(99000);
		finish1 = System.currentTimeMillis();
		System.out.println("ArrayList: " + (finish1 - start1));

		start2 = System.currentTimeMillis();
		linkedList.contains(99000);
		finish2 = System.currentTimeMillis();
		System.out.println("LinkedList: " + (finish2 - start2));

		start3 = System.currentTimeMillis();
		set.contains(99000);
		finish3 = System.currentTimeMillis();
		System.out.println("HashSet: " + (finish3 - start3));

		
		
//		Performance para buscar todos os valores da coleção!
//		output
//		ArrayList: 2993
//		LinkedList: 3006
//		HashSet: 11 //UAU!!
		System.out.println(System.lineSeparator() + "Performance para buscar todos os valores da coleção!");
		start1 = System.currentTimeMillis();
		for (Integer numero : arrayList) {
			arrayList.contains(numero);
		}
		finish1 = System.currentTimeMillis();
		System.out.println("ArrayList: " + (finish1 - start1));
		
		start2 = System.currentTimeMillis();
		for (Integer numero : linkedList) {
			linkedList.contains(numero);
		}
		finish2 = System.currentTimeMillis();
		System.out.println("LinkedList: " + (finish2 - start2));
		
		start3 = System.currentTimeMillis();
		for (Integer numero : set) {
			set.contains(numero);
		}
		finish3 = System.currentTimeMillis();
		System.out.println("HashSet: " + (finish3 - start3));
		
		
		
//		Performance para remover da coleção os valores de 1 até 1000
//		ArrayList: 17
//		LinkedList: 9
//		HashSet: 9
		System.out.println(System.lineSeparator() + "Performance para remover da coleção os valores de 1 até 1000:");
		start1 = System.currentTimeMillis();
		for (int i = 1; i<= 1000; i++) {
			arrayList.remove(i);
		}
		finish1 = System.currentTimeMillis();
		System.out.println("ArrayList: " + (finish1 - start1));
	
		start2 = System.currentTimeMillis();
		for (int i = 1; i<= 1000; i++) {
			linkedList.remove(i);
		}		
		finish2 = System.currentTimeMillis();
		System.out.println("LinkedList: " + (finish2 - start2));

		start3 = System.currentTimeMillis();
		for (int i = 1; i<= 1000; i++) {
			arrayList.remove(i);
		}
		finish3 = System.currentTimeMillis();
		System.out.println("HashSet: " + (finish3 - start3));
		
		

	}

}
