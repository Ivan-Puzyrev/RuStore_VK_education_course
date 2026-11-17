package com.ivanpuzyrev.rustorevkeducationcourse

import com.ivanpuzyrev.rustorevkeducationcourse.data.AppDetailsDTO
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppInfoDTO
import com.ivanpuzyrev.rustorevkeducationcourse.data.Mapper
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MapperTest {

    private val mapper = Mapper()

    @Test
    fun `after mapping AppDetailsDTO to AppDetails EXPECT the same app size`() {
        val appDetailsDto = createAppDetailsDTO()
        val appDetails = mapper.appDetailsDTOtoAppDetails(appDetailsDto)
        assertEquals(appDetailsDto.size, appDetails.size, DELTA)
    }

    @Test
    fun `after mapping AppDetailsDTO to AppDetails EXPECT the same app screenshots`() {
        val screenshotUrlList = listOf("https://example.com/s1.png", "https://example.com/s2.png")
        val appDetailsDto = createAppDetailsDTO(screenshotUrlList = screenshotUrlList)
        val appDetails = mapper.appDetailsDTOtoAppDetails(appDetailsDto)
        assertEquals(appDetailsDto.screenshotUrlList, appDetails.screenshotsUrls)
    }

    @Test
    fun `after mapping AppDetailsDTO to AppDetails with empty screenshot list EXPECT empty screenshot list`() {
        val appDetailsDto = createAppDetailsDTO(screenshotUrlList = emptyList())
        val appDetails = mapper.appDetailsDTOtoAppDetails(appDetailsDto)
        assertTrue(appDetails.screenshotsUrls.isEmpty())
    }

    @Test
    fun `after mapping AppInfoDTO to AppInfo EXPECT the same id`() {
        val appInfoDto = createAppInfoDTO()
        val appInfo = mapper.appInfoDTOtoAppInfo(appInfoDto)
        assertEquals(appInfoDto.id, appInfo.id)
    }

    @Test
    fun `after mapping AppInfoDTO to AppInfo EXPECT the same iconUrl`() {
        val appInfoDto = createAppInfoDTO()
        val appInfo = mapper.appInfoDTOtoAppInfo(appInfoDto)
        assertEquals(appInfoDto.iconUrl, appInfo.iconUrl)
    }


    private fun createAppDetailsDTO(
        id: String = "details-1",
        name: String = "Test App",
        iconUrl: String = "https://example.com/icon.png",
        category: String = "Tools",
        developer: String = "Test Developer",
        ageRating: Int = 12,
        size: Double = 52.4,
        screenshotUrlList: List<String> = listOf(
            "https://example.com/s1.png",
            "https://example.com/s2.png"
        ),
        description: String = "Test description"
    ) = AppDetailsDTO(
        id = id,
        name = name,
        iconUrl = iconUrl,
        category = category,
        developer = developer,
        ageRating = ageRating,
        size = size,
        screenshotUrlList = screenshotUrlList,
        description = description
    )

    private fun createAppInfoDTO(
        id: String = "info-1",
        name: String = "Test App Info",
        iconUrl: String = "https://example.com/icon2.png",
        category: String = "Games",
        description: String = "Info description"
    ) = AppInfoDTO(
        id = id,
        name = name,
        iconUrl = iconUrl,
        category = category,
        description = description
    )

    private companion object {
        const val DELTA = 0.0001
    }
}