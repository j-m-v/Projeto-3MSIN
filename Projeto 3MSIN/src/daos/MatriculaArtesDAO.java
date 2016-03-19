package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import to.MatriculaArtesTO;

public class MatriculaArtesDAO {
	private String dados[][];

	// incluir
	public void incluir(MatriculaArtesTO to) {

		String sqlInsert = "INSERT INTO MatriculaArtes (dataMatricula, valorMatricula, statusMatricula, statusPagamento, codigoAluno, codigoCursoArt) VALUES (?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlInsert);) {
			st.setString(1, to.getDataMatricula());
			st.setDouble(2, to.getValorMatricula());
			st.setString(3, to.getStatusMatricula());
			st.setString(4, to.getStatusPagamento());
			st.setInt(5, to.getCodigoAluno());
			st.setInt(6, to.getCodigoCurso());
			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(MatriculaArtesTO to) {
		String sqlUpdate = "UPDATE MatriculaArtes SET dataMatricula = ?, valorMatricula = ?, statusMatricula = ?, statusPagamento = ?, codigoAluno = ?, codigoCursoArt = ? WHERE codigoMatricula = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUpdate);) {

			st.setString(1, to.getDataMatricula());
			st.setDouble(2, to.getValorMatricula());
			st.setString(3, to.getStatusMatricula());
			st.setString(4, to.getStatusPagamento());
			st.setInt(5, to.getCodigoAluno());
			st.setInt(6, to.getCodigoCurso());
			st.setInt(7, to.getCodigoMatricula());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// consultaPorCodigo
	public MatriculaArtesTO consultar(int id) {
		MatriculaArtesTO to = new MatriculaArtesTO();

		String sqlSelect = "SELECT * FROM MatriculaArtes WHERE codigoMatricula = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlSelect);) {

			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery();) {

				if (rs.next()) {
					to.setDataMatricula(rs.getString("dataMatricula"));
					to.setValorMatricula(rs.getDouble("valorMatricula"));
					to.setStatusMatricula(rs.getString("statusMatricula"));
					to.setStatusPagamento(rs.getString("statusPagamento"));
					to.setCodigoAluno(rs.getInt("codigoAluno"));
					to.setCodigoCurso(rs.getInt("codigoCursoArt"));
				} // fim do if
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}// fim do método consulta por código

	public void deletar(MatriculaArtesTO to) {

		String sqlDelete = "DELETE FROM MatriculaArtes WHERE codigoMatricula = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlDelete);) {

			st.setInt(1, to.getCodigoMatricula());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String[][] consultarTodos() {
		int codigoAluno = 0;
		int codigoCurso = 0;
		String dataMatricula, statusMatricula, statusPagamento;
		double valorMatricula = 0.0;

		String sqlTable = "SELECT matri.codigoMatricula, alu.nome, art.nomeCurso, matri.valorMatricula, matri.dataMatricula, matri.statusMatricula, matri.statusPagamento FROM MatriculaArtes AS matri INNER JOIN aluno AS alu ON alu.codigoAluno = matri.codigoAluno INNER JOIN Artes AS art ON art.codigoCursoArt  = matri.codigoCursoArt WHERE alu.codigoAluno = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlTable);) {

			try (ResultSet rs = st.executeQuery();) {
				int linha = 0;

				while (rs.next()) {

					codigoAluno = rs.getInt("codigoAluno");
					codigoCurso = rs.getInt("codigoCursoArt");
					dataMatricula = rs.getString("NomeCurso");
					valorMatricula = rs.getDouble("Valor");
					statusMatricula = rs.getString("StatusMatriculas");
					statusPagamento = rs.getString("statusPagamento");

					dados[linha][0] = String.valueOf(codigoAluno);
					dados[linha][1] = String.valueOf(codigoCurso);
					dados[linha][2] = String.valueOf(dataMatricula);
					dados[linha][3] = String.valueOf(valorMatricula);
					dados[linha][4] = String.valueOf(statusMatricula);
					dados[linha][5] = String.valueOf(statusPagamento);
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

	public int retornarUltimoID() {
		int cod = 0;

		String sqlUltimoID = "SELECT MAX(codigoMatricula) AS codigoMatricula from MatriculaArtes";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUltimoID);) {

			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					cod = rs.getInt("codigoMatricula");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return cod;
	}

}
