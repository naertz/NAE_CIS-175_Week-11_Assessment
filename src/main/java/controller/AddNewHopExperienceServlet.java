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
 * Servlet implementation class AddNewHopExperienceServlet
 */
@WebServlet("/AddNewHopExperienceServlet")
public class AddNewHopExperienceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewHopExperienceServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinuxDistroHelper ldh = new LinuxDistroHelper();
		
		String distroSelection = request.getParameter("distroId");
		LinuxDistro selectedDistro = new LinuxDistro();
		
		if (distroSelection != null) {
		    selectedDistro = ldh.findLinuxDistroID(Integer.parseInt(distroSelection));
		}
		
		String month = request.getParameter("month");
		String day   = request.getParameter("day");
		String year  = request.getParameter("year");
		
		LocalDate hopDate;
		try {
		    hopDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException error) {
		    hopDate = LocalDate.now();
		}
		
		int rating;
		try {
		    rating = Integer.parseInt(request.getParameter("rating"));
		} catch (NumberFormatException error) {
		    rating = 50;
		}
		if (rating < 0 || rating > 100) {
		    rating = 50;
		}
		
		String journal = request.getParameter("journal");
		
		String finalThoughts = request.getParameter("finalThoughts");
		
		HopExperience hopExperience = new HopExperience(selectedDistro, hopDate, rating, journal, finalThoughts);
	
		HopExperienceHelper heh = new HopExperienceHelper();
		heh.insertHopExperience(hopExperience);
		
		System.out.println("Success!");
		System.out.println(hopExperience.toString());
		
		getServletContext().getRequestDispatcher("/ShowAllHopExperiencesServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
