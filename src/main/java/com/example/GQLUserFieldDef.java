package com.example;

import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLNonNull;

import static graphql.Scalars.GraphQLInt;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;

/**
 * field query 'users'
 * <p>
 * Returns one user by id
 */
public class GQLUserFieldDef {

    private final UserService service;

    public GQLUserFieldDef(UserService service) {
        this.service = service;
    }

    public GraphQLFieldDefinition get() {
        return newFieldDefinition()
                .name("user")
                .type(new GQLUserObject().get())
                .argument(newArgument()
                        .name("id")
                        .type(new GraphQLNonNull(GraphQLInt)))
                .dataFetcher(env -> service.findById(env.getArgument("id")))
                .build();
    }

}
