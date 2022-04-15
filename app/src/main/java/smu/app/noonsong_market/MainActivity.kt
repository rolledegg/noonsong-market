package smu.app.noonsong_market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val  bottomNavigationView: BottomNavigationView by lazy {
        findViewById<BottomNavigationView>(R.id.bottom_navigation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main)

        bottomNavigationView.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.page_home->{
                    true
                }
                R.id.page_post->{
                    true
                }
                R.id.page_chatting->{
                    true
                }
                R.id.page_mypage->{
                    true
                }
                else -> false
            }
        }


    }
}