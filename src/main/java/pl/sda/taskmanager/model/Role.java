package pl.sda.taskmanager.model;

import javax.persistence.*;

/**
 * @author Remigiusz Zudzin
 */

@Entity
public class Role {

    @Id                                                 //primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Long role_id;

    private String roleName;

}
