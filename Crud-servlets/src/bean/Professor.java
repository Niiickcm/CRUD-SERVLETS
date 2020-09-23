package bean;

public class Professor {
	// padr�o JavaBean ou POJO � Classe com getters/setters, mais m�todos construtores
	private String nomeProfessor;
	private int  pisProfessor;
	private int pasepProfessor;
	
	public Professor(String nomeProfessor, int pisProfessor, int pasepProfessor) {
		this.nomeProfessor = nomeProfessor;
		this.pisProfessor = pisProfessor;
		this.pasepProfessor = pasepProfessor;
		
	}
	public Professor() {
	}
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	public int getPisProfessor() {
		return pisProfessor;
	}
	public void setPisProfessor(int pisProfessor) {
		this.pisProfessor = pisProfessor;
	}
	public int getPasepProfessor() {
		return pasepProfessor;
	}
	public void setPasepProfessor(int pasepProfessor) {
		this.pasepProfessor = pasepProfessor;
	}
}
