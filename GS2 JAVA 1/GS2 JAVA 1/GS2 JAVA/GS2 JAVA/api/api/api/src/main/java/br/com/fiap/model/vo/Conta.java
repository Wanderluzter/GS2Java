package br.com.fiap.model.vo;

public class Conta {
	
	private int id_conta;
	private float valor_conta;
	private float consumo_conta;
	private float custo_conta;
	private String mes_conta;
	private String usuario_conta;
	
	public Conta() {
		// TODO Auto-generated constructor stub
	}
	
	public Conta(int id, float valor, float consumo, float custoKwh, String mes, String usuario) {
		this.id_conta = id;
		this.valor_conta = valor;
		this.consumo_conta = consumo;
		this.custo_conta = custoKwh;
		this.mes_conta = mes;
		this.usuario_conta = usuario;
	}

	public int getId() {
		return id_conta;
	}
	public void setId(int id) {
		this.id_conta = id;
	}
	public float getValor() {
		return valor_conta;
	}
	public void setValor(float valor) {
		this.valor_conta = valor;
	}
	public float getConsumo() {
		return consumo_conta;
	}
	public void setConsumo(float consumo) {
		this.consumo_conta = consumo;
	}
	public float getCustoKwh() {
		return custo_conta;
	}
	public void setCustoKwh(float custoKwh) {
		this.custo_conta = custoKwh;
	}
	public String getMes() {
		return mes_conta;
	}
	public void setMes(String mes) {
		this.mes_conta = mes;
	}
	public String getUsuario() {
		return usuario_conta;
	}
	public void setUsuario(String usuario) {
		this.usuario_conta = usuario;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id_conta + ", valor=" + valor_conta + ", consumo=" + consumo_conta + ", custoKwh=" + custo_conta + ", mes="
				+ mes_conta + ", usuario=" + usuario_conta + "]";
	}
	
}
