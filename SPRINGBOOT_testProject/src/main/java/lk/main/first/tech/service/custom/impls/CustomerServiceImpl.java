package lk.main.first.tech.service.custom.impls;

import lk.main.first.tech.dto.CustomerDTO;
import lk.main.first.tech.entity.Customer;
import lk.main.first.tech.repository.custom.CustomerRepository;
import lk.main.first.tech.service.custom.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customers = customerRepository.findAll().stream().map(customer -> new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress())).collect(Collectors.toList());
        return customers;
    }


    public String saveCustomer(CustomerDTO dto) {
        return customerRepository.save(new Customer(dto.getId(),dto.getName(),dto.getAddress())).getId();
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        customerRepository.save(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    @Override
    public void removeCustomer(String id)
        {
            customerRepository.deleteById(id);
        }

    @Override
    public CustomerDTO getCustomerById(String id) {
        return null;
    }

    @Override
    public boolean isCustomerExists(String id) {
        return false;
    }

}
