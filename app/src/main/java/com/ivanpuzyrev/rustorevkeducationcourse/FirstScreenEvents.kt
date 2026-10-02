package com.ivanpuzyrev.rustorevkeducationcourse


sealed interface FirstScreenEvents {
    data class OpenSecondScreen(val message: String): FirstScreenEvents
    data class OpenDialer(val phoneNumber: String): FirstScreenEvents
    data class ShareMessage(val message: String): FirstScreenEvents
    data class Error(val message: String): FirstScreenEvents
}