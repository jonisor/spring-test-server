package com.example.springy.util

import com.example.springy.model.ArtistAd
import org.springframework.core.ParameterizedTypeReference

fun getTestAd(id: String): ArtistAd = ArtistAd(
    id = id,
    title = "Test 1",
    description = "Test",
    artistId = "Not real one"
)

inline fun <reified T> typeReference() = object : ParameterizedTypeReference<T>() {}

inline fun <T1 : Any, T2 : Any, R : Any> let2(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}