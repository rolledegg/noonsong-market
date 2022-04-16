package smu.app.noonsong_market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // 멤버 변수 선언
    private val  bottomNavigationView: BottomNavigationView by lazy {
        findViewById<BottomNavigationView>(R.id.bottom_navigation)
    }
    private val homeFragment: HomeFragment by lazy {
       HomeFragment.newInstance()
    }
    private val myPageFragment: MyPageFragment by lazy {
        MyPageFragment.newInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // default fragment

        supportFragmentManager.beginTransaction().add(R.id.container,homeFragment).commit()


        bottomNavigationView.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.page_home->{
                    supportFragmentManager.beginTransaction().replace(R.id.container,homeFragment).commit()

                    true
                }
                R.id.page_post->{
                    supportFragmentManager.beginTransaction().replace(R.id.container,myPageFragment).commit()

                    true
                }
                R.id.page_chatting->{
                    supportFragmentManager.beginTransaction().replace(R.id.container,homeFragment).commit()

                    true
                }
                R.id.page_mypage->{
                    supportFragmentManager.beginTransaction().replace(R.id.container,myPageFragment).commit()
                    true
                }
                else -> false
            }
        }


    }
}