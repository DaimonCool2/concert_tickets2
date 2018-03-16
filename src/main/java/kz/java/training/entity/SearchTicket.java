package kz.java.training.entity;

public class SearchTicket extends AddTicket {
	private int ticketId;
	private String imageForPage;
	private String dateOfTheEventForPage;
	

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getImageForPage() {
		return imageForPage;
	}

	public void setImageForPage(String imageForPage) {
		this.imageForPage = imageForPage;
	}

	public String getDateOfTheEventForPage() {
		return dateOfTheEventForPage;
	}

	public void setDateOfTheEventForPage(String dateOfTheEventForPage) {
		this.dateOfTheEventForPage = dateOfTheEventForPage;
	}

	@Override
	public String toString() {
		return super.toString() + "SearchTicket [imageForPage=" + imageForPage + ", dateOfTheEventForPage=" + dateOfTheEventForPage + "]";
	}

}
