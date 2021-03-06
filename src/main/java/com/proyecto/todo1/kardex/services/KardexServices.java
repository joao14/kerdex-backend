package com.proyecto.todo1.kardex.services;

import com.proyecto.todo1.kardex.dto.Product;
import com.proyecto.todo1.kardex.dto.Sale;
import com.proyecto.todo1.kardex.dto.User;
import com.proyecto.todo1.kardex.model.Request;
import com.proyecto.todo1.kardex.model.SaleRequest;
import com.proyecto.todo1.kardex.model.UserResponse;
import com.proyecto.todo1.kardex.respository.IProductDao;
import com.proyecto.todo1.kardex.respository.ISaleDao;
import com.proyecto.todo1.kardex.respository.IUserDao;
import com.proyecto.todo1.kardex.util.ApiRequestException;
import com.proyecto.todo1.kardex.util.ApiResponse;
import com.proyecto.todo1.kardex.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class KardexServices {

    private static final String LOGGER_RESPONSE_FORMAT = "004-RES";
    private static final String LOGGER_REQUEST_FORMAT = "004-REQ";
    private static final Logger logger = LoggerFactory.getLogger(KardexServices.class);

    @Autowired
    private IProductDao iProductDao;


    @Autowired
    private IUserDao iUserDao;

    @Autowired
    private ISaleDao iSaleDao;


    public ResponseEntity<ApiResponse> registerProduct(Request request) {
        logger.info("1.-Create product of kardex", LOGGER_REQUEST_FORMAT);
        Product temp = new Product(request.getName(), request.getStock(), request.getPrice(), request.getStatus());
        ApiResponse apiResponse = null;
        Product productTemp = null;
        try {
            productTemp = iProductDao.findProduct(request.getName());
            if (productTemp == null) {
                iProductDao.save(temp);
                apiResponse = new ApiResponse(
                        "Create product success", String.valueOf(HttpStatus.OK.value()),
                        HttpStatus.OK, new Date(), null);
            } else {
                apiResponse = new ApiResponse(
                        "Product has been created before", String.valueOf(HttpStatus.CREATED.value()),
                        HttpStatus.CREATED, new Date(), null);
            }
        } catch (Exception ex) {
            logger.error("It happend mistake when created product");
            logger.info(ex.getMessage());
            throw new ApiRequestException("Mistake when inert products");
        }
        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
    }

    public ResponseEntity<ApiResponse> updateProduct(Request request) {
        logger.info("1.-Update product of kardex", LOGGER_REQUEST_FORMAT);
        Product productTemp = null;
        ApiResponse apiResponse = null;
        try {
            productTemp = iProductDao.findProductbyId(request.getId());
            System.out.println(productTemp.getName());
            if (productTemp != null) {
                productTemp.setPrice(request.getPrice());
                productTemp.setStock(request.getStock());
                productTemp.setStatus(request.getStatus());
                productTemp.setName(request.getName());
                iProductDao.save(productTemp);
                apiResponse = new ApiResponse(
                        "Update product success", String.valueOf(HttpStatus.OK.value()),
                        HttpStatus.OK, new Date(), null);
            } else {
                apiResponse = new ApiResponse(
                        "Product was not find in the kardex", String.valueOf(HttpStatus.CREATED.value()),
                        HttpStatus.CREATED, new Date(), null);
            }
        } catch (Exception ex) {
            logger.error("It happend mistake when update product");
            logger.info(ex.getMessage());
            throw new ApiRequestException("Mistake when update products");
        }
        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
    }

    public ResponseEntity<ApiResponse> deleteProduct(String idProduct) {
        logger.info("1.-Delete product of kardex", LOGGER_REQUEST_FORMAT);
        ApiResponse apiResponse = null;
        try {
            iProductDao.deleteById(Integer.parseInt(idProduct));
            apiResponse = new ApiResponse("Delete success", String.valueOf(HttpStatus.OK.value()), HttpStatus.OK, new Date(), null);
        } catch (Exception ex) {
            logger.error("It happend mistake");
            logger.info(ex.getMessage());
            throw new ApiRequestException("Mistake when delete products");
        }
        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
    }

    public ResponseEntity<ApiResponse> products() {
        logger.info("1.-Select products", LOGGER_REQUEST_FORMAT);
        ApiResponse apiResponse = null;
        List<Product> lista = null;
        try {
            lista = iProductDao.findAll();
            apiResponse = new ApiResponse(
                    "OK", String.valueOf(HttpStatus.OK.value()),
                    HttpStatus.OK,
                    new Date(),
                    lista);
        } catch (Exception ex) {
            logger.error("It happend mistake");
            logger.info(ex.getMessage());
            throw new ApiRequestException("Mistake in select products");
        }
        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
    }

    public ResponseEntity<Response> login(String name, String password) {
        logger.info("1.- Login to System Kardex", LOGGER_REQUEST_FORMAT);
        Response response = null;
        try {
            User user = iUserDao.findUser(name, password);
            if (user != null) {
                UserResponse userResponse = new UserResponse();
                userResponse.setId(user.getId());
                userResponse.setName(user.getName());
                userResponse.setLastname(user.getLastname());
                userResponse.setUsername(user.getUsername());
                userResponse.setPassword(user.getPassword());
                userResponse.setPerfil(user.getPerfil());
                userResponse.setStatus(user.getStatus());
                response = new Response(
                        "Correct credentials", String.valueOf(HttpStatus.OK.value()),
                        HttpStatus.OK,
                        new Date(), userResponse);
            } else {
                response = new Response(
                        "Incorrect credentials", String.valueOf(HttpStatus.CONFLICT.value()),
                        HttpStatus.CONFLICT,
                        new Date(), null);
            }

        } catch (Exception ex) {
            logger.error("It happend mistake");
            logger.info(ex.getMessage());
            throw new ApiRequestException("Mistake in select products");
        }
        return new ResponseEntity<>(response, response.getStatus());
    }

    public ResponseEntity<ApiResponse> users() {
        logger.info("1.- Get users ", LOGGER_REQUEST_FORMAT);
        ApiResponse apiResponse = null;
        List<User> lista = null;
        try {
            lista = iUserDao.findAll();
            apiResponse = new ApiResponse(
                    "OK", String.valueOf(HttpStatus.OK.value()),
                    HttpStatus.OK,
                    new Date(),
                    lista);
        } catch (Exception ex) {
            logger.error("It happend mistake");
            logger.info(ex.getMessage());
            throw new ApiRequestException("Mistake in select users");
        }
        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
    }

    public ResponseEntity<ApiResponse> finishSales(SaleRequest saleRequest) {
        logger.info("1.- Start finish steals ", LOGGER_REQUEST_FORMAT);
        ApiResponse apiResponse = null;
        try {
            Product product = iProductDao.findProductbyId(String.valueOf(saleRequest.getId()));
            if ((product.getStock() >= Integer.parseInt(saleRequest.getStock())) && product.getStock() > 0) {
                iSaleDao.save(new Sale(saleRequest.getIndetification(), saleRequest.getName(), saleRequest.getMail(), saleRequest.getPhone(), product));
                product.setStock(product.getStock() - Integer.parseInt(saleRequest.getStock()));
                iProductDao.save(product);
                apiResponse = new ApiResponse(
                        "Sale complete od kardex", String.valueOf(HttpStatus.OK.value()),
                        HttpStatus.OK,
                        new Date(), null);
            } else {
                apiResponse = new ApiResponse(
                        "Sale incomplete because the stock product is sold out", String.valueOf(HttpStatus.ACCEPTED.value()),
                        HttpStatus.ACCEPTED,
                        new Date(), null);
            }

        } catch (Exception ex) {
            logger.error("It happend mistake");
            logger.info(ex.getMessage());
            throw new ApiRequestException("Mistake in finish sales");
        }
        return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
    }

}
