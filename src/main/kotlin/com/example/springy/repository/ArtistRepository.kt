package com.example.springy.repository

import com.example.springy.model.Artist
import org.springframework.stereotype.Repository

@Repository
class ArtistRepository {

    var mArtists = mutableListOf<Artist>()

    init {
        val artist1 = Artist(
            id = "202",
            name = "Mr. Ink",
            city = "Helsinki",
            experience = 12
        )

        mArtists.add(artist1)
    }

    fun getArtist(id: String): Artist? {
        return mArtists.find { it.id == id }
    }
}