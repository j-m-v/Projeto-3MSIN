package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.CursoArtesTO;
import to.ListaCursoArtesTO;


public class ListarCursoArtesDAO {
	
	public ListaCursoArtesTO listarCursos() {
		CursoArtesTO to;
		ArrayList<CursoArtesTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM CursoArtes";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoArtesTO();
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nomeArtes"));
					to.setDataInicio(rs.getString("dataInicio"));
					to.setDataTermino(rs.getString("dataTermino"));
					to.setHorario(rs.getString("horario"));
					to.setVagas(rs.getInt("vagas"));
					to.setValor(rs.getDouble("valor"));
					to.setLivros(rs.getString("livros"));
					to.setDescricaoMaterial(rs.getString("material"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		ListaCursoArtesTO listaCursoArtes = new ListaCursoArtesTO();
		listaCursoArtes.setCursosArtes(lista);
		return listaCursoArtes;
	}
	
	public ListaCursoArtesTO listarCursos(String chave) {
		CursoArtesTO to;
		ArrayList<CursoArtesTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM CursoArtes where upper(nomeArtes) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoArtesTO();
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nomeArtes"));
					to.setDataInicio(rs.getString("dataInicio"));
					to.setDataTermino(rs.getString("dataTermino"));
					to.setHorario(rs.getString("horario"));
					to.setVagas(rs.getInt("vagas"));
					to.setValor(rs.getDouble("valor"));
					to.setLivros(rs.getString("livros"));
					to.setDescricaoMaterial(rs.getString("material"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		ListaCursoArtesTO lca = new ListaCursoArtesTO();
		lca.setCursosArtes(lista);
		return lca;
	}

}
