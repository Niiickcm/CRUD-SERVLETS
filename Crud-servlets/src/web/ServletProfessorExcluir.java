package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Professor;
import dao.ProfessorDAO;


@WebServlet("/excluir.professor")
public class ServletProfessorExcluir extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ServletProfessorExcluir() {
		super();
	} 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//criando o objeto aluno
		Professor prof = new Professor();
		
		try {
			String nomeProf = (request.getParameter("nomeProfessor"));
			ProfessorDAO profDAO = new ProfessorDAO();
			prof = profDAO.excluirProfessor(nomeProf);		

		} catch (Exception e) {
			e.printStackTrace();
		}			 
		
		request.setAttribute("mensagem", "Excluiu Professor : "+request.getParameter("nomeProfessor")); 
		RequestDispatcher rd = request.getRequestDispatcher("excluir.jsp"); 
		rd.forward(request, response); 
	}
}