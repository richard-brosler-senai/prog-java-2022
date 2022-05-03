package br.com.senaisp.aula09;

public class Aula09Exe01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		for(int intLinha=1;intLinha<10;intLinha++) {
			for (int intColuna=1;intColuna<10;intColuna++) {
				System.out.print(intLinha+"-"+intColuna+" ");
			}
			System.out.println();
		}
		*/
		//Usando o while
		int intLinha=1; 
		int intColuna;
		while(intLinha<10) {
			intColuna=1;
			while(intColuna<10) {
				System.out.print(intLinha+"-"+intColuna+" ");
				intColuna++;
			}
			System.out.println();
			intLinha++;
		}
		
	}
	
}
