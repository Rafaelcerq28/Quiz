import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Jogo extends GeradorJogo{
	
	public void intro() {
		System.out.println("Bem vindo ao Quiz de conhecimentos gerais!\n");
		System.out.println("Aqui vao algumas dicas básicas para a conclusão dos desafios:\n");
		System.out.println("#1 Mantenha a calma (Isso é muito importante).");
		System.out.println("#2 Para que suas informações sejam enviadas para jogo é necessário DIGITA-LAS e em seguida pressionar ENTER.");
		System.out.println("#3 O jogo possui 10 questões e são de multipla escolha, então escolha sabiamente.");
		System.out.println("#4 Boa sorte!\n");
		
		pausaDramatica();
		
	}
	
	public static void menu() throws SQLException {
		Jogo j = new Jogo();
		Gabarito gabarito = new Gabarito();
		Perguntas pergunta = new Perguntas();
		String continuar = "s";
		boolean encerrar = false;
		int pontos =0;
		
		boolean passagem = false;
		boolean rankVisualisado = false;
		
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
			
			if(passagem == false && rankVisualisado == false) {
				j.intro();
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
						System.out.print("\n----------------------------------------------------------");
						System.out.print("---------------------------");
					}
					
					//Insere uma informação no rodapé ao terminar as perguntas
					j.rodape();
			
					System.out.println("\nAguarde um momento... Estamos Calculando sua pontuação.\n");
					//Uma pausa dramatica para "calcular os pontos"
					j.pausaDramatica();
					
					System.out.println("Pronto, sua pontuação foi calculada!\n");
					//Ao terminar o laço o jogador recebe a soma dos pontos 
					
					j1.setPontuacao(pontos);
					j1.pontosJogador();	
					
					banco.insereJogador(j1.getNome(), j1.getPontuacao());
					
					System.out.println("Gostaria de ver o gabarito? S/N");
					String exibir = sc.next();
					
					if(exibir.equalsIgnoreCase("s")) {
						//Exibe um gabarito do quiz
						gabarito.getGabarito();
						j.pausaDramatica();
					}					
					
					//Insere a pontuação e o nome do jogador no banco de dados
										
					
					Database.coletaPontuacao();
					passagem = true;
					
					break;
					
				case "2":
					System.out.println("\n\t     RANK");
					Database.coletaPontuacao();
					rankVisualisado = true;
					
					break;
				case "3":
					if(passagem ==false) {
						System.out.println("\nVolte quando estiver preparado!");
					}
					
					encerrar = true;
					break;
				default:
					System.out.println("Opção Invalida.");
			}
			
			if(encerrar == true) {
				break;
			}
			
			System.out.print("\nGostaria de retornar ao menu principal?(S/N)? ");
			continuar = sc.next();
			
			while(!continuar.equalsIgnoreCase("s") && !continuar.equalsIgnoreCase("n")) {
				System.out.println("Opcao invalida.\n");
				System.out.print("\nretornar ao menu principal?(S/N)? ");
				continuar = sc.next();
			}
		}
		System.out.println("\nAté mais!");
	}
	
}
