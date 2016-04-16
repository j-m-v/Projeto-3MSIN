package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.CursoInformaticaTO;

public class ListarCursoInformaticaDAO {
	public ArrayList<CursoInformaticaTO> listarCursos() {
		CursoInformaticaTO to;
		ArrayList<CursoInformaticaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM Informatica";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoInformaticaTO();
					to.setCodigoInformatica(rs.getInt("codigoCursoInfo"));
					to.setNome(rs.getString("nomeCurso"));
					to.setDataInicio(rs.getString("dataInicio"));
					to.setHorarioPrevisto(rs.getString("horarioPrevisto"));
					to.setNumeroVagas(rs.getInt("numeroDeVagas"));
					to.setValorCurso(rs.getDouble("valorCurso"));
					to.setSoftwares(rs.getString("descricaoSoftware"));
					to.setNumeroLaboratorios(rs.getString("numeroLaboratorios"));
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
	
	public ArrayList<CursoInformaticaTO> listarCursos(String chave) {
		CursoInformaticaTO to;
		ArrayList<CursoInformaticaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM Informatica where upper(nomeCurso) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoInformaticaTO();
					to.setCodigoInformatica(rs.getInt("codigoCursoInfo"));
					to.setNome(rs.getString("nomeCurso"));
					to.setDataInicio(rs.getString("dataInicio"));
					to.setHorarioPrevisto(rs.getString("horarioPrevisto"));
					to.setNumeroVagas(rs.getInt("numeroDeVagas"));
					to.setValorCurso(rs.getDouble("valorCurso"));
					to.setSoftwares(rs.getString("descricaoSoftware"));
					to.setNumeroLaboratorios(rs.getString("numeroLaboratorios"));
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
