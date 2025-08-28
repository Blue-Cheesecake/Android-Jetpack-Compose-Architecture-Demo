import com.sinut.core_data.api.avartar.constants.AvartarApiPath
import com.sinut.core_data.api.avartar.data.datasources.AvartarDataSource
import com.sinut.core_data.api.avartar.data.models.AvartarResponseModel
import kotlinx.coroutines.delay
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

private interface AvartarRetrofit : AvartarDataSource {
    @GET(AvartarApiPath.FIND_ALL)
    override suspend fun findAll(): AvartarResponseModel
}

class AvartarNetworkDataSource @Inject constructor(private val retrofit: Retrofit) : AvartarDataSource {
    override suspend fun findAll(): AvartarResponseModel {
        val service = retrofit.create(AvartarRetrofit::class.java)
        // delay for demo purposes
        delay(1000L)
        val response = service.findAll()
        return response
    }
}