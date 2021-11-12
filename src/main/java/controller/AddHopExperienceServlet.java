package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddHopExperienceServlet
 */
@WebServlet("/AddHopExperienceServlet")
public class AddHopExperienceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddHopExperienceServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinuxDistroHelper ldh = new LinuxDistroHelper();

		request.setAttribute("linuxDistroList", ldh.getLinuxDistroList());

		if (ldh.getLinuxDistroList().isEmpty()) {
			request.setAttribute("linuxDistroList", "");
		}

		getServletContext().getRequestDispatcher("/new-hop-experience.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
