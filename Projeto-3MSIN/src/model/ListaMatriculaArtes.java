package model;

import dao.ListarMatriculaArtesDAO;
import to.ListaMatriculaArtesTO;

public class ListaMatriculaArtes {
    public ListaMatriculaArtesTO listarMatriculaArtes(){
		ListaMatriculaArtesTO lista;
		ListarMatriculaArtesDAO lma = new ListarMatriculaArtesDAO();
		lista = lma.listarMatriculas();
		return lista;
	}
	
	public ListaMatriculaArtesTO listarMatriculaArtes(String chave){
		ListaMatriculaArtesTO lista;
		ListarMatriculaArtesDAO dao = new ListarMatriculaArtesDAO();
		lista = dao.listarMatriculas(chave);
		return lista;
	}




}
