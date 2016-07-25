package eventnix.event.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.jar.Attributes.Name;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import eventnix.event.bean.EventBeanI;
import eventnix.event.model.Event;

@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize = 16177215)
public class FileUpload extends HttpServlet {

	@EJB
	private EventBeanI eventBean;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	};

	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

		fileUpload(request, response);
	}

	public void fileUpload(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			ServletFileUpload upload = new ServletFileUpload();
			try {

				String name = null, venue = null, ticketNumber = null, price = null, start = null, end = null, category = null, userId = null, imageName = null;
				userId = request.getSession().getAttribute("uid").toString();
				String descript = null;
				FileItemIterator itr = upload.getItemIterator(request);
				while (itr.hasNext()) {
					FileItemStream item = itr.next();
					if (item.isFormField()) {

						String fieldName = item.getFieldName();
						InputStream is = item.openStream();
						byte[] b = new byte[is.available()];
						is.read(b);
						String value = new String(b);

						response.getWriter().println(
								fieldName + ":" + value + "</br>");
						if (fieldName.equals("name")) {
							name = value.toString();

						} else if (fieldName.equals("venue")) {
							venue = value.toString();
						}

						else if (fieldName.equals("ticketNumber")) {
							ticketNumber = value.toString();
						} else if (fieldName.equals("price")) {
							price = value.toString();

						} else if (fieldName.equals("start_date_time")) {
							start = value.toString();
						} else if (fieldName.equals("end_date_time")) {
							end = value.toString();
						} else if (fieldName.equals("description")) {
							descript = value.toString();

						} else if (fieldName.equals("category")) {
							category = value.toString();
						}

					}

					else {

						String path = getServletContext().getRealPath("/");

						if (Upload.processFile(path, item)) {

							response.getWriter().println("File uploaded ");
							imageName = item.getName().toString();
							Event event = new Event();
							event.setName(name);
							event.setPrice(price);
							event.setTickets(Integer.parseInt(ticketNumber));
							event.setCategory(category);
							event.setVenue(venue);
							event.setStartDateTime(start);
							event.setEndDateTime(end);
							event.setImageName(imageName);
							event.setDescription(descript);
							event.setUserId(Long.parseLong(userId));
							DateFormat simDateFormat = new SimpleDateFormat(
									"yyyy/MM/dd HH:mm:ss");
							Date date = new Date();
							event.setPostedDateTime(simDateFormat.format(date));
							eventBean.save(event);
						} else {
							response.getWriter().println("File failed");
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
	}

}