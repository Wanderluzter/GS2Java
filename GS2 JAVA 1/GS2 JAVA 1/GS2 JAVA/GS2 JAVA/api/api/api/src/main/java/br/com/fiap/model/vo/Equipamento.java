package br.com.fiap.model.vo;
 
public class Equipamento {
	
	
	private int id;
	private String nome;
	private String marca;
	private int ano;
	private double consumo;
	private String status;
	private String usuario;
	
	public Equipamento() {
	}
	
	public Equipamento(int id, String nome, String marca, int ano, double consumo, String status, String usuario) {
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.ano = ano;
		this.consumo = consumo;
		this.status = status;
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public double getConsumo() {
		return consumo;
	}
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Equipamento [id=" + id + ", nome=" + nome + ", marca=" + marca + ", ano=" + ano + ", consumo=" + consumo
				+ ", status=" + status + "]";
	}
	
}