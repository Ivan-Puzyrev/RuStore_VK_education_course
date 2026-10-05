package com.ivanpuzyrev.rustorevkeducationcourse.data

import com.ivanpuzyrev.rustorevkeducationcourse.domain.App
import com.ivanpuzyrev.rustorevkeducationcourse.domain.Category

object AppRepository {
    val appList = listOf(
        App(
            icon = "https://static.rustore.ru/imgproxy/-fb8TfFrlYjwu7wYCEPuKsm4wWkTLBTx_0_a9GpeKfc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/2027823295/content/ICON/97486018-5785-424d-9cab-4fe496d27c76.png@webp",
            title = "VK Видео: кино, сериалы, ТВ, мультфильмы и клипы",
            category = Category.ENTERTAINMENT,
            description = """Смотри кино, мультики, сериалы, ТВ онлайн, спортивные трансляции, короткие видео и фильмы бесплатно на всех устройствах: от смартфона до телевизора. Премьеры и блокбастеры из кинотеатров и онлайн-платформ на твоем девайсе!

Откройте интертеймент без границ с VK Видео: онлайн-просмотр ТВ, новинки кино и сериалов, познавательные и развлекательные видео, мультики для детей (без интернета), эксклюзивный контент, спортивные трансляции и смешные клипы ждут тебя. Ты можешь скачать видео для офлайн просмотра в один клик."""
        ),
        App(
            icon = "https://static.rustore.ru/imgproxy/PTo8g-Giv9VHYo7_Rwxw_1wC07KtDM7eSJgAfMlv53s/preset:web_app_icon_160/plain/https://static.rustore.ru/3f3d7180-6eb9-45ad-8706-f467c6dcf82a@webp",
            title = "ВКонтакте: чаты, видео, музыка",
            category = Category.COMMUNICATION,
            description = """ВКонтакте — это общение, бесплатные звонки, мессенджер и чат, музыка и видео, игры и мини-приложения для любых задач, десятки миллионов людей и безграничные возможности для развлечений, бизнеса и обмена новостями из любой точки мира.

Отправляйте сообщения.
В мессенджере можно общаться не только с друзьями ВКонтакте, но и с контактами из вашей телефонной книги. Не забывайте заводить знакомства в соцсети и использовать мессенджер для общения! В чатах есть видеосообщения, персональные стикеры, яркие фоны, исчезающие и голосовые сообщения."""
        ),
        App(
            icon = "https://static.rustore.ru/imgproxy/7HOcGO9T6TglJ15g7aDv0CiensvQL4TYOQvtE46lR6E/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/1/27/d8/apk/2688703/content/ICON/ea0c42d8-934f-41a6-a3da-89798736f888.png@webp",
            title = "Авито – путешествия, работа, услуги, авто",
            category = Category.SERVICES,
            description = """На Авито каждый может найти что-то своё среди миллионов частных объявлений и предложений компаний по всей России: от квартиры и отеля, автомобиля и ремонта, до работы и кандидатов на вакансии.

Кроме того, на Авито можно найти разнообразные услуги в сферах ремонта, образования, красоты, здоровья и многих других, а также профессиональные консультации — от репетиторов и тренеров до юристов и бухгалтеров. Платформа предоставляет множество вариантов для поиска специалистов, подходящих под любые требования и бюджет."""
        ),
        App(
            icon = "https://static.rustore.ru/imgproxy/qriFjN8OV6VBF4CCbWcxPm7SL0Y0YtMfxTeJSzWZ1Rc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png@webp",
            title = "СберБанк Онлайн",
            category = Category.FINANCE,
            description = """СберБанк Онлайн — ваш надёжный помощник в ежедневных делах. Все финансовые и нефинансовые возможности доступны в одном приложении: от быстрых платежей и удобных переводов до сервисов для жизни, покупок и путешествий.

На главном экране собраны самые нужные финансовые инструменты. Баланс карты, переводы, история операций, информация о бонусах Спасибо и расходы за месяц — все действия доступны в несколько кликов."""
        ),
        App(
            icon = "https://static.rustore.ru/imgproxy/qqoP1Cyi4tplnwb8Z_yJ2mnWVhuen4kzin6tQLWsSHY/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/220863/content/ICON/2238e3ca-e3e7-41d0-b037-777ddc637a5b.png@webp",
            title = "Т-Банк: карты, вклады, кредиты",
            category = Category.FINANCE,
            description = """Т-Банк — приложение для управления деньгами и картами онлайн. Оплачивайте ЖКХ, штрафы ГИБДД и госуслуги без комиссии, переводите через СБП, копите на вкладах и инвестируйте — всё под рукой.

Дебетовая карта Black — пластиковая МИР или виртуальная. Оплачивайте счета бесконтактно и телефоном, получайте кэшбэк рублями за покупки. Если нужны дополнительные деньги, подойдет кредитка Платинум с лимитом до 1 000 000 ₽."""
        ),
        App(
            icon = "https://static.rustore.ru/imgproxy/lzg_3CHk-oqIqIfBj0KFQ-vhwK6NUJk6qC1r1Lt0fKM/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/3/28/37/apk/404415/content/ICON/577a3521-f7ef-4322-ab3c-c96b9262c562.png@webp",
            title = "ВТБ Онлайн",
            category = Category.FINANCE,
            description = """Мобильное приложение ВТБ Онлайн — современный и безопасный цифровой банк, который всегда под рукой. В любой момент вы можете быстро и удобно совершать платежи и переводы, контролировать счета и управлять своими финансами.

🔒 Безопасность на первом месте
Войти в приложение можно по номеру телефона, коду из СМС или биометрии — выбирайте удобный способ для себя. Для онлайн-защиты установите определитель номера и самозапреты на снятие наличных, кредиты и другие операции, подключите сервис «защита близких» и используйте «тревожную кнопку» для сообщения о мошеннических операциях. Больше информации о том, как себя обезопасить, читайте в разделе «Безопасность»."""
        ),
        App(
            icon = "https://static.rustore.ru/imgproxy/FjgsClgg0crUVE9DiaueyRVtmQQMrZ7fYyNh88Gedq0/preset:web_app_icon_160/plain/https://static.rustore.ru/afb07f02-5399-4f45-a366-e49a7b3420ad@webp",
            title = "Альфа-Банк",
            category = Category.FINANCE,
            description = """Лучший мобильный банк пять лет подряд по версии Markswebb

Мобильное приложение Альфа-Банка — это безопасный доступ к вашим счетам и банковским картам. В любой момент вы можете сделать быстрый перевод близкому человеку, проверить, сколько денег осталось, оформить кредит онлайн или пополнить счёт мобильного."""
        ),
        App(
            icon = "https://static.rustore.ru/imgproxy/5mxpzJGODrELiruaecHe6JeJ2RKs9c4tbuREgPUoe0g/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/2024529087/content/ICON/b6616286-ea99-40fc-85f8-e36f2b59465a.png@webp",
            title = "Ozon Банк: выгодные покупки",
            category = Category.FINANCE,
            description = """Откройте бесплатную банковскую Ozon Карту в мобильном Ozon Банке, и вы сможете получать кешбэк за покупки даже за пределами Ozon. До 25% — в категориях повышенного кешбэка, 1% — за остальные покупки за пределами Ozon.

Используйте пластиковую Ozon Карту или добавьте виртуальную Ozon Карту в Mir Pay и оплачивайте покупки со смартфона!"""
        ),
        App(
            icon = "https://static.rustore.ru/imgproxy/M4yIW2hN3Nfg5_WjYdl0VZM6hwPq2-XfM3uuwGJshWI/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/6/30/b6/apk/514239/content/ICON/8a44b15d-a16e-41a4-b926-9088693015ca.png@webp",
            title = "OZON: товары, одежда, билеты",
            category = Category.SHOPPING,
            description = """Ozon — крупный маркетплейс в России с быстрой доставкой и выгодными ценами.

На Ozon удобно покупать каждый день: широкий ассортимент, скидки и доставка от 1 дня по всей стране. В приложении вы найдёте всё для дома, работы, отдыха и путешествий — в одном месте и без лишних шагов."""
        ),
        App(
            icon = "https://static.rustore.ru/imgproxy/6N0m3heN9vooK5mQ2eqkSYr32Lux3QSOPiMh14YqM30/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/2/19/d7/apk/537791/content/ICON/b2916730-6a34-4ebe-aedf-df926e807741.png@webp",
            title = "Госуслуги",
            category = Category.GOVERNMENT,
            description = """Приложение «Госуслуги» — ваш помощник для взаимодействия с ведомствами и государством

В приложении можно оплачивать штрафы и госпошлины, подавать заявления в ведомства, хранить личные документы и предъявлять их в бытовых ситуациях, сканировать товары, управлять согласиями на использование личных и биометрических данных и многое другое."""
        ),
        App(
            icon = "https://static.rustore.ru/imgproxy/OYKFMgpckkNGCd1jKcnHKojgnsMJ09qjfr9TYyjkyx4/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/2/2/1e/apk/260799/content/ICON/8e439c58-11cf-4e0a-a3dc-9596eda08cfd.png@webp",
            title = "2ГИС: навигатор, транспорт, друзья на карте",
            category = Category.MAPS,
            description = """Карте бензина в 2ГИС — узнайте, работает ли заправка, насколько она загружена, есть ли сейчас топливо и ограничения на продажу. Данные обновляем каждые 10 минут.

Карта, навигатор, общественный транспорт, путеводитель, справочник, а также локатор для отслеживания местоположения близких на карте в одном приложении. 2ГИС покажет ваше местоположение, найдёт нужный адрес, поможет спланировать маршрут на машине, автобусе, велосипеде или пешеходный. А ещё друзья прямо на карте!"""
        ),
        App(
            icon = "https://static.rustore.ru/imgproxy/XZTurDFM5sMC9kQZ0HVSEankh6Q9kAtrkWOQ5KUkhoo/preset:web_app_icon_160/plain/https://static.rustore.ru/2025/9/10/6d/apk/994584511/content/ICON/27a78d43-a664-4fe0-a69d-3edc896c8176.png@webp",
            title = "Яндекс Книги",
            category = Category.ENTERTAINMENT,
            description = "Яндекс Книги — лёгкий способ читать и слушать книжные новинки и бестселлеры в удобном приложении"
        ),
        App(
            icon = "https://static.rustore.ru/imgproxy/7710ZzLRdVSNKrA9-y4LfSwBDDoYj9GHc9k4riI5YZU/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/2844095/content/ICON/ecfab09e-2c74-4d5a-9c75-5f46351e156c.png@webp",
            title = "Литрес: Книги и аудиокниги",
            category = Category.ENTERTAINMENT,
            description = """Литрес — ваш проводник в мир литературы!

Литрес — крупнейший сервис электронных и аудиокниг в России*, где вы всегда найдёте что почитать: эксклюзивы, бестселлеры, новинки и классика литературы. Более 1 миллиона электронных книг в текстовом и аудиоформате ждут вас!"""
        ),
        App(
            icon = "https://static.rustore.ru/imgproxy/y27V6ORx0W7Ie-4SaHQYqMGAlEgKgUrMktoiNfnOaq8/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/9/11/e2/apk/2063755997/content/ICON/c43430ab-1d75-42c4-929d-bc413b35dcd7.png@webp",
            title = "Netflix",
            category = Category.ENTERTAINMENT,
            description = """Ищете фильмы и сериалы, которые смотрят и обсуждают во всем мире? Все это есть на Netflix. Приложение безопасно, работает быстро и всегда под рукой, чтобы вы могли наслаждаться контентом без задержек.

Откройте для себя удостоенные наград фильмы, сериалы, прямые трансляции, подкасты и игры с мобильным приложением. Теперь you не пропустите ни одного момента из мира Netflix ни в путешествии, ни по дороге на работу, ни в перерыве между дел."""
        )
    )
}