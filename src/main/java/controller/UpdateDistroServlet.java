package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LinuxDistro;

/**
 * Servlet implementation class UpdateDistroServlet
 */
@WebServlet("/UpdateDistroServlet")
public class UpdateDistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDistroServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinuxDistroHelper ldh = new LinuxDistroHelper();
		
		String name    = request.getParameter("name");
		String basedOn = request.getParameter("basedOn");
		String origin  = request.getParameter("origin");
		Integer id     = Integer.parseInt(request.getParameter("id"));
		
		LinuxDistro distro = ldh.findLinuxDistroID(id);
		distro.setName(name);
		distro.setBasedOn(basedOn);
		distro.setOrigin(origin);
		
		ldh.updateLinuxDistro(distro);
		
		getServletContext().getRequestDispatcher("/ShowAllDistrosServlet").forward(request, response);
		
		
	}

}
