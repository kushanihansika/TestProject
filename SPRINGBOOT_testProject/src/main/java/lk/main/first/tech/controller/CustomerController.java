package lk.main.first.tech.controller;

import lk.main.first.tech.dto.CustomerDTO;
import lk.main.first.tech.service.custom.CustomerService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v3/customers")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService ;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerDTO customer){
        if (customer.getId().isEmpty() || customer.getName().isEmpty() || customer.getAddress().isEmpty()){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }else{
            String customerId = customerService.saveCustomer(customer);
            return new ResponseEntity<String>("\""+customerId+"\"",HttpStatus.CREATED);
        }
    }

    @PutMapping(path = "/{id:C\\d{3}}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateCustomer(@PathVariable("id") String id, @RequestBody CustomerDTO customer){
        if (!customerService.isCustomerExists(id)){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        if (customer.getName().isEmpty() || customer.getAddress().isEmpty()){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }else{
            customer.setId(id);
            customerService.updateCustomer(customer);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping(path = "/{id:C\\d{3}}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") String id){
        if (!customerService.isCustomerExists(id)){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        customerService.removeCustomer(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }




}
