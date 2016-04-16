package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.AlunoTO;



public class ListarAlunoDAO {
	
	public ArrayList<AlunoTO> listarAlunos() {
		AlunoTO to;
		ArrayList<AlunoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM Aluno";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new AlunoTO();
					to.setCodigo(rs.getInt("codigoAluno"));
					to.setNome(rs.getString("nome"));
					to.setCPF(rs.getString("CPF"));
					to.setRG(rs.getString("RG"));
					to.setDataNasc(rs.getString("dataNasc"));
					to.setRG(rs.getString("RG"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmail(rs.getString("email"));
					to.setCEP(rs.getString("cep"));
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
				while(rs.next()) {
					to = new AlunoTO();
					to.setCodigo(rs.getInt("codigoAluno"));
					to.setNome(rs.getString("nome"));
					to.setCPF(rs.getString("CPF"));
					to.setRG(rs.getString("RG"));
					to.setDataNasc(rs.getString("dataNasc"));
					to.setRG(rs.getString("RG"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmail(rs.getString("email"));
					to.setCEP(rs.getString("cep"));
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


}
