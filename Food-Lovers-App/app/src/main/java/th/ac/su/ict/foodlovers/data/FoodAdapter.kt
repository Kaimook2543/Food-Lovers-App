package th.ac.su.ict.foodlovers.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_menu_food.view.*
import th.ac.su.ict.foodlovers.R
import java.util.zip.Inflater

class FoodAdapter(private val context: Context,
private val dataSource:ArrayList<Foodlover>) : BaseAdapter(){


    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = inflater.inflate(R.layout.list_menu_food,null)

        rowView.foodName.text = dataSource[position].foodName
        rowView.storeName.text = dataSource[position].storeName
        rowView.price.text = dataSource[position].price.toString()

        if (dataSource[position].star == 1)
            rowView.star1.setImageResource(R.drawable.star)
        else if (dataSource[position].star == 2) {
            rowView.star1.setImageResource(R.drawable.star)
            rowView.star2.setImageResource(R.drawable.star)
        }
        else if (dataSource[position].star == 3){
            rowView.star1.setImageResource(R.drawable.star)
            rowView.star2.setImageResource(R.drawable.star)
            rowView.star3.setImageResource(R.drawable.star)
        }
        else if (dataSource[position].star == 4){
            rowView.star1.setImageResource(R.drawable.star)
            rowView.star2.setImageResource(R.drawable.star)
            rowView.star3.setImageResource(R.drawable.star)
            rowView.star4.setImageResource(R.drawable.star)
        }
        else if (dataSource[position].star == 5){
            rowView.star1.setImageResource(R.drawable.star)
            rowView.star2.setImageResource(R.drawable.star)
            rowView.star3.setImageResource(R.drawable.star)
            rowView.star4.setImageResource(R.drawable.star)
            rowView.star5.setImageResource(R.drawable.star)
        }

//        rowView.img.setImageResource(R.drawable.food01)

        val res = context.resources
        val drawableId:Int = res.getIdentifier(dataSource[position].imageFile,"drawable",context.packageName)

        rowView.img.setImageResource(drawableId)

        return rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

}