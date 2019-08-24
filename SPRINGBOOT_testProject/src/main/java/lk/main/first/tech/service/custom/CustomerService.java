package lk.main.first.tech.service.custom;

import lk.main.first.tech.dto.CustomerDTO;
import lk.main.first.tech.service.SuperService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerService extends SuperService {


    List<CustomerDTO> getAllCustomers();

    String saveCustomer(CustomerDTO dto);

    void updateCustomer(CustomerDTO dto);

    void removeCustomer(String id);

    CustomerDTO getCustomerById(String id);

    boolean isCustomerExists(String id);
}
