package com.example.lambgame
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private var lampBroken = false
    private var lampOn = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val image = findViewById<ImageView>(R.id.image)
        val button = findViewById<Button>(R.id.btn)
        image.setOnLongClickListener {
            val mediaPlayer = MediaPlayer.create(this, R.raw.broke)
            image.setImageResource(R.drawable.lamba_broke)
            lampBroken = true
            mediaPlayer.start()
            button.visibility = View.VISIBLE
            true
        }
    }
    fun onClickLamp(view:View)
    {
        val mediaPlayer = MediaPlayer.create(this,R.raw.click)
        val imageView = view as ImageView

        if (!lampOn && !lampBroken)
        {
            imageView.setImageResource(R.drawable.lamba_on)
            lampOn = !lampOn
            mediaPlayer.start()
        }
        else if (lampOn && !lampBroken)
        {
            imageView.setImageResource(R.drawable.lamba_off)
            lampOn = !lampOn
            mediaPlayer.start()
        }
    }
    fun onBtnClick(view:View)
    {
        val imageView = findViewById<ImageView>(R.id.image)
        val button = view as Button
        imageView.setImageResource(R.drawable.lamba_off)
        lampOn = false
        lampBroken = false
        button.visibility = View.INVISIBLE
    }
}