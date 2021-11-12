package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LinuxDistro;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinuxDistroHelper ldh = new LinuxDistroHelper();
		String action = request.getParameter("performDistroAction");

		String path = "/ShowAllDistrosServlet";

		if (action.equals("Add Distro")) {
			path = "/index.html";
		} else if (action.equals("Edit Distro")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				LinuxDistro distro = ldh.findLinuxDistroID(id);
				request.setAttribute("newDistro", distro);
				path = "/update-distro.jsp";
			} catch (NumberFormatException error) {
				System.out.println("Missing distro");
			}
		} else if (action.equals("Delete Distro")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				LinuxDistro distro = ldh.findLinuxDistroID(id);
				ldh.deleteLinuxDistro(distro);
			} catch (NumberFormatException error) {
				System.out.println("Missing distro");
			}
		}

		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
