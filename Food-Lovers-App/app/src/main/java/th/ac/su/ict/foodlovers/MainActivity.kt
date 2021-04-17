package th.ac.su.ict.foodlovers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import th.ac.su.ict.foodlovers.Utils.getJsonDataFromAsset
import th.ac.su.ict.foodlovers.data.FoodAdapter
import th.ac.su.ict.foodlovers.data.Foodlover

class MainActivity : AppCompatActivity() {

    var itemList:ArrayList<Foodlover> = ArrayList<Foodlover>()
    lateinit var arrayAdapter:ArrayAdapter<Foodlover>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val jsonFileString =
            getJsonDataFromAsset(applicationContext,"food lover_data.json")


        val gson = Gson()
        val listItemType = object :TypeToken<ArrayList<Foodlover>>(){}.type

        var FoodloverList : ArrayList<Foodlover> = gson.fromJson(jsonFileString,listItemType)

//        Log.i("data",FoodloverList[0].foodName)
        itemList = FoodloverList

        val adapter = FoodAdapter(this@MainActivity,itemList)
        listView.adapter = adapter

        listView.setOnItemClickListener{ parent, view, position, id ->

            var intent = Intent(this@MainActivity,DetailActivity::class.java)
            intent.putExtra("title",itemList[position].foodName)
            intent.putExtra("description",itemList[position].description)
            intent.putExtra("imageFile",itemList[position].imageFile)
            intent.putExtra("hhh",itemList[position].star)
            intent.putExtra("storeName",itemList[position].storeName)

            startActivity(intent)


        }



    }
}