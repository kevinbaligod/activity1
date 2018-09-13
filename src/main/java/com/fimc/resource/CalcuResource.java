package com.fimc.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/calculator")
public class CalcuResource {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response calcu(CalcuRequest calcuRequest) {
	
		CalcuResponse calcuResponse = new CalcuResponse();
		
		try {
			if(!calcuRequest.getOperator().isEmpty() || !calcuRequest.getOperator().equals(null) || calcuRequest.getNumber1() != 0 || calcuRequest.getNumber2() != 0) {
				if(Double.valueOf(calcuRequest.getNumber1()) instanceof Double || Double.valueOf(calcuRequest.getNumber2()) instanceof Double ) {
					if(calcuRequest.getOperator().equals("+")) {
						calcuResponse.setAction("Addition");
						calcuResponse.setResult(splitAns(String.valueOf(calcuRequest.getNumber1() + calcuRequest.getNumber2())));
						return Response.ok().entity(calcuResponse).build();
					}else if (calcuRequest.getOperator().equals("-")) {
						calcuResponse.setAction("Subtraction");
						calcuResponse.setResult(splitAns(String.valueOf(calcuRequest.getNumber1() - calcuRequest.getNumber2())));
						return Response.ok().entity(calcuResponse).build();
					}else if (calcuRequest.getOperator().equals("*")) {
						calcuResponse.setAction("Multiplication");
						calcuResponse.setResult(splitAns(String.valueOf(calcuRequest.getNumber1() * calcuRequest.getNumber2())));
						return Response.ok().entity(calcuResponse).build();
					}else if (calcuRequest.getOperator().equals("/")) {
						if(calcuRequest.getNumber1() == 0 || calcuRequest.getNumber2() == 0) {
							return Response.status(Response.Status.BAD_REQUEST)
						               .entity("Cannot be divided by zero.").type( MediaType.TEXT_PLAIN).build();
						}else {
							calcuResponse.setAction("Division");

							double aa =  calcuRequest.getNumber1() / calcuRequest.getNumber2();
							System.out.println(String.format("%.5f",aa));							
							calcuResponse.setResult(String.format("%.5f",aa));
							return Response.ok().entity(calcuResponse).build();
						}
					}else {
						/*return Response.status(HttpServletResponse.SC_BAD_REQUEST).build();*/

						return Response.status(Response.Status.BAD_REQUEST)
			               .entity("Invalid Operator").type( MediaType.TEXT_PLAIN).build();
					}
				}else {
					return Response.status(Response.Status.BAD_REQUEST)
				               .entity("Invalid Number.").type( MediaType.TEXT_PLAIN).build();
				}
			}else {
				return Response.status(Response.Status.BAD_REQUEST)
			               .entity("All fields are required.").type( MediaType.TEXT_PLAIN).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
		               .entity("All fields are required.").type( MediaType.TEXT_PLAIN).build();
		}

	}
	
	public String splitAns(String comp) {
		
		String answer11 = "";
		
		try {
			String ans = comp;
			String[] answer = ans.split("\\.");
			String whole = answer[0];
			
			answer11 = whole;
		} catch (Exception e) {
			answer11 = comp;
		}
		return answer11;		
		
	}

}
