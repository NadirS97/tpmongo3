package mongo;

import com.mongodb.Block;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import modele.Artist;
import modele.Movie;
import mongo.dao.MongoFacadeCine;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DemoMongoPojo {
    public static void main(String[] args) {
        MongoFacadeCine facadeCine = new MongoFacadeCine();


        System.out.println("Tous les artistes--------------------");
        // Titre des films
        for(Artist artist : facadeCine.getAllArtists()) {
            System.out.println(artist.getNom());
        }
        System.out.println("----------------------------------");


        System.out.println("Tous les films--------------------");
        // Titre des films
        for(Movie movie : facadeCine.getAllMovies()) {
            System.out.println(movie.getTitle());
        }
        System.out.println("----------------------------------");


        // Titre des films du genre Sciences-fiction

        System.out.println("Tous les films SF--------------------");

        for(Movie movie : facadeCine.getMoviesByGenre("Science-fiction")) {
            System.out.println(movie.getTitle());
        }
        System.out.println("----------------------------------");


        // Tous les genres distincts

        System.out.println("Tous genres--------------------");

        for(String genre:facadeCine.getAllGenres()) {
            System.out.println(genre);
        }
        System.out.println("----------------------------------");


        facadeCine.getArtistsOfAMovie("Matrix");

    }
}
