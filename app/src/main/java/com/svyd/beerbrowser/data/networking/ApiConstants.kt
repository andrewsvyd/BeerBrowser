package com.svyd.beerbrowser.data.networking

class ApiConstants private constructor() {

    companion object {

        private const val PROTOCOL = "http://"
        private const val LIVE_INSTANCE = "api.punkapi.com/v2/"

        const val API_ENDPOINT = PROTOCOL + LIVE_INSTANCE

        const val CONNECTION_TIME_OUT = 30
        const val READ_TIME_OUT = 30
        const val WRITE_TIME_OUT = 30
    }
}
