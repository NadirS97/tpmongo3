package modele;


import org.bson.codecs.pojo.annotations.BsonProperty;

public class ArtistOld {

    @BsonProperty("_id")
    private String id;
    @BsonProperty(value = "last_name")
    private String nom;
    @BsonProperty(value = "first_name")
    private String prenom;
    @BsonProperty(value = "birth_date")
    private String naissance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }
}
