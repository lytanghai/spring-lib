package com.psp.fd.pspspringboot.mockitoJwt.repository;

import com.psp.fd.pspspringboot.mockitoJwt.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    Optional<Pokemon> findByType(String type);
}
