package to;

public class MatriculaInformaticaTO {
	// atributos
		private int id;
		private int idAluno;
		private String nomeAluno;
		private int idCurso;
		private String nomeInformatica;
		private String data;
		private double valor;
		private String statusMatricula;
		private String statusPagamento;


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

		public String getNomeAluno() {
			return nomeAluno;
		}

		public void setNomeAluno(String nomeAluno) {
			this.nomeAluno = nomeAluno;
		}

		public String getNomeInformatica() {
			return nomeInformatica;
		}

		public void setNomeCurso(String nomeInformatica) {
			this.nomeInformatica = nomeInformatica;
		}
}
