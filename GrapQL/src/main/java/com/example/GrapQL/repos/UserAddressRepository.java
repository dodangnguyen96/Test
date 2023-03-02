package com.example.GrapQL.repos;

import com.example.GrapQL.models.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
    UserAddress findById(long String);
}
