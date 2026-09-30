package com.potenciometro.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.potenciometro.application.entities.RegistroPotenciometro;

@Repository
public interface RegistroPotenciometroRepository extends JpaRepository<RegistroPotenciometro, Long> {

}
