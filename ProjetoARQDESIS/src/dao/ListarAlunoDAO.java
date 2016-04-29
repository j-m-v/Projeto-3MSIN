package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.AlunoTO;
import to.ListaAlunoTO;




public class ListarAlunoDAO {
	
	public ListaAlunoTO listarAlunos() {
		AlunoTO to;
		ArrayList<AlunoTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM Aluno";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
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
		ListaAlunoTO listaAluno = new ListaAlunoTO();
		listaAluno.setAlunos(lista);
		return listaAluno;
	}
	
	public ListaAlunoTO listarAlunos(String chave) {
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
		ListaAlunoTO listaAluno = new ListaAlunoTO();
		listaAluno.setAlunos(lista);
		return listaAluno;
	}


}
