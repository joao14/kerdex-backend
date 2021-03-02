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
public class Request {

    @JsonPropertyOrder("1")
    @JsonAlias("id")
    @JsonProperty("id")
    String id;

    @JsonPropertyOrder("2")
    @JsonAlias("name")
    @JsonProperty("name")
    String name;

    @JsonPropertyOrder("3")
    @JsonAlias("stock")
    @JsonProperty("stock")
    Integer stock;


    @JsonPropertyOrder("4")
    @JsonAlias("price")
    @JsonProperty("price")
    Float price;

    @JsonPropertyOrder("5")
    @JsonAlias("status")
    @JsonProperty("status")
    String status;

}
