package mapeador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Mapeador {

	private Map<Class<?>, Class<?>> mapa = new HashMap<>();
	
	public void carrega(String nomeDoArquivo) throws FileNotFoundException, IOException, ClassNotFoundException{
		
		Properties properties = new Properties();
		
		properties.load(new FileInputStream(nomeDoArquivo));
			
		for(Object objetoChave : properties.keySet()){
			
			Class<?> interfacee = Class.forName(objetoChave.toString());
			Class<?> implementacao = Class.forName(properties.get(objetoChave).toString());
			
			if(!interfacee.isAssignableFrom(implementacao)){
				
				throw new RuntimeException("A classe "+ implementacao.getName() + " nao implementa " + interfacee.getName());
			}			
			mapa.put(interfacee, implementacao);
 		}
	}
	
	public Class<?> pegaImplementacao(Class<?> _interfacee){
		return mapa.get(_interfacee);
	}
	
	public <E> E pegaInstancia(Class<E> _interface) throws Exception{
		Class<?> implementacao = mapa.get(_interface);
		return (E) implementacao.newInstance();
	}

	public <E> E pegaInstancia(Class<E> _interface, Object... parametros) throws Exception{
		
		Class<?> implementacao = mapa.get(_interface);
		
		Class<?>[] tiposDeConstrutor = new Class<?>[parametros.length];
		
		for(int i=0; i<tiposDeConstrutor.length; i++){
			tiposDeConstrutor[i] = parametros[i].getClass();
		}
		
		Constructor<?> construtor = implementacao.getConstructor(tiposDeConstrutor);
		
		//ja estou faendo um cast aqui, entao nao preciso faer cast quando eu chamar esse metodo
		return (E) construtor.newInstance(parametros);
	}

}
