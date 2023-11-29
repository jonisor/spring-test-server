package com.example.springy.controller

import com.example.springy.model.ArtistAd
import com.example.springy.repository.ArtistAdRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ArtistAdResource {

    @Autowired
    val artistAdRepository = ArtistAdRepository()

    @GetMapping("ads/artists")
    fun getArtistsAds(): List<ArtistAd> {
        return artistAdRepository.getArtistAds()
    }

    @GetMapping("ads/{id}")
    fun getAd(@PathVariable id: String): ArtistAd? {
        return artistAdRepository.getAd(id)
    }

    @PostMapping("ads/create")
    fun addUser(@RequestBody ad: ArtistAd): List<ArtistAd> {
        return artistAdRepository.addAd(ad)
    }

}