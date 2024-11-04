package org.example.neo4j.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node("Person")
@AllArgsConstructor
public class PersonEntity {
    @Id
    private final String name;

    private final Integer born;
}
