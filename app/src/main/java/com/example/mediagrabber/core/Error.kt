package com.example.mediagrabber.core


sealed interface Error {
    enum class Network : Error {
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        PAYLOAD_TOO_LARGE,
        SERVER_ERROR,
        SERIALIZATION,
        UNAUTHORIZED,
        FORBIDDEN,
        NOT_FOUND,
        BAD_REQUEST,
        CONFLICT,
        GONE,
        UNPROCESSABLE_ENTITY,
        UNKNOWN
    }
}