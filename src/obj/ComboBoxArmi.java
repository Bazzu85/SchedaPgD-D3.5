package obj;

public class ComboBoxArmi {
	int prg = 0;
	String nome = "";
	
	public ComboBoxArmi(int prg , String nome) {
        this.prg = prg;
        this.nome = nome;
    }
	public int getPrg() {
		return prg;
	}
	public void setPrg(int prg) {
		this.prg = prg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
