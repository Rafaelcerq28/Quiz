import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class Database {
	
	public static Connection conexao() throws SQLException {
		try{
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/quiz","root","");
		
			return c;
		}catch(SQLException ex) {
			
			System.out.println("Falha ao conectar-se com o banco de dados. Verifique sua conexao.");
			return null;
			
		}

	}
	
	public static void insereJogador(String nome, int pontuacao) throws SQLException {
		Connection c = Database.conexao();
		
		String sql = "insert into jogador (nome,pontuacao) values (?,?)";
		
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.setInt(2, pontuacao);
		
		boolean resultado = stmt.execute();
		
		stmt.close();
		c.close();
		System.out.println("\nPontuação gravada!");
		
	}
	
	public static void coletaPontuacao() throws SQLException {
		Connection con = Database.conexao();
		
		Jogador dadosJogador = new Jogador();
		ArrayList<Jogador> infoJogador = new ArrayList<Jogador>();
		
		//Busca as alternativas no banco
		String sql = "select * from jogador order by pontuacao desc";
		PreparedStatement stmt = con.prepareStatement(sql);
		boolean resultado = stmt.execute();
		
		ResultSet rs = stmt.getResultSet();
		int n = 0;
		//armazena e exibe as alternativas do banco
	
		System.out.println("---------------------------------");
		System.out.println("\tNome + Pontuação\t|");
		System.out.println("---------------------------------\n");
	
		while(rs.next()) {
			
			
			//Coleta a pergunta e as alternativas
			//String jogador = rs.getString("nome");
			
			//int pontuacao = rs.getInt("pontuacao");		 
			dadosJogador.setNome(rs.getString("nome"));
			dadosJogador.setPontuacao(rs.getInt("pontuacao"));
			infoJogador.add(dadosJogador);
			System.out.println(dadosJogador.getNome()+ " - " + dadosJogador.getPontuacao());
			//System.out.println(infoJogador.get(n).getNome()+ "\t\t" + infoJogador.get(n).getPontuacao());
			n++;
		}
		
		con.close();
		stmt.close();
		rs.close();
	}
	
	
	
}
