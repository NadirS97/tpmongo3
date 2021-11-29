package modele;

import java.util.Collection;

public class Movie {
    private String title;
    private int year;

    private String genre;
    private String summary;
    private String country;
    
    private Collection<Artist> actors;

    public Collection<Artist> getActors() {
        return actors;
    }

    public void setActors(Collection<Artist> actors) {
        this.actors = actors;
    }
    /*
        <title>Impitoyable</title>
    <year>1992</year>
    <genre>Western</genre>
    <summary>Légendaire hors-la-loi, William Munny s'est reconverti depuis onze ans en paisible fermier. Il
	 reprend néanmoins les armes pour traquer deux tueurs en compagnie de son vieil ami Ned
	 Logan. Mais ce dernier est capturé, puis éxécute. L'honneur et l'amitié imposent dès lors à
	 Munny de redevenir une dernière fois le héros qu'il fut jadis... </summary>
    <country>USA</country>

     */


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
