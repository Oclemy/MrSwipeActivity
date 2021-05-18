package info.camposha.mr_swipeactivity

import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat

class SecondActivity : AppCompatActivity() {
    private var gestureObject: GestureDetectorCompat? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        gestureObject = GestureDetectorCompat(
            this,
            SwipeToActivity(this@SecondActivity, null, true, false, false, MainActivity::class.java)
        )
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        gestureObject!!.onTouchEvent(event)
        return super.onTouchEvent(event)
    }
}