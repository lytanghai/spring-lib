package com.psp.fd.pspspringboot.mockitoJwt.repository;

import com.psp.fd.pspspringboot.mockitoJwt.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByPokemonId(int pokemonId);
}
