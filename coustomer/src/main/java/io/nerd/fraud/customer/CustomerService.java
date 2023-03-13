package io.nerd.fraud.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public Customer registerCustomer(CustomerRegistrationRequest customerRequest) {
        var customer =Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        // todo check if email valid
        // todo check if email not taken
        return customerRepository.save(customer);
    }
}
