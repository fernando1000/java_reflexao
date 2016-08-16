package validarnulo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidarNulo {

	public static List<String> pegaAtributosNulos(Object objeto) throws IllegalArgumentException, IllegalAccessException{
		
		List<String> lista = new ArrayList<>();
		
		Class<?> classe = objeto.getClass();
	
		//para cada atributo da classe
		for(Field field : classe.getFields()){
		
			//extrai o valor do atributo
			Object objetoComValor = field.get(objeto);
			
			//se o valor do atributo for nulo
			if(objetoComValor == null){
				
				//adiciona na lista pegando o nome do atributo
				lista.add(field.getName());
			}
		}
		
		return lista;
	}
}
