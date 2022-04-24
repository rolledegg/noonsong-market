package smu.app.noonsong_market.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import smu.app.noonsong_market.databinding.ItemArticleBinding
import smu.app.noonsong_market.model.Article


class ArticleAdapter(val clickListener:(Article) -> Unit): ListAdapter<Article,ArticleAdapter.ArtitleItemViewHolder>(diffUtil) {
    inner class ArtitleItemViewHolder(private val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root){
        // 데이터를 가져와서 바인드 해주는 역할의 함수
        fun bind(articleModel:Article){
            binding.articleTitleTv.text =articleModel.title
            binding.articlePriceTv.text =articleModel.price
            binding.articleDateTv.text =articleModel.date
            binding.articleStatusTv.text =articleModel.status

            binding.root.setOnClickListener{
                clickListener(articleModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtitleItemViewHolder {
        // 미리 만들어진 뷰홀더가 없을 경우에 새로 생성하는 함수
        return ArtitleItemViewHolder(ItemArticleBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ArtitleItemViewHolder, position: Int) {
        // 실제로 뷰홀더에 데이ㅓ를 바인드해주는 함수
        holder.bind(currentList[position])
    }

    //뷰의 포지션이 변경되었을때 같은 아이템이 올라오면 다시 할당할 필요가 없기 때문에 같은 아이템인지 판단하는 것
    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<Article>(){
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }
}