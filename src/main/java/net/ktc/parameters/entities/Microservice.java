package net.ktc.parameters.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Microservice implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(nullable = false, length = 20, unique = true)
    private String name;
    @Column(nullable = false, length = 20, unique = true)
    private String link;
    private String description;

    @OneToMany(mappedBy = "microservice")
    @JsonIgnore
    private Collection<Parameterservice> parameterservices;

}
