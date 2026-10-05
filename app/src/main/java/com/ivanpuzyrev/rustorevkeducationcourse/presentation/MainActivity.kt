package com.ivanpuzyrev.rustorevkeducationcourse.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepository
import com.ivanpuzyrev.rustorevkeducationcourse.ui.theme.RuStoreVKEducationCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RuStoreVKEducationCourseTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        AppListToolBar(
                            onBackClick = {
                                Toast.makeText(
                                    this,
                                    "Ни шагу назад",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        )
                    }
                ) { innerPadding ->
                    AppListScreen(
                        modifier = Modifier.padding(innerPadding),
                        appList = AppRepository.appList.shuffled(),
                        onCardClick = {
                            Toast.makeText(this, "Я есть «$it»", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}