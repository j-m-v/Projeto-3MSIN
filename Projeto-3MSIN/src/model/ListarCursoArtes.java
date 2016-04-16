package model;

import java.util.ArrayList;


import dao.ListarCursoArtesDAO;
import to.CursoArtesTO;

public class ListarCursoArtes {
    public ArrayList<CursoArtesTO> listarCursos(){
		ArrayList<CursoArtesTO> lista;
		ListarCursoArtesDAO dao = new ListarCursoArtesDAO();
		lista = dao.listarCursos();
		return lista;
	}
	
	public ArrayList<CursoArtesTO> listarCursos(String chave){
		ArrayList<CursoArtesTO> lista;
		ListarCursoArtesDAO dao = new ListarCursoArtesDAO();
		lista = dao.listarCursos(chave);
		return lista;
	}



}
