package daos;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import to.AlunoTO;

public class AlunoDAO {
	private String dados[][];

	public void incluir(AlunoTO to) {
		String sqlInsert = "INSERT INTO aluno (nome, CPF, RG, dataNasc, telefone, email, cep, endereco, cidade, estado, login) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlInsert);) {
			st.setString(1, to.getNome());
			st.setString(2, to.getCPF());
			st.setString(3, to.getRG());
			st.setString(4, to.getDataNasc());
			st.setString(5, to.getTelefone());
			st.setString(6, to.getEmail());
			st.setString(7, to.getCEP());
			st.setString(8, to.getEndereco());
			st.setString(9, to.getCidade());
			st.setString(10, to.getEstado());
			st.setString(11, to.getLogin());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(AlunoTO to) {

		String sqlUpdate = "UPDATE Aluno SET nome = ?, CPF = ?, RG = ?, dataNasc = ?, telefone = ?, email = ?, cep = ?, endereco = ?, cidade = ?, estado =? WHERE codigoAluno = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUpdate);) {
			st.setString(1, to.getNome());
			st.setString(2, to.getCPF());
			st.setString(3, to.getRG());
			st.setString(4, to.getDataNasc());
			st.setString(5, to.getTelefone());
			st.setString(6, to.getEmail());
			st.setString(7, to.getCEP());
			st.setString(8, to.getEndereco());
			st.setString(9, to.getCidade());
			st.setString(10, to.getEstado());
			st.setInt(11, to.getCodigo());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// consultaPorCodigo
	public AlunoTO consultar(int id) {
		AlunoTO to = new AlunoTO();
		String sqlSelect = "SELECT * FROM aluno WHERE codigoAluno = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlSelect);) {
			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nome"));
					to.setCPF(rs.getString("CPF"));
					to.setRG(rs.getString("RG"));
					to.setDataNasc(rs.getString("dataNasc"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmail(rs.getString("CPF"));
					to.setCEP(rs.getString("cep"));
					to.setEndereco(rs.getString("endereco"));
					to.setCidade(rs.getString("cidade"));
					to.setEstado(rs.getString("estado"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}

	// deletar
	public void deletar(AlunoTO to) {
		String sqlDelete = "DELETE FROM Aluno WHERE codigoAluno = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlDelete);) {
			st.setInt(1, to.getCodigo());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// listar todos Alunos
	public String[][] consultarTodos() {
		int codigo = 0;
		String nome, cpf, rg, dataNasc, telefone, email, cep, endereco, cidade, estado;

		String sqlTable = "SELECT * FROM Aluno ORDER BY codigoAluno";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlTable);) {

			try (ResultSet rs = st.executeQuery();) {
				int linha = 0;

				while (rs.next()) {

					codigo = rs.getInt("codigoAluno");
					nome = rs.getString("nome");
					cpf = rs.getString("CPF");
					rg = rs.getString("RG");
					dataNasc = rs.getString("dataNasc");
					telefone = rs.getString("telefone");
					email = rs.getString("email");
					cep = rs.getString("cep");
					endereco = rs.getString("endereco");
					cidade = rs.getString("cidade");
					estado = rs.getString("estado");

					dados[linha][0] = String.valueOf(codigo);
					dados[linha][1] = String.valueOf(nome);
					dados[linha][2] = String.valueOf(cpf);
					dados[linha][3] = String.valueOf(rg);
					dados[linha][4] = String.valueOf(dataNasc);
					dados[linha][5] = String.valueOf(telefone);
					dados[linha][6] = String.valueOf(email);
					dados[linha][7] = String.valueOf(cep);
					dados[linha][8] = String.valueOf(endereco);
					dados[linha][9] = String.valueOf(cidade);
					dados[linha][10] = String.valueOf(estado);
					linha++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return dados;

	}

	// Método para retornar o login do usuário na página inicial
	public void retornarLogin() {
		AlunoTO to = new AlunoTO();
		String sqlLogin = " SELECT * FROM Aluno WHERE login = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlLogin);) {

			st.setString(1, to.getLogin());

			try (ResultSet rs = st.executeQuery();) {

				if (rs.next()) {
					to.setNome(rs.getString("nome"));
					to.setCodigo(rs.getInt("codigoAluno"));

				} // fim do if

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}

	// método para retornar o id do último aluno cadastrado
	public int retornarUltimoID() {
		int cod = 0;

		String sqlUltimoID = " SELECT MAX(codigoAluno) AS codigoAluno from Aluno ";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUltimoID);) {

			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					cod = rs.getInt("codigoAluno");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return cod;
	}
}// fim da classe
