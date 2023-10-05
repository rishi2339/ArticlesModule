
import com.example.newslib.data.model.Article
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/quotes")
    suspend fun getItems(@Query("page") page: Int): Response<Article>
}