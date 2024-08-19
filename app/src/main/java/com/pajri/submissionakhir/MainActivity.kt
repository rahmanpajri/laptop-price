package com.pajri.submissionakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvLaptop: RecyclerView
    private val list = ArrayList<Laptop>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvLaptop = findViewById(R.id.rv_laptops)
        rvLaptop.setHasFixedSize(true)

        list.addAll(getListLaptops())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvLaptop.layoutManager = LinearLayoutManager(this)
        val listLaptopAdapter = ListLaptopAdapter(list)
        rvLaptop.adapter = listLaptopAdapter

    }


    private fun getListLaptops(): ArrayList<Laptop> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val listLaptop = ArrayList<Laptop>()
        for(i in dataName.indices){
            val laptop = Laptop(dataName[i],dataDesc[i],dataPhoto[i],dataPrice[i])
            listLaptop.add(laptop)
        }
        return listLaptop
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val about = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(about)
        return super.onOptionsItemSelected(item)
    }

}