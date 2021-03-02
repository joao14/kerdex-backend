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
public class UserResponse {

    @JsonPropertyOrder("1")
    @JsonAlias("id")
    @JsonProperty("id")
    Integer id;

    @JsonPropertyOrder("2")
    @JsonAlias("name")
    @JsonProperty("name")
    String name;

    @JsonPropertyOrder("3")
    @JsonAlias("lastname")
    @JsonProperty("lastname")
    String lastname;

    @JsonPropertyOrder("4")
    @JsonAlias("username")
    @JsonProperty("username")
    String username;

    @JsonPropertyOrder("5")
    @JsonAlias("password")
    @JsonProperty("password")
    String password;

    @JsonPropertyOrder("6")
    @JsonAlias("perfil")
    @JsonProperty("perfil")
    String perfil;

    @JsonPropertyOrder("7")
    @JsonAlias("status")
    @JsonProperty("status")
    String status;

    @JsonPropertyOrder("8")
    @JsonAlias("token")
    @JsonProperty("token")
    String token;

}
