package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.CursoArtesTO;
import factory.ConnectionFactory;

public class CursoArtesDAO {

	private String dados[][];

	// incluir
	public void incluir(CursoArtesTO to) {

		String sqlInsert = "INSERT INTO Artes (nomeCurso, dataInicio, dataTermino, horarioPrevisto, numeroDeVagas, valorCurso, livros, descricaoMaterial ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlInsert);) {
			st.setString(1, to.getNomeArtes());
			st.setString(2, to.getDataInicio());
			st.setString(3, to.getDataTermino());
			st.setString(4, to.getHorarioPrevisto());
			st.setInt(5, to.getNumeroVagas());
			st.setDouble(6, to.getValorCurso());
			st.setString(7, to.getLivros());
			st.setString(8, to.getDescricaoMaterial());
			st.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						to.setCodigoArtes(rs.getInt(1));
					}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// alterar
	public void alterar(CursoArtesTO to) {

		String sqlUpdate = "UPDATE Artes SET nomeCurso = ?, dataInicio = ?, dataTermino = ?, horarioPrevisto = ?, numeroDeVagas = ?, valorCurso = ?, livros = ?, descricaoMaterial = ? WHERE codigoCursoArt = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUpdate);) {

			st.setString(1, to.getNomeArtes());
			st.setString(2, to.getDataInicio());
			st.setString(3, to.getDataTermino());
			st.setString(4, to.getHorarioPrevisto());
			st.setInt(5, to.getNumeroVagas());
			st.setDouble(6, to.getValorCurso());
			st.setString(7, to.getLivros());
			st.setString(8, to.getDescricaoMaterial());
			st.setInt(9, to.getCodigoArtes());
			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// consultaPorCodigo
	public CursoArtesTO consultar(int id) {
		CursoArtesTO to = new CursoArtesTO();

		String sqlSelect = "SELECT * FROM Artes WHERE codigoCursoArt = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlSelect);) {

			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					to.setNomeArtes(rs.getString("nomeCurso"));
					to.setDataInicio(rs.getString("dataInicio"));
					to.setDataTermino(rs.getString("dataTermino"));
					to.setHorarioPrevisto(rs.getString("horarioPrevisto"));
					to.setNumeroVagas(rs.getInt("numeroDeVagas"));
					to.setValorCurso(rs.getDouble("valorCurso"));
					to.setLivros(rs.getString("livros"));
					to.setDescricaoMaterial(rs.getString("descricaoMaterial"));
				} // fim do if

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}

	public void deletar(CursoArtesTO to) {

		String sqlDelete = "DELETE FROM Artes WHERE codigoCursoArt = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlDelete);) {

			st.setInt(1, to.getCodigoArtes());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// listar todos cursos
	public String[][] consultarTodos() {
		int codigo = 0;
		int numeroVagas = 0;
		double valorCurso = 0;
		String nomeArtes, dataIni, dataTer, horarioPrevisto, livros, descricaoMaterial;

		String sqlTable = "SELECT * FROM Artes ORDER BY codigoCursoArt";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlTable);) {

			try (ResultSet rs = st.executeQuery();) {
				int linha = 0;

				while (rs.next()) {
					codigo = rs.getInt("codigoCursoArt");
					nomeArtes = rs.getString("nomeCurso");
					dataIni = rs.getString("dataInicio");
					dataTer = rs.getString("dataTermino");
					horarioPrevisto = rs.getString("horarioPrevisto");
					numeroVagas = rs.getInt("numeroDeVagas");
					valorCurso = rs.getDouble("valorCurso");
					livros = rs.getString("livros");
					descricaoMaterial = rs.getString("descricaoMaterial");

					dados[linha][0] = String.valueOf(codigo);
					dados[linha][1] = String.valueOf(nomeArtes);
					dados[linha][2] = String.valueOf(dataIni);
					dados[linha][3] = String.valueOf(dataTer);
					dados[linha][4] = String.valueOf(horarioPrevisto);
					dados[linha][5] = String.valueOf(numeroVagas);
					dados[linha][6] = String.valueOf(valorCurso);
					dados[linha][7] = String.valueOf(livros);
					dados[linha][8] = String.valueOf(descricaoMaterial);

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

		String sqlUltimoID = " SELECT MAX(codigoCursoArt) AS codigoCursoArt from Artes";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUltimoID);) {

			try (ResultSet rs = st.executeQuery();) {

				if (rs.next()) {
					cod = rs.getInt("codigoCursoArt");
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
