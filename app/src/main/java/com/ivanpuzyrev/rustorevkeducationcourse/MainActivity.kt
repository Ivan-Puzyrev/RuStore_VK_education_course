package com.ivanpuzyrev.rustorevkeducationcourse

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ivanpuzyrev.rustorevkeducationcourse.ui.theme.RuStoreVKEducationCourseTheme
import androidx.core.net.toUri
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {

    val firstScreenViewModel by viewModels<FirstScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val textFieldState = rememberTextFieldState()
            val focusRequester = remember { FocusRequester() }

            RuStoreVKEducationCourseTheme {
                LaunchedEffect(Unit) {
                    focusRequester.requestFocus()
                    processViewModelEvents(firstScreenViewModel)
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(2 / 3f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .focusRequester(focusRequester),
                            state = textFieldState,
                            placeholder = { Text(stringResource(R.string.enter_your_text_or_phone_number)) }
                        )
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                firstScreenViewModel.processAction(ViewModelActions.OpenSecondScreen(textFieldState.text.toString()))
                            }
                        ) {
                            Text(stringResource(R.string.open_second_activity))
                        }
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                firstScreenViewModel.processAction(ViewModelActions.OpenDialer(textFieldState.text.toString())
                                )
                            }
                        ) {
                            Text(stringResource(R.string.call_your_friend))
                        }
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                firstScreenViewModel.processAction(ViewModelActions.ShareMessage(textFieldState.text.toString()))
                            }
                        ) {
                            Text(stringResource(R.string.share_the_message))
                        }
                    }
                }
            }
        }
    }
}

suspend fun ComponentActivity.processViewModelEvents(firstScreenViewModel: FirstScreenViewModel) {

    firstScreenViewModel.firstScreenEventsFlow.collect {
        when (it) {
            is FirstScreenEvents.Error -> {
                Toast.makeText(
                    this, it.message,
                    Toast.LENGTH_SHORT
                ).show()
                delay(2.seconds)
            }

            is FirstScreenEvents.OpenDialer -> {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = "tel:${it.phoneNumber}".toUri()
                }
                try {
                    startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(
                        this, getString(R.string.no_app_found_for_this_action),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            is FirstScreenEvents.OpenSecondScreen -> {
                val intent = Intent(this, SecondScreenActivity::class.java).apply {
                    putExtra("key", it.message)
                }
                startActivity(intent)
            }

            is FirstScreenEvents.ShareMessage -> {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, it.message)
                }
                val chooser = Intent.createChooser(intent, getString(R.string.share_with))
                try {
                    startActivity(chooser)
                } catch (e: Exception) {
                    Toast.makeText(
                        this, getString(R.string.no_app_found_for_this_action),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}