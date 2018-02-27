package kz.java.training.entity;

import java.util.Calendar;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddTicket extends Ticket {
	@NotNull(message = "Пустое поле")
	@Digits(integer = 6, fraction=2, message = "Некорректная цена")
	private Double price;

	@NotNull(message = "Пустое поле")
	@Digits(integer = 7, fraction = 0, message = "Некорректное число билетов")
	private Integer numberOfTickets;
	
	@NotEmpty(message = "Пустое поле")
	private String location;

	private Calendar dateOfTheEvent;

	private String description;
	private byte[] image;
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(Integer numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Calendar getDateOfTheEvent() {
		return dateOfTheEvent;
	}
	public void setDateOfTheEvent(Calendar dateOfTheEvent) {
		this.dateOfTheEvent = dateOfTheEvent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	

}
