package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.MatriculaArtes;

public class TestMatriculaArtes {
	MatriculaArtes matricula, copia;

	@Before
	public void setUp() throws Exception {
		matricula = new MatriculaArtes("19/08/2016", 250.99, "este", "este",1, 1);
		copia = new MatriculaArtes("19/08/2016", 250.99, "este", "este",1, 1);
	}

	@Test
	public void testIncluir() {
		matricula.incluir();
		copia.setId(matricula.getId());
		copia.consultar();
		assertEquals(matricula, copia);
	}

	@Test
	public void testAlterar() {
		matricula.setData("19/02/2018");
		copia.setData("19/02/2018");
		matricula.alterar();
		assertEquals(matricula, copia);
	}

	@Test
	public void testDeletar() {
		matricula.setStatusMatricula(null);
		matricula.setStatusPagamento(null);
		copia.setStatusMatricula(null);
		copia.setStatusPagamento(null);
		assertEquals(matricula, copia);
	}

}
