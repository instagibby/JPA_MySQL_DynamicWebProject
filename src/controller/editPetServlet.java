package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cat;

/**
 * Servlet implementation class editPetServlet
 */
@WebServlet("/editPetServlet")
public class editPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		petHelper ph = new petHelper();
		String name = request.getParameter("name");
		String breed = request.getParameter("breed");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Cat catToUpdate = ph.searchForCatById(tempId);
		catToUpdate.setName(name);
		catToUpdate.setBreed(breed);
		ph.updateItem(catToUpdate);
		getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);
	}

}
