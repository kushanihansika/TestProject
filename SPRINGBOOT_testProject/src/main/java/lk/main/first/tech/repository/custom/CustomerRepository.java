package lk.main.first.tech.repository.custom;

import lk.main.first.tech.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer ,String> {
}
