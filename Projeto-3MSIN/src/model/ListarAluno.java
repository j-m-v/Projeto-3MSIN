package model;

import java.util.ArrayList;

import dao.ListarAlunoDAO;
import to.AlunoTO;


public class ListarAluno {
	
		public ArrayList<AlunoTO> listarAlunos(){
			ArrayList<AlunoTO> lista;
			ListarAlunoDAO dao = new ListarAlunoDAO();
			lista = dao.listarAlunos();
			return lista;
		}
		
		public ArrayList<AlunoTO> listarAlunos(String chave){
			ArrayList<AlunoTO> lista;
			ListarAlunoDAO dao = new ListarAlunoDAO();
			lista = dao.listarAlunos(chave);
			return lista;
		}


}
