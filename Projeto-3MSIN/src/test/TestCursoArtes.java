package test;

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
		copia.setId(curso.getId());
		copia.consultar();
		assertEquals(curso, copia);
	}

	@Test
	public void testAlterar() {
		curso.setNome("Memórias Postumas de Bras Cubas");
		copia.setNome("Memórias Postumas de Bras Cubas");
		curso.alterar();
		assertEquals(curso, copia);
	}

	@Test
	public void testDeletar() {
		curso.setDescricaoMaterial(null);;
		curso.setNome(null);
		copia.setDescricaoMaterial(null);;
		copia.setNome(null);
		curso.deletar();
		assertEquals(curso, copia);
	}
}
