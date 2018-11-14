import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Perguntas {
	
	//ArryLists que armazenam as perguntas e as respostas, auxiliando na montagem do gabarito
	private ArrayList<String> questao = new ArrayList<String>();
	private ArrayList<String> respEscolhida = new ArrayList<String>();
	private ArrayList<String> respCorreta = new ArrayList<String>();
	
	//exibe o gabarito
	public void gabarito() {
		int i = 0;
		
		for(String s : questao) {
			System.out.printf("\nQuestao %d)\n",i+1);
			System.out.println("Pergunta: " + questao.get(i));
			System.out.println("Resposta Escolhida: " + respEscolhida.get(i));
			System.out.println("Resposta Correta: " + respCorreta.get(i));
			System.out.println("\n");
			i++;
		}
	}
	
	public static String[] coletaPergunta(String[] vetor,int cont, Perguntas gabarito) throws SQLException {
		String [] alternativa = new String [5];
		
		Connection con = Database.conexao();

		//Busca as alternativas no banco
		String sql = "select * from pergunta where id = "+cont;
		PreparedStatement stmt = con.prepareStatement(sql);
		boolean resultado = stmt.execute();
		
		ResultSet rs = stmt.getResultSet();
		
		//inicializa as variaveis para receberem a String com as alternativas
		//String a = null, b = null, c = null, d = null, e = null;
		
		//armazena e exibe as alternativas do banco
		while(rs.next()) {
			//Coleta a pergunta e as alternativas
			String pergunta = rs.getString("pergunta");
			System.out.println("\nPergunta: "+pergunta);
			
			gabarito.questao.add(pergunta); 
			
			for(int i=0;i<5;i++) {
				 alternativa[i] = rs.getString(vetor[i]);
			}
			
			//Exibe a pergunta e as alternativas 
			System.out.println();
			System.out.println("A)"+ alternativa[0]);
			System.out.println("B)"+ alternativa[1]);
			System.out.println("C)"+ alternativa[2]);
			System.out.println("D)"+ alternativa[3]);
			System.out.println("E)"+ alternativa[4]);
		}
		
		con.close();
		stmt.close();
		rs.close();
		
		return alternativa;
	}
	
	public static int validaRespostas(String [] alternativa,int i, Perguntas gabarito) throws SQLException {
		
		int pontos =0;
	
		//coletaPerguntas(vetor);
		Connection con = Database.conexao();
		//comando para buscar a respota no banco
		String sql = "select resposta from pergunta where id ="+i;
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.execute();
		ResultSet rs = stmt.getResultSet();
		
		//inicializa a variavel para receber a String cm a resposta
		String resposta = null;
		
		//armazena na variavel a String com a resposta
		while(rs.next()) {
			resposta = rs.getString("resposta");
			gabarito.respCorreta.add(resposta);
			//System.out.println("INSERIDO NO GABARITO!" + resposta);
		}
		
		
		//pega o palpite do usuario
		Scanner sc = new Scanner(System.in);
		System.out.print("\nDigite sua resposta: ");
		String palpite = sc.next();
		palpite = palpite.toUpperCase();
		
		while(true){
			if(!palpite.equals("A") && !palpite.equals("B") && !palpite.equals("C") && !palpite.equals("D") && !palpite.equals("E")){
				System.out.println("ATENÇÃO! O PROGRAMA SÓ ACEITA OS VALORES EQUIVALENTE AS RESPOSTAS(A,B,C,D,E)");
				System.out.print("\nDigite novamente sua resposta: ");
				palpite = sc.next();
				palpite = palpite.toUpperCase();
			}else {
				break;
			}
		}
		
		//verifica a resposta ja passando ela para maiuscula
		boolean cmp;
		switch(palpite.toUpperCase()) {
			case "A":
				cmp =  alternativa[0].equalsIgnoreCase(resposta);
				gabarito.respEscolhida.add(alternativa[0]);
				if(cmp == true) {
					pontos = 1;
				}
				break;
			case "B":
				cmp =  alternativa[1].equalsIgnoreCase(resposta);
				gabarito.respEscolhida.add(alternativa[1]);
				if(cmp == true) {
					pontos = 1;
				}
				break;
			case "C":
				cmp =  alternativa[2].equalsIgnoreCase(resposta);
				gabarito.respEscolhida.add(alternativa[2]);
				if(cmp == true) {
					pontos = 1;
				}
				break;
			case "D":
				cmp =  alternativa[3].equalsIgnoreCase(resposta);
				gabarito.respEscolhida.add(alternativa[3]);
				if(cmp == true) {
					pontos = 1;
				}
				break;
			case "E":
				cmp =  alternativa[4].equalsIgnoreCase(resposta);
				gabarito.respEscolhida.add(alternativa[4]);
				if(cmp == true) {
					pontos = 1;
				}
				break;
			default:
				System.out.println();
			break;
		}
		
		stmt.close();
		rs.close();
		con.close();	
		
		return pontos;
	}
	
}
 
