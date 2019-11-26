package com.example.viewpagerkotlin

import android.content.Context
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

  class SlidingImage_Adapter (private val context: Context,
                            private val imageModelArrayList: ArrayList<ImageModel>) : PagerAdapter() {
      private val inflater: LayoutInflater

      init {
          inflater = LayoutInflater.from(context)
      }

      override fun isViewFromObject(view: View, `object`: Any): Boolean {
          return view == `object`
      }
      override fun getCount(): Int {
          return imageModelArrayList.size
      }
      override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
          container.removeView(`object` as View)
      }

      override fun instantiateItem(view: ViewGroup, position: Int): Any {

          val imageLayout = inflater.inflate(R.layout.slidingimages_layout, view, false)!!
          val imageView = imageLayout.findViewById(R.id.imageView) as ImageView
          val textView = imageLayout.findViewById(R.id.textView) as TextView
          imageView.setImageResource(imageModelArrayList[position].image_drawable)
          textView.setText(imageModelArrayList[position].text_image)
          view.addView(imageLayout, 0)
          return imageLayout
      }

      override fun restoreState(state: Parcelable?, loader: ClassLoader?) {}

      override fun saveState(): Parcelable? {
          return null
      }




}