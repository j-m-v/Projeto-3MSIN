package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.CursoInformaticaTO;
import factory.ConnectionFactory;

public class CursoInformaticaDAO {

	// incluir
	public void incluir(CursoInformaticaTO to) {
		String sqlInsert = "INSERT INTO CursoInformatica (nomeInformatica, dataInicio, dataTermino, horario, vagas, valor, softwares, numLab ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlInsert);) {

			st.setString(1, to.getNome());
			st.setString(2, to.getDataInicio());
			st.setString(3, to.getDataTermino());
			st.setString(4, to.getHorario());
			st.setInt(5, to.getVagas());
			st.setDouble(6, to.getValor());
			st.setString(7, to.getSoftwares());
			st.setString(8, to.getNumeroLaboratorio());
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

	// alterar
	public void alterar(CursoInformaticaTO to) {
		String sqlUpdate = "UPDATE CursoInformatica SET nomeInformatica = ?, dataInicio = ?, dataTermino = ?, horario = ?, vagas = ?, valor = ?, softwares = ?, numLab = ? WHERE idInformatica = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUpdate);) {

			st.setString(1, to.getNome());
			st.setString(2, to.getDataInicio());
			st.setString(3, to.getDataTermino());
			st.setString(4, to.getHorario());
			st.setInt(5, to.getVagas());
			st.setDouble(6, to.getValor());
			st.setString(7, to.getSoftwares());
			st.setString(8, to.getNumeroLaboratorio());
			st.setInt(9, to.getId());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// consultaPorCodigo
	public CursoInformaticaTO consultar(int id) {
		CursoInformaticaTO to = new CursoInformaticaTO();

		String sqlSelect = "SELECT * FROM CursoInformatica WHERE idInformatica = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlSelect);) {

			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery();) {

				if (rs.next()) {
					to.setNome(rs.getString("nomeInformatica"));
					to.setDataInicio(rs.getString("dataInicio"));
					to.setDataTermino(rs.getString("dataTermino"));
					to.setHorario(rs.getString("horario"));
					to.setVagas(rs.getInt("vagas"));
					to.setValor(rs.getDouble("valor"));
					to.setSoftwares(rs.getString("softwares"));
					to.setNumeroLaboratorio(rs.getString("numLab"));

				} // fim do if
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}// fim do método consulta por código

	public void deletar(CursoInformaticaTO to) {

		String sqlDelete = "DELETE FROM CursoInformatica WHERE idInformatica = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlDelete);) {

			st.setInt(1, to.getId());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}// fim da classe
