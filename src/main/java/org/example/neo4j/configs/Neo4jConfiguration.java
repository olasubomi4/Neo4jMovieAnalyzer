package org.example.neo4j.configs;

import org.neo4j.driver.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.transaction.ReactiveNeo4jTransactionManager;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableNeo4jRepositories
@EnableTransactionManagement
public class Neo4jConfiguration  {

    @Bean
    public ReactiveNeo4jTransactionManager reactiveTransactionManager(Driver driver) {
        return new ReactiveNeo4jTransactionManager(driver);
    }
}
