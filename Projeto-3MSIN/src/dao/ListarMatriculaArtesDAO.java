package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.ListaMatriculaArtesTO;
import to.MatriculaArtesTO;

public class ListarMatriculaArtesDAO {
	
	public ListaMatriculaArtesTO listarMatriculas() {
		MatriculaArtesTO to;
		ArrayList<MatriculaArtesTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT matri.idMatriculaArtes, alu.nome, art.nomeArtes, matri.dataMatricula, matri.valor, matri.statusMatricula, matri.statusPagamento " +
                           "FROM MatriculaArtes matri " + 
                           "INNER JOIN Aluno alu ON alu.idAluno = matri.idAluno " + 
                           "INNER JOIN CursoArtes art ON art.idArtes  = matri.idCurso";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new MatriculaArtesTO();
					to.setId(rs.getInt("matri.idMatriculaArtes"));
					to.setNomeAluno(rs.getString("alu.nome"));
					to.setNomeCurso(rs.getString("art.nomeArtes"));
					to.setData(rs.getString("matri.dataMatricula"));
					to.setValor(rs.getDouble("matri.valor"));
					to.setStatusMatricula(rs.getString("matri.statusMatricula"));
					to.setStatusPagamento(rs.getString("matri.statusPagamento"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		ListaMatriculaArtesTO lma = new ListaMatriculaArtesTO();
		lma.setMatriculaArtes(lista);
		return lma;
	}
	
	public ListaMatriculaArtesTO listarMatriculas(String chave) {
		MatriculaArtesTO to;
		ArrayList<MatriculaArtesTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT matri.idMatriculaArtes, alu.nome, art.nomeArtes, matri.dataMatricula, matri.valor, matri.statusMatricula, matri.statusPagamento " +
                           "FROM MatriculaArtes matri " + 
                           "INNER JOIN Aluno alu ON alu.idAluno = matri.idAluno " + 
                           "INNER JOIN CursoArtes art ON art.idArtes  = matri.idCurso WHERE UPPER(art.nomeArtes) LIKE ? " +
                           "OR UPPER(alu.nome) LIKE ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			stm.setString(2, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new MatriculaArtesTO();
					to.setId(rs.getInt("matri.idMatriculaArtes"));
					to.setNomeAluno(rs.getString("alu.nome"));
					to.setNomeCurso(rs.getString("art.nomeArtes"));
					to.setData(rs.getString("matri.dataMatricula"));
					to.setValor(rs.getDouble("matri.valor"));
					to.setStatusMatricula(rs.getString("matri.statusMatricula"));
					to.setStatusPagamento(rs.getString("matri.statusPagamento"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		ListaMatriculaArtesTO lma = new ListaMatriculaArtesTO();
		lma.setMatriculaArtes(lista);
		return lma;
	}

}
