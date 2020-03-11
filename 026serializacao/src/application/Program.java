package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Program {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		String nome = "Naila";

//		-- SERIALIZAÇÃO

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objeto.bin"));
//		Serialização -> transformar um objeto, no caso acima uma String, em um fluxo de bits e bytes,
//		que poderá então ser armazenada no HD. O objeto "oos" accima irá salvar a classe no
//		arquivo "objeto.bin".
//		A classe ObjectOutputStream pode jogar a exceção IOException.
//		A classe FileOutputStrem pode jogar a exceção FileNotFoundException

		oos.writeObject(nome); // Salvando a String no arquivo "objeto.bin"
		oos.close();

//		-- DESSERIALIZAÇÃO

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objeto.bin"));
//		Agora fazemos o caminho inverso, transformando o fluxo de bits e bytes em um objeto
		String novoNome = (String) ois.readObject();
//		É necessário fazer o cast pois o método retorna um Object. 
//		O método readObject pode jogar a exceção ClassNotFoundException, no caso de não encontrar
//		no programa a classe do objeto.
		ois.close();

		System.out.println(novoNome); // output: Naila

//		-- SERIALIZANDO OBJETOS CRIADOS PELO PROGRAMADOR
//		É necessário implementar a interface Serializable nas classes que serão serializadas
		
		ClasseFilha classe = new ClasseFilha("CLASSE FILHA!!!");
		ClasseCompostaDentroDaClasseFilha classeComposta = new ClasseCompostaDentroDaClasseFilha(10);
		classe.setClasseComposta(classeComposta);

		// Serialização
		ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("objeto2.bin")); // Cria o objeto2.bin
		oos2.writeObject(classe); // Escreve o fluxo de bits e bytes no arquivo
		oos2.close(); // Fecha o recurso

		// Desserialização
		ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("objeto2.bin"));
		ClasseFilha novaClasse = (ClasseFilha) ois2.readObject();
		ois2.close();

		System.out.println(novaClasse.getNome()); // output: CLASSE FILHA!!!
		System.out.println(novaClasse.getClasseComposta().getNumero()); // output: 10

	}
}