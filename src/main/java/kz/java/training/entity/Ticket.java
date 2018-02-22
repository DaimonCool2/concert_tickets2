package kz.java.training.entity;

import java.util.Arrays;
import java.util.Calendar;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Ticket {
	
	@NotEmpty(message = "Пустое поле")
	private String nameOfGroup;
	
	@NotNull(message = "Пустое поле")
	private Integer numberOfTickets;
	
	//@NotNull(message = "Пустое поле")
	private MusicGenre musicGenre;
	
	@NotEmpty(message = "Пустое поле")
	private String city;
	
	@NotEmpty(message = "Пустое поле")
	private String location;
	
	//@NotNull(message = "Пустое поле")
	private Calendar dateOfTheEvent;
	
	private String description;
	private byte[] image;
	
	public String getNameOfGroup() {
		return nameOfGroup;
	}
	public void setNameOfGroup(String nameOfGroup) {
		this.nameOfGroup = nameOfGroup;
	}
	public Integer getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(Integer numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	public MusicGenre getMusicGenre() {
		return musicGenre;
	}
	public void setMusicGenre(MusicGenre musicGenre) {
		this.musicGenre = musicGenre;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	@Override
	public String toString() {
		return "Ticket [nameOfGroup=" + nameOfGroup + ", numberOfTickets=" + numberOfTickets + ", musicGenre="
				+ musicGenre + ", city=" + city + ", location=" + location + ", dateOfTheEvent=" + dateOfTheEvent
				+ ", description=" + description + ", image=" + Arrays.toString(image) + "]";
	}


}
