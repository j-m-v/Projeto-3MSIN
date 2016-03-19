package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.CursoArtes;

public class TestCursoArtes {
	CursoArtes curso, copia;

	@Before
	public void setUp() throws Exception {
		curso = new CursoArtes("Desenho", "Dom Quixote", "20/08/2016", "20/12/2016", "19:00", 20, 200.99,
				"Lapis, Caneta e tesoura");

		copia = new CursoArtes("Desenho", "Dom Quixote", "20/08/2016", "20/12/2016", "19:00", 20, 200.99,
				"Lapis, Caneta e tesoura");
	}

	@Test
	public void testIncluir() {
		curso.incluir();
		assertEquals("Teste criacao", curso, copia);
	}

	@Test
	public void testAlterar() {
		curso.setCodigoArtes(1);
		copia.setCodigoArtes(1);
		curso.setNomeArtes("Memórias Postumas de Bras Cubas");
		copia.setNomeArtes("Memórias Postumas de Bras Cubas");
		curso.alterar();
		assertEquals("testa inclusao", curso, copia);
	}

	@Test
	public void testConsultar() {
		curso.setCodigoArtes(3);
		copia.setCodigoArtes(3);
		curso.consultar();
		assertEquals("testa inclusao", curso, copia);
	}

	@Test
	public void testDeletar() {
		curso.setCodigoArtes(2);
		copia.setCodigoArtes(2);
		curso.deletar();
		assertEquals("testa inclusao", curso, copia);
	}

	@Test
	public void testConsultarTodSos() {
		curso.consultarTodos();
	}

	@Test
	public void testRetornarUltimoID() {
		curso.retornarUltimoID();
	}

}
