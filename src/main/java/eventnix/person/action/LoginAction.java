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
import javax.servlet.http.HttpSession;

import eventnix.person.bean.PersonBeanI;
import eventnix.person.model.Person;


@WebServlet("/login/*")
public class LoginAction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	PersonBeanI personBean;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
PrintWriter out = response.getWriter();
		
		String comp [] = request.getRequestURI().split("/");
		
		String path = comp [comp.length-1];
		
		if (path.equalsIgnoreCase("userEvent")){
			
			HttpSession session = request.getSession();
			
			int id =  Integer.parseInt(session.getAttribute("uid").toString());
			
			System.out.println(personBean.attendersListJSON(id));
			
			out.println(personBean.attendersListJSON(id));
		}
			
		else{
			HttpSession session = request.getSession();
			
			session.invalidate();
			
		    response.sendRedirect("login.jsp");
		    
		    return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phone = request.getParameter("phone");
		
		String password = request.getParameter("password");
		
		String hashedPass = "";
		
		try {
			
			hashedPass = hashPassword(password);
			
		} catch (NoSuchAlgorithmException e1) {

			e1.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		
		boolean login = personBean.loginStatus(phone, hashedPass);
		
		

		try{
			if (login == true) {
				
				String uType = personBean.userType(phone, hashedPass).toString();
				
				String lastName = personBean.lastName(phone, hashedPass).toString();
				
				HttpSession session = request.getSession();
				
				session.setAttribute("sessionLname", lastName);
				session.setAttribute("userType", uType);
				 session.setMaxInactiveInterval(1800000);
				
				String uid = personBean.userId(phone, hashedPass);
				
				session.setAttribute("uid", uid);
				
				if("Attender".equals(uType)){
					
					out.println("index.jsp");
					
				}
				else if ("Organizer".equals(uType)){
					
					out.println("organizer.jsp");
					
				}
				else if ("Admin".equals(uType)){
					
					out.println("admin.jsp");
					
				}	
			}
		
			else if (login == false) {

				out.println("login1.jsp");
			}
		}
		catch (Exception e){
			
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