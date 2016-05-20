package dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import to.AlunoTO;
import factory.ConnectionFactory;

public class AlunoDAO {

	public void incluir(AlunoTO to) {
		String sqlInsert = "INSERT INTO aluno (nome, cpf, rg, dataNascimento, fone, email, cep, endereco, cidade, estado) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlInsert);) {
			st.setString(1, to.getNome());
			st.setString(2, to.getCpf());
			st.setString(3, to.getRg());
			st.setString(4, to.getDataNascimento());
			st.setString(5, to.getTelefone());
			st.setString(6, to.getEmail());
			st.setString(7, to.getCep());
			st.setString(8, to.getEndereco());
			st.setString(9, to.getCidade());
			st.setString(10, to.getEstado());
			st.execute();

			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm1 = conn.prepareStatement(sqlSelect); ResultSet rs = stm1.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(AlunoTO to) {

		String sqlUpdate = "UPDATE Aluno SET nome = ?, cpf = ?, rg = ?, dataNascimento = ?, fone = ?, email = ?, cep = ?, endereco = ?, cidade = ?, estado =? WHERE idAluno = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUpdate);) {
			st.setString(1, to.getNome());
			st.setString(2, to.getCpf());
			st.setString(3, to.getRg());
			st.setString(4, to.getDataNascimento());
			st.setString(5, to.getTelefone());
			st.setString(6, to.getEmail());
			st.setString(7, to.getCep());
			st.setString(8, to.getEndereco());
			st.setString(9, to.getCidade());
			st.setString(10, to.getEstado());
			st.setInt(11, to.getId());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// consultaPorCodigo
	public AlunoTO consultar(int id) {
		AlunoTO to = new AlunoTO();
		String sqlSelect = "SELECT * FROM aluno WHERE idAluno = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlSelect);) {
			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nome"));
					to.setCpf(rs.getString("cpf"));
					to.setRg(rs.getString("rg"));
					to.setDataNascimento(rs.getString("dataNascimento"));
					to.setTelefone(rs.getString("fone"));
					to.setEmail(rs.getString("Email"));
					to.setCep(rs.getString("cep"));
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
		String sqlDelete = "DELETE FROM Aluno WHERE idAluno = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlDelete);) {
			st.setInt(1, to.getId());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<AlunoTO> listarAlunos() {
		AlunoTO to;
		ArrayList<AlunoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM Aluno";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					to = new AlunoTO();
					to.setId(rs.getInt("idAluno"));
					to.setNome(rs.getString("nome"));
					to.setCpf(rs.getString("cpf"));
					to.setRg(rs.getString("rg"));
					to.setDataNascimento(rs.getString("dataNascimento"));
					to.setRg(rs.getString("RG"));
					to.setTelefone(rs.getString("fone"));
					to.setEmail(rs.getString("email"));
					to.setCep(rs.getString("cep"));
					to.setEndereco(rs.getString("endereco"));
					to.setCidade(rs.getString("cidade"));
					to.setEstado(rs.getString("estado"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<AlunoTO> listarAlunos(String chave) {
		AlunoTO to;
		ArrayList<AlunoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM Aluno where upper(nome) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					to = new AlunoTO();
					to.setId(rs.getInt("idAluno"));
					to.setNome(rs.getString("nome"));
					to.setCpf(rs.getString("cpf"));
					to.setRg(rs.getString("rg"));
					to.setDataNascimento(rs.getString("dataNascimento"));
					to.setRg(rs.getString("RG"));
					to.setTelefone(rs.getString("fone"));
					to.setEmail(rs.getString("email"));
					to.setCep(rs.getString("cep"));
					to.setEndereco(rs.getString("endereco"));
					to.setCidade(rs.getString("cidade"));
					to.setEstado(rs.getString("estado"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

}// fim da classe
