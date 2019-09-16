package com.crazyma.itemshownsample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClicked(view: View) {
        when (view.id) {
            R.id.oneListButton -> {
                startActivity(Intent(this, OneRecyclerViewActivity::class.java))
            }
            else -> {

            }
        }
    }
}
