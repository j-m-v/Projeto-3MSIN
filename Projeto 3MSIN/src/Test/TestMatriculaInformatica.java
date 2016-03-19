package Test;

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
		assertEquals("Teste criacao", matricula, copia);
	}

	@Test
	public void testAlterar() {
		matricula.setCodigoMatricula(1);
		copia.setCodigoMatricula(1);
		matricula.setDataMatricula("19/02/2018");
		copia.setDataMatricula("19/02/2018");
		matricula.alterar();
		assertEquals("testa inclusao", matricula, copia);
	}

	@Test
	public void testConsultar() {
		matricula.setCodigoMatricula(3);
		copia.setCodigoMatricula(3);
		matricula.consultar();
		assertEquals("testa inclusao", matricula, copia);
	}

	@Test
	public void testDeletar() {
		matricula.setCodigoMatricula(2);
		copia.setCodigoMatricula(2);
		matricula.deletar();
		assertEquals("testa inclusao", matricula, copia);
	}

	/*@Test
	public void testConsultarTodSos() {
		matricula.consultarTodos();
	}/*/

	@Test
	public void testRetornarUltimoID() {
		matricula.retornarUltimoID();
	}

}
