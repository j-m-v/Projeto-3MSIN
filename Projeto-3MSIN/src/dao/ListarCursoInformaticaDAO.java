package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.CursoInformaticaTO;
import to.ListaCursoInformaticaTO;

public class ListarCursoInformaticaDAO {
	
	public ListaCursoInformaticaTO listarCursos() {
		CursoInformaticaTO to;
		ArrayList<CursoInformaticaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM CursoInformatica";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoInformaticaTO();
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nomeInformatica"));
					to.setDataInicio(rs.getString("dataInicio"));
					to.setDataTermino(rs.getString("dataTermino"));
					to.setHorario(rs.getString("horario"));
					to.setVagas(rs.getInt("vagas"));
					to.setValor(rs.getDouble("valor"));
					to.setSoftwares(rs.getString("softwares"));
					to.setNumeroLaboratorios(rs.getString("numLab"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		ListaCursoInformaticaTO lci = new ListaCursoInformaticaTO();
		lci.setCursosInformatica(lista);
		return lci;
	}
	
	public ListaCursoInformaticaTO listarCursos(String chave) {
		CursoInformaticaTO to;
		ArrayList<CursoInformaticaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM CursoInformatica where upper(nomeInformatica) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new CursoInformaticaTO();
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nomeInformatica"));
					to.setDataInicio(rs.getString("dataInicio"));
					to.setDataTermino(rs.getString("dataTermino"));
					to.setHorario(rs.getString("horario"));
					to.setVagas(rs.getInt("vagas"));
					to.setValor(rs.getDouble("valor"));
					to.setSoftwares(rs.getString("softwares"));
					to.setNumeroLaboratorios(rs.getString("numLab"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		ListaCursoInformaticaTO lci = new ListaCursoInformaticaTO();
		lci.setCursosInformatica(lista);
		return lci;
	}

}
