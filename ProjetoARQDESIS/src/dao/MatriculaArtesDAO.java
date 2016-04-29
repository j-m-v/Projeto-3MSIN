package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import to.MatriculaArtesTO;
import factory.ConnectionFactory;

public class MatriculaArtesDAO {

	// incluir
	public void incluir(MatriculaArtesTO to) {

		String sqlInsert = "INSERT INTO MatriculaArtes (dataMatricula, valor, statusMatricula, statusPagamento, idAluno, idCurso) VALUES (?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlInsert);) {
			st.setString(1, to.getData());
			st.setDouble(2, to.getValor());
			st.setString(3, to.getStatusMatricula());
			st.setString(4, to.getStatusPagamento());
			st.setInt(5, to.getIdAluno());
			st.setInt(6, to.getIdCurso());
			st.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						to.setId(rs.getInt(1));
					}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(MatriculaArtesTO to) {
		String sqlUpdate = "UPDATE MatriculaArtes SET dataMatricula = ?, valor = ?, statusMatricula = ?, statusPagamento = ?, idAluno = ?, idCurso = ? WHERE idMatriculaArtes = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUpdate);) {

			st.setString(1, to.getData());
			st.setDouble(2, to.getValor());
			st.setString(3, to.getStatusMatricula());
			st.setString(4, to.getStatusPagamento());
			st.setInt(5, to.getIdAluno());
			st.setInt(6, to.getIdCurso());
			st.setInt(7, to.getId());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// consultaPorCodigo
	public MatriculaArtesTO consultar(int id) {
		MatriculaArtesTO to = new MatriculaArtesTO();

		String sqlSelect = "SELECT * FROM MatriculaArtes WHERE idMatriculaArtes = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlSelect);) {

			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery();) {

				if (rs.next()) {
					to.setData(rs.getString("dataMatricula"));
					to.setValor(rs.getDouble("valor"));
					to.setStatusMatricula(rs.getString("statusMatricula"));
					to.setStatusPagamento(rs.getString("statusPagamento"));
					to.setIdAluno(rs.getInt("idAluno"));
					to.setIdCurso(rs.getInt("idCurso"));
				} // fim do if
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}// fim do m�todo consulta por c�digo

	public void deletar(MatriculaArtesTO to) {

		String sqlDelete = "DELETE FROM MatriculaArtes WHERE idMatriculaArtes = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlDelete);) {

			st.setInt(1, to.getId());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
