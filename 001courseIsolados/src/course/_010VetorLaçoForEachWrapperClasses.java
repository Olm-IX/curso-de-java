package course;

public class _010VetorLaçoForEachWrapperClasses {

	public static void main(String[] args) {

		String[] vect = new String[] { "Maria", "Bob", "Alex" }; // SINTAXE PARA CRIAR O VETOR JÁ COM OS ELEMENTOS
		
		
		// JEITO DE FAZER UTILIZANDO O FOR 
		for (int i = 0; i < vect.length; i++) { 
			System.out.println(vect[i]);
		}
		
		// JEITO DE FAZER UTILIZANDO O LAÇO FOR EACH
		for (String obj : vect) {
			System.out.println(obj);
		}
		// LEITURA: PARA CADA OBJETO 'OBJ' (APELIDO) CONTIDO EM 'VECT', FAÇA

	}

}
