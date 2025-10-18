package com.example.demo.dao;

import com.example.demo.conserto.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
    List<Conserto> findAllByAtivoTrue();
}
