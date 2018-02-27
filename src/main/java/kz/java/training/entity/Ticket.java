package kz.java.training.entity;

import java.util.Arrays;
import java.util.Calendar;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Ticket {
	@NotEmpty(message = "Пустое поле")
	private String nameOfGroup;

	private MusicGenre musicGenre;

	@NotEmpty(message = "Пустое поле")
	private String city;

	public String getNameOfGroup() {
		return nameOfGroup;
	}

	public void setNameOfGroup(String nameOfGroup) {
		this.nameOfGroup = nameOfGroup;
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



}
