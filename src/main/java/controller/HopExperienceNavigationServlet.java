package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HopExperience;

/**
 * Servlet implementation class HopExperienceNavigationServlet
 */
@WebServlet("/HopExperienceNavigationServlet")
public class HopExperienceNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HopExperienceNavigationServlet() {
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
		HopExperienceHelper heh = new HopExperienceHelper();
		String action = request.getParameter("performHopExperienceAction");

		if (action == null) {
			getServletContext().getRequestDispatcher("/ShowAllHopExperiencesServlet").forward(request, response);
		} else if (action.equals("Add Hop Experience")) {
			getServletContext().getRequestDispatcher("/AddHopExperienceServlet").forward(request, response);
		} else if (action.equals("Edit Hop Experience")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				HopExperience hopExperience = heh.findHopExperienceID(id);
				request.setAttribute("newHopExperience", hopExperience);
				request.setAttribute("month", hopExperience.getHopDate().getMonthValue());
				request.setAttribute("date", hopExperience.getHopDate().getDayOfMonth());
				request.setAttribute("year", hopExperience.getHopDate().getYear());
				LinuxDistroHelper ldh = new LinuxDistroHelper();

				request.setAttribute("linuxDistroList", ldh.getLinuxDistroList());

				if (ldh.getLinuxDistroList().isEmpty()) {
					request.setAttribute("linuxDistroList", "");
				}

				getServletContext().getRequestDispatcher("/update-hop-experience.jsp").forward(request, response);
			} catch (NumberFormatException error) {
				getServletContext().getRequestDispatcher("/ShowAllHopExperiencesServlet").forward(request, response);
			}
		} else if (action.equals("Delete Hop Experience")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				HopExperience hopExperience = heh.findHopExperienceID(id);
				heh.deleteHopExperience(hopExperience);
			} catch (NumberFormatException error) {
				System.out.println("Missing Hop Experience");
			} finally {
				getServletContext().getRequestDispatcher("/ShowAllHopExperiencesServlet").forward(request, response);
			}
		}
	}
}
