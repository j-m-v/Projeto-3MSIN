package model;

import java.util.Calendar;

import dao.MatriculaInformaticaDAO;
import to.MatriculaInformaticaTO;

public class MatriculaInformatica {
	// Atributos
	private int id;
	private int idAluno;
	private int idCurso;
	private String data;
	private double valor;
	private String statusMatricula;
	private String statusPagamento;

	public MatriculaInformatica() {
		id = 0;
		idAluno = 0;
		idCurso = 0;
		data = "";
		valor = 0.0;
		statusMatricula = "";
		statusPagamento = "";
	}

	public MatriculaInformatica(String dataMatricula, double valorMatricula, String statusMatricula, String statusPagamento, int codigoAluno,
			int codigoCurso) {
		this.idAluno = codigoAluno;
		this.idCurso = codigoCurso;
		this.data = dataMatricula;
		this.valor = valorMatricula;
		this.statusMatricula = statusMatricula;
		this.statusPagamento = statusPagamento;
	}
	
	public MatriculaInformatica(int codigoMatricula, String dataMatricula, double valorMatricula, String statusMatricula, String statusPagamento, int codigoAluno,
			int codigoCurso) {
		this.id = codigoMatricula;
		this.idAluno = codigoAluno;
		this.idCurso = codigoCurso;
		this.data = dataMatricula;
		this.valor = valorMatricula;
		this.statusMatricula = statusMatricula;
		this.statusPagamento = statusPagamento;
	}

	public int getId() {
		return id;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public String getData() {
		return data;
	}

	public double getValor() {
		return valor;
	}

	public String getStatusMatricula() {
		return statusMatricula;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setId(int codigoMatricula) {
		this.id = codigoMatricula;
	}

	public void setIdAluno(int codigoAluno) {
		this.idAluno = codigoAluno;
	}

	public void setIdCurso(int codigoCurso) {
		this.idCurso = codigoCurso;
	}

	public void setData(String dataMatricula) {
		this.data = dataMatricula;
	}

	public void setValor(double valorMatricula) {
		this.valor = valorMatricula;
	}

	public void setStatusMatricula(String statusMatricula) {
		this.statusMatricula = statusMatricula;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public void incluir() {
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		MatriculaInformaticaTO to = new MatriculaInformaticaTO();
		to.setIdAluno(idAluno);
		to.setIdCurso(idCurso);
		to.setData(data);
		to.setValor(valor);
		to.setStatusMatricula(statusMatricula);
		to.setStatusPagamento(statusPagamento);
		dao.incluir(to);
		setId(to.getId());
	}
    
	public MatriculaInformaticaTO getTO() {
		MatriculaInformaticaTO to = new MatriculaInformaticaTO();
		to.setIdAluno(idAluno);
		to.setIdCurso(idCurso);
		to.setData(data);
		to.setValor(valor);
		to.setStatusMatricula(statusMatricula);
		to.setStatusPagamento(statusPagamento);
		return to;
	}
	
	
	public void alterar() {
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		MatriculaInformaticaTO to = new MatriculaInformaticaTO();
		to.setId(id);
		to.setIdAluno(idAluno);
		to.setIdCurso(idCurso);
		to.setData(data);
		to.setValor(valor);
		to.setStatusMatricula(statusMatricula);
		to.setStatusPagamento(statusPagamento);
		dao.alterar(to);
	}

	public void consultar() {
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		MatriculaInformaticaTO to = dao.consultar(id);
		idAluno = to.getIdAluno();
		idCurso = to.getIdCurso();
		data = to.getData();
		valor = to.getValor();
		statusMatricula = to.getStatusMatricula();
		statusPagamento = to.getStatusPagamento();
	}
	
	public void deletar() {
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		MatriculaInformaticaTO to = new MatriculaInformaticaTO();
		to.setId(id);
		dao.deletar(to);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculaInformatica other = (MatriculaInformatica) obj;
		if (statusPagamento == null) {
			if (other.statusPagamento != null)
				return false;
		} else if (!statusPagamento.equals(other.statusPagamento))
			return false;
		if (id != other.id) {
			return false;
		}
		if (idAluno != other.idAluno) {
			return false;
		}
		if (idCurso != other.idCurso) {
			return false;
		}
		return true;
	}
	
	public String dataAtual(){ 
		Calendar dTime = Calendar.getInstance();
	     
	     int dia = dTime.get(Calendar.DAY_OF_MONTH);
	     String day = Integer.toString(dia);
	           
	     int mes =  dTime.get(Calendar.MONTH);
	     String month =""; 
	     switch (mes)  
	     {  
	              
	        case 0:  
	           {  
	              month = "1";  
	              break;  
	           }
	        case 1:  
	           {  
	              month = "2";  
	              break;  
	           }
	        case 2:  
	           {  
	              month = "3";  
	              break;  
	           }
	        case 3:  
	           {  
	              month = "4";  
	              break;  
	           }
	        case 4:  
	           {  
	              month = "5";  
	              break;  
	           }
	        case 5:  
	           {  
	              month = "6";  
	              break;  
	           } 
	        case 6:  
	           {  
	              month = "7";  
	              break;  
	           }
	        case 7:  
	           {  
	              month = "8";  
	              break;  
	           }  
	        case 8:  
	           {  
	              month = "9";  
	              break;  
	           }  
	        case 9:  
	           {  
	              month = "10";  
	              break;  
	           }
	        case 10:  
	           {  
	              month = "11";  
	              break;  
	           }
	        case 11:  
	           {  
	              month = "12";  
	              break;  
	           }  
	              
	     }
	           
	     int ano =  dTime.get(Calendar.YEAR);
	     String year = Integer.toString(ano);
	     return day +"/"+ month +"/"+ year;
		}

}