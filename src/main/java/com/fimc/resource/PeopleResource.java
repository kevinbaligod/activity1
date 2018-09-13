package com.fimc.resource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Path("/people")
public class PeopleResource {
	
	PeopleResponse peopleResponse = new PeopleResponse();
	List<PeopleResponse> peopleResponseList = new ArrayList<PeopleResponse>();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response people(List<PeopleRequest> peopleRequest) {
	
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		
		for (int i = 0; i < peopleRequest.size(); i++) {
			if(StringUtils.isEmpty(peopleRequest.get(i).getFirstName()) || 
					StringUtils.isEmpty(peopleRequest.get(i).getLastName()) || 
					peopleRequest.get(i).getBirthDate() == null) {
				
				return Response.status(Response.Status.BAD_REQUEST)
			               .entity("All fields required.").type( MediaType.TEXT_PLAIN).build();
			}else {
				peopleResponse = new PeopleResponse();
				
				peopleResponse.setFirstName(peopleRequest.get(i).getFirstName());
				peopleResponse.setLastName(peopleRequest.get(i).getLastName());
				peopleResponse.setBirthDate(dateFormat.format(peopleRequest.get(i).getBirthDate()));
				
				peopleResponseList.add(peopleResponse);
				
				
				
			}
		}
		return Response.ok().entity(peopleResponseList).build();
		

	}
	

}
