package validarnulo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;

public class ValidarNuloTeste {

	@Test
	public void testaSeTemFieldsNulos() throws IllegalArgumentException, IllegalAccessException{
	
		ValidarNuloUsuario usuario = new ValidarNuloUsuario();
				//usuario.nome = null;
				usuario.email = null;
				usuario.senha = 123;
				
		List<String> lista = ValidarNulo.pegaAtributosNulos(usuario);
	
		assertTrue(lista.contains("nome"));
		assertTrue(lista.contains("email"));
		assertEquals(lista.size(), 2);
		
		
	}
}
