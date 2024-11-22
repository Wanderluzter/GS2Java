package br.com.fiap.model.vo;
 
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Usuario {
 
    private String emailUs;
    private String nome;
    private String telefone;
    private String cepUs;
    private String senha;
    
public Usuario() {
		
	}
	public Usuario(String emailUs, String nome, String telefone, String cepUs, String senha) {
		this.emailUs = emailUs;
		this.nome = nome;
		this.telefone = telefone;
		this.cepUs = cepUs;
		this.senha = senha;
	}
	
	public String getEmailUs() {
		return emailUs;
	}
	public void setEmailUs(String emailUs) {
		this.emailUs = emailUs;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCepUs() {
		return cepUs;
	}
	public void setCepUs(String cepUs) {
		this.cepUs = cepUs;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Usuario [emailUs=" + emailUs + ", nome=" + nome + ", telefone=" + telefone + ", cepUs=" + cepUs
				+ ", senha=" + senha + "]";
	}
    
 
   
}