package smu.app.noonsong_market.fragment

import android.content.AbstractThreadedSyncAdapter
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import smu.app.noonsong_market.R
import smu.app.noonsong_market.adapter.ArticleAdapter
import smu.app.noonsong_market.databinding.FragmentHomeBinding
import smu.app.noonsong_market.model.Article

class HomeFragment : Fragment() {
    companion object {
        const val TAG: String = "LOG"

        fun newInstance() : HomeFragment {
            return HomeFragment()
        }
    }

    // 뷰가 사라질 떄 즉 메모리에서 날라갈 떄 같이 날리기 위해 따로 뺴두기
    //private var binding:FragmentHomeBinding? = null
    private lateinit var binding:FragmentHomeBinding
    private lateinit var adapter: ArticleAdapter

    //데이터 배열
    var articleList = ArrayList<Article>()

    // 메모리에 올라갔을 떄
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"HomeFragment - onCreate() called")
        Log.d(TAG,"HomeFragment - this.articleList.size: ${this.articleList.size}")
        for(i in 1..5){
            val article1 = Article(id=130)
            this.articleList.add(article1)
            val article2 = Article(id=131, title = "두번째 타이틀 입니다",price = "30,000")
            this.articleList.add(article2)
        }
        Log.d(TAG,"HomeFragment - this.articleList.size: ${this.articleList.size}")

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG,"HomeFragment - onAttach() called")
    }

    // 뷰가 생성되었을 떄
    // 프레그먼트와 레이아웃을 연결시켜주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG,"HomeFragment - onCreateView() called")

       binding = FragmentHomeBinding.inflate(inflater,container,false)
        //binding = fargmentHomeBinding
        initBookRecyclerView()
        return binding.root

    }

    override fun onDestroyView() {
        //binding = null
        super.onDestroyView()
    }

    fun initBookRecyclerView(){
        adapter = ArticleAdapter(clickListener= {
            Log.d(TAG,"recyclerview clicked")
        })
        adapter.submitList(this.articleList)

        binding.articleRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.articleRecyclerView.adapter = adapter


    }

}