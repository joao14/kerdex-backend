package com.proyecto.todo1.kardex.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @JsonPropertyOrder("1")
    @JsonAlias("user")
    @JsonProperty("user")
    String user;

    @JsonPropertyOrder("2")
    @JsonAlias("password")
    @JsonProperty("password")
    String password;
}
