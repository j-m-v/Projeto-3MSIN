package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.CursoArtesTO;



public class ListarCursoArtesDAO {
	public ArrayList<CursoArtesTO> listarCursos() {
		CursoArtesTO to;
		ArrayList<CursoArtesTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM Artes";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoArtesTO();
					to.setCodigoArtes(rs.getInt("codigoCursoArt"));
					to.setNomeArtes(rs.getString("nomeCurso"));
					to.setDataInicio(rs.getString("dataInicio"));
					to.setHorarioPrevisto(rs.getString("horarioPrevisto"));
					to.setNumeroVagas(rs.getInt("numeroDeVagas"));
					to.setValorCurso(rs.getDouble("valorCurso"));
					to.setLivros(rs.getString("livros"));
					to.setDescricaoMaterial(rs.getString("descricaoMaterial"));
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
	
	public ArrayList<CursoArtesTO> listarCursos(String chave) {
		CursoArtesTO to;
		ArrayList<CursoArtesTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM Aluno where upper(nomeCurso) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoArtesTO();
					to.setCodigoArtes(rs.getInt("codigoCursoArt"));
					to.setNomeArtes(rs.getString("nomeCurso"));
					to.setDataInicio(rs.getString("dataInicio"));
					to.setHorarioPrevisto(rs.getString("horarioPrevisto"));
					to.setNumeroVagas(rs.getInt("numeroDeVagas"));
					to.setValorCurso(rs.getDouble("valorCurso"));
					to.setLivros(rs.getString("livros"));
					to.setDescricaoMaterial(rs.getString("descricaoMaterial"));
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
