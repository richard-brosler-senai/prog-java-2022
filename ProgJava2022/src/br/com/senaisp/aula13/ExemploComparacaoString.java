package br.com.senaisp.aula13;

public class ExemploComparacaoString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Programa para testar Strings
		String str1 = "Richard";
		String str2 = "richard";
		/* 
		 * Comparação de igualdade de strings independetemente de
		 * maiúsculas ou minúsculas 
		 * 
		 * */
		if (str1.equalsIgnoreCase(str2)) {
			System.out.println("As 2 strings são iguais "+""
					+ "independentemente de maiúsculo e minúsculo");
		}
		/* Este teste diferencia maiúsculas de minúsculas */
		if (str1.equals(str2)) {
			System.out.println("As 2 strings são iguais "+""
					+ " testando maiúsculas e minúsculas");
		}
		/* Comparação de maior ou menor em strings */
		
		/* Comparando se a str1 é maior que a str2 - 
		 * Diferencia maiúsculas de minúsculas */
		if (str1.compareTo(str2)>0) {
			System.out.println("A str1 é maior que a str2");
		}
		/* Comparando se a str1 é maior que a str2 independemente 
		 * de maiúsculas e minúsculas */
		if (str1.compareToIgnoreCase(str2)>0) {
			System.out.println("A str1 é maior que a str2");
		}
		/* Comparando se a str1 é menor que a str2 - 
		 * Diferencia maiúsculas de minúsculas */
		if (str1.compareTo(str2)<0) {
			System.out.println("A str1 é menor que a str2");
		}
		/* Comparando se a str1 é menor que a str2 independemente 
		 * de maiúsculas e minúsculas */
		if (str1.compareToIgnoreCase(str2)<0) {
			System.out.println("A str1 é menor que a str2");
		}
		
	}

}
