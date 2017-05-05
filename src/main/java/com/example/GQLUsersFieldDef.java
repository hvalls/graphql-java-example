package com.example;

import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;

import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;

/**
 * field query 'users'
 * <p>
 * Returns all the users in the database
 */
public class GQLUsersFieldDef {

    private final UserService service;

    public GQLUsersFieldDef(UserService service) {
        this.service = service;
    }

    public GraphQLFieldDefinition get() {
        return newFieldDefinition()
                .name("users")
                .type(GraphQLList.list(new GQLUserObject().get()))
                .dataFetcher(env -> service.findAll())
                .build();
    }

}
