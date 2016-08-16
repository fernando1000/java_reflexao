package geraxml;

import java.lang.reflect.Field;

public class GeradorXml {

	public static String pegaXml(Object objeto) throws Exception{

		StringBuilder sb = new StringBuilder();
		
		Class<?> classe = objeto.getClass();
		
		sb.append("<"+ classe.getSimpleName() + "> \n");
		
		for(Field field : classe.getDeclaredFields()){
			
			sb.append("<"+ field.getName() + ">");
			
			field.setAccessible(true);
			sb.append(field.get(objeto));
			sb.append("</"+ field.getName() + "> \n");		
		}
		
		sb.append("</"+ classe.getSimpleName()+ "> \n");
		
		return sb.toString();
	}
}
