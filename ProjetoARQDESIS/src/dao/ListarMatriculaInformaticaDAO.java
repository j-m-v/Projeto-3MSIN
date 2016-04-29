package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import to.ListaMatriculaInformaticaTO;
import to.MatriculaInformaticaTO;

public class ListarMatriculaInformaticaDAO {
	
	public ListaMatriculaInformaticaTO listarMatriculas() {
		MatriculaInformaticaTO to;
		ArrayList<MatriculaInformaticaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT matri.idMatriculaInformatica, alu.nome, inf.nomeInformatica, matri.dataMatricula, matri.valor, matri.statusMatricula, matri.statusPagamento " +
			                "FROM MatriculaInformatica matri " + 
			                "INNER JOIN Aluno alu ON alu.idAluno = matri.idAluno " + 
			                "INNER JOIN CursoInformatica inf ON inf.idInformatica  = matri.idCurso";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new MatriculaInformaticaTO();
					to.setId(rs.getInt("matri.idMatriculaInformatica"));
					to.setNomeAluno(rs.getString("alu.nome"));
					to.setNomeCurso(rs.getString("inf.nomeInformatica"));
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
		ListaMatriculaInformaticaTO lma = new ListaMatriculaInformaticaTO();
		lma.setMatriculaInformatica(lista);
		return lma;
	}
	
	public ListaMatriculaInformaticaTO listarMatriculas(String chave) {
		MatriculaInformaticaTO to;
		ArrayList<MatriculaInformaticaTO> lista = new ArrayList<>();
		String sqlSelect = "SELECT matri.idMatriculaInformatica, alu.nome, inf.nomeInformatica, matri.dataMatricula, matri.valor, matri.statusMatricula, matri.statusPagamento " +
			                "FROM MatriculaInformatica matri " + 
			                "INNER JOIN Aluno alu ON alu.idAluno = matri.idAluno " + 
			                "INNER JOIN CursoInformatica inf ON inf.idInformatica  = matri.idCurso WHERE UPPER(inf.nomeInformatica) LIKE ? " +
                            "OR UPPER(alu.nome) LIKE ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new MatriculaInformaticaTO();
					to.setId(rs.getInt("matri.idMatriculaInformatica"));
					to.setNomeAluno(rs.getString("alu.nome"));
					to.setNomeCurso(rs.getString("inf.nomeInformatica"));
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
		ListaMatriculaInformaticaTO lma = new ListaMatriculaInformaticaTO();
		lma.setMatriculaInformatica(lista);
		return lma;
	}

}
