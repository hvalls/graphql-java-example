package com.example;

import graphql.schema.GraphQLObjectType;

import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

/**
 * Response type User
 */
public class GQLUserObject {

    public GraphQLObjectType get() {
        return newObject()
                .name("user")
                .field(newFieldDefinition()
                        .name("id")
                        .type(GraphQLInt)
                        .build())
                .field(newFieldDefinition()
                        .name("name")
                        .type(GraphQLString)
                        .build())
                .field(newFieldDefinition()
                        .name("email")
                        .type(GraphQLString)
                        .build())
                .build();
    }

}
