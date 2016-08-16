package geraxml;

public class GeradorXmlTeste {

	public static void main(String[] args) throws Exception {

		Usuario u = new Usuario();
		u.setNome("fernando");
		u.setEmail("email");
		u.setSenha(123);
		
		String xmlGerado = GeradorXml.pegaXml(u);

		System.out.println(xmlGerado);
	}

}
