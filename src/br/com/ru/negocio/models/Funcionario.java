package br.com.ru.negocio.models;

public class Funcionario extends Usuario{

		private String id;
		
		public Funcionario(String primeiroNome, String ultimoNome, String cpf, String login, String senha) {
			super(primeiroNome, ultimoNome, cpf, login, senha);
			
		}
		

		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		@Override
		public String toString() {
			return "Funcionario [id=" + id + "]";
		}
		
		
}
