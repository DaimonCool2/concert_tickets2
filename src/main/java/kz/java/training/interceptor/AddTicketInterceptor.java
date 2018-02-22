package kz.java.training.interceptor;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kz.java.training.entity.MusicGenre;

public class AddTicketInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		MusicGenre musicGenre = MusicGenre.getMusicGenreEnum(request.getParameter("musGenre"));
		Calendar dateOfTheEvent = Calendar.getInstance();
		dateOfTheEvent.set(Integer.parseInt(request.getParameter("year")),
				Integer.parseInt(request.getParameter("month")) - 1, Integer.parseInt(request.getParameter("day")),
				Integer.parseInt(request.getParameter("hour")), Integer.parseInt(request.getParameter("minute")));
		request.setAttribute("musicGenre", musicGenre);
		request.setAttribute("dateOfTheEvent", dateOfTheEvent);
		return true;
	}


}
