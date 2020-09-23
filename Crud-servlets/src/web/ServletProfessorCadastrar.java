package web;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import bean.Professor;
import dao.ProfessorDAO;


@WebServlet("/incluir.professor")

public class ServletProfessorCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ServletProfessorCadastrar() {
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
	
		
		//aluno sets valores
		prof.setNomeProfessor(request.getParameter("nomeProfessor"));
		prof.setPisProfessor(Integer.parseInt(request.getParameter("pisProfessor")));
		prof.setPasepProfessor(Integer.parseInt(request.getParameter("pasepProfessor")));
	

		try {
			ProfessorDAO ProfDAO = new ProfessorDAO();
			ProfDAO.salvar(prof); 	


		} catch (Exception e) {
			e.printStackTrace();
		}
          
	     
		
			
		request.setAttribute("mensagem", "Cadastrou Professor: "+request.getParameter("nomeProfessor")); 
		RequestDispatcher rd = request.getRequestDispatcher("incluir.jsp"); 
		rd.forward(request, response); 
		}
			
		
		
	}
