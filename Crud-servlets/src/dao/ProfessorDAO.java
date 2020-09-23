package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.Professor;
import util.ConnectionFactory;

public class ProfessorDAO {
	private Connection conn;
	private PreparedStatement ps;
	

	public ProfessorDAO() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// método de salvar

	public void salvar(Professor prof) throws Exception {
		if (prof == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO tbProfessor (nomeProfessor, "
					+ "pisProfessor, pasepProfessor) "
					+ "values (?, ?, ?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, prof.getNomeProfessor());
			ps.setInt(2, prof.getPisProfessor());
			ps.setInt(3, prof.getPasepProfessor());
			
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

	}
	
	
	public Professor excluirProfessor(String nomeProfessor) throws Exception {
		try {	

			String SQL = "DELETE FROM tbProfessor WHERE `nomeProfessor` = ?";

			ps = this.conn.prepareStatement(SQL);
			ps.setString(1, nomeProfessor);			
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new Exception("Erro ao deletar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
		return null;
	}	



	

	public List<Professor> listar() throws Exception {
		List<Professor> listaProfessor = new ArrayList<Professor>();
		try {
			String SQL = "Select * from tbProfessor";

			ps = this.conn.prepareStatement(SQL);
			ResultSet dados = ps.executeQuery();
			while(dados.next()){
				Professor prof = new Professor();
				prof.setNomeProfessor(dados.getString("nomeProfessor"));
				prof.setPisProfessor(dados.getInt("pisProfessor"));
				prof.setPasepProfessor(dados.getInt("pasepProfessor"));
				
				listaProfessor.add(prof);
			}

		} catch (SQLException sqle) {
			throw new Exception("Erro ao listar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
		return listaProfessor;
	}

	
	
	public List<Professor> listarProfessorLike(String nomeProfessor) throws Exception {
		List<Professor> listaProfessor = new ArrayList<Professor>();
		Professor prof = new Professor();
		try {
			String SQL = "Select * from tbProfessor Where nomeProfessor like ' "+nomeProfessor+  " %'   " ;

			ps = this.conn.prepareStatement(SQL);
			ResultSet dados = ps.executeQuery();
			while(dados.next()){
			
				prof.setNomeProfessor(dados.getString("nomeProfessor"));
				prof.setPisProfessor(dados.getInt("pisProfessor"));
				prof.setPasepProfessor(dados.getInt("pasepProfessor"));

				listaProfessor.add(prof);
			}

		} catch (SQLException sqle) {
			throw new Exception("Erro ao listar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
		return listaProfessor;
	}

	
	
	public Professor listarProfessor(String prof)throws Exception{
		Professor professor = new Professor();	
		try {
			String SQL = "Select * from tbProfessor Where nomeProfessor = "+prof;
			ps = this.conn.prepareStatement(SQL);
			ResultSet dados = ps.executeQuery();
			while(dados.next()){				
				professor.setNomeProfessor(dados.getString("nomeProfessor"));
				professor.setPisProfessor(dados.getInt("pisProfessor"));
				professor.setPasepProfessor(dados.getInt("pasepProfessor"));
								
			}

		} catch (SQLException sqle) {
			throw new Exception("Erro ao listar dados do aluno " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
		return professor;
	}
	
	
	
	
	public void atualizar(Professor prof) throws Exception {
		if (prof == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {

			String SQL = "UPDATE tbProfessor SET "
					+ "`nomeProfessor` = ?, "
					+ "`pisProfessor` = ?, "
					+ "`pasepProfessor` = ? " 
					+ "WHERE `nomeProfessor` = ? ";

			ps = this.conn.prepareStatement(SQL);
			ps.setString(1, prof.getNomeProfessor());
			ps.setInt(2, prof.getPisProfessor());
			ps.setInt(3, prof.getPasepProfessor());
			ps.setString(4, prof.getNomeProfessor());
			
			System.out.println(ps.toString());
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new Exception("Erro ao atualizar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	}
	
	


