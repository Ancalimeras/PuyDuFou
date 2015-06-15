package entites;

import entites.NotePK;
import entites.Spectacle;
import entites.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-15T22:40:23")
@StaticMetamodel(Note.class)
public class Note_ { 

    public static volatile SingularAttribute<Note, NotePK> notePK;
    public static volatile SingularAttribute<Note, Utilisateur> utilisateur;
    public static volatile SingularAttribute<Note, Spectacle> spectacle;
    public static volatile SingularAttribute<Note, Float> note;

}