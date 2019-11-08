package com.example.viewpagerkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.viewpagerindicator.CirclePageIndicator
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {


    lateinit var pager1:ViewPager
    private var imageModelArrayList: ArrayList<ImageModel>? = null

      private val myImageList = intArrayOf(R.drawable.img_1,
        R.drawable.img_2, R.drawable.img_1, R.drawable.img_2, R.drawable.img_1,
        R.drawable.img_2)
         val myTextList= arrayOf("Travel to the top of the Space Needle's 520 ft"
           ,"Range of the Pacific Northwest and the highest mountain",
           "The Museum of Flight is a private non-profit air",
           "most popular scenic attractions.","More than 1.5 million",
           "most popular scenic attractions.","More than 1.5 million" )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageModelArrayList = ArrayList()
        imageModelArrayList = populateList()

        pager1= findViewById(R.id.pager) as ViewPager
        pager1!!.adapter = SlidingImage_Adapter(this@MainActivity, this.imageModelArrayList!!)

        val indicator = findViewById(R.id.indicator) as CirclePageIndicator

          indicator.setViewPager(pager1)


          val density = resources.displayMetrics.density

        //Set circle indicator radius
          indicator.setRadius(5 * density)



       //  NUM_PAGES = imageModelArrayList!!.size


        // Auto start of viewpager
      /* val handler = Handler()
        val Update = Runnable {
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            pager1!!.setCurrentItem(currentPage++, true)
        }

        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, 4000, 4000)*/

        // Pager listener over indicator

        indicator.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageSelected(position: Int)
            {
              currentPage = position
            }
            override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {
            }
            override fun onPageScrollStateChanged(pos: Int) {
            }
        })
    }

      private fun populateList():ArrayList<ImageModel>
          {
           val list = ArrayList<ImageModel>()
           for (i in 0..5) {
            val imageModel = ImageModel()
               imageModel.image_drawable = myImageList.get(i)
               imageModel.text_image=myTextList.get(i)
                list.add(imageModel)
            }
           return list
       }
    companion object
    {
      // private var mPager: ViewPager? = null
       private var currentPage = 0
     private var NUM_PAGES = 0
    }

}



