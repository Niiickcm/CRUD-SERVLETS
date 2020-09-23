package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import bean.Professor;
import dao.ProfessorDAO;


@WebServlet("/listar.professor")

public class ServletProfessorListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletProfessorListar() {
		super();
	} 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<style>\r\n" + 
				"table {\r\n" + 
				"  font-family: arial, sans-serif;\r\n" + 
				"  border-collapse: collapse;\r\n" + 
				"  width: 100%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"td, th {\r\n" + 
				"  border: 1px solid #dddddd;\r\n" + 
				"  text-align: left;\r\n" + 
				"  padding: 8px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"tr:nth-child(even) {\r\n" + 
				"  background-color: #dddddd;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body><h2>Lista dos Professores</h2>\r\n" + 
				"\r\n" + 
				"<table>\r\n" + 
				"  <tr>\r\n" + 
				"    <th>Nome</th>\r\n" + 
				"    <th>Pis</th>\r\n" + 
				"    <th>Pasep</th>\r\n" + 
				"  </tr>");

		List<Professor> listaProfessor = new ArrayList<Professor>();

		try {
			ProfessorDAO profDAO = new ProfessorDAO();
			listaProfessor =  profDAO.listar();	

			for(int i=0;i < listaProfessor.size();i++){
				Professor prof = new Professor();
				prof = listaProfessor.get(i);
				out.println(" <tr>\r\n" + 
						"    <td>"+prof.getNomeProfessor()+"</td>\r\n" + 
						"    <td>"+prof.getPisProfessor()+"</td>\r\n" + 
						"    <td>"+prof.getPasepProfessor()+"</td>\r\n" + 
						"  </tr>");
			}

			out.println("</table>\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"</html>");

		} catch (Exception e) {
			e.printStackTrace();
		}

		out.close();
	}
}