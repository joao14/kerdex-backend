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
public class SaleRequest {

    @JsonPropertyOrder("1")
    @JsonAlias("indetification")
    @JsonProperty("indetification")
    String indetification;

    @JsonPropertyOrder("2")
    @JsonAlias("name")
    @JsonProperty("name")
    String name;

    @JsonPropertyOrder("3")
    @JsonAlias("mail")
    @JsonProperty("mail")
    String mail;


    @JsonPropertyOrder("4")
    @JsonAlias("phone")
    @JsonProperty("phone")
    String phone;

    @JsonPropertyOrder("5")
    @JsonAlias("id")
    @JsonProperty("id")
    Integer id;

    @JsonPropertyOrder("6")
    @JsonAlias("stock")
    @JsonProperty("stock")
    String stock;

}
