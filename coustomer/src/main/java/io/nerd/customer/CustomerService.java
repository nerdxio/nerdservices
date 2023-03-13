package io.nerd.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
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
