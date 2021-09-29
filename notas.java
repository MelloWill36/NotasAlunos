package notas;

import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class notas {

	static int sizeArray = 30;

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

		double prova1[] = { 0 }, prova2[] = { 0 }, prova3[] = { 0 }, prova4[] = { 0 }, media[] = { 0 };
		prova1 = new double[sizeArray];
		prova2 = new double[sizeArray];
		prova3 = new double[sizeArray];
		prova4 = new double[sizeArray];
		media = new double[sizeArray];
		String nomesAlunos[] = { " " };
		nomesAlunos = new String[sizeArray];
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("------------ SISTEMA DE CADASTRO DE NOTAS - ESCOLA --------------");
			System.out.println("-----------------------------------------------------------------");
			for (int i = 0; i < sizeArray; i++) {
				System.out.print("---- ENTRE COM NOME DO ALUNO: ");
				nomesAlunos[i] = input.nextLine();
				System.out.print("---- ENTRE COM A NOTA DA 1º PROVA: ");
				prova1[i] = Double.parseDouble(input.nextLine());
				System.out.print("---- ENTRE COM A NOTA DA 2º PROVA: ");
				prova2[i] = Double.parseDouble(input.nextLine());
				System.out.print("---- ENTRE COM A NOTA DA 3º PROVA: ");
				prova3[i] = Double.parseDouble(input.nextLine());
				System.out.print("---- ENTRE COM A NOTA DA 4º PROVA: ");
				prova4[i] = Double.parseDouble(input.nextLine());
				media[i] = (prova1[i] + prova2[i] + prova3[i] + prova4[i]) / 4;
				System.out.print("---- A MEDIA DE: " + media[i] + "\r\n");
				System.out.println("-----------------------------------------------------------------");
				System.out.println("-- DESEJA CONTIUAR?  1-SIM  | 2-NÃO ");
				int option = Integer.parseInt(input.nextLine());
				if (option == 2) {
					break;
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImprimeDados(prova1, prova2, prova3, prova4, media, nomesAlunos);
		SalvaArquivo(prova1, prova2, prova3, prova4, media, nomesAlunos);
		SalvaHash(prova1, prova2, prova3, prova4, media, nomesAlunos);
	}

	static void ImprimeDados(double[] prova1, double[] prova2, double[] prova3, double[] prova4, double[] media,
			String[] nomesAlunos) {
		System.out.println(
				"----------------------------------------------------------------------------------------------------- ");
		System.out.println(
				"------------------------------- SISTEMA DE NOTAS - ESCOLA - IMPRESSÃO ------------------------------- ");
		System.out.println(
				"----------------------------------------------------------------------------------------------------- ");

		System.out.println("--\n\rNOME\t\t\tPROVA 1\t\tPROVA 2\t\tPROVA 3\t\tPROVA 4\t\tMEDIA ");
		for (int i = 0; i < sizeArray; i++) {
			if (nomesAlunos != null);
			System.out.println("" + nomesAlunos[i] + "\t\t\t" + prova1[i] + "\t\t" + prova2[i] + "\t\t" + prova3[i]
					+ "\t\t" + prova4[i] + "\t\t" + media[i]);
		}
		System.out.println(
				"------------------------------------------------------------------------------------------------------ ");
	}

	static void SalvaArquivo(double[] prova1, double[] prova2, double[] prova3, double[] prova4, double[] media,
			String[] nomesAlunos) throws IOException {

		FileWriter saveFile = new FileWriter("C:\\Users\\William\\Documents\\notas.txt");

		saveFile.write(nomesAlunos[0] + " - " + prova1[0] + " - " + prova2[0] + " - " + prova3[0] + " - " + prova4[0]
				+ " - " + media[0] + "\n\r");

		for (int i = 1; i < sizeArray; i++) {
			if (nomesAlunos != null);
			saveFile.append(nomesAlunos[i] + " - " + prova1[i] + " - " + prova2[i] + " - " + prova3[i] + " - "
					+ prova4[i] + " - " + media[i] + "\n\r");

		}

		saveFile.close();

	}

	static void SalvaHash(double[] prova1, double[] prova2, double[] prova3, double[] prova4, double[] media,
			String[] nomesAlunos) throws IOException, NoSuchAlgorithmException {

		String textoHash = nomesAlunos.hashCode() + "\n\r" + prova1.hashCode() + "\n\r" + prova2.hashCode() + "\n\r"
				+ prova3.hashCode() + "\n\r" + prova4.hashCode() + "\n\r" + media.hashCode() + "\n\r";

		FileWriter saveHash = new FileWriter("C:\\Users\\William\\Documents\\hashNotas.txt");
		saveHash.write(textoHash);
		saveHash.close();
	}
}
