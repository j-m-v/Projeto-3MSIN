package model;

import java.util.Calendar;

import dao.MatriculaInformaticaDAO;
import to.MatriculaInformaticaTO;

public class MatriculaInformatica {
	// Atributos
	private int codigoMatricula;
	private int codigoAluno;
	private int codigoCurso;
	private String dataMatricula;
	private double valorMatricula;
	private String statusMatricula;
	private String statusPagamento;

	public MatriculaInformatica() {
		codigoMatricula = 0;
		codigoAluno = 0;
		codigoCurso = 0;
		dataMatricula = "";
		valorMatricula = 0.0;
		statusMatricula = "";
	}

	public MatriculaInformatica(String dataMatricula, double valorMatricula, String statusMatricula, String statusPagamento, int codigoAluno,
			int codigoCurso) {
		this.codigoAluno = codigoAluno;
		this.codigoCurso = codigoCurso;
		this.dataMatricula = dataMatricula;
		this.valorMatricula = valorMatricula;
		this.statusMatricula = statusMatricula;
		this.statusPagamento = statusPagamento;
	}
	
	public MatriculaInformatica(int codigoMatricula, String dataMatricula, double valorMatricula, String statusMatricula, String statusPagamento, int codigoAluno,
			int codigoCurso) {
		this.codigoMatricula = codigoMatricula;
		this.codigoAluno = codigoAluno;
		this.codigoCurso = codigoCurso;
		this.dataMatricula = dataMatricula;
		this.valorMatricula = valorMatricula;
		this.statusMatricula = statusMatricula;
		this.statusPagamento = statusPagamento;
	}

	public int getCodigoMatricula() {
		return codigoMatricula;
	}

	public int getCodigoAluno() {
		return codigoAluno;
	}

	public int getCodigoCurso() {
		return codigoCurso;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public double getValorMatricula() {
		return valorMatricula;
	}

	public String getStatusMatricula() {
		return statusMatricula;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setCodigoMatricula(int codigoMatricula) {
		this.codigoMatricula = codigoMatricula;
	}

	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}

	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public void setValorMatricula(double valorMatricula) {
		this.valorMatricula = valorMatricula;
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
		to.setCodigoAluno(codigoAluno);
		to.setCodigoCurso(codigoCurso);
		to.setDataMatricula(dataMatricula);
		to.setValorMatricula(valorMatricula);
		to.setStatusMatricula(statusMatricula);
		to.setStatusPagamento(statusPagamento);
		dao.incluir(to);
		setCodigoMatricula(to.getCodigoMatricula());
	}
    
	public MatriculaInformaticaTO getTO() {
		MatriculaInformaticaTO to = new MatriculaInformaticaTO();
		to.setCodigoAluno(codigoAluno);
		to.setCodigoCurso(codigoCurso);
		to.setDataMatricula(dataMatricula);
		to.setValorMatricula(valorMatricula);
		to.setStatusMatricula(statusMatricula);
		to.setStatusPagamento(statusPagamento);
		return to;
	}
	
	
	public void alterar() {
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		MatriculaInformaticaTO to = new MatriculaInformaticaTO();
		to.setCodigoMatricula(codigoMatricula);
		to.setCodigoAluno(codigoAluno);
		to.setCodigoCurso(codigoCurso);
		to.setDataMatricula(dataMatricula);
		to.setValorMatricula(valorMatricula);
		to.setStatusMatricula(statusMatricula);
		to.setStatusPagamento(statusPagamento);
		dao.alterar(to);
	}

	public void consultar() {
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		MatriculaInformaticaTO to = dao.consultar(codigoMatricula);
		codigoAluno = to.getCodigoAluno();
		codigoCurso = to.getCodigoCurso();
		dataMatricula = to.getDataMatricula();
		valorMatricula = to.getValorMatricula();
		statusMatricula = to.getStatusMatricula();
		statusPagamento = to.getStatusPagamento();
	}
	
	public void deletar() {
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		MatriculaInformaticaTO to = new MatriculaInformaticaTO();
		to.setCodigoMatricula(codigoMatricula);
		dao.deletar(to);
	}

	public void consultarTodos() {
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		dao.consultarTodos();
	}

	public void retornarUltimoID() {
		MatriculaInformaticaDAO dao = new MatriculaInformaticaDAO();
		dao.retornarUltimoID();
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
		if (codigoMatricula != other.codigoMatricula) {
			return false;
		}
		if (codigoAluno != other.codigoAluno) {
			return false;
		}
		if (codigoCurso != other.codigoCurso) {
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