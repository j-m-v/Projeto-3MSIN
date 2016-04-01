package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestConnectionFactory.class, TestAluno.class, TestCursoArtes.class, TestCursoInformatica.class,
			   TestMatriculaArtes.class, TestMatriculaInformatica.class })

public class SuiteTest {
}
