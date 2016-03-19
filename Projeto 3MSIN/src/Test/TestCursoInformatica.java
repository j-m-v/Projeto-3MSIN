package Test;

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
		assertEquals("Teste criacao", curso, copia);
	}

	@Test
	public void testAlterar() {
		curso.setCodigoInformatica(1);
		copia.setCodigoInformatica(1);
		curso.setNome("Memórias Postumas de Bras Cubas");
		copia.setNome("Memórias Postumas de Bras Cubas");
		curso.alterar();
		assertEquals("testa inclusao", curso, copia);
	}

	@Test
	public void testConsultar() {
		curso.setCodigoInformatica(3);
		copia.setCodigoInformatica(3);
		curso.consultar();
		assertEquals("testa inclusao", curso, copia);
	}

	@Test
	public void testDeletar() {
		curso.setCodigoInformatica(2);
		copia.setCodigoInformatica(2);
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
