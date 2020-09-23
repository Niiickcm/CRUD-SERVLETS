package web;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Professor;
import dao.ProfessorDAO;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Professor;
import dao.ProfessorDAO;


@WebServlet("/atualizar.professor")

public class ServletProfessorAtualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ServletProfessorAtualizar() {
		super();
	} 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//criando o objeto aluno
		Professor profBusca = new Professor();
		Professor profSalvo = new Professor();

		// recebendo qual botão foi clicado
		String botaoClicado = request.getParameter("enviar");

		//recebendo o CA do aluno
		String prof = request.getParameter("prof");


		if(botaoClicado.equals("buscar")) {
			try {				
				ProfessorDAO ProfDAO = new ProfessorDAO();
				profBusca = ProfDAO.listarProfessor(prof);
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("mensagem0", profBusca.getNomeProfessor());
			request.setAttribute("mensagem1", profBusca.getPisProfessor());
			request.setAttribute("mensagem2", profBusca.getPasepProfessor());

			RequestDispatcher rd = request.getRequestDispatcher("alterar.jsp"); 
			rd.forward(request, response); 

		}else if (botaoClicado.equals("salvar")){

			try {
				//aluno sets valores
				profSalvo.setNomeProfessor(request.getParameter("nomeProfessor"));
				profSalvo.setPisProfessor(Integer.parseInt(request.getParameter("pisProfessor")));
				profSalvo.setPasepProfessor(Integer.parseInt(request.getParameter("pasepProfessor")));
			
				ProfessorDAO profDAO = new ProfessorDAO();
				profDAO.atualizar(profSalvo); 	

			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("mensagem", "Atualizou o Professor "+request.getParameter("nomeOculto")); 
			RequestDispatcher rd = request.getRequestDispatcher("alterar.jsp"); 
			rd.forward(request, response); 
		}
	}
}