package com.proyecto.todo1.kardex.controller;

import com.proyecto.todo1.kardex.model.Request;
import com.proyecto.todo1.kardex.services.KardexServices;
import com.proyecto.todo1.kardex.util.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/api/kardex/v1")
public class KardexController {

    private static final String LOGGER_RESPONSE_FORMAT = "001-RES";
    private static final String LOGGER_REQUEST_FORMAT = "001-REQ";
    private static final Logger logger = LoggerFactory.getLogger(KardexController.class);

    @Autowired
    private KardexServices kardexService;

    @PostMapping(value = "/register/product")
    public ResponseEntity<Object> register(@RequestBody Request request) {
        System.out.println("Producto de valores");
        ResponseEntity<ApiResponse> response = kardexService.registerProduct(request);
        System.out.println("Paso final...");
        return new ResponseEntity<>(response.getBody(), response.getBody().getStatus());
    }

    @PutMapping(value = "/update/product")
    public ResponseEntity<Object> update(@RequestBody Request request) {
        System.out.println("Update...");
        ResponseEntity<ApiResponse> response = kardexService.updateProduct(request);
        System.out.println("Paso final...");
        return new ResponseEntity<>(response.getBody(), response.getBody().getStatus());
    }

    @PutMapping(value = "/delete/product")
    public ResponseEntity<Object> delete(@RequestHeader Integer idProduct) {
        System.out.println("Delete...");
        ResponseEntity<ApiResponse> response = null;
        try {
            response = kardexService.deleteProduct(idProduct);
        } catch (Exception e) {
            System.out.println("Error:::");
            System.out.println(e);
        }
        System.out.println("Paso final...");
        return new ResponseEntity<>(response.getBody(), response.getBody().getStatus());
    }

    @GetMapping(value = "/products")
    public ResponseEntity<Object> products() {
        System.out.println("Search...");
        ResponseEntity<ApiResponse> response = kardexService.products();
        System.out.println("Paso final...");
        return new ResponseEntity<>(response.getBody(), response.getBody().getStatus());
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Object> users() {
        System.out.println("Users...");
        ResponseEntity<ApiResponse> response = kardexService.users();
        System.out.println("Paso final...");
        return new ResponseEntity<>(response.getBody(), response.getBody().getStatus());
    }



}
