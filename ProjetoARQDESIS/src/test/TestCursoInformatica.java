package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.CursoInformatica;

public class TestCursoInformatica {
	CursoInformatica curso, copia;

	@Before
	public void setUp() throws Exception {
		curso = new CursoInformatica("Infraestrutura","20/08/2016", "20/12/2016", "19:00",
				20, 200.99, "Cad e java", "7");

		copia = new CursoInformatica("Infraestrutura","20/08/2016", "20/12/2016", "19:00",
				20, 200.99, "Cad e java", "7");
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
		curso.setSoftwares(null);
		curso.setNome(null);
		copia.setSoftwares(null);
		copia.setNome(null);
		assertEquals(curso, copia);
	}
}
