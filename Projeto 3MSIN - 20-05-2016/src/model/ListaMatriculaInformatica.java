package model;

import java.util.ArrayList;

import dao.MatriculaInformaticaDAO;
import to.MatriculaInformaticaTO;

public class ListaMatriculaInformatica {
    public  ArrayList<MatriculaInformaticaTO> listarMatriculaInformatica(){
		ArrayList<MatriculaInformaticaTO> lista;
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		lista = dao.listarMatriculas();
		return lista;
	}
	
	public ArrayList<MatriculaInformaticaTO> listarMatriculaInformatica(String chave){
		ArrayList<MatriculaInformaticaTO> lista;
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		lista = dao.listarMatriculas(chave);
		return lista;
	}

}


