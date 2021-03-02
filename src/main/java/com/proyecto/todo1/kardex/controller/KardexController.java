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
        System.out.println("Create product");
        ResponseEntity<ApiResponse> response = kardexService.registerProduct(request);
        return new ResponseEntity<>(response.getBody(), response.getBody().getStatus());
    }

    @PutMapping(value = "/update/product")
    public ResponseEntity<Object> update(@RequestBody Request request) {
        System.out.println("Update product");
        ResponseEntity<ApiResponse> response = kardexService.updateProduct(request);
        return new ResponseEntity<>(response.getBody(), response.getBody().getStatus());
    }

    @PutMapping(value = "/delete/product")
    public ResponseEntity<Object> delete(@RequestParam String idProduct) {
        System.out.println("Delete product");
        ResponseEntity<ApiResponse> response = kardexService.deleteProduct(idProduct);
        return new ResponseEntity<>(response.getBody(), response.getBody().getStatus());
    }

    @GetMapping(value = "/products")
    public ResponseEntity<Object> products() {
        System.out.println("Search products");
        ResponseEntity<ApiResponse> response = kardexService.products();
        return new ResponseEntity<>(response.getBody(), response.getBody().getStatus());
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Object> users() {
        System.out.println("Search Users");
        ResponseEntity<ApiResponse> response = kardexService.users();
        return new ResponseEntity<>(response.getBody(), response.getBody().getStatus());
    }


}
