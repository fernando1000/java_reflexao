package chamarMetodos;

import java.lang.reflect.Method;

public class CriaMetodo {

	public static boolean validarObjeto(Object objeto) throws Exception{
		
		boolean resultado = true;
		
		Class<?> classe = objeto.getClass();
		
		for(Method metodo : classe.getMethods()){
			
			if(metodo.getName().startsWith("valida") && metodo.getReturnType() == boolean.class && metodo.getParameterTypes().length == 0){
				
				Boolean retorno = (Boolean) metodo.invoke(objeto);
				
				resultado = resultado && retorno.booleanValue();
			}
		}
		
		return resultado;
	}
}
