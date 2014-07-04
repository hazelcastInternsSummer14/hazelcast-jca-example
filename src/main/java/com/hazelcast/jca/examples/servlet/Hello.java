package com.hazelcast.jca.examples.servlet;

import javax.annotation.Resource;
import com.hazelcast.core.TransactionalMap;
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
        	out.write("<h1>Example of Hazelcast JCA</h1>");

		HazelcastConnection hzConn = null;
 	
		try {
			TransactionalMap<Object,Object> txmap = hzConn.getTransactionalMap("txmap");
			if(txmap != null){
				for(int i = 0; i<61; i++)
					txmap.put(i,"Hello");
			}
		} finally {
			if(out != null)
				out.close();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}	
}
