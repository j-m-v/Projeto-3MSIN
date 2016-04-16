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
		copia.setCodigoArtes(curso.getCodigoArtes());
		copia.consultar();
		assertEquals(curso, copia);
	}

	@Test
	public void testAlterar() {
		curso.setNomeArtes("Memórias Postumas de Bras Cubas");
		copia.setNomeArtes("Memórias Postumas de Bras Cubas");
		curso.alterar();
		assertEquals(curso, copia);
	}

	@Test
	public void testDeletar() {
		curso.setDescricaoMaterial(null);;
		curso.setNomeArtes(null);
		copia.setDescricaoMaterial(null);;
		copia.setNomeArtes(null);
		curso.deletar();
		assertEquals(curso, copia);
	}
}
