package course;

public class _010VetorLa�oForEachWrapperClasses {

	public static void main(String[] args) {

		String[] vect = new String[] { "Maria", "Bob", "Alex" }; // SINTAXE PARA CRIAR O VETOR J� COM OS ELEMENTOS
		
		
		// JEITO DE FAZER UTILIZANDO O FOR 
		for (int i = 0; i < vect.length; i++) { 
			System.out.println(vect[i]);
		}
		
		// JEITO DE FAZER UTILIZANDO O LA�O FOR EACH
		for (String obj : vect) {
			System.out.println(obj);
		}
		// LEITURA: PARA CADA OBJETO 'OBJ' (APELIDO) CONTIDO EM 'VECT', FA�A

	}

}
