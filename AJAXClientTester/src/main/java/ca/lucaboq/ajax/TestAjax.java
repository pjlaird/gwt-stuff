package ca.lucaboq.ajax;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/my/path")
public interface TestAjax {
	
	@GET
	@Path("/get/path")
	void myGet();
	
	@POST
	@Path("/post/path")
	void myPost();
}
