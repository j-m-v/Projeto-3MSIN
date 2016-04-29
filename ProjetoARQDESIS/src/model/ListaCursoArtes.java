package model;

import dao.ListarCursoArtesDAO;
import to.ListaCursoArtesTO;


public class ListaCursoArtes {

	public ListaCursoArtesTO listarCursosArtes(){
		ListaCursoArtesTO lista;
		ListarCursoArtesDAO dao = new ListarCursoArtesDAO();
		lista = dao.listarCursos();
		return lista;
	}
	
	public ListaCursoArtesTO listarCursosArtes(String chave){
		ListaCursoArtesTO lista;
		ListarCursoArtesDAO dao = new ListarCursoArtesDAO();
		lista = dao.listarCursos(chave);
		return lista;
	}

	
}

