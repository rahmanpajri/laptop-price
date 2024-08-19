package com.pajri.submissionakhir

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val KEY_LAPTOP = "key_laptop"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val actionBar = supportActionBar
        actionBar!!.title = "Detail Laptop"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val laptop = if(Build.VERSION.SDK_INT >=33){
            intent.getParcelableExtra(KEY_LAPTOP, Laptop::class.java)
        }else{
            intent.getParcelableExtra(KEY_LAPTOP)
        }
        val tvPhoto:ImageView = findViewById(R.id.photo_received)
        val tvName:TextView = findViewById(R.id.name_received)
        val tvDescription:TextView = findViewById(R.id.desc_received)
        val tvPrice:TextView = findViewById(R.id.price_received)


        if (laptop != null) {
            Glide.with(this)
                .load(laptop.photo)
                .into(tvPhoto)
            tvName.text = laptop.name
            tvDescription.text = laptop.desc
            tvPrice.text = laptop.price
        }

        val btnShare: Button = findViewById(R.id.action_share)
        btnShare.setOnClickListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val about = Intent(this@DetailActivity, MainActivity::class.java)
        startActivity(about)
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.action_share -> {
                val send: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Share Laptoop ini")
                    type = "text/plain"
                }
                val share = Intent.createChooser(send, null)
                startActivity(share)
            }
        }
    }
}