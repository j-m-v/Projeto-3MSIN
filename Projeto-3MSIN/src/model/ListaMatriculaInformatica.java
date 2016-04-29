package model;

import dao.ListarMatriculaInformaticaDAO;
import to.ListaMatriculaInformaticaTO;

public class ListaMatriculaInformatica {
    public ListaMatriculaInformaticaTO listarMatriculaInformatica(){
		ListaMatriculaInformaticaTO lista;
		ListarMatriculaInformaticaDAO lmi = new ListarMatriculaInformaticaDAO();
		lista = lmi.listarMatriculas();
		return lista;
	}
	
	public ListaMatriculaInformaticaTO listarMatriculaInformatica(String chave){
		ListaMatriculaInformaticaTO lista;
		ListarMatriculaInformaticaDAO dao = new ListarMatriculaInformaticaDAO();
		lista = dao.listarMatriculas(chave);
		return lista;
	}

}


