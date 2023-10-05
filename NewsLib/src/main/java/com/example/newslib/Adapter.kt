
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newslib.data.model.Response
import com.example.newslib.databinding.ItemBinding

class Adapter(private val itemList: List<Response>): RecyclerView.Adapter<Adapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Response) {
            binding.title.text = item.author
            binding.desc.text = item.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(ItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
        //return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}





