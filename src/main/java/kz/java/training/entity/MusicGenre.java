package kz.java.training.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.context.MessageSource;

public enum MusicGenre {

	ROCK, POP, RAP, JAZZ;

	//private static List<String> genres = Arrays.asList("rock", "pop", "rap", "jazz");

	public static MusicGenre getMusicGenreEnum(String musicGenre) {
		for (MusicGenre musGenre : MusicGenre.values()) {
			if (musGenre.name().equalsIgnoreCase(musicGenre)) {
				return musGenre;
			}
		}
		return null;
	}

	public static MusicGenre getMusicGenreEnumByDifferentLanguageValue(String musicGenre, MessageSource messageSource,
			Locale locale) {
		MusicGenre musGenre = null;
		for (MusicGenre musicGenreEnum : MusicGenre.values()) {
			if (messageSource.getMessage(musicGenreEnum.name().toLowerCase(), null, locale).equalsIgnoreCase(musicGenre)) {
				musGenre = musicGenreEnum;
			}
		}
		return musGenre;
	}


}
