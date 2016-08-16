package chamarMetodos;

public class User {

	private String nome;
	private String email;
	private String senha;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	private boolean validaEmail(){
		System.out.println("passou pelo metodo validaEmail");
		return email.contains("@");
	}
	
	public boolean validaSenha(){
		System.out.println("passou pelo metodo validaSenha");
		return senha.length() > 4;
	}
	
	
}
