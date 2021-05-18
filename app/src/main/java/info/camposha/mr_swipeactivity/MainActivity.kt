package info.camposha.mr_swipeactivity

import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import info.camposha.mr_swipeactivity.MainActivity

class MainActivity : AppCompatActivity() {
    private var gestureObject: GestureDetectorCompat? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gestureObject = GestureDetectorCompat(
            this,
            SwipeToActivity(this@MainActivity, SecondActivity::class.java, false, true, false, null)
        )
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        gestureObject!!.onTouchEvent(event)
        return super.onTouchEvent(event)
    }
}