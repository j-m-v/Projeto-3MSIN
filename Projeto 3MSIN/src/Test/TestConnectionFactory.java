package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import daos.ConnectionFactory;


public class TestConnectionFactory {

	@Test
	public void testObterConexao() {
		try {
			assertNotNull("testa se a conexao nao e nula", ConnectionFactory.obtemConexao());
		} catch (SQLException e) {
			e.printStackTrace();
			fail("gerou SQLException");
		}
	}
}
