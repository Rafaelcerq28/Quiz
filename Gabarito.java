import java.util.ArrayList;
import java.util.Scanner;

public class Gabarito {
	//ArryLists que armazenam as perguntas e as respostas, auxiliando na montagem do gabarito
	private ArrayList<String> questao = new ArrayList<String>();
	private ArrayList<String> respEscolhida = new ArrayList<String>();
	private ArrayList<String> respCorreta = new ArrayList<String>();
	
	public void setQuestao(String questao) {
		this.questao.add(questao);
	}

	public void setRespEscolhida(String respEscolhida) {
		this.respEscolhida.add(respEscolhida);
	}

	public void setRespCorreta(String respCorreta) {
		this.respCorreta.add(respCorreta);
	}

	//exibe o gabarito
	public void getGabarito() {
		int i = 0;
		String continuar;
		Scanner sc = new Scanner(System.in);
		
		for(String s : questao) {
			System.out.printf("\nQuestao %d)\n",i+1);
			System.out.println("Pergunta: " + questao.get(i));
			System.out.println("Resposta Escolhida: " + respEscolhida.get(i));
			System.out.println("Resposta Correta: " + respCorreta.get(i));
			System.out.println("\n");
			
			if(i <= 8) {
				System.out.println("Gostaria de ver a proxima nota? ");
				System.out.println("(S)Continua - (N)Encerra a exibição");
				
				continuar = sc.next();
				
				if(continuar.equalsIgnoreCase("n") || i > 8) {
					System.out.println("\nEncerrando exibição do gabarito.\n");
					break;
				}
			}
			i++;
		}
		System.out.println("\nO rank será exibido em breve.\n");
	}
}
