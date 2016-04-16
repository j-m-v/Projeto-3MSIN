package model;

import dao.AlunoDAO;
import to.AlunoTO;

public class Aluno {
	private int codigo;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private String rg;
	private String cpf;
	private String login;
	private String senha;
	private String cep;
	private String dataNasc;
	private String cidade;
	private String estado;

	public Aluno() {

		codigo = 0;
		nome = "";
		endereco = "";
		telefone = "";
		email = "";
		rg = "";
		cpf = "";
		dataNasc = "";
		login = "";
	}

	public Aluno(String nome, String cpf, String rg, String dataNasc, String telefone, String email, String cep,
			String endereco, String cidade, String estado) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.email = email;
		this.cep = cep;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Aluno(int codigo, String nome, String cpf, String rg, String dataNasc, String telefone, String email, String cep,
			String endereco, String cidade, String estado) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.email = email;
		this.cep = cep;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
	}

	// METODOS MODIFICADORES
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRG(String rg) {
		this.rg = rg;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setCEP(String cep) {
		this.cep = cep;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// METODOS DE ACESSO
	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public String getEmail() {
		return email;
	}

	public String getRG() {
		return rg;
	}

	public String getCPF() {
		return cpf;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getCEP() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void incluir() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		to.setNome(nome);
		to.setCPF(cpf);
		to.setRG(rg);
		to.setDataNasc(dataNasc);
		to.setTelefone(telefone);
		to.setEmail(email);
		to.setCEP(cep);
		to.setEndereco(endereco);
		to.setCidade(cidade);
		to.setEstado(estado);
		dao.incluir(to);
		setCodigo(to.getCodigo());
	}
	
	public AlunoTO getTO() {
		AlunoTO to = new AlunoTO();
		to.setCodigo(codigo);
		to.setNome(nome);
		to.setCPF(cpf);
		to.setRG(rg);
		to.setDataNasc(dataNasc);
		to.setTelefone(telefone);
		to.setEmail(email);
		to.setCEP(cep);
		to.setEndereco(endereco);
		to.setCidade(cidade);
		to.setEstado(estado);
		return to;
	}

	public void alterar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		to.setCodigo(codigo);
		to.setNome(nome);
		to.setCPF(cpf);
		to.setRG(rg);
		to.setDataNasc(dataNasc);
		to.setTelefone(telefone);
		to.setEmail(email);
		to.setCEP(cep);
		to.setEndereco(endereco);
		to.setCidade(cidade);
		to.setEstado(estado);
		dao.alterar(to);
	}

	public void consultar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = dao.consultar(codigo);
		nome = to.getNome();
		cpf = to.getCPF();
		rg = to.getRG();
		dataNasc = to.getDataNasc();
		telefone = to.getTelefone();
		email = to.getEmail();
		cep = to.getCEP();
		endereco = to.getEndereco();
		cidade = to.getCidade();
		estado = to.getEstado();
	}

	public void deletar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		to.setCodigo(codigo);
		dao.deletar(to);
	}

	public void consultarTodos() {
		AlunoDAO dao = new AlunoDAO();
		dao.consultarTodos();
	}

	public void retornarLogin() {
		AlunoDAO dao = new AlunoDAO();
		dao.retornarLogin();
	}

	public void retornarUltimoID() {
		AlunoDAO dao = new AlunoDAO();
		dao.retornarUltimoID();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}

}