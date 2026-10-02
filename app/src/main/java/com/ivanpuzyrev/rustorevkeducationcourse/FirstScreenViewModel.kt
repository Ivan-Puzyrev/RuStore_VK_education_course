package com.ivanpuzyrev.rustorevkeducationcourse

import android.telephony.PhoneNumberUtils
import androidx.lifecycle.ViewModel
import com.ivanpuzyrev.rustorevkeducationcourse.FirstScreenEvents.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class FirstScreenViewModel : ViewModel() {

    private val firstScreenEventsChannel = Channel<FirstScreenEvents>()
    val firstScreenEventsFlow = firstScreenEventsChannel.receiveAsFlow()

    fun processAction(viewModelActions: ViewModelActions) {
        when (viewModelActions) {
            is ViewModelActions.OpenDialer -> {
                val phone = viewModelActions.phone
                    if (PhoneNumberUtils.isGlobalPhoneNumber(phone)) {
                            firstScreenEventsChannel.trySend(OpenDialer(phone))
                    } else {
                        firstScreenEventsChannel.trySend(Error("Please enter a valid phone number"))
                    }
            }

            is ViewModelActions.OpenSecondScreen -> {
                val message = viewModelActions.message
                    if (message.isNotBlank()) {
                        firstScreenEventsChannel.trySend(OpenSecondScreen(message))
                    } else {
                        firstScreenEventsChannel.trySend(Error("Please enter a text"))
                    }
            }

            is ViewModelActions.ShareMessage -> {
                val message = viewModelActions.message
                    if (message.isNotBlank()) {
                        firstScreenEventsChannel.trySend(ShareMessage(message))
                    } else {
                        firstScreenEventsChannel.trySend(Error("Please enter a text"))
                    }
            }
        }
    }
}

sealed interface ViewModelActions {
    data class OpenSecondScreen(val message: String) : ViewModelActions
    data class OpenDialer(val phone: String) : ViewModelActions
    data class ShareMessage(val message: String) : ViewModelActions
}

