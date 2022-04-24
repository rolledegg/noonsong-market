package smu.app.noonsong_market.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import smu.app.noonsong_market.R

class ChattingFragment : Fragment() {
    companion object {
        const val TAG: String = "LOG"

        fun newInstance() : ChattingFragment {
            return ChattingFragment()
        }
    }

    // 메모리에 올라갔을 떄
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"ChattingFragment - onCreate() called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG,"ChattingFragment - onAttach() called")
    }

    // 뷰가 생성되었을 떄
    // 프레그먼트와 레이아웃을 연결시켜주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG,"ChattingFragment - onCreateView() called")
        val view: View = inflater.inflate(R.layout.fragment_chatting,container,false)
        return view
    }
}