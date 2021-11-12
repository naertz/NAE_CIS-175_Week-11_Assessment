package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HopExperience;

/**
 * Servlet implementation class ShowAllHopExperiencesServlet
 */
@WebServlet("/ShowAllHopExperiencesServlet")
public class ShowAllHopExperiencesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAllHopExperiencesServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HopExperienceHelper heh = new HopExperienceHelper();
		List<HopExperience> hopExperiences = heh.getHopExperienceList();
		request.setAttribute("hopExperienceList", hopExperiences);

		if (hopExperiences.isEmpty()) {
			request.setAttribute("hopExperiencesList", "");
		}

		getServletContext().getRequestDispatcher("/hop-experiences.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
