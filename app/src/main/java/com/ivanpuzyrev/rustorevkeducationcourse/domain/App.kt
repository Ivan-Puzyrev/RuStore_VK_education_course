package com.ivanpuzyrev.rustorevkeducationcourse.domain

data class App(
    val icon: String,
    val title: String,
    val category: Category,
    val description: String
)

enum class Category(val text: String) {
    ENTERTAINMENT ("Развлечения"),
    COMMUNICATION ("Общение"),
    SERVICES ("Услуги"),
    FINANCE ("Финансы"),
    SHOPPING ("Покупки"),
    GOVERNMENT ("Государственные"),
    MAPS ("Карты и навигация")
}
