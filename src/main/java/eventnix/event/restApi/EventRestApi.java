package eventnix.event.restApi;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import eventnix.event.bean.EventBeanI;

@Path("/event")
public class EventRestApi {
	
	@EJB
	private  EventBeanI eventBean;
	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response list(){
		String f = "f";
		return Response.ok().entity(eventBean.listInJson()).build();
		
	}

}
