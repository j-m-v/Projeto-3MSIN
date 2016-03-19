package Test;

import static org.junit.Assert.*;
import org.junit.Test;

import model.Aluno;

import org.junit.Before;

public class TestAluno {
	Aluno aluno, copia;

	@Before
	public void setUp() throws Exception {
		aluno = new Aluno("Mauricio", "4454904920", "376136522", "19/08/1996", "77888877", "mauriciomelo.co", "sadsada",
				"Rua Oceano Pacifico", "dasdada", "adsiohsada", "asasasa");

		copia = new Aluno("Mauricio", "4454904920", "376136522", "19/08/1996", "77888877", "mauriciomelo.co", "sadsada",
				"Rua Oceano Pacifico", "dasdada", "adsiohsada", "asasasa");
	}

	@Test
	public void testIncluir() {
		aluno.incluir();
		assertEquals("Teste criacao", aluno, copia);
	}

	@Test
	public void testAlterar() {
		aluno.setCodigo(3);
		copia.setCodigo(3);
		aluno.setTelefone("22233");
		copia.setTelefone("22233");
		aluno.alterar();
		assertEquals("testa inclusao", aluno, copia);
	}

	@Test
	public void testConsultar() {
		aluno.setCodigo(3);
		copia.setCodigo(3);
		aluno.consultar();
		assertEquals("testa inclusao", aluno, copia);
	}

	@Test
	public void testDeletar() {
		aluno.setCodigo(2);
		copia.setCodigo(2);
		aluno.deletar();
		assertEquals("testa inclusao", aluno, copia);
	}

	@Test
	public void testConsultarTodos() {
		aluno.consultarTodos();
	}

	@Test
	public void testRetornarLogin() {
		aluno.setLogin("catapau");
		copia.setLogin("catapau");
		aluno.retornarLogin();
		assertEquals("testa inclusao", aluno, copia);
	}

	@Test
	public void testRetornarUltimoID() {
		aluno.retornarUltimoID();
	}

}
