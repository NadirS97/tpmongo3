package mongo;

import com.mongodb.ClientSessionOptions;
import com.mongodb.ConnectionString;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class DemoMongo {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create(new ConnectionString("mongodb://172.26.0.2:27017"));

        MongoDatabase database = mongoClient.getDatabase("cine");

        MongoCollection<Document> movies = database.getCollection("movies");
        MongoCollection<Document> artits = database.getCollection("artists");

        // . Combien y a-t-il de films et d'artistes dans la base de données ?
        System.out.println("films : "+movies.countDocuments());
        System.out.println("artistes : "+artits.countDocuments());

        // . Affichez la liste des films
        final Consumer<? super Document> printJson = doc -> System.out.println(doc.toJson());
        //movies.find().forEach(printJson);

        // . Donnez la liste des titres des films de Science-fiction
        final Consumer<? super Document> printTitre = doc -> System.out.println(doc);
        System.out.println("films de science-fiction :");
        movies.find(Filters.eq("genre", "Science-fiction")).forEach(printTitre);

        // . Donnez l'ensemble des genres de films.
        System.out.println("tous les genres :");
        Set<String> genres = new HashSet<>();
        MongoCursor<Document> all = movies.find().iterator();
        while (all.hasNext()) {
            Document doc = all.next();
            genres.add(doc.getString("genre"));
        }
        System.out.println(genres);


    }
}
