package smu.app.noonsong_market.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import smu.app.noonsong_market.adapter.ProductAdapter
import smu.app.noonsong_market.api.ProductApi
import smu.app.noonsong_market.databinding.FragmentHomeBinding
import smu.app.noonsong_market.model.Product

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
    private lateinit var adapter: ProductAdapter

    //데이터 배열
    var productList = ArrayList<Product>()

    // 메모리에 올라갔을 떄
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"HomeFragment - onCreate() called")

        val retrofit = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val productApi = retrofit.create(ProductApi::class.java)

        // 커스텀 상품 직접 넣기
        val article1 = Product(id = 30,title = "에어팟 프로 판매합니다",price = "200,000",description = "",coverSmallUrl = "",category = "electronic")
        this.productList.add(article1)


        productApi.getProducts()
            .enqueue(object: Callback<List<Product>> {
                override fun onResponse(
                    call: Call<List<Product>>,
                    response: Response<List<Product>>
                ) {
                    if(response.isSuccessful.not()){
                        //예외처리
                        Log.d(TAG,"NOT SUCCESS")
                        return
                    }

                    response.body()?.let{
                        Log.d(TAG,it.toString())

                        it.forEach { product-> //위에도 it이 있으니 헷갈리니까 변수 명명
                            Log.d(TAG,product.toString())
                            productList.add(product)
                        }
                        adapter.submitList(productList)
                    }
                }

                override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                    Log.e(TAG,t.toString())
                }

            })




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
        adapter = ProductAdapter(clickListener= {
            Log.d(TAG,"recyclerview clicked")
        })

        adapter.submitList(this.productList)
        binding.articleRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.articleRecyclerView.adapter = adapter


    }

}