package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import to.CursoArtesTO;
import factory.ConnectionFactory;

public class CursoArtesDAO {

	// incluir
	public void incluir(CursoArtesTO to) {

		String sqlInsert = "INSERT INTO CursoArtes (nomeArtes, dataInicio, dataTermino, horario, vagas, valor, livros, material ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlInsert);) {
			st.setString(1, to.getNome());
			st.setString(2, to.getDataInicio());
			st.setString(3, to.getDataTermino());
			st.setString(4, to.getHorario());
			st.setInt(5, to.getVagas());
			st.setDouble(6, to.getValor());
			st.setString(7, to.getLivros());
			st.setString(8, to.getDescricaoMaterial());
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
	public void alterar(CursoArtesTO to) {

		String sqlUpdate = "UPDATE CursoArtes SET nomeArtes = ?, dataInicio = ?, dataTermino = ?, horario = ?, vagas = ?, valor = ?, livros = ?, material = ? WHERE idArtes = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlUpdate);) {

			st.setString(1, to.getNome());
			st.setString(2, to.getDataInicio());
			st.setString(3, to.getDataTermino());
			st.setString(4, to.getHorario());
			st.setInt(5, to.getVagas());
			st.setDouble(6, to.getValor());
			st.setString(7, to.getLivros());
			st.setString(8, to.getDescricaoMaterial());
			st.setInt(9, to.getId());
			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// consultaPorCodigo
	public CursoArtesTO consultar(int id) {
		CursoArtesTO to = new CursoArtesTO();

		String sqlSelect = "SELECT * FROM CursoArtes WHERE idArtes = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlSelect);) {

			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nomeArtes"));
					to.setDataInicio(rs.getString("dataInicio"));
					to.setDataTermino(rs.getString("dataTermino"));
					to.setHorario(rs.getString("horario"));
					to.setVagas(rs.getInt("vagas"));
					to.setValor(rs.getDouble("valor"));
					to.setLivros(rs.getString("livros"));
					to.setDescricaoMaterial(rs.getString("material"));
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

		String sqlDelete = "DELETE FROM CursoArtes WHERE idArtes = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement st = conn.prepareStatement(sqlDelete);) {

			st.setInt(1, to.getId());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<CursoArtesTO> listarCursos() {
		CursoArtesTO to;
		ArrayList<CursoArtesTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM CursoArtes";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					to = new CursoArtesTO();
					to.setId(rs.getInt("idArtes"));
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
		return lista;
	}

	public ArrayList<CursoArtesTO> listarCursos(String chave) {
		CursoArtesTO to;
		ArrayList<CursoArtesTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM CursoArtes where upper(nomeArtes) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					to = new CursoArtesTO();
					to.setId(rs.getInt("idArtes"));
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
		return lista;
	}
	
	
	
}// fim da classe
