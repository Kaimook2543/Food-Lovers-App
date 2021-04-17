package th.ac.su.ict.foodlovers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.list_menu_food.*
import kotlinx.android.synthetic.main.list_menu_food.foodName
import kotlinx.android.synthetic.main.list_menu_food.view.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("title")
        val foodData = intent.getStringExtra("description")
        val imageFile = intent.getStringExtra("imageFile")
        val caption = intent.getStringExtra("storeName")
        val star = intent.getIntExtra("hhh",0)


        namestore.setText(caption)
        foodName.setText(title)

        lo.setText(foodData)


        if (star == 1)
            star01.setImageResource(R.drawable.star)
        else if (star == 2) {
            star01.setImageResource(R.drawable.star)
            star02.setImageResource(R.drawable.star)
        }
        else if (star == 3) {
            star01.setImageResource(R.drawable.star)
            star02.setImageResource(R.drawable.star)
            star03.setImageResource(R.drawable.star)
        }
        else if (star == 4) {
            star01.setImageResource(R.drawable.star)
            star02.setImageResource(R.drawable.star)
            star03.setImageResource(R.drawable.star)
            star04.setImageResource(R.drawable.star)
        }
        else if (star == 5){
            star01.setImageResource(R.drawable.star)
            star02.setImageResource(R.drawable.star)
            star03.setImageResource(R.drawable.star)
            star04.setImageResource(R.drawable.star)
            star05.setImageResource(R.drawable.star)

        }

        val res = resources
        val drawableID: Int =
            res.getIdentifier(imageFile, "drawable", packageName)

        img1.setImageResource(drawableID)
    }
}