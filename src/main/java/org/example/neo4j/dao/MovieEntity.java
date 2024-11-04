package org.example.neo4j.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Data
@Node("Movie")
@AllArgsConstructor
public class MovieEntity {
    @Id
    private final String title;

    @Property("tagline")
    private final String description;

    @Relationship(type = "ACTED_IN", direction =Relationship.Direction.INCOMING)
    private Set<PersonEntity> actors = new HashSet<>();

    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private Set<PersonEntity> directors = new HashSet<>();

}
