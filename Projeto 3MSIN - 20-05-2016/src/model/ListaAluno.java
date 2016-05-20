package model;

import java.util.ArrayList;
import to.AlunoTO;
import dao.AlunoDAO;

public class ListaAluno {
	public ArrayList<AlunoTO> listarAlunos(){
		ArrayList<AlunoTO> lista;
		AlunoDAO dao = new AlunoDAO();
		lista = dao.listarAlunos();
		return lista;
	}
	public ArrayList<AlunoTO> listarAlunos(String chave){
		ArrayList<AlunoTO> lista;
		AlunoDAO dao = new AlunoDAO();
		lista = dao.listarAlunos(chave);
		return lista;
	}

}
