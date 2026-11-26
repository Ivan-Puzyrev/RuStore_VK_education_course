package com.ivanpuzyrev.rustorevkeducationcourse

import com.ivanpuzyrev.rustorevkeducationcourse.data.api.AppDetailsDTO
import com.ivanpuzyrev.rustorevkeducationcourse.data.api.AppInfoDTO
import com.ivanpuzyrev.rustorevkeducationcourse.data.api.AppListApi
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepositoryImpl
import com.ivanpuzyrev.rustorevkeducationcourse.data.Mapper
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppInfo
import com.ivanpuzyrev.rustorevkeducationcourse.domain.Result
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class AppRepositoryImplTest {

    private val appListApi: AppListApi = mock()
    private val mapper = Mapper()
    private val repository = AppRepositoryImpl(appListApi, mapper)

    @Test
    fun `get app list EXPECT a one call of loadAppList`() = runTest {
        val mockedAppDTOList = createAppListDTO()
        whenever(appListApi.loadAppList()).thenReturn(mockedAppDTOList)
        repository.downloadAppList()
        verify(appListApi).loadAppList()
    }

    @Test
    fun `get app list EXPECT a list 3 apps`() = runTest {
        val mockedAppDTOList = createAppListDTO()
        whenever(appListApi.loadAppList()).thenReturn(mockedAppDTOList)
        val appList =
            repository.downloadAppList() as? Result.Success<List<AppInfo>> ?: Result.Success(emptyList())
        assertEquals(3, appList.data.size)
    }

    @Test
    fun `install app EXPECT a list of progress from 0 to 100`() = runTest {
        val listOfProgress = repository.installApp().toList()
        assert(listOfProgress.first() == 0 && listOfProgress.last() == 100)
    }

    @Test
    fun `get app by id EXPECT an app with the same id`() = runTest {
        val mockedAppDetailsDTO = createAppDetailsDTO()
        whenever(appListApi.loadAppDetailsById("first")).thenReturn(mockedAppDetailsDTO)
        val appDetails = repository.getAppDetailsById("first") as Result.Success
        assertEquals("first", appDetails.data.id)
    }

    @Test
    fun `get app by id EXPECT a one call of loadAppDetailsById`() = runTest {
        val mockedAppDetailsDTO = createAppDetailsDTO()
        whenever(appListApi.loadAppDetailsById("first")).thenReturn(mockedAppDetailsDTO)
        repository.getAppDetailsById("first")
        verify(appListApi).loadAppDetailsById("first")
    }

    private fun createAppListDTO() = listOf(
        AppInfoDTO(
            id = "first",
            name = "first",
            iconUrl = "https://example.com/first.png",
            category = "Games",
            description = "First App Info"
        ),
        AppInfoDTO(
            id = "second",
            name = "second",
            iconUrl = "https://example.com/second.png",
            category = "Games",
            description = "Second App Info"
        ),
        AppInfoDTO(
            id = "third",
            name = "third",
            iconUrl = "https://example.com/third.png",
            category = "Games",
            description = "Third App Info"
        ),
    )

    private fun createAppDetailsDTO() = AppDetailsDTO(
        ageRating = 3,
        category = "Games",
        description = "First App Info",
        developer = "Unknown",
        iconUrl = "https://example.com/first.png",
        id = "first",
        name = "first",
        screenshotUrlList = emptyList(),
        size = 5.6
    )
}