package com.example.testspringdata;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserdetailRepository extends JpaRepository<Userdetail, String> {
}