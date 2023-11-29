package com.example.springy.repository

import com.example.springy.model.ArtistAd
import org.springframework.stereotype.Repository

@Repository
class ArtistAdRepository {

    var mArtistAds = mutableListOf<ArtistAd>()

    init {
        val ad1 = ArtistAd(
            id = "1",
            title = "Traditional tattoo",
            description = "Looking for client in Southern Finland",
            imageUrl =
            "https://img.freepik.com/premium-vector/american-traditional-tattoo-designs-coloring-book_960911-7527.jpg",
            artistId = "202"
        )
        val ad2 = ArtistAd(
            id = "2",
            title = "Colourful tattoo",
            description = "Search for long lasting project to implement design for full back. Should be worth it.",
            imageUrl =
            "https://ae01.alicdn.com/kf/HTB17Sa.OpXXXXblXXXXq6xXFXXXR/34x48cm-Full-Back-Large-color-fighting-Tiger-and-Dragon-Waterproof-Temporary-Tattoo-Stickers-Mens-Art-Fake.jpg",
            artistId = "202"
        )
        val ad3 = ArtistAd(
            id = "3",
            title = "Colourful tattoo",
            description = "Hope to find long term customer for bigger thighs project. Estimated time at least 18 working hours. Location goes everywhere nationally.",
            imageUrl =
            "https://designs.tattooswizard.com/cdn/shop/files/zUnEqOJfcDlUBNey3ygJU8P2sWskxanKviX7InIlBvg.jpg?v=1696681512",
            artistId = "202"
        )
        val ad4 = ArtistAd(
            id = "4",
            title = "Dark calligraphy text",
            description = "",
            imageUrl =
            "https://fiverr-res.cloudinary.com/images/q_auto,f_auto/gigs/327969555/original/d7743c967da6c1083356349c9b340258d54eb299/do-dark-abstract-dark-lettering-tattoo-designs.jpg",
            artistId = "202"
        )

        mArtistAds.addAll(listOf(ad1, ad2, ad3, ad4))
    }

    fun getArtistAds(): List<ArtistAd> {
        return mArtistAds
    }

    fun getAd(id: String): ArtistAd? {
        return mArtistAds.find { it.id == id }
    }

    fun addAd(ad: ArtistAd): List<ArtistAd> {
        mArtistAds.add(ad)

        return mArtistAds
    }
}