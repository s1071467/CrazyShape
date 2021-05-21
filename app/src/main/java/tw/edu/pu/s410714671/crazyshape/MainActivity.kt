package tw.edu.pu.s410714671.crazyshape

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_main.*

@GlideModule
public final class MyAppGlideModule : AppGlideModule()



class MainActivity : AppCompatActivity() {
    lateinit var gDetector: GestureDetector
    var X: Int = 0
    fun ShowPicture(){
        when (X){
            0 -> imgNext.setImageResource(R.drawable.circle)
            1 -> imgNext.setImageResource(R.drawable.star)
            2 -> imgNext.setImageResource(R.drawable.square)
            3 -> imgNext.setImageResource(R.drawable.triangle)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //gDetector = GestureDetector(this, this)

        //imgNext.setOnTouchListener(this)
        val img: ImageView = findViewById(R.id.imgTitle)
        GlideApp.with(this)
            .load(R.drawable.cover)
            .override(800, 600)
            .into(img)

        Toast.makeText(baseContext, "作者：吳承軒", Toast.LENGTH_LONG).show()

        imgNext.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {
                intent = Intent(this@MainActivity, GameActivity::class.java).apply {
                    putExtra("picture",imgNext.drawable.toString())
                }
                startActivity(intent)
                return true
            }

        })


    }

/*
    override fun onDown(e: MotionEvent?): Boolean {
        TODO("Not yet implemented")
        return true
    }

    override fun onShowPress(e: MotionEvent?) {
        TODO("Not yet implemented")

    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        //var X: Int = (1..4).random()
        X=(0..3).random()
        ShowPicture()
        return true

    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        TODO("Not yet implemented")
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        TODO("Not yet implemented")

    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        gDetector.onTouchEvent(event)
        return true

    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }

 */


}