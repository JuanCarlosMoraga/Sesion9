package com.moraga.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.moraga.myapplication.dao.DataBaseBuilder
import com.moraga.myapplication.databinding.ActivityMainBinding
import com.moraga.myapplication.entities.City
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //funMain()
        }

    /*private fun funMain() = runBlocking{
        val context = this@MainActivity
        val db = DataBaseBuilder.getIntance(context)

        val city1 = City(0, "Masaya", "Ciudad de las flores", 50000)
        val city2 = City(0, "Managua", "Capital de Nicaragua", 500600)
        val city3 = City(0, "Granada", "La gran sultana", 200600)

        var listCities: List<City> = listOf(city1, city2, city3)

        val cityDao = db.CityDao()

        listCities.forEach{
            city -> cityDao.insert(city)
        }
    }*/
}