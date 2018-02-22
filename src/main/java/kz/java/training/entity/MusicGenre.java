package kz.java.training.entity;

public enum MusicGenre {
	
	ROCK("рок", 1), POP("поп", 2),RAP("рэп", 3), JAZZ("джаз", 4);

    private String musicGenreInRussian;
    private int musicGenreInDB;
    MusicGenre(String musicGenreInRussian, int musicGenreInDB){
        this.musicGenreInRussian = musicGenreInRussian;
        this.musicGenreInDB = musicGenreInDB;
    }

    public static MusicGenre getMusicGenreEnum(String musicGenre){
        switch (musicGenre.toLowerCase()){
            case "рок" : return ROCK;
            case "поп" : return POP;
            case "рэп" : return RAP;
            case "джаз" : return JAZZ;
        }
        return  valueOf(musicGenre.toUpperCase());
    }

	public String getMusicGenreInRussian() {
		return musicGenreInRussian;
	}

	public int getMusicGenreInDB() {
		return musicGenreInDB;
	}


}
