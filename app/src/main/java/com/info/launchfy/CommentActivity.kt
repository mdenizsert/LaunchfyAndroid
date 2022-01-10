package com.info.launchfy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

class CommentActivity : AppCompatActivity() {

    lateinit var ratingBar: RatingBar
    lateinit var sendComment: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        ratingBar = findViewById(R.id.ratingBar) as RatingBar
        sendComment = findViewById(R.id.buttonSendComment) as Button

        sendComment.setOnClickListener {
            Toast.makeText(applicationContext,ratingBar.rating.toString(),Toast.LENGTH_SHORT).show()
        }
    }
}