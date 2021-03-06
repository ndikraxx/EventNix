package eventnix.person.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import eventnix.common.model.Address;
import eventnix.common.model.Login;
import eventnix.person.bean.PersonBeanI;
import eventnix.person.model.Person;

@WebServlet("/register")


public class RegisterAction extends HttpServlet {
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
		
		
		 String password = request.getParameter("password");
		 String hashedPass ="";
		 try {
			 hashedPass = hashPassword(password);
		} catch (NoSuchAlgorithmException e) {
		
			e.printStackTrace();
		}
		 
		 person.setFirstName(request.getParameter("firstname"));
		 person.setLastName(request.getParameter("lastname"));
		 person.setPassword(hashedPass);
		 person.setUserType(request.getParameter("usertype"));
		 person.setIdentification(request.getParameter("id"));
		 person.setEmail(request.getParameter("email"));
		 person.setPhoneNumber(request.getParameter("phone"));
		 
		personBean.save(person);
	}
	public static String hashPassword(String password)
			throws NoSuchAlgorithmException{
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(password.getBytes());
				byte [] b = md.digest();
				StringBuffer sb = new StringBuffer();
				for (byte b1 : b) {
					sb.append(Integer.toHexString(b1 & 0xff).toString());
				}
				return sb.toString();
				
			}

}
