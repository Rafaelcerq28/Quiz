import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Jogo extends GeradorJogo{
	
	
	public static void menu() throws SQLException {
		Jogo j = new Jogo();
		Perguntas gabarito = new Perguntas();
		Perguntas pergunta = new Perguntas();
		String continuar = "s";
		int pontos =0;
		
		while(!continuar.equalsIgnoreCase("n")) {
			//Cria um jogador
			Jogador j1 = new Jogador();
			
			//Cria uma conexao com o banco apenas para testar
			//Caso de errado o programa é encerrado
			Connection con = Database.conexao();
			
			if(con == null) {
				break;
			}else {
				con.close();
			}
			
			//Inicio do jogo
			Scanner sc = new Scanner(System.in);
			
			//Apresenta o menu e aguarda a opção
			j.subMenu();
			System.out.print("Escolha uma das opções acima: ");
			String opcao = sc.next();
			
			switch(opcao) {
				
				//OPÇÂO 1 - O Jogo
				case "1":
					
					Database banco = new Database();
					
					System.out.println("\nOPÇÃO 1 SELECIONADA! ");
					Scanner entraUsr = new Scanner(System.in);
					
					//Pega o nome do usuário
					System.out.print("Digite seu nome: ");
					j1.setNome(entraUsr.nextLine());
					
					//Insere um cabeçalho antes das perguntas
					j.cabecalhoJogo();
					
					//Laço onde é apresentado as perguntas e calcula a resposta
					for(int i=1; i<=10;i++) {
						//Pega as letras convertidas
						String [] letras = conversaoLetras();					
						//Pega as perguntas no banco
						String [] perguntas = pergunta.coletaPergunta(letras,i,gabarito);
						//Metodo que recebe as perguntas, coleta e valida as respostas no banco de dados
						//Retorna um inteiro passando a pontuação para a variavel pontos
						pontos += pergunta.validaRespostas(perguntas,i,gabarito);
						
					}
					
					//Insere uma informação no rodapé ao terminar as perguntas
					j.rodape();
					
					//Uma pausa dramatica para "calcular os pontos"
					j.pausaDramatica();
					
					//Ao terminar o laço o jogador recebe a soma dos pontos 
					
					j1.setPontuacao(pontos);
					j1.pontosJogador();	
					
					banco.insereJogador(j1.getNome(), j1.getPontuacao());
					
					System.out.println("Gostaria de ver o gabarito? S/N");
					String exibir = sc.next();
					
					if(exibir.equalsIgnoreCase("s")) {
						//Exibe um gabarito do quiz
						gabarito.gabarito();
					}					
					
					//Insere a pontuação e o nome do jogador no banco de dados
										
					break;
					
				case "2":
					System.out.println("\n\t     RANK");
					Database.coletaPontuacao();
					
					break;
				
				default:
					System.out.println("Opção Invalida.");
			}
			
			System.out.print("\nContinuar(S/N)? ");
			continuar = sc.next();
			
			while(!continuar.equalsIgnoreCase("s") && !continuar.equalsIgnoreCase("n")) {
				System.out.println("Opcao invalida.\n");
				System.out.print("\nContinuar(S/N)? ");
				continuar = sc.next();
			}
		}
		System.out.println("\nAté mais!");
	}
	
}
