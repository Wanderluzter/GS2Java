package br.com.fiap.model.vo;
 
public class Equipamento {
	
	
	private int id_equip;
	private String nome_equip;
	private String marca_equip;
	private int ano_equip;
	private double consumo_equip;
	private String status_equip;
	private String usuario_equip;
	
	public Equipamento() {
	}
	
	public Equipamento(int id, String nome, String marca, int ano, double consumo, String status, String usuario) {
		this.id_equip = id;
		this.nome_equip = nome;
		this.marca_equip = marca;
		this.ano_equip = ano;
		this.consumo_equip = consumo;
		this.status_equip = status;
		this.usuario_equip = usuario;
	}
	public int getId() {
		return id_equip;
	}
	public void setId(int id) {
		this.id_equip = id;
	}
	public String getNome() {
		return nome_equip;
	}
	public void setNome(String nome) {
		this.nome_equip = nome;
	}
	public String getMarca() {
		return marca_equip;
	}
	public void setMarca(String marca) {
		this.marca_equip = marca;
	}
	public int getAno() {
		return ano_equip;
	}
	public void setAno(int ano) {
		this.ano_equip = ano;
	}
	public double getConsumo() {
		return consumo_equip;
	}
	public void setConsumo(double consumo) {
		this.consumo_equip = consumo;
	}
	public String getStatus() {
		return status_equip;
	}
	public void setStatus(String status) {
		this.status_equip = status;
	}
	public String getUsuario() {
		return usuario_equip;
	}
	public void setUsuario(String usuario) {
		this.usuario_equip = usuario;
	}
	
	@Override
	public String toString() {
		return "Equipamento [id=" + id_equip + ", nome=" + nome_equip + ", marca=" + marca_equip + ", ano=" + ano_equip + ", consumo=" + consumo_equip
				+ ", status=" + status_equip + "]";
	}
	
}