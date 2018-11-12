import java.util.ArrayList;

public class Jogador {
	
	private String nome;
	private int pontuacao = 0;
	
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void pontosJogador() {
		System.out.printf("_\\| Nome: %s\t|\tPontuação: %d |/_\n",this.getNome(),this.getPontuacao());
	}
	
	
	
}
