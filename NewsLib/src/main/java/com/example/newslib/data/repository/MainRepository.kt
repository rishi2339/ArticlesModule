
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newslib.data.model.Article
import com.example.newslib.utils.NetworkFinder

private val TAG = "ItemRepository"
class MainRepository(private val apiService: ApiService, private val applicationContext: Context) {

    private val quotesLiveData = MutableLiveData<MyResponse<Article>>()
    val articles: LiveData<MyResponse<Article>> = quotesLiveData

    suspend fun getItems(page: Int) {
        Log.d(TAG,"here -- ${TAG}")
        if (NetworkFinder.isInternetAvailable(applicationContext)) {
            val result = apiService.getItems(page = page)

            if (result.body() != null) {
                quotesLiveData.postValue(MyResponse.Success(result.body()!!))
            }
        } else {
            quotesLiveData.postValue(MyResponse.Error("Network Unavailable"))
        }
    }

}












