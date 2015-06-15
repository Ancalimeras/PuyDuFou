package entites;

import entites.Note;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-15T22:40:23")
@StaticMetamodel(Spectacle.class)
public class Spectacle_ { 

    public static volatile SingularAttribute<Spectacle, String> image;
    public static volatile SingularAttribute<Spectacle, Integer> idSpectacle;
    public static volatile SingularAttribute<Spectacle, Integer> duree;
    public static volatile SingularAttribute<Spectacle, Float> positionLatitude;
    public static volatile SingularAttribute<Spectacle, String> nomSpectacle;
    public static volatile SingularAttribute<Spectacle, Integer> nbActeurs;
    public static volatile SingularAttribute<Spectacle, Float> moyenneNote;
    public static volatile SingularAttribute<Spectacle, String> descriptionSpectacle;
    public static volatile SingularAttribute<Spectacle, Float> positionLongitude;
    public static volatile CollectionAttribute<Spectacle, Note> noteCollection;

}