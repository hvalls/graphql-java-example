package com.example;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.GraphQLError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GQLController {

    @Autowired
    GraphQL graphQL;

    @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, Object> graphql(@RequestBody String body) {
        ExecutionResult result = graphQL.execute(body);
        List<GraphQLError> errors = result.getErrors();

        if (!errors.isEmpty()) {
            return new HashMap<String, Object>(){{
                put("errors", errors);
            }};
        }

        return result.getData();
    }

}
