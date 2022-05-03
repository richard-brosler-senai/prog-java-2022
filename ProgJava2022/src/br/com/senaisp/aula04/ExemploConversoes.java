package br.com.senaisp.aula04;

public class ExemploConversoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Definindo uma variável double com um valor qualquer
		double dblTeste = 51.12;
		System.out.println("Double: " + dblTeste);
		//Convertendo para float
		float fltTeste = (float) dblTeste;
		System.out.println("Float: " + fltTeste);
		//Convertendo para long (inteiro)
		long lngTeste = (long) fltTeste;
		System.out.println("Long: " + lngTeste);
		//Convertendo para int (inteiro)
		int intTeste = (int) lngTeste;
		System.out.println("Int: " + intTeste);
		//Convertendo para short (inteiro)
		short shtTeste = (short) intTeste;
		System.out.println("Short: " + shtTeste);
		//Convertendo para byte (inteiro)
		byte bytTeste = (byte) shtTeste;
		System.out.println("Byte: " + bytTeste);
		//Convertendo texto para números
		System.out.println("Vamos iniciar Conversão de String para Números");
		String strValor = "52";
		//Convertendo para Double
		dblTeste = Double.parseDouble(strValor);
		System.out.println("Double: " + dblTeste);
		//Convertendo para Float
		fltTeste = Float.parseFloat(strValor);
		System.out.println("Float: " + fltTeste);
		//Convertendo para Long
		lngTeste = Long.parseLong(strValor);
		System.out.println("Long: " + lngTeste);
		//Convertendo para Int
		intTeste = Integer.parseInt(strValor);
		System.out.println("Int: " + intTeste);
		//Convertendo para Short
		shtTeste = Short.parseShort(strValor);
		System.out.println("Short: " + shtTeste);
		//Convertendo para Byte
		bytTeste = Byte.parseByte(strValor);
		System.out.println("Byte: " + bytTeste);
		//Convertendo para String
		System.out.println("Agora vamos de números para String/Caracter");
		intTeste = 65; //Tabela Ascii A = 65
		char chrTeste = (char) intTeste;
		System.out.println("Char :" + chrTeste);
		//Convertendo de Double para String
		dblTeste = 52.12;
		String strTeste = Double.toString(dblTeste);
		System.out.println("Double para String: " + strTeste);
		//Convertendo de Float para String
		fltTeste = 52.12f;
		strTeste = Float.toString(fltTeste);
		System.out.println("Float para String: " + fltTeste);
		//Convertendo de Long para String
		lngTeste = 523;
		strTeste = Long.toString(lngTeste);
		System.out.println("Long para String: " + strTeste);
		//Convertendo de Inteiro para String
		intTeste = 523;
		strTeste = Integer.toString(intTeste);
		System.out.println("Inteiro para String: " + strTeste);
		//Convertendo de Short para String
		shtTeste = 523;
		strTeste = Short.toString(shtTeste);
		System.out.println("Short para String: " + strTeste);
		//Convertendo de Byte para String
		bytTeste = 52;
		strTeste = Byte.toString(bytTeste);
		System.out.println("Byte para String: " + strTeste);
		//Convertendo Números para Outras bases
		System.out.println("Convertendo números para outras bases");
		intTeste = 255;
		//Convertendo para Binário (base 2)
		strTeste = Integer.toString(intTeste, 2);
		System.out.println("O número " + intTeste + " em binário é " + strTeste);
		//Convertendo para Hexadecimal (base 16)
		strTeste = Integer.toString(intTeste, 16);
		System.out.println("O número " + intTeste + " em hexadecimal é " + strTeste);
		//Convertendo para Octal (base 8)
		strTeste = Integer.toString(intTeste, 8);
		System.out.println("O número " + intTeste + " em octal é " + strTeste);
		//De outras bases para o Inteiro
		System.out.println("Convertendo de outras bases (2,8,16) para o inteiro");
		//Hexadecimal para decimal
		strTeste = "ff";
		intTeste = Integer.parseInt(strTeste, 16);
		System.out.println("hexadecimal "+ strTeste + " na base 10: " + intTeste);
		//Binário para decimal
		strTeste = "11111111";
		intTeste = Integer.parseInt(strTeste, 2);
		System.out.println("Binário "+ strTeste + " na base 10: " + intTeste);
		//Octal para decimal
		strTeste = "377";
		intTeste = Integer.parseInt(strTeste, 8);
		System.out.println("Octal "+ strTeste + " na base 10: " + intTeste);
	}
}
