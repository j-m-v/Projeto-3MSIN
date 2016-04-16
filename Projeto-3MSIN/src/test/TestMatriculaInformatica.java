package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.MatriculaInformatica;

public class TestMatriculaInformatica {
	MatriculaInformatica matricula, copia;

	@Before
	public void setUp() throws Exception {
		matricula = new MatriculaInformatica("19/08/2016", 250.99, "este", "este",2, 1);
		copia = new MatriculaInformatica("19/08/2016", 250.99, "este", "este",2, 1);
	}
	
	@Test
	public void testIncluir() {
		matricula.incluir();
		copia.setCodigoMatricula(matricula.getCodigoMatricula());
		copia.consultar();
		assertEquals(matricula, copia);
	}

	@Test
	public void testAlterar() {
		matricula.setDataMatricula("19/02/2018");
		copia.setDataMatricula("19/02/2018");
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
