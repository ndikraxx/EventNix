package eventnix.person.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eventnix.common.model.Address;
import eventnix.common.model.Login;
import eventnix.person.bean.PersonBeanI;
import eventnix.person.model.Person;

@WebServlet("/login/*")


public class LoginA extends HttpServlet {
	private static final long serialVersionUID = 1L;


@EJB
PersonBeanI personBean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Welcome all");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person person = new Person ();
		 person.setFirstName(request.getParameter("firstname"));
		 person.setLastName(request.getParameter("lastname"));
		 
		 person.setLogin(new Login());
		 person.getLogin().setUsername(request.getParameter("username"));
		 person.getLogin().setPassword(request.getParameter("password"));
		 person.getLogin().setUserType(request.getParameter("usertype"));

		 person.setAddress(new Address());
		 person.getAddress().setEmail(request.getParameter("email"));
		 person.getAddress().setPhoneNumber(request.getParameter("phone"));
		 
		 personBean.save(person);
	}

}
