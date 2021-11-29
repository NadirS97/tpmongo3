package mongo.dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import modele.Artist;
import modele.Movie;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.Collection;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoFacadeCine {


    public static final String NOM_BD = "cine";
    public static final String ARTISTS = "artists";
    public static final String MOVIES = "movies";
    private MongoDatabase mongoDatabase;

    public MongoFacadeCine() {
        CodecRegistry pojoCodecRegistry =
                fromRegistries(
                        MongoClientSettings.getDefaultCodecRegistry(),
                        fromProviders(PojoCodecProvider.builder()
                                .automatic(true).build()
                        )
                );
        // connection au serveur localhost:27017
        MongoClient mongoClient = MongoClients.create(
                new ConnectionString("mongodb://172.26.0.2:27017"));

        // accès à la database cine
        this.mongoDatabase = mongoClient.getDatabase(NOM_BD)
                .withCodecRegistry(pojoCodecRegistry);
    }

    public Collection<Artist> getAllArtists() {
        MongoCollection<Artist> artistes =
                mongoDatabase.getCollection(ARTISTS,
                        Artist.class);
        Collection<Artist> artists = new ArrayList<>();
        artistes.find().forEach(a->artists.add(a));
        return artists;
    }

    public Collection<Movie> getAllMovies() {
        MongoCollection<Movie> films = mongoDatabase.getCollection(MOVIES,Movie.class);
        Collection<Movie> movies = new ArrayList<>();
        films.find().forEach(a->movies.add(a));
        return movies;
    }


    public Collection<Movie> getMoviesByGenre(String genre) {
        MongoCollection<Movie> films = mongoDatabase.getCollection(MOVIES,Movie.class);
        Collection<Movie> movies = new ArrayList<>();
        films.find(Filters.eq("genre",genre)).forEach(e -> movies.add(e));
        return movies;
    }


    public Collection<String> getAllGenres() {
        MongoCollection<Movie> films = mongoDatabase.getCollection(MOVIES,Movie.class);
        Collection<String> genre = new ArrayList<>();
        films.distinct("genre",String.class).forEach(e -> genre.add(e));
        return genre;
    }


    public Collection<Artist> getArtistsOfAMovie(String movieTitle) {

        MongoCollection<Movie> films = mongoDatabase.getCollection(MOVIES,Movie.class);
        Movie film = films.find(Filters.eq("title",movieTitle)).first();
        return null;



    }




}
