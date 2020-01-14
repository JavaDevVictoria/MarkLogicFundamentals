package com.mlu.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.DatabaseClientFactory.Authentication;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.io.JacksonHandle;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/page")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DatabaseClient client = DatabaseClientFactory.newClient("localhost", 8051, "admin", "admin", Authentication.DIGEST); 
		
		JSONDocumentManager docMgr = client.newJSONDocumentManager();
		JacksonHandle handle = new JacksonHandle();
		docMgr.read("/fun/hello.json", handle);
		JsonNode doc = handle.get();
		
		PrintWriter out = response.getWriter();
		out.println(doc.get("greeting").asText()); 
		client.release();
	}

}
