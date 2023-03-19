package br.com.ru.negocio.models;

import java.util.Objects;

public class Usuario {
	
	private String primeiroNome;
	private String ultimoNome;
	private String cpf;
	private String login;
	private String senha;
	
	public Usuario(String primeiroNome, String ultimoNome, String cpf, String login, String senha) {
		
		this.primeiroNome= primeiroNome;
		this.ultimoNome= ultimoNome;
		this.cpf= cpf;
		this.login= login;
		this.senha= senha;
		
	}
	
public Usuario(String primeiroNome, String ultimoNome, String login, String senha) {
		
		this.primeiroNome= primeiroNome;
		this.ultimoNome= ultimoNome;
		this.login= login;
		this.senha= senha;
		
	}
	
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	
	public String getUltimoNome() {
		return ultimoNome;
	}
	
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	} 
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, login, primeiroNome, senha, ultimoNome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(login, other.login)
				&& Objects.equals(primeiroNome, other.primeiroNome) && Objects.equals(senha, other.senha)
				&& Objects.equals(ultimoNome, other.ultimoNome);
	}


	@Override
	public String toString() {
		return "Usuario [primeiroNome=" + primeiroNome + ", ultimoNome=" + ultimoNome + ", cpf=" + cpf + ", login="
				+ login + ", senha=" + senha + "]";
	}
	
	
	
	
}
