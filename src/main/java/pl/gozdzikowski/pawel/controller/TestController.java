package pl.gozdzikowski.pawel.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pl.gozdzikowski.pawel.service.TestService;

@Path("/")
public class TestController {
	
	@Inject
	TestService testService;
	
	@Inject
	HttpServletRequest request;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/test")
	public Response test() {
		request.getSession().setAttribute("test2", "test");
		return Response.ok(testService.hello()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("test-long")
	public Response testLong() {
		request.getSession().setAttribute("test", "test");
		testService.testLong();
		return Response.ok("test").build();
	}

}
