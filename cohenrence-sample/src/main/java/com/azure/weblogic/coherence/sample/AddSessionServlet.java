package com.azure.weblogic.coherence.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddSessionServlet
 */
/**
 * @author preetham
 *
 */
public class AddSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSessionServlet() {
        System.out.println("AddSessionServlet Constructor called!");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("AddSessionServlet \"Init\" method called");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("AddSessionServlet \"Destroy\" method called");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddSessionServlet \"Service\" method(inherited) called");
        System.out.println("AddSessionServlet \"DoPost\" method called");
        
        storeInSessionAndRespond(request, response);

	}
	
	private void storeInSessionAndRespond(HttpServletRequest request,
		HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String emailId = request.getParameter("email");
		System.out.println("Username from jsp page is "+ uname + " and email id is "+ emailId);
		//Create a session
		HttpSession session = request.getSession(true);
		if(session!=null)
		{
			//store the attributes
			session.setAttribute("uname", uname);
			session.setAttribute("emailId", emailId);
			System.out.println("Username and email id is stored in the session");
		}

		out.write("<html><body><h2>Username and email id is stored in the session, click <a href=\"TestSessionServlet\"> Test Session </a> to test the session</h2></body></html>");
	}



}
