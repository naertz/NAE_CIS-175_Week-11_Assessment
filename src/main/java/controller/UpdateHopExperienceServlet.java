package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HopExperience;
import model.LinuxDistro;

/**
 * Servlet implementation class UpdateHopExperienceServlet
 */
@WebServlet("/UpdateHopExperienceServlet")
public class UpdateHopExperienceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateHopExperienceServlet() {
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
		LinuxDistroHelper ldh   = new LinuxDistroHelper();

		Integer id = Integer.parseInt(request.getParameter("id"));
		HopExperience hopExperience = heh.findHopExperienceID(id);

		String distroSelection = request.getParameter("distroId");
		LinuxDistro selectedDistro = new LinuxDistro();

		if (distroSelection != null) {
			selectedDistro = ldh.findLinuxDistroID(Integer.parseInt(distroSelection));
		}

		hopExperience.setDistro(selectedDistro);

		String month = request.getParameter("month");
		String day   = request.getParameter("day");
		String year  = request.getParameter("year");

		LocalDate hopDate;
		try {
			hopDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException error) {
			hopDate = LocalDate.now();
		}

		hopExperience.setHopDate(hopDate);

		int rating;
		try {
			rating = Integer.parseInt(request.getParameter("rating"));
		} catch (NumberFormatException error) {
			rating = 50;
		}
		if (rating < 0 || rating > 100) {
			rating = 50;
		}

		hopExperience.setRating(rating);

		String journal = request.getParameter("journal");

		hopExperience.setJournal(journal);

		String finalThoughts = request.getParameter("finalThoughts");

		hopExperience.setFinalThoughts(finalThoughts);

		heh.updateHopExperience(hopExperience);

		getServletContext().getRequestDispatcher("/ShowAllHopExperiencesServlet").forward(request, response);
	}

}
