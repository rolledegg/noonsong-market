package smu.app.noonsong_market

import android.app.Application

/*
    context를 전역으로 가져올 수 있도록 해주는 클래스

    manifest application 요소에 android:name=".App" 추가해줘야함
 */
class App : Application(){
    companion object{
        lateinit var instance: App
        private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}