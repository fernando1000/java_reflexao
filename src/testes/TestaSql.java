package testes;

import geraxml.Usuario;

public class TestaSql {

	public static void main(String[] args) throws Exception {

		RetornoRessalvas rr = new RetornoRessalvas();	
		rr.setId(1020);
		rr.setNrOcorrencia(123456);
		rr.setTexto("testando");
		rr.setOutroTexto("outroTexto");
		
		Usuario u = new Usuario();
		u.setNome("fernando");
		u.setEmail("email");
		u.setSenha(333333);
		
		System.out.println(CriaSQL.devolveSQLupdate(rr));
		System.out.println(CriaSQL.devolveSQLupdate(u));
	}

}
