package entites;

import entites.MenuRestaurant;
import entites.TypeService;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-06-15T22:40:23")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, String> nomService;
    public static volatile CollectionAttribute<Service, MenuRestaurant> menuRestaurantCollection;
    public static volatile SingularAttribute<Service, Integer> idService;
    public static volatile SingularAttribute<Service, Float> positionLatitude;
    public static volatile SingularAttribute<Service, TypeService> typeService;
    public static volatile SingularAttribute<Service, Float> noteService;
    public static volatile SingularAttribute<Service, Float> positionLongitude;
    public static volatile SingularAttribute<Service, String> descriptionService;

}