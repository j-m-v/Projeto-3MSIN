package model;

import java.util.ArrayList;


import dao.ListarMatriculaInformaticaDAO;
import to.MatriculaInformaticaTO;

public class ListarMatriculaInformatica {

    public ArrayList<MatriculaInformaticaTO> listarMatriculaInformatica(){
		ArrayList<MatriculaInformaticaTO> lista;
		ListarMatriculaInformaticaDAO dao = new ListarMatriculaInformaticaDAO();
		lista = dao.listarMatriculas();
		return lista;
	}
	
	public ArrayList<MatriculaInformaticaTO> listarMatriculaInformatica(int chave){
		ArrayList<MatriculaInformaticaTO> lista;
		ListarMatriculaInformaticaDAO dao = new ListarMatriculaInformaticaDAO();
		lista = dao.listarMatriculas(chave);
		return lista;
	}




}
