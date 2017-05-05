package com.example;

import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static graphql.schema.GraphQLObjectType.newObject;

@Configuration
@Import(UserService.class)
public class GQLConfig {

    @Autowired
    UserService userService;

    @Bean
    public GraphQL graphQL() {
        GraphQLObjectType queryType = newObject()
                .name("query")
                .field(new GQLUserFieldDef(userService).get())
                .field(new GQLUsersFieldDef(userService).get())
                .build();
        GraphQLSchema schema = GraphQLSchema.newSchema().query(queryType).build();
        return GraphQL.newGraphQL(schema).build();

    }

}
