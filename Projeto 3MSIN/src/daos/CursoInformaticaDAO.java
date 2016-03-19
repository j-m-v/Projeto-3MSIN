package daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.CursoInformaticaTO;

public class CursoInformaticaDAO {

	private String dados[][];

	// incluir
	public void incluir(CursoInformaticaTO to) {
		String sqlInsert = "INSERT INTO Informatica (codigoCursoInfo, nomeCurso, dataInicio, dataTermino, horarioPrevisto, numeroDeVagas, valorCurso, descricaoSoftware, numeroLaboratorios ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlInsert);) {

			st.setInt(1, to.getCodigoInformatica());
			st.setString(2, to.getNome());
			st.setString(3, to.getDataInicio());
			st.setString(4, to.getDataTermino());
			st.setString(5, to.getHorarioPrevisto());
			st.setInt(6, to.getNumeroVagas());
			st.setDouble(7, to.getValorCurso());
			st.setString(8, to.getSoftwares());
			st.setString(9, to.getNumeroLaboratorios());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// alterar
	public void alterar(CursoInformaticaTO to) {
		String sqlUpdate = "UPDATE Informatica SET nomeCurso = ?, dataInicio = ?, dataTermino = ?, horarioPrevisto = ?, numeroDeVagas = ?, valorCurso = ?, descricaoSoftware = ?, numeroLaboratorios = ? WHERE codigoCursoInfo = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUpdate);) {

			st.setString(1, to.getNome());
			st.setString(2, to.getDataInicio());
			st.setString(3, to.getDataTermino());
			st.setString(4, to.getHorarioPrevisto());
			st.setInt(5, to.getNumeroVagas());
			st.setDouble(6, to.getValorCurso());
			st.setString(7, to.getSoftwares());
			st.setString(8, to.getNumeroLaboratorios());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// consultaPorCodigo
	public CursoInformaticaTO consultar(int id) {
		CursoInformaticaTO to = new CursoInformaticaTO();

		String sqlSelect = "SELECT * FROM Informatica WHERE codigoCursoInfo = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlSelect);) {

			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery();) {

				if (rs.next()) {
					to.setNome(rs.getString("nomeCurso"));
					to.setDataInicio(rs.getString("dataInicio"));
					to.setDataTermino(rs.getString("dataTermino"));
					to.setHorarioPrevisto(rs.getString("horarioPrevisto"));
					to.setNumeroVagas(rs.getInt("numeroDeVagas"));
					to.setValorCurso(rs.getDouble("valorCurso"));
					to.setSoftwares(rs.getString("descricaoSoftware"));
					to.setNumeroLaboratorios(rs.getString("numeroLaboratorios"));

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

		String sqlDelete = "DELETE FROM Informatica WHERE codigoCursoInfo = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlDelete);) {

			st.setInt(1, to.getCodigoInformatica());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String[][] consultarTodos() {

		int codigo = 0;
		int numeroVagas = 0;
		double valorCurso = 0;
		int laboratorio = 0;
		String nomeInfo, dataIni, dataTer, horarioPrevisto, softwares;

		String sqlSelect = "SELECT * FROM Informatica ORDER BY codigoCursoInfo";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = st.executeQuery();) {

				int linha = 0;

				while (rs.next()) {

					codigo = rs.getInt("codigoCursoInfo");
					nomeInfo = rs.getString("nomeCurso");
					dataIni = rs.getString("dataInicio");
					dataTer = rs.getString("dataTermino");
					horarioPrevisto = rs.getString("horarioPrevisto");
					numeroVagas = rs.getInt("numeroDeVagas");
					valorCurso = rs.getDouble("valorCurso");
					softwares = rs.getString("descricaoSoftware");
					laboratorio = rs.getInt("numeroLaboratorios");

					dados[linha][0] = String.valueOf(codigo);
					dados[linha][1] = String.valueOf(nomeInfo);
					dados[linha][2] = String.valueOf(dataIni);
					dados[linha][3] = String.valueOf(dataTer);
					dados[linha][4] = String.valueOf(horarioPrevisto);
					dados[linha][5] = String.valueOf(numeroVagas);
					dados[linha][6] = String.valueOf(valorCurso);
					dados[linha][7] = String.valueOf(softwares);
					dados[linha][8] = String.valueOf(laboratorio);

					linha++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return dados;
	}

	// método para retornar o id do último curso cadastrado
	public int retornarUltimoID() {

		int cod = 0;

		String sqlUltimoID = " SELECT MAX(codigoCursoInfo) AS codigoCursoInfo from Informatica ";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUltimoID);) {

			try (ResultSet rs = st.executeQuery();) {

				if (rs.next()) {
					cod = rs.getInt("getCodigoInformatica");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return cod;
	}
}// fim da classe
