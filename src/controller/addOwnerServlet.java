package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cat;
import model.Owner;

/**
 * Servlet implementation class addPetServlet
 */
@WebServlet("/addOwnerServlet")
public class addOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String birthday = request.getParameter("bday");
		String catOverlordId = request.getParameter("catOverlordId");
		
		Date bdayFix = Date.valueOf(birthday);
		int catId = Integer.parseInt(catOverlordId);
		
		Owner yikes = new Owner(name, bdayFix, catId);
		ownerHelper ph = new ownerHelper();
		ph.insertOwner(yikes);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
