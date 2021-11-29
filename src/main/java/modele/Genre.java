package modele;

public enum Genre {
    WESTERN("Western"),
    DRAMA("drama"),
    ROMANCE("romance"),
    ACTION("Action"),
    FANTASTIQUE("Fantastique"),
    SF("Science-fiction"),
    THILLER("Thriller"),
    GUERRE("Guerre"),
    CRIME("crime"),
    SUSPENSE("Suspense"),
    HORREUR("Horreur"),
    COMEDIE("Comédie");

    private String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return genre;
    }

    public static Genre valueGenre(String val) {
        for(Genre genre : values()) {
            if (genre.getGenre().equals(val)) {
                return genre;
            }
        }
        throw new IllegalArgumentException();
    }
}
