package model;

import dao.MatriculaArtesDAO;
import to.MatriculaArtesTO;
import java.util.ArrayList;

public class ListaMatriculaArtes {
    public ArrayList<MatriculaArtesTO>listarMatriculaArtes(){
		ArrayList<MatriculaArtesTO> lista;
		MatriculaArtesDAO dao = new MatriculaArtesDAO();
		lista = dao.listarMatriculas();
		return lista;
	}
	
	public ArrayList<MatriculaArtesTO> listarMatriculaArtes(String chave){
		ArrayList<MatriculaArtesTO> lista;
		MatriculaArtesDAO dao = new MatriculaArtesDAO();
		lista = dao.listarMatriculas(chave);
		return lista;
	}




}
