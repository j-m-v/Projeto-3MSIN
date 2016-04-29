package model;

import dao.AlunoDAO;
import to.AlunoTO;

public class Aluno {
	private int id;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private String rg;
	private String cpf;
	private String login;
	private String senha;
	private String cep;
	private String dataNascimento;
	private String cidade;
	private String estado;

	public Aluno() {
		id = 0;
		nome = "";
		endereco = "";
		telefone = "";
		email = "";
		rg = "";
		cpf = "";
		dataNascimento = "";
		cidade = "";
		estado = "";
	}

	public Aluno(String nome, String cpf, String rg, String dataNasc, String telefone, String email, String cep,
			String endereco, String cidade, String estado) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNasc;
		this.telefone = telefone;
		this.email = email;
		this.cep = cep;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Aluno(int id, String nome, String cpf, String rg, String dataNasc, String telefone, String email, String cep,
			String endereco, String cidade, String estado) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNasc;
		this.telefone = telefone;
		this.email = email;
		this.cep = cep;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
	}

	// METODOS MODIFICADORES
	public void setId(int id) {
		this.id = id;
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

	public void setDataNascimento(String dataNasc) {
		this.dataNascimento = dataNasc;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// METODOS DE ACESSO
	public int getId() {
		return id;
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public String getRg() {
		return rg;
	}

	public String getCpf() {
		return cpf;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getCep() {
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
		to.setCpf(cpf);
		to.setRg(rg);
		to.setDataNascimento(dataNascimento);
		to.setTelefone(telefone);
		to.setEmail(email);
		to.setCep(cep);
		to.setEndereco(endereco);
		to.setCidade(cidade);
		to.setEstado(estado);
		dao.incluir(to);
		setId(to.getId());
	}

	public AlunoTO getTO() {
		AlunoTO to = new AlunoTO();
		to.setId(id);
		to.setNome(nome);
		to.setCpf(cpf);
		to.setRg(rg);
		to.setDataNascimento(dataNascimento);
		to.setTelefone(telefone);
		to.setEmail(email);
		to.setCep(cep);
		to.setEndereco(endereco);
		to.setCidade(cidade);
		to.setEstado(estado);
		return to;
	}

	public void alterar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		to.setId(id);
		to.setNome(nome);
		to.setCpf(cpf);
		to.setRg(rg);
		to.setDataNascimento(dataNascimento);
		to.setTelefone(telefone);
		to.setEmail(email);
		to.setCep(cep);
		to.setEndereco(endereco);
		to.setCidade(cidade);
		to.setEstado(estado);
		dao.alterar(to);
	}

	public void consultar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = dao.consultar(id);
		nome = to.getNome();
		cpf = to.getCpf();
		rg = to.getRg();
		dataNascimento = to.getDataNascimento();
		telefone = to.getTelefone();
		email = to.getEmail();
		cep = to.getCep();
		endereco = to.getEndereco();
		cidade = to.getCidade();
		estado = to.getEstado();
	}

	public void deletar() {
		AlunoDAO dao = new AlunoDAO();
		AlunoTO to = new AlunoTO();
		to.setId(id);
		dao.deletar(to);
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