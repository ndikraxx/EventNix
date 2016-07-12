package eventnix.person.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eventnix.person.bean.PersonBeanI;
import eventnix.person.model.Person;

@WebServlet("/login")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	PersonBeanI personBean;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String hashedPass = "";
		try {
			hashedPass = hashPassword(password);
		} catch (NoSuchAlgorithmException e1) {

			e1.printStackTrace();
		}

		PrintWriter out = response.getWriter();

		boolean login = personBean.loginStatus(username, hashedPass);
		System.out.println("login status is " + login);
		try {
			if (login == true) {
				System.out.println(personBean.userType(username, hashedPass));
				System.out.println(personBean.lastName(username, hashedPass));
				out.println("index.jsp");

			} else if (login == false) {
				
				out.println("login.jsp");
			}
		}

		catch (Exception e) {

		}

	}

	public static String hashPassword(String password)
			throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] b = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b1 : b) {
			sb.append(Integer.toHexString(b1 & 0xff).toString());
		}
		return sb.toString();

	}

}