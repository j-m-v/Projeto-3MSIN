package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.MatriculaInformaticaTO;

public class ListarMatriculaInformaticaDAO {
	public ArrayList<MatriculaInformaticaTO> listarMatriculas() {
		MatriculaInformaticaTO to;
		ArrayList<MatriculaInformaticaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM MatriculaInfo";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new MatriculaInformaticaTO();
					to.setCodigoMatricula(rs.getInt("codigoMatricula"));
					to.setDataMatricula(rs.getString("dataMatricula"));
					to.setValorMatricula(rs.getDouble("valorMatricula"));
					to.setStatusMatricula(rs.getString("statusMatricula"));
					to.setStatusPagamento(rs.getString("statusPagamento"));
					to.setCodigoAluno(rs.getInt("codigoAluno"));
					to.setCodigoCurso(rs.getInt("codigoCursoInfo"));
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
	
	public ArrayList<MatriculaInformaticaTO> listarMatriculas(int chave) {
		MatriculaInformaticaTO to;
		ArrayList<MatriculaInformaticaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM MatriculaInfo WHERE codigoMatricula = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, chave);
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new MatriculaInformaticaTO();
					to.setCodigoMatricula(rs.getInt("codigoMatricula"));
					to.setDataMatricula(rs.getString("dataMatricula"));
					to.setValorMatricula(rs.getDouble("valorMatricula"));
					to.setStatusMatricula(rs.getString("statusMatricula"));
					to.setStatusPagamento(rs.getString("statusPagamento"));
					to.setCodigoAluno(rs.getInt("codigoAluno"));
					to.setCodigoCurso(rs.getInt("codigoCursoInfo"));
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
