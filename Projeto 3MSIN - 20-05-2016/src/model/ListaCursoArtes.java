package model;

import java.util.ArrayList;

import dao.CursoArtesDAO;
import to.CursoArtesTO;


public class ListaCursoArtes {

	public ArrayList<CursoArtesTO> listarCursosArtes(){
		ArrayList<CursoArtesTO>lista;
		CursoArtesDAO dao = new CursoArtesDAO();
		lista = dao.listarCursos();
		return lista;
	}
	
	public ArrayList<CursoArtesTO> listarCursosArtes(String chave){
		ArrayList<CursoArtesTO> lista;
		CursoArtesDAO dao = new CursoArtesDAO();
		lista = dao.listarCursos(chave);
		return lista;
}
}
