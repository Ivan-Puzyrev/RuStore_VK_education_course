package com.ivanpuzyrev.rustorevkeducationcourse.data

import com.ivanpuzyrev.rustorevkeducationcourse.domain.App
import com.ivanpuzyrev.rustorevkeducationcourse.domain.Category

object AppRepository {
    private val appList = listOf(
        App(
            id = 1,
            iconUrl = "https://static.rustore.ru/imgproxy/-fb8TfFrlYjwu7wYCEPuKsm4wWkTLBTx_0_a9GpeKfc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/2027823295/content/ICON/97486018-5785-424d-9cab-4fe496d27c76.png@webp",
            title = "VK Видео: кино, сериалы, ТВ, мультфильмы и клипы",
            category = Category.ENTERTAINMENT,
            description = """Смотри кино, мультики, сериалы, ТВ онлайн, спортивные трансляции, короткие видео и фильмы бесплатно на всех устройствах: от смартфона до телевизора. Премьеры и блокбастеры из кинотеатров и онлайн-платформ на твоем девайсе!

Откройте интертеймент без границ с VK Видео: онлайн-просмотр ТВ, новинки кино и сериалов, познавательные и развлекательные видео, мультики для детей (без интернета), эксклюзивный контент, спортивные трансляции и смешные клипы ждут тебя. Ты можешь скачать видео для офлайн просмотра в один клик.""",
            developer = "VK",
            ageLimit = 12,
            size = 96,
            screenshotsUrls = listOf(
                "https://static.rustore.ru/imgproxy/ZCsMXpX_Bp3gIRjnrtPm15UZtsDaEoPlM_o17_9sCvo/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/4/15/39/apk/2027823295/content/SCREENSHOT/0cff6242-3ca9-4591-b6e7-42fbd31b4b2c.jpg@webp",
                "https://static.rustore.ru/imgproxy/cGHqGrlUXmRaql71aP4Dluu9cC5ftyFai2jy7bHJUQo/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/4/15/5e/apk/2027823295/content/SCREENSHOT/508b971e-1220-4592-ae1f-a3f31f03dfd7.png@webp",
                "https://static.rustore.ru/imgproxy/X0KjzkehfR5slDEnBiqJiGsE1euR_5HkssZCHwV1Rs4/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/7/2/f1/apk/2027823295/content/SCREENSHOT/8398b9a4-872c-4880-9b3d-fb885c31551f.png@webp",
                "https://static.rustore.ru/imgproxy/oiqHAEiezmNxr18vBWl_pLHKItgtmgdkItUBX9mt5yM/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/4/15/7c/apk/2027823295/content/SCREENSHOT/6ce5fc10-745a-4363-b693-6f05803e2b91.png@webp",
                "https://static.rustore.ru/imgproxy/_gPBXyXbUmImpa6kuucTGiEO2FQCPTfPHgm-gzD0sHg/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/7/13/aa/apk/2027823295/content/SCREENSHOT/e2576fd7-b475-4209-8b67-d0651c05f016.png@webp",
                "https://static.rustore.ru/imgproxy/s07-iEDuleCwnodV98yOZ1Nu-Hr1GgLGl_TVRtQkPzk/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/4/15/f7/apk/2027823295/content/SCREENSHOT/576f9603-1e46-42c8-9846-1b46e740d5a2.png@webp"
            )
        ),
        App(
            id = 2,
            iconUrl = "https://static.rustore.ru/imgproxy/PTo8g-Giv9VHYo7_Rwxw_1wC07KtDM7eSJgAfMlv53s/preset:web_app_icon_160/plain/https://static.rustore.ru/3f3d7180-6eb9-45ad-8706-f467c6dcf82a@webp",
            title = "ВКонтакте: чаты, видео, музыка",
            category = Category.COMMUNICATION,
            description = """ВКонтакте — это общение, бесплатные звонки, мессенджер и чат, музыка и видео, игры и мини-приложения для любых задач, десятки миллионов людей и безграничные возможности для развлечений, бизнеса и обмена новостями из любой точки мира.

Отправляйте сообщения.
В мессенджере можно общаться не только с друзьями ВКонтакте, но и с контактами из вашей телефонной книги. Не забывайте заводить знакомства в соцсети и использовать мессенджер для общения! В чатах есть видеосообщения, персональные стикеры, яркие фоны, исчезающие и голосовые сообщения.""",
            developer = "VK",
            ageLimit = 12,
            size = 126,
            screenshotsUrls = listOf(
                "https://static.rustore.ru/imgproxy/tPlNYbKway4jR_sNz2e3TjBpspq5VpyM6NIjhJkfcRU/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/5/6/d3/apk/317631/content/SCREENSHOT/3e54a2d0-13a1-4508-a8dd-b93a05ea2a63.jpg@webp",
                "https://static.rustore.ru/imgproxy/8fmR6mS-5tml1vxpxXGsgBfXpfnnkLS4gbNmz6KEWsI/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/5/6/26/apk/317631/content/SCREENSHOT/e7535e33-6e0e-4cc2-bd2e-08d5499948f5.jpg@webp",
                "https://static.rustore.ru/imgproxy/8vNWMwSGcHsvicKHzk_FyoXYcHCw5hrkIoULE1_-3Mk/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/5/6/2f/apk/317631/content/SCREENSHOT/43bb1c06-5d7c-4035-940e-4160714bc9f4.jpg@webp",
                "https://static.rustore.ru/imgproxy/EX_CjAITJRR0HzlIRmOmxmnhfuLAS1YAmjY5uw0WQds/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/5/6/9a/apk/317631/content/SCREENSHOT/769fc419-7340-42ca-ad05-1e9ab10a5ba6.jpg@webp",
                "https://static.rustore.ru/imgproxy/3NQx0HA6bCl2ON7wIYsDURrJKBafuR_0W-QK0ebdEJ4/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/5/6/65/apk/317631/content/SCREENSHOT/23919033-aaff-41df-aaaa-6d53324e7284.jpg@webp",
                "https://static.rustore.ru/imgproxy/ESedwSiuxiArwL8TEs5FWBDpW5vgXOFz_JqqMzu5UBU/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/5/6/0d/apk/317631/content/SCREENSHOT/1ec20e52-671b-47c1-b6ce-29b2ae00e870.png@webp"
            )
        ),
        App(
            id = 3,
            iconUrl = "https://static.rustore.ru/imgproxy/7HOcGO9T6TglJ15g7aDv0CiensvQL4TYOQvtE46lR6E/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/1/27/d8/apk/2688703/content/ICON/ea0c42d8-934f-41a6-a3da-89798736f888.png@webp",
            title = "Авито – путешествия, работа, услуги, авто",
            category = Category.SERVICES,
            description = """На Авито каждый может найти что-то своё среди миллионов частных объявлений и предложений компаний по всей России: от квартиры и отеля, автомобиля и ремонта, до работы и кандидатов на вакансии.

Кроме того, на Авито можно найти разнообразные услуги в сферах ремонта, образования, красоты, здоровья и многих других, а также профессиональные консультации — от репетиторов и тренеров до юристов и бухгалтеров. Платформа предоставляет множество вариантов для поиска специалистов, подходящих под любые требования и бюджет.""",
            developer = "ООО \"КЕХ еКоммерц\"",
            ageLimit = 0,
            size = 236,
            screenshotsUrls = listOf(
                "https://static.rustore.ru/imgproxy/p1j4XGe5wsOfER3mCNasdYs2Eu_tKk8JcRErPZswwrU/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/7/17/0f/apk/2688703/content/SCREENSHOT/6c09afa6-d4fd-4d24-a84f-24e07fbc96f8.png@webp",
                "https://static.rustore.ru/imgproxy/KRGPiL2CJ6f_6MWQxxGHyqEgMmC7-7NFYk9KozFIq30/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/4/20/38/apk/2688703/content/SCREENSHOT/9e50e796-9c0a-4a40-927f-a3bd5c4bf047.jpg@webp",
                "https://static.rustore.ru/imgproxy/d2OtHIvOso_Zo8LSq_G8WEUetHiMffiMHxVPVMi6vdM/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/3/d3/apk/2688703/content/SCREENSHOT/d19586e4-115c-48ae-bc0c-adc5f757213e.png@webp",
                "https://static.rustore.ru/imgproxy/q8TRK22zWrxUwdf5pwSjRqwZJnxwJ1yWgto_TG488h0/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/3/01/apk/2688703/content/SCREENSHOT/a095d237-b0dd-4845-9d4e-da822ed7eb2e.png@webp",
                "https://static.rustore.ru/imgproxy/HKOe7ZY62-m334KgqJlF7sYwiIxSjoTif6l7hnfWlSc/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/3/4e/apk/2688703/content/SCREENSHOT/08091df3-f33c-42c9-9d69-c6973d5be619.png@webp",
                "https://static.rustore.ru/imgproxy/gARgXOXiqSkgDjA1TcnRO1vERuf3qkojeGqBIPBaT6s/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/3/1c/apk/2688703/content/SCREENSHOT/9b12fe94-1d35-4bba-a4d4-1a04d89788ee.png@webp"
            )
        ),
        App(
            id = 4,
            iconUrl = "https://static.rustore.ru/imgproxy/qriFjN8OV6VBF4CCbWcxPm7SL0Y0YtMfxTeJSzWZ1Rc/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png@webp",
            title = "СберБанк Онлайн",
            category = Category.FINANCE,
            description = """СберБанк Онлайн — ваш надёжный помощник в ежедневных делах. Все финансовые и нефинансовые возможности доступны в одном приложении: от быстрых платежей и удобных переводов до сервисов для жизни, покупок и путешествий.

На главном экране собраны самые нужные финансовые инструменты. Баланс карты, переводы, история операций, информация о бонусах Спасибо и расходы за месяц — все действия доступны в несколько кликов.""",
            developer = "СберБанк Онлайн",
            ageLimit = 0,
            size = 120,
            screenshotsUrls = listOf(
                "https://static.rustore.ru/imgproxy/glCtpJ1upJCoD5L_-N-eUoCeEKexNfL6UL4nlWyK28I/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/10/82/apk/462271/content/SCREENSHOT/606d04b0-7394-44f6-a09e-4e421fdc29cd.png@webp",
                "https://static.rustore.ru/imgproxy/bLcQxZ1t-IALSX8ef1dEGObHpunx0CWhTXHhxHAXL-U/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/10/57/apk/462271/content/SCREENSHOT/1ce4c330-e6a0-44e8-a8bf-cd159c52e88b.png@webp",
                "https://static.rustore.ru/imgproxy/OkfoiKj_r2GnV4WlUD6wUo42CpSFW4OCrkP08C_T47A/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/10/ad/apk/462271/content/SCREENSHOT/7f0e81c1-9bb8-4208-a97d-09eb98675330.png@webp",
                "https://static.rustore.ru/imgproxy/es5AAR-q7nzbHBO9nfiwHpejBpE-zZCwOqBy07hslD8/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/10/68/apk/462271/content/SCREENSHOT/dcbeb7aa-6d5c-4af4-ad54-fa6d7ea6e800.png@webp"
            )
        ),
        App(
            id = 5,
            iconUrl = "https://static.rustore.ru/imgproxy/qqoP1Cyi4tplnwb8Z_yJ2mnWVhuen4kzin6tQLWsSHY/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/220863/content/ICON/2238e3ca-e3e7-41d0-b037-777ddc637a5b.png@webp",
            title = "Т-Банк: карты, вклады, кредиты",
            category = Category.FINANCE,
            description = """Т-Банк — приложение для управления деньгами и картами онлайн. Оплачивайте ЖКХ, штрафы ГИБДД и госуслуги без комиссии, переводите через СБП, копите на вкладах и инвестируйте — всё под рукой.

Дебетовая карта Black — пластиковая МИР или виртуальная. Оплачивайте счета бесконтактно и телефоном, получайте кэшбэк рублями за покупки. Если нужны дополнительные деньги, подойдет кредитка Платинум с лимитом до 1 000 000 ₽.""",
            developer = "АО «ТБанк»",
            ageLimit = 0,
            size = 232,
            screenshotsUrls = listOf(
                "https://static.rustore.ru/imgproxy/hLcnZNbojpOz2tj6qrAhsgNJcTWURgt_p4SDqwLWgjE/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/9/30/f1/apk/220863/content/SCREENSHOT/a99db8d2-1771-49b9-9dec-b965184a42a6.png@webp",
                "https://static.rustore.ru/imgproxy/CbiJl01Kv9-Sys7afoTvLPKA2yQ8eyqNuBt3F5fCj_Q/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/9/30/af/apk/220863/content/SCREENSHOT/2811bcf2-5e0e-4cd6-a7d5-a27cdd351f33.png@webp",
                "https://static.rustore.ru/imgproxy/vxIacvepP55ugICvJHndO3QAfgpWRWRzz2ooBEouFWk/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/9/30/2a/apk/220863/content/SCREENSHOT/52a7432c-ca4d-4952-95cb-5b793764c894.png@webp",
                "https://static.rustore.ru/imgproxy/qXEobyZ2bLgjsvQNX8qXExmgU0DzfgvHL3RHlReXHDs/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/9/30/f8/apk/220863/content/SCREENSHOT/59a2589b-29f0-4bcd-b8f8-e36b6f393c47.png@webp",
                "https://static.rustore.ru/imgproxy/WwI0h7DlmJ0lygV7X7WOXg-G6WnFCkEGxbAM4NgQfSg/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/9/30/24/apk/220863/content/SCREENSHOT/8228964f-e741-4445-aca9-47cca4bb81c0.png@webp",
                "https://static.rustore.ru/imgproxy/2L8DjW3-n9jy_H20HgCuTlP065QdqXShLjRRsWg9YjI/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/9/30/86/apk/220863/content/SCREENSHOT/b4d35726-6ca7-4e88-bbe6-932dbecfcede.png@webp"
            )
        ),
        App(
            id = 6,
            iconUrl = "https://static.rustore.ru/imgproxy/lzg_3CHk-oqIqIfBj0KFQ-vhwK6NUJk6qC1r1Lt0fKM/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/3/28/37/apk/404415/content/ICON/577a3521-f7ef-4322-ab3c-c96b9262c562.png@webp",
            title = "ВТБ Онлайн",
            category = Category.FINANCE,
            description = """Мобильное приложение ВТБ Онлайн — современный и безопасный цифровой банк, который всегда под рукой. В любой момент вы можете быстро и удобно совершать платежи и переводы, контролировать счета и управлять своими финансами.

🔒 Безопасность на первом месте
Войти в приложение можно по номеру телефона, коду из СМС или биометрии — выбирайте удобный способ для себя. Для онлайн-защиты установите определитель номера и самозапреты на снятие наличных, кредиты и другие операции, подключите сервис «защита близких» и используйте «тревожную кнопку» для сообщения о мошеннических операциях. Больше информации о том, как себя обезопасить, читайте в разделе «Безопасность».""",
            developer = "Банк ВТБ (ПАО)",
            ageLimit = 0,
            size = 185,
            screenshotsUrls = listOf(
                "https://static.rustore.ru/imgproxy/aPkzR8SEc3VDN-FcftT-GGSQc3fc8LpRRdQTsuKPZYM/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/3/28/12/apk/404415/content/SCREENSHOT/a0a1e69a-38c0-4d1a-a131-00ef13185ff6.png@webp",
                "https://static.rustore.ru/imgproxy/rZGvtrUtwnxhGkoxibFxG2PipN2v_IN55YJeX2RI5dw/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/3/28/53/apk/404415/content/SCREENSHOT/fc38e187-d67b-44fd-8311-df364cb41407.png@webp",
                "https://static.rustore.ru/imgproxy/g_cb0EoyjClQGws9sKm9iN_huFNqd0PYrnfBidOVQ5E/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/3/28/69/apk/404415/content/SCREENSHOT/e7dd16b6-d853-4268-9a2d-f9d947d96ce8.png@webp",
                "https://static.rustore.ru/imgproxy/3OyBWXjfjQUD_aUrhBaRKSoET06P4ixhb5HqOTDMljg/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/3/28/e8/apk/404415/content/SCREENSHOT/3ec7ee40-fc0c-4c1f-9e8a-5b75d51c6f84.png@webp",
                "https://static.rustore.ru/imgproxy/phpkq-_ClUI40luSSUxOtSqt3qd4qwvrvTwjIgaMaVw/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/3/28/ae/apk/404415/content/SCREENSHOT/b72c1efa-470b-4450-8f0e-9b0b00bcb2d5.png@webp",
                "https://static.rustore.ru/imgproxy/stxF8Gra1DZWJipiLCaQLvcy-ZEpR46PL1zaQoXfJ7Y/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/3/28/cc/apk/404415/content/SCREENSHOT/8a395630-5f48-4da4-9356-d6c316739c77.png@webp"
            )
        ),
        App(
            id = 7,
            iconUrl = "https://static.rustore.ru/imgproxy/FjgsClgg0crUVE9DiaueyRVtmQQMrZ7fYyNh88Gedq0/preset:web_app_icon_160/plain/https://static.rustore.ru/afb07f02-5399-4f45-a366-e49a7b3420ad@webp",
            title = "Альфа-Банк",
            category = Category.FINANCE,
            description = """Лучший мобильный банк пять лет подряд по версии Markswebb

Мобильное приложение Альфа-Банка — это безопасный доступ к вашим счетам и банковским картам. В любой момент вы можете сделать быстрый перевод близкому человеку, проверить, сколько денег осталось, оформить кредит онлайн или пополнить счёт мобильного.""",
            developer = "ВТБ Онлайн",
            ageLimit = 0,
            size = 185,
            screenshotsUrls = listOf(
                "https://static.rustore.ru/imgproxy/aPkzR8SEc3VDN-FcftT-GGSQc3fc8LpRRdQTsuKPZYM/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/3/28/12/apk/404415/content/SCREENSHOT/a0a1e69a-38c0-4d1a-a131-00ef13185ff6.png@webp",
                "https://static.rustore.ru/imgproxy/rZGvtrUtwnxhGkoxibFxG2PipN2v_IN55YJeX2RI5dw/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/3/28/53/apk/404415/content/SCREENSHOT/fc38e187-d67b-44fd-8311-df364cb41407.png@webp",
                "https://static.rustore.ru/imgproxy/g_cb0EoyjClQGws9sKm9iN_huFNqd0PYrnfBidOVQ5E/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/3/28/69/apk/404415/content/SCREENSHOT/e7dd16b6-d853-4268-9a2d-f9d947d96ce8.png@webp",
                "https://static.rustore.ru/imgproxy/3OyBWXjfjQUD_aUrhBaRKSoET06P4ixhb5HqOTDMljg/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/3/28/e8/apk/404415/content/SCREENSHOT/3ec7ee40-fc0c-4c1f-9e8a-5b75d51c6f84.png@webp",
                "https://static.rustore.ru/imgproxy/phpkq-_ClUI40luSSUxOtSqt3qd4qwvrvTwjIgaMaVw/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/3/28/ae/apk/404415/content/SCREENSHOT/b72c1efa-470b-4450-8f0e-9b0b00bcb2d5.png@webp",
                "https://static.rustore.ru/imgproxy/stxF8Gra1DZWJipiLCaQLvcy-ZEpR46PL1zaQoXfJ7Y/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/3/28/cc/apk/404415/content/SCREENSHOT/8a395630-5f48-4da4-9356-d6c316739c77.png@webp"
            )
        ),
        App(
            id = 8,
            iconUrl = "https://static.rustore.ru/imgproxy/5mxpzJGODrELiruaecHe6JeJ2RKs9c4tbuREgPUoe0g/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/2024529087/content/ICON/b6616286-ea99-40fc-85f8-e36f2b59465a.png@webp",
            title = "Ozon Банк: выгодные покупки",
            category = Category.FINANCE,
            description = """Откройте бесплатную банковскую Ozon Карту в мобильном Ozon Банке, и вы сможете получать кешбэк за покупки даже за пределами Ozon. До 25% — в категориях повышенного кешбэка, 1% — за остальные покупки за пределами Ozon.

Используйте пластиковую Ozon Карту или добавьте виртуальную Ozon Карту в Mir Pay и оплачивайте покупки со смартфона!""",
            developer = "ООО \"Интернет Решения\"\n",
            ageLimit = 0,
            size = 127,
            screenshotsUrls = listOf(
                "https://static.rustore.ru/imgproxy/U8uo8LLkq_ThlUBMlWgEWAssYiMa8cJCg1c5tDqasvo/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/26/fa/apk/2024529087/content/SCREENSHOT/d6deebac-a901-4ad9-b6f2-47ab001a32c4.png@webp",
                "https://static.rustore.ru/imgproxy/c_LdnoMknG4EENwXBprA0sCJHo6ms553ME2Qy3sFRgg/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/26/38/apk/2024529087/content/SCREENSHOT/50071593-61c8-4f23-8df8-aeaf9ead3b8e.png@webp",
                "https://static.rustore.ru/imgproxy/6WeHYciC8Lk5ispx4ZMS4ZRSRUG8V5xTHH5EEVuGlc8/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/26/39/apk/2024529087/content/SCREENSHOT/a788018b-a0fe-429b-9c96-c62f4703ca2e.png@webp",
                "https://static.rustore.ru/imgproxy/E0u_mL6TdZkF-PcZGRQUC6W4mX4xgdrez-bGTqIc6RE/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/26/3c/apk/2024529087/content/SCREENSHOT/80441e80-a318-4299-9794-268de26c0382.png@webp",
                "https://static.rustore.ru/imgproxy/FRb4aIvWsXLVjctgVVQV1bQfXWlk5aHm3lIie5rvlXA/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/26/1b/apk/2024529087/content/SCREENSHOT/110cf10d-bb6c-4eb9-b053-42876a441e44.png@webp",
                "https://static.rustore.ru/imgproxy/qvE7Mt98pYMFFBssiFNzQv-xpYvWfn3tQTKhfollvLU/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/26/d5/apk/2024529087/content/SCREENSHOT/662d1b13-29b1-46f1-a428-6361ecb179c4.png@webp"
            )
        ),
        App(
            id = 9,
            iconUrl = "https://static.rustore.ru/imgproxy/M4yIW2hN3Nfg5_WjYdl0VZM6hwPq2-XfM3uuwGJshWI/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/6/30/b6/apk/514239/content/ICON/8a44b15d-a16e-41a4-b926-9088693015ca.png@webp",
            title = "OZON: товары, одежда, билеты",
            category = Category.SHOPPING,
            description = """Ozon — крупный маркетплейс в России с быстрой доставкой и выгодными ценами.

На Ozon удобно покупать каждый день: широкий ассортимент, скидки и доставка от 1 дня по всей стране. В приложении вы найдёте всё для дома, работы, отдыха и путешествий — в одном месте и без лишних шагов.""",
            developer = "ООО \"Интернет Решения\"\n",
            ageLimit = 0,
            size = 111,
            screenshotsUrls = listOf(
                "https://static.rustore.ru/imgproxy/edSNXen1Wu2GpX55P6Iheu8U8NTy6xoU-VhT0Xcbk5E/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/2/c9/apk/514239/content/SCREENSHOT/4874316f-ffb7-4803-99bb-5cfaac48631e.jpg@webp",
                "https://static.rustore.ru/imgproxy/A8N9S-u2wq5yQmqrK3shBFAIsrh72AaGCgidIyQpUJE/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/2/3c/apk/514239/content/SCREENSHOT/81f2cc3b-4654-4239-8222-aac10398ed1b.jpg@webp",
                "https://static.rustore.ru/imgproxy/df9umjkME2j-aSSMJS5o7QQdyCB_K7AlXbX0czyoMf8/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/2/3c/apk/514239/content/SCREENSHOT/268f91e9-67ae-42b1-9151-d2bd087457aa.jpg@webp",
                "https://static.rustore.ru/imgproxy/u0PtH_CxHQhbK-GTp8UxJxVxABGjJz1ODL1vL8k836k/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/2/eb/apk/514239/content/SCREENSHOT/2dd47bde-0e08-4eab-98b4-282edb0a75e2.jpg@webp",
                "https://static.rustore.ru/imgproxy/qf1C4_ERkbqWGpaCIlgztvt6ATlmIbJRSbGnr_Jv6qU/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/2/03/apk/514239/content/SCREENSHOT/3faafe63-5494-42ca-b67f-dd65bfa8dd20.jpg@webp",
                "https://static.rustore.ru/imgproxy/PmO0C84ALP7G2CPo3bmXSwzeOvue5U36VZR-l6UfTB4/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/2/8f/apk/514239/content/SCREENSHOT/80d52352-3d2d-4fec-84b7-a37386326f6f.jpg@webp"
            )
        ),
        App(
            id = 10,
            iconUrl = "https://static.rustore.ru/imgproxy/6N0m3heN9vooK5mQ2eqkSYr32Lux3QSOPiMh14YqM30/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/2/19/d7/apk/537791/content/ICON/b2916730-6a34-4ebe-aedf-df926e807741.png@webp",
            title = "Госуслуги",
            category = Category.GOVERNMENT,
            description = """Приложение «Госуслуги» — ваш помощник для взаимодействия с ведомствами и государством

В приложении можно оплачивать штрафы и госпошлины, подавать заявления в ведомства, хранить личные документы и предъявлять их в бытовых ситуациях, сканировать товары, управлять согласиями на использование личных и биометрических данных и многое другое.""",
            developer = "Министерство цифрового развития, связи и массовых коммуникаций Российской Федерации\n",
            ageLimit = 0,
            size = 151,
            screenshotsUrls = listOf(
                "https://static.rustore.ru/imgproxy/4xMKiAgeBZhkuPHL5qMh7SYS6jt9xtikStDu74TJaHc/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/25/ac/apk/537791/content/SCREENSHOT/a8b8dd05-fc73-4cbb-8ae5-7d9ea578db2f.png@webp",
                "https://static.rustore.ru/imgproxy/rQ36DqvDhRwitYfiFSyPiQNKL0oRloJfzEdFhLm7LiI/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/25/0d/apk/537791/content/SCREENSHOT/a22d257d-e361-48f3-b0db-04d42a12e88b.png@webp",
                "https://static.rustore.ru/imgproxy/sWBLb4Fwcpe0P1n34st2daNH8YL1Ll3_MuYTpVBRLOM/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/25/25/apk/537791/content/SCREENSHOT/eca9e98f-b5ae-4a7e-b28a-85a1d1e3987b.png@webp",
                "https://static.rustore.ru/imgproxy/zsB66Zcsfi1LD3YA79awXI8-qWCsZIDI6CjXAe7xhxA/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/25/41/apk/537791/content/SCREENSHOT/da47acce-30a0-4c34-9e06-0f8ddb302380.png@webp",
                "https://static.rustore.ru/imgproxy/KeDLQCMFS2dUVVXBXNqKjp5SOzGrh91kAd_InxiTmdo/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/25/e2/apk/537791/content/SCREENSHOT/fb843364-8a62-4b6d-9fe0-cb218bfd7bea.png@webp",
                "https://static.rustore.ru/imgproxy/yTev3k-N5yLIUQN1vO4ASLwbyWjgAFoGQf8UAC_fq1k/preset:web_scr_prt_384/plain/https://static.rustore.ru/2025/11/25/e3/apk/537791/content/SCREENSHOT/3ec2aec8-89ad-4590-b12c-f901044692b5.png@webp"
            )
        ),
        App(
            id = 11,
            iconUrl = "https://static.rustore.ru/imgproxy/OYKFMgpckkNGCd1jKcnHKojgnsMJ09qjfr9TYyjkyx4/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/2/2/1e/apk/260799/content/ICON/8e439c58-11cf-4e0a-a3dc-9596eda08cfd.png@webp",
            title = "2ГИС: навигатор, транспорт, друзья на карте",
            category = Category.MAPS,
            description = """Карте бензина в 2ГИС — узнайте, работает ли заправка, насколько она загружена, есть ли сейчас топливо и ограничения на продажу. Данные обновляем каждые 10 минут.

Карта, навигатор, общественный транспорт, путеводитель, справочник, а также локатор для отслеживания местоположения близких на карте в одном приложении. 2ГИС покажет ваше местоположение, найдёт нужный адрес, поможет спланировать маршрут на машине, автобусе, велосипеде или пешеходный. А ещё друзья прямо на карте!""",
            developer = "ООО \"ДубльГИС\"\n",
            ageLimit = 0,
            size = 282,
            screenshotsUrls = listOf(
                "https://static.rustore.ru/imgproxy/JpVseW-lgPlFvEzz8RfY85XtokxZwPKUwJIBEoRAMws/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/15/4b/apk/260799/content/SCREENSHOT/01cdca67-cf61-4c6c-b9ac-9578d14ba35e.jpg@webp",
                "https://static.rustore.ru/imgproxy/moYBVY8nHIewWUNILyqsMyjMRWsibrRrlxFKTq-_e4Q/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/15/86/apk/260799/content/SCREENSHOT/5b7fdec8-7141-4d3b-9f70-5ab5278dbf61.jpg@webp",
                "https://static.rustore.ru/imgproxy/zKgm975DrORTlmi084eZYpRQ00-Z3Va35xhnHwiuuAU/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/15/30/apk/260799/content/SCREENSHOT/4323707c-ef9e-48c7-b71f-7cb94f1842c9.jpg@webp",
                "https://static.rustore.ru/imgproxy/rJu_NXbn4hEaHGBps8oPGzWoG6XwyHxRyOZXo787aok/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/15/1b/apk/260799/content/SCREENSHOT/eb633235-ba6f-4dfb-ac8e-a41c8514b656.jpg@webp",
                "https://static.rustore.ru/imgproxy/fXGtNOlxvUxmF-5VesyGiinkn29tkmFdxrYofoVWx4k/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/15/f4/apk/260799/content/SCREENSHOT/62aa3edb-7f75-4308-837b-281aa6f4e6d0.jpg@webp",
                "https://static.rustore.ru/imgproxy/-V_1IyXKeseotDk8u25yxtlZ9cNW1YYUxZcoZ3P3EqM/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/15/5f/apk/260799/content/SCREENSHOT/4d5fd046-6e17-4adf-93a3-8405fb6c0c22.jpg@webp"
            )
        ),
        App(
            id = 12,
            iconUrl = "https://static.rustore.ru/imgproxy/XZTurDFM5sMC9kQZ0HVSEankh6Q9kAtrkWOQ5KUkhoo/preset:web_app_icon_160/plain/https://static.rustore.ru/2025/9/10/6d/apk/994584511/content/ICON/27a78d43-a664-4fe0-a69d-3edc896c8176.png@webp",
            title = "Яндекс Книги",
            category = Category.ENTERTAINMENT,
            description = "Яндекс Книги — лёгкий способ читать и слушать книжные новинки и бестселлеры в удобном приложении",
            developer = "ООО \"ЯНДЕКС\"\n",
            ageLimit = 0,
            size = 50,
            screenshotsUrls = listOf(
                "https://static.rustore.ru/imgproxy/Kq92k4FhVGVShCeQqZawA9FyC_QunIJQ7ZobIhfC5MQ/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/8/20/ec/apk/994584511/content/SCREENSHOT/477ecaa4-f259-46ad-8337-9a3e31419558.jpg@webp",
                "https://static.rustore.ru/imgproxy/EafIu_yp4ticR_uPZhe8T7uDa1oOuxCFe0fClAqnhho/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/8/20/2f/apk/994584511/content/SCREENSHOT/2b8261e1-33d6-4548-bb47-46833adc02b1.jpg@webp",
                "https://static.rustore.ru/imgproxy/_Ht_uykHTJH_5gYGDPXlaJXWP4jykBa-vTnjW_Xx-y0/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/8/20/1a/apk/994584511/content/SCREENSHOT/acf14697-5e20-4ed1-ac56-6d0ac58e61d4.jpg@webp",
                "https://static.rustore.ru/imgproxy/Xb19ZCbQM9egobuf7YhmkA21EPxfh-yaI7_B4CMyfwQ/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/8/20/66/apk/994584511/content/SCREENSHOT/18f51adc-0f6e-4037-be24-2f16ab161626.jpg@webp",
                "https://static.rustore.ru/imgproxy/zzWKtfYrdR0YKWDAaKKsYuvMppdzUBaf2tawzhV4Fr4/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/8/20/4a/apk/994584511/content/SCREENSHOT/c25418d2-2e8e-4d5b-961b-d7456706e051.jpg@webp",
                "https://static.rustore.ru/imgproxy/J0TKsSNd2ssRqm7Ktmp6HwVED3sH1QddgQs5GZ_KSzE/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/8/20/a1/apk/994584511/content/SCREENSHOT/a3fc62d5-9c98-480e-b261-ef0bd34fdcd0.jpg@webp"
            )
        ),
        App(
            id = 13,
            iconUrl = "https://static.rustore.ru/imgproxy/7710ZzLRdVSNKrA9-y4LfSwBDDoYj9GHc9k4riI5YZU/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/2844095/content/ICON/ecfab09e-2c74-4d5a-9c75-5f46351e156c.png@webp",
            title = "Литрес: Книги и аудиокниги",
            category = Category.ENTERTAINMENT,
            description = """Литрес — ваш проводник в мир литературы!

Литрес — крупнейший сервис электронных и аудиокниг в России*, где вы всегда найдёте что почитать: эксклюзивы, бестселлеры, новинки и классика литературы. Более 1 миллиона электронных книг в текстовом и аудиоформате ждут вас!""",
            developer = "ООО \"ЛитРес\"",
            ageLimit = 0,
            size = 73,
            screenshotsUrls = listOf(
                "https://static.rustore.ru/imgproxy/Z9iXghplYAcSDuLq7oxuGofvmU4QPs5ZmNfANobJRq4/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/7/8/d2/apk/2844095/content/SCREENSHOT/ee19401d-e114-43a3-9350-6b9ee6154919.jpeg@webp",
                "https://static.rustore.ru/imgproxy/wJam_TckvpmgS6QpQSGZ3rEKTebyoE9j3Aj36sikMSw/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/7/8/e1/apk/2844095/content/SCREENSHOT/efbbcc38-8690-4382-9944-62370d2f3d6f.jpeg@webp",
                "https://static.rustore.ru/imgproxy/I0EVN510UEHmF6GPMR4yVWXJ84ypGRBvr5hblD1mbv4/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/7/8/33/apk/2844095/content/SCREENSHOT/3f335c6b-cc8d-4935-b4b8-57f3cafa12f9.jpeg@webp",
                "https://static.rustore.ru/imgproxy/vy15akv06KHn8c4I8h0HvhezdJWKTHsDgEZYVVaDBQ0/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/7/8/d6/apk/2844095/content/SCREENSHOT/63ae0284-f321-43d5-a649-eee32e407b4e.jpeg@webp",
                "https://static.rustore.ru/imgproxy/oLI5z_4Zuvv28oszcJpPkCfbARwMEXfZbyXouYIUynA/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/7/8/0e/apk/2844095/content/SCREENSHOT/f4154162-4929-41ee-b50f-ed2ce5291dcd.jpeg@webp",
                "https://static.rustore.ru/imgproxy/xGTEp32tj6aK7zLb0Y-AHcgyho7mdOwmm4p-ysBm_kQ/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/7/8/f1/apk/2844095/content/SCREENSHOT/dbe99ddf-8fe1-4630-bb92-2d2e50898cd1.jpeg@webp"
            )
        ),
        App(
            id = 14,
            iconUrl = "https://static.rustore.ru/imgproxy/y27V6ORx0W7Ie-4SaHQYqMGAlEgKgUrMktoiNfnOaq8/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/9/11/e2/apk/2063755997/content/ICON/c43430ab-1d75-42c4-929d-bc413b35dcd7.png@webp",
            title = "Netflix",
            category = Category.ENTERTAINMENT,
            description = """Ищете фильмы и сериалы, которые смотрят и обсуждают во всем мире? Все это есть на Netflix. Приложение безопасно, работает быстро и всегда под рукой, чтобы вы могли наслаждаться контентом без задержек.

Откройте для себя удостоенные наград фильмы, сериалы, прямые трансляции, подкасты и игры с мобильным приложением. Теперь you не пропустите ни одного момента из мира Netflix ни в путешествии, ни по дороге на работу, ни в перерыве между дел.""",
            developer = "Netflix, Inc.",
            ageLimit = 12,
            size = 33,
            screenshotsUrls = listOf(
                "https://static.rustore.ru/imgproxy/uC9lNMj7aPgwNSweHizOkv00vAEfR7CL7IDCx-pJLcI/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/11/89/apk/2063755997/content/SCREENSHOT/43bf641b-86b2-46ba-91c8-1d898ae78b82.jpeg@webp",
                "https://static.rustore.ru/imgproxy/6s_-izgHJ3vVeB5SKF2pcPxJh78j310p15HM8xesfBE/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/11/56/apk/2063755997/content/SCREENSHOT/39683dcd-e503-4c27-ab88-f2949f8353aa.jpeg@webp",
                "https://static.rustore.ru/imgproxy/SahnrB5OmWkuKKzlGn7jenK0DcggPMoLasYKMgOxxDo/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/11/33/apk/2063755997/content/SCREENSHOT/7342ebca-6aeb-4b34-97d7-820469e3ef22.jpeg@webp",
                "https://static.rustore.ru/imgproxy/vIMU1qGtH0mRs2yyf9lBo54nsk-b7HJD89xh2m4QDxo/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/11/10/apk/2063755997/content/SCREENSHOT/1777d8b4-bcdc-41dc-83fe-cff6160d129c.jpeg@webp",
                "https://static.rustore.ru/imgproxy/D8BaS2vKAOKcWJG1hzfvHfFQ13XD20C9JH2c698z0IA/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/11/19/apk/2063755997/content/SCREENSHOT/c73fa39b-3234-4b25-a804-829c548a74aa.jpeg@webp",
                "https://static.rustore.ru/imgproxy/ziHu_XKRcQ0t7mRtq07VisDTL3HlCkrmOegoUBjtv40/preset:web_scr_prt_384/plain/https://static.rustore.ru/2026/9/11/0d/apk/2063755997/content/SCREENSHOT/091b4834-a411-426e-a39d-914e93d5dab1.jpeg@webp"
            )
        )
    )

    fun getAppList() = appList
    fun getAppById(appId: Int) = appList[appId - 1]
}