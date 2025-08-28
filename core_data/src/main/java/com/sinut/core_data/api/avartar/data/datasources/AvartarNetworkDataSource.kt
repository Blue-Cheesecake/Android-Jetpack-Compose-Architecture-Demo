import com.sinut.core_data.api.avartar.constants.AvartarApiPath
import com.sinut.core_data.api.avartar.data.datasources.AvartarDataSource
import com.sinut.core_data.api.avartar.data.models.AvartarResponseModel
import com.sinut.core_data.api.avartar.data.models.FindAllAvartarQueriesRequestModel
import kotlinx.coroutines.delay
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

private interface AvartarRetrofit {
    @GET(AvartarApiPath.FIND_ALL)
    suspend fun findAll(
        @Query("searchText") searchText: String?,
        @Query("status") status: String?,
        @Query("pets") pets: String?,
    ): AvartarResponseModel
}

class AvartarNetworkDataSource @Inject constructor(private val retrofit: Retrofit) : AvartarDataSource {
    override suspend fun findAll(queries: FindAllAvartarQueriesRequestModel): AvartarResponseModel {
        val service = retrofit.create(AvartarRetrofit::class.java)
        // delay for demo purposes
        delay(1000L)
        val response = service.findAll(
            searchText = queries.searchText,
            status = queries.status,
            pets = queries.pets,
        )
        return response
    }
}