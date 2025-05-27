package com.psp.fd.pspspringboot.mockitoJwt.service;

import com.psp.fd.pspspringboot.mockitoJwt.dto.PokemonDto;
import com.psp.fd.pspspringboot.mockitoJwt.dto.PokemonResponse;

public interface PokemonService {
    PokemonDto createPokemon(PokemonDto pokemonDto);
    PokemonResponse getAllPokemon(int pageNo, int pageSize);
    PokemonDto getPokemonById(int id);
    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);
    void deletePokemonId(int id);
}
