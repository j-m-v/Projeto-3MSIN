package model;

import java.util.ArrayList;

import dao.ListarCursoInformaticaDAO;
import to.CursoInformaticaTO;
public class ListarCursoInformatica {
	 public ArrayList<CursoInformaticaTO> listarCursos(){
			ArrayList<CursoInformaticaTO> lista;
			ListarCursoInformaticaDAO dao = new ListarCursoInformaticaDAO();
			lista = dao.listarCursos();
			return lista;
		}
		
		public ArrayList<CursoInformaticaTO> listarCursos(String chave){
			ArrayList<CursoInformaticaTO> lista;
			ListarCursoInformaticaDAO dao = new ListarCursoInformaticaDAO();
			lista = dao.listarCursos(chave);
			return lista;
		}


}
