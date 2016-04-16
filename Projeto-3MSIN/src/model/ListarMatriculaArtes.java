package model;

import java.util.ArrayList;


import dao.ListarMatriculaArtesDAO;
import to.MatriculaArtesTO;

public class ListarMatriculaArtes {

    public ArrayList<MatriculaArtesTO> listarMatriculaArtes(){
		ArrayList<MatriculaArtesTO> lista;
		ListarMatriculaArtesDAO dao = new ListarMatriculaArtesDAO();
		lista = dao.listarMatriculas();
		return lista;
	}
	
	public ArrayList<MatriculaArtesTO> listarMatriculaArtes(int chave){
		ArrayList<MatriculaArtesTO> lista;
		ListarMatriculaArtesDAO dao = new ListarMatriculaArtesDAO();
		lista = dao.listarMatriculas(chave);
		return lista;
	}




}
