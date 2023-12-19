package com.example.lambgame
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private var lampOn = false
    private var lampNum = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var lamp = findViewById<ImageView>(R.id.lamp1)
        val image = findViewById<ImageView>(R.id.image)
        val button = findViewById<Button>(R.id.btn)
        image.setOnLongClickListener {
            val mediaPlayer = MediaPlayer.create(this, R.raw.broke)
            image.setImageResource(R.drawable.lamba_off)
            lamp.setImageResource(R.drawable.lamba_broke)
            mediaPlayer.start()
            if (lampNum == 3){
                button.visibility = View.VISIBLE
            }
            lampNum++
            lampOn = false
            when(lampNum)
            {
                1 -> lamp = findViewById(R.id.lamp1)
                2 -> lamp = findViewById(R.id.lamp2)
                3 -> lamp = findViewById(R.id.lamp3)
                //4 -> lamp = findViewById(R.id.lamp4)
                else -> lamp = findViewById(R.id.lamp1)
            }
            true
        }
    }
    fun onClickLamp(view:View)
    {
        val mediaPlayer = MediaPlayer.create(this,R.raw.click)
        val imageView = view as ImageView
        var lamp = findViewById<ImageView>(R.id.lamp1)
        when(lampNum)
        {
            1 -> lamp = findViewById(R.id.lamp1)
            2 -> lamp = findViewById(R.id.lamp2)
            3 -> lamp = findViewById(R.id.lamp3)
            4 -> lamp = findViewById(R.id.lamp4)
        }
        if (!lampOn && lampNum != 5)
        {
            imageView.setImageResource(R.drawable.lamba_on)
            lamp.setImageResource(R.drawable.lamba_on)

            lampOn = !lampOn
            mediaPlayer.start()
        }
        else if (lampOn && lampNum != 5)
        {
            imageView.setImageResource(R.drawable.lamba_off)
            lamp.setImageResource(R.drawable.lamba_off)

            lampOn = !lampOn
            mediaPlayer.start()
        }
    }
    fun onBtnClick(view:View)
    {
        val imageView = findViewById<ImageView>(R.id.image)
        val button = view as Button
        imageView.setImageResource(R.drawable.lamba_off)
        findViewById<ImageView>(R.id.lamp1).setImageResource(R.drawable.lamba_off)
        findViewById<ImageView>(R.id.lamp2).setImageResource(R.drawable.lamba_off)
        findViewById<ImageView>(R.id.lamp3).setImageResource(R.drawable.lamba_off)
        findViewById<ImageView>(R.id.lamp4).setImageResource(R.drawable.lamba_off)
        lampOn = false
        lampNum = 1
        button.visibility = View.INVISIBLE
    }
}