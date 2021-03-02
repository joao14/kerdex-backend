package com.proyecto.todo1.kardex.util;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.proyecto.todo1.kardex.model.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Serializable {

    @JsonPropertyOrder("1")
    @JsonAlias("message")
    @JsonProperty("message")
    String message;

    @JsonPropertyOrder("2")
    @JsonAlias("code")
    @JsonProperty("code")
    String code;

    @JsonPropertyOrder("3")
    @JsonAlias("status")
    @JsonProperty("status")
    HttpStatus status;

    @JsonPropertyOrder("4")
    @JsonAlias("date")
    @JsonProperty("date")
    Date date;

    @JsonPropertyOrder("5")
    @JsonAlias("user")
    @JsonProperty("user")
    UserResponse user;


}
