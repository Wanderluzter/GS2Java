package br.com.fiap.model.vo;

public class Conta {
	
	private int id ;
	private float valor;
	private float consumo;
	private float custoKwh;
	private String mes;
	private String usuario;
	
	public Conta() {
		// TODO Auto-generated constructor stub
	}
	
	public Conta(int id, float valor, float consumo, float custoKwh, String mes, String usuario) {
		this.id = id;
		this.valor = valor;
		this.consumo = consumo;
		this.custoKwh = custoKwh;
		this.mes = mes;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public float getConsumo() {
		return consumo;
	}
	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}
	public float getCustoKwh() {
		return custoKwh;
	}
	public void setCustoKwh(float custoKwh) {
		this.custoKwh = custoKwh;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", valor=" + valor + ", consumo=" + consumo + ", custoKwh=" + custoKwh + ", mes="
				+ mes + ", usuario=" + usuario + "]";
	}
	
}
