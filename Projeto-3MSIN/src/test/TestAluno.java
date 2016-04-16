package test;

import static org.junit.Assert.*;
import org.junit.Test;

import model.Aluno;

import org.junit.Before;

public class TestAluno {
	Aluno aluno, copia;

	@Before
	public void setUp() throws Exception {
		aluno = new Aluno("Mauricio", "9999999", "9999999", "19/08/1996", "99999999", 
				"email JUnit", "04856-285", "Endereco JUnit", "São Paulo", "São Paulo");
		copia = new Aluno("Mauricio", "9999999", "9999999", "19/08/1996", "99999999", 
				"email JUnit", "04856-285", "Endereco JUnit", "São Paulo", "São Paulo");
		

	}

	@Test
	public void testIncluir() {
		aluno.incluir();	
		copia.setCodigo(aluno.getCodigo());
		copia.consultar();
		assertEquals(aluno, copia);
	}

	@Test
	public void testAlterar() {
		aluno.setTelefone("8888");
		copia.setTelefone("8888");
		aluno.alterar();
		assertEquals(aluno, copia);
	}

	@Test
	public void testDeletar() {
		aluno.setCidade(null);
		aluno.setEstado(null);
		copia.setCidade(null);
		copia.setEstado(null);	
		aluno.deletar();
		assertEquals(aluno, copia);
	}
}
