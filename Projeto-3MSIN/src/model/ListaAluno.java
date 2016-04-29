package model;


import dao.ListarAlunoDAO;
import to.ListaAlunoTO;

public class ListaAluno {
		public ListaAlunoTO listarAlunos(){
			ListaAlunoTO lista;
			ListarAlunoDAO dao = new ListarAlunoDAO();
			lista = dao.listarAlunos();
			return lista;
		}
		
		public ListaAlunoTO listarAlunos(String chave){
			ListaAlunoTO lista;
			ListarAlunoDAO dao = new ListarAlunoDAO();
			lista = dao.listarAlunos(chave);
			return lista;
		}


}
