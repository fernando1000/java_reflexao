package mapeador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MapeadorTeste {

	public static void main(String... args) throws FileNotFoundException, ClassNotFoundException, IOException{

		Mapeador mapeador = new Mapeador();
	
		mapeador.carrega("classes.prop");
		
		System.out.println(mapeador.pegaImplementacao(List.class));
		System.out.println(mapeador.pegaImplementacao(Map.class));
		
	}
}
