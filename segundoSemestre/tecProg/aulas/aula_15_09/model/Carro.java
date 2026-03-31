package aulas.aula_15_09.model;

public class Carro {
    private String marca;
	private String modelo;
	private int ano;
	private double tanque;
	
	public Carro(String marca, String modelo, int ano) /*throws Exception*/{
		
		if(ano < 2015) {
			System.out.println("Não pode criar");
			//throw new Exception();
		}
		else {
			this.ano = ano;
		}
		
		this.marca = marca;
		this.modelo = modelo;
		
	}
 
	public String getMarca() {
		return this.marca;
	//	Ou return marca;
	}
	
	public void setMarca(String novaMarca) {
		this.marca = novaMarca;
	}
	
	public String getModelo() {
		return this.modelo;
	//	Ou return modelo;
	}
	
	public void setModelo(String novoModelo) {
		this.modelo = novoModelo;
	}
	
 
	public int getAno() {
		return this.ano;
	//	Ou return ano;
	}
	
	public void setAno(int novoAno) {
		if(ano < 2015) {
			System.out.println("O ano não pode ser alterado");
		}else {
			this.ano = novoAno;
		}
	}
	
	public double getTanque() {
		return this.tanque;
	//	Ou return tanque;
	}
	
	public void setTanque(double novoTanque) {
		this.tanque = novoTanque;
	}
	
	public void ligar() {
		System.out.println("Carro ligado.");
	}
 
	public void acelerar() {
		System.out.println("Acelerando...");
	}

}
