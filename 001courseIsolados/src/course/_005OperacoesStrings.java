package course;

public class _005OperacoesStrings {

	public static void main(String[] args) {
		
		String original = "abcde FGHIJ ABC abc DEFG ";
		
		String s01 = original.toLowerCase(); // TRANSFORMA TUDO EM MINUSCULO
		String s02 = original.toUpperCase(); // TRANSFORMA TUDO EM MAIUSCULO
		String s03 = original.trim(); // ELIMINA OS ESPA�OS NOS CANTOS DA STRING!
		String s04 = original.substring(2); // RECORTAR A STRING COM O CARACTER DA POSI��O 2 EM DIANTE (a posi��o 2 inclusa, come�a do 0 a contagem)
		String s05 = original.substring(2, 9); // A PARTIR DE, AT� (abaixo do 9, o 9 n�o conta!)
		String s06 = original.replace('a', 'x'); // TROCAR TODOS OS "a" MINUSCULO POR "x"
		String s07 = original.replace("abc", "xy");
		int i = original.indexOf("bc"); // VAI DIZER A PRIMEIRA OCORRENCIA
		int j = original.lastIndexOf("bc"); // VAI DIZER A ULTIMA OCORRENCIA
		
		// OPERA��O SPLIT - separa o String em um vetor
		
		String s = "potato apple lemon";
		String[] vect = s.split(" "); // VAI SEPARAR POR ESPA�O (" ") E CRIAR UM VETOR COM O RESULTADO
		String word1 = vect[0]; // ATRIBUINDO O ELEMENTO A UMA VARIAVEL
		String word2 = vect[1];
		String word3 = vect[2];
		
		
		
		System.out.println("Original: -" + original + "-");
		System.out.println("toLowerCase: -" + s01 + "-");
		System.out.println("toUpperCase: -" + s02 + "-");
		System.out.println("trim: -" + s03 + "-");
		System.out.println("substring(2): -" + s04 + "-");
		System.out.println("substring(2, 9): -" + s05 + "-");
		System.out.println("replace('a', 'x'): -" + s06 + "-");
		System.out.println("replace('abc', 'xy'): -" + s07 + "-");
		System.out.println("Index of 'bc': " + i);
		System.out.println("Last index of 'bc': " + j);
		System.out.println("Split: Primeira palavra: " + word1 + " | Segunda palavra: " + word2 + " | Terceira palavra:" + word3);

	}

}
