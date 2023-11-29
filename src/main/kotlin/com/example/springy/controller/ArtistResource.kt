package com.example.springy.controller

import com.example.springy.model.Artist
import com.example.springy.repository.ArtistRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ArtistResource {

    @Autowired
    val artistRepository = ArtistRepository()

    @GetMapping("artists/{id}")
    fun getArtist(@PathVariable id: String): Artist? {
        return artistRepository.getArtist(id)
    }
}