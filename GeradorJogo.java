import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GeradorJogo {

	public void subMenu() {
		System.out.println("\n#################################");
		System.out.println("#\t1 - Jogar\t\t#");
		System.out.println("#\t2 - Exibir rank\t\t#");
		System.out.println("#\t3 - Sair\t\t#");
		System.out.println("#################################");
	}
	
	public void pausaDramatica() {
		
		for(int i = 0; i < 5; i++){	
			try{
				//Tenta pausar em 1s (1000 milisegundos).
				Thread.sleep(1000);
			}catch (InterruptedException e){	
				//Erro na execução.
				System.out.println("ERRO");
			}
		}
		
	}
	
	public void cabecalhoJogo() {
		System.out.println("\n#################################");
		System.out.println("#\tQUE OS JOGOS COMECEM!\t#");
		System.out.println("#################################\n");
		System.out.print("----------------------------------------------------------");
		System.out.print("---------------------------");
	}

	public void rodape() {
		System.out.println("\n#################################");
		System.out.println("#\tJogo Finalizado!\t#");
		System.out.println("#################################");
	}

	
	
	//METODO OFICIAL A SER USADO NO PROJETO
	public static String[] conversaoLetras() {

		Random r = new Random();
		List<Integer> lista = new ArrayList<Integer>(); 
		
		for(int i=0;i<5;i++) {
			lista.add(0);
		}
		
		boolean flag = true;
		
		while(flag == true) {
			flag = false;
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					if(i==j) {
						
					}else if(lista.get(i) == lista.get(j)) {
						lista.set(j,r.nextInt(5));
						flag = true;
					}
				}
			}
		}

		char vetor [] = new char [5];
		String vetorS [] = new String[5];
		for(int i=0;i<5;i++) {
			vetor[i] = (char) (lista.get(i)+65);
		}
		
		for(int i=0;i<5;i++) {
			vetor[i] = (char) (lista.get(i)+65);
			vetorS[i] = ""+vetor[i];
		}
		return vetorS;
	}

}
