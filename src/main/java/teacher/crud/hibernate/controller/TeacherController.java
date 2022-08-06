package teacher.crud.hibernate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher.crud.hibernate.beans.Teacher;
import teacher.crud.hibernate.dao.TeacherDAO;
import teacher.crud.hibernate.dao.TeacherDAOImpl;


@WebServlet("/TeacherController")
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TeacherDAO teacherDAO = null;       
    
    public TeacherController() {
        super();        
    }
    
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	
    	teacherDAO = new TeacherDAOImpl();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/add":
			addNewTeacher(request, response);
			break;

		case "/update":	
			updateTeacher(request, response);
			break;	
			
		case "/delete":		
			deleteTeacher(request, response);
			break;
			
		case "/list":	
			getAllTeachers(request, response);
			break;	
			
		case "/get":	
			getTeacher(request, response);
			break;
			
			
		default:
			getAllTeachers(request, response);
			break;
		}		
	}

	private void getTeacher(HttpServletRequest request, HttpServletResponse response) {
		int idTeacher = Integer.parseInt(request.getParameter("idTeacher"));
		
		Teacher teacher = teacherDAO.getTeacher(idTeacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teachers.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}		
	}

	private void getAllTeachers(HttpServletRequest request, HttpServletResponse response) {
		List<Teacher> teachers = teacherDAO.getAllTeachers();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teachers.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}	
	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) {
		int idTeacher = Integer.parseInt(request.getParameter("idTeacher"));
		
		teacherDAO.deleteTeacher(idTeacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teachers.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}			
	}

	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) {
		int idTeacher = Integer.parseInt(request.getParameter("idTeacher"));
		
		String teacherFirstName = request.getParameter("teacherFirstName");
		String teacherLastName = request.getParameter("teacherLastName");
		int teacherRank = Integer.parseInt("teacherRank");
		double teacherSalary = Double.parseDouble("teacherSalary");
		String teacherSubjectTaught = request.getParameter("teacherSubjectTaught");
		
		Teacher teacher = new Teacher(idTeacher, teacherFirstName, teacherLastName, teacherRank, teacherSalary, teacherSubjectTaught);
		teacherDAO.updateTeacher(teacher);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teachers.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}			
	}

	private void addNewTeacher(HttpServletRequest request, HttpServletResponse response) {
		
		String teacherFirstName = request.getParameter("teacherFirstName");
		String teacherLastName = request.getParameter("teacherLastName");
		int teacherRank = Integer.parseInt("teacherRank");
		double teacherSalary = Double.parseDouble("teacherSalary");
		String teacherSubjectTaught = request.getParameter("teacherSubjectTaught");
		
		Teacher teacher = new Teacher(teacherFirstName, teacherLastName, teacherRank, teacherSalary, teacherSubjectTaught);
		teacherDAO.addTeacher(teacher);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teachers.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}			
	}
}
