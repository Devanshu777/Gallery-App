package com.example.galleryapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var currentImage = 0
    private lateinit var galleryView: ImageView
    private lateinit var galleryDetailView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5)
        val imagesDetails = arrayOf("lady on a boat", "Maldives", "Paris sea view", "Paris infrastructure ", "Fort")

        galleryView = findViewById(R.id.galleryImage)
        galleryView.setImageResource(images[currentImage])

        galleryDetailView = findViewById(R.id.galleryImageDetail)
        galleryDetailView.text = imagesDetails[currentImage]

        val next: Button = findViewById(R.id.btnNext)
        val previous: Button = findViewById(R.id.btnPrev)

        next.setOnClickListener {
            //changing the image to the next image in the array
            currentImage = (currentImage + 1) % images.size
            galleryView.setImageResource(images[currentImage])
            galleryDetailView.text = imagesDetails[currentImage]
            }
        previous.setOnClickListener {
            //changing the image to the previous image in the array
            currentImage = (currentImage - 1 + images.size) % images.size
            galleryView.setImageResource(images[currentImage])
            galleryDetailView.text = imagesDetails[currentImage]
        }
    }
}