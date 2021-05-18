package info.camposha.mr_swipeactivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent

class SwipeToActivity(//the activity where you will change activity from
    var context: Context,
    var firstClass: Class<*>?,
    var left: Boolean,
    var right: Boolean, //these enable sliding to left, right or both directions
    var both: Boolean, //first class is the class you come to when sliding to right, second class when you slide left
    var secondClass: Class<*>?
) : SimpleOnGestureListener() {
    override fun onFling(
        event1: MotionEvent,
        event2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        if (event2.x > event1.x) {
            if (right || both && firstClass != null) {
                //TODO WHEN SWIPING TO RIGHT
                val intent = Intent(context, firstClass)
                (context as Activity).finish()
                context.startActivity(intent)
            }
        } else if (event2.x < event1.x) {
            if (left || both && secondClass != null) {
                //TODO WHEN SWIPING TO LEFT
                val intent = Intent(context, secondClass)
                (context as Activity).finish()
                context.startActivity(intent)
            }
        }
        return true
    }
}