package kz.java.training.entity;

public enum MusicGenre {

	ROCK("рок", 1), POP("поп", 2), RAP("рэп", 3), JAZZ("джаз", 4);

	private String musicGenreInRussian;
	private int musicGenreInDB;

	MusicGenre(String musicGenreInRussian, int musicGenreInDB) {
		this.musicGenreInRussian = musicGenreInRussian;
		this.musicGenreInDB = musicGenreInDB;
	}

	public static MusicGenre getMusicGenreEnum(String musicGenre) {
		for (MusicGenre musGenre : MusicGenre.values()) {
			if (musGenre.name().equalsIgnoreCase(musicGenre)
					|| musGenre.getMusicGenreInRussian().equalsIgnoreCase(musicGenre)) {
				return musGenre;
			}
		}
		return null;
	}

	public String getMusicGenreInRussian() {
		return musicGenreInRussian;
	}

	public int getMusicGenreInDB() {
		return musicGenreInDB;
	}

}
