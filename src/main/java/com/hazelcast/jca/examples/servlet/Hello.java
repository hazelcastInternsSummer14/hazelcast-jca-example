package com.hazelcast.jca.examples.servlet;

import javax.annotation.Resource;
import com.hazelcast.core.IMap;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.resource.ResourceException;
import javax.resource.cci.ConnectionFactory;
import com.hazelcast.jca.HazelcastConnection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = -8314035702649252239L;

	@Resource(mappedName = "java:/HazelcastCF")
	protected ConnectionFactory connectionFactory;

	protected HazelcastConnection getConnection() throws ResourceException {
		HazelcastConnection c = (HazelcastConnection) connectionFactory.getConnection();
		return c;
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	resp.setContentType("text/html");
        	
		PrintWriter out = resp.getWriter();
        out.write("<h1>Hazelcast JCA Example</h1>");

		HazelcastConnection hzConn = null;
 	
		try {
			hzConn = getConnection();

			IMap<Object,Object> map = hzConn.getMap("example");
			String action = req.getParameter("action");

			if(action.equals("put")) {
				map.put(map.size(),req.getParameter("data"));
			}
			else if(action.equals("get")) {
				for(int i = 0; i<map.size(); i++) {
					out.write(i +"=>"+ map.get(i) +"<br />");
				}
			}
			else if(action.equals("clear")) {
				map.clear();
			}

			hzConn.close();
		}
		catch(ResourceException e) {

		}
		finally {
			if(out != null)
				out.close();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}	
}
