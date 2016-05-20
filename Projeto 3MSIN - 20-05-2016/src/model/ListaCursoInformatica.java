package model;

import dao.ListarCursoInformaticaDAO;
import to.ListaCursoInformaticaTO;

public class ListaCursoInformatica {


	public ListaCursoInformaticaTO listarCursoInformatica(){
		ListaCursoInformaticaTO lista;
		ListarCursoInformaticaDAO dao = new ListarCursoInformaticaDAO();
		lista = dao.listarCursos();
		return lista;
	}
	
	public ListaCursoInformaticaTO listarCursoInformatica(String chave){
		ListaCursoInformaticaTO lista;
		ListarCursoInformaticaDAO dao = new ListarCursoInformaticaDAO();
		lista = dao.listarCursos(chave);
		return lista;
	}


}
