package net.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.java.dao.PersonDao;
import net.java.model.Person;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/register")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PersonDao personDao = new PersonDao();
	
    /**
     * Default constructor. 
     */
    public PersonServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/personregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String name = request.getParameter("Name");
		int age = Integer.parseInt(request.getParameter("Age"));
		String message = request.getParameter("Message");
		
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		person.setMessage(message);
		
		try {
			personDao.registerPerson(person);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/personDetail.jsp");
		dispatcher.forward(request, response);
		
	}

}
