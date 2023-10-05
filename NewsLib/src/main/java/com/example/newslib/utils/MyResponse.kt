import com.example.newslib.data.model.Response

sealed class MyResponse<T>(val data: T? = null, val errorMessage: String? = null){
    class Success<T>(data: T): MyResponse<T>(data = data)
    class Error<T>(errorMessage: String): MyResponse<T>(errorMessage = errorMessage)
}









