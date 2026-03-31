package aulas.aula_03_10.model;

public class Aluno {
    private String nome;
	private String matricula;
	private double notaFinal;

    public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome) {
		System.out.println("Olá sou " + nome);
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public void setMatricula(String matricula) {
		System.out.println("Matricula Finalizada.");
	}
	
	public double getNotaFinal() {
		return this.notaFinal;
	}
	
	public void setNotaFinal(double notaFinal) {
		System.out.println("Minha nota final foi: " + notaFinal);
	}
}
