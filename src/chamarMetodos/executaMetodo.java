package chamarMetodos;

public class executaMetodo {
	
	public static void main(String... abc) throws Exception{
		
		User u = new User();
		u.setEmail("email");
		u.setNome("nome");
		u.setSenha("11111");
		
		boolean valido = CriaMetodo.validarObjeto(u);
	
		if(valido){
			System.out.println("objeto valido");
		}else{
			System.out.println("objeto nao valido");
			
		}
	}
}
