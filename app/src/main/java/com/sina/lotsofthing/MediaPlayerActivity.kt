package com.sina.lotsofthing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_media_player.*
import kotlinx.android.synthetic.main.fragment_media_controller.*

class MediaPlayerActivity : AppCompatActivity() {
    var counter:Int=1
    lateinit var fragments:MutableList<Fragment>
    lateinit var titles:MutableList<String>
    var paused:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)
        val songFragment=SongFragment()
        fragments= mutableListOf(songFragment,AlbumFragment())
        titles= mutableListOf("Songs","Albums")
        viewPager.adapter=ViewPagerAdapter(supportFragmentManager,fragments,titles)
        tabLayout.setupWithViewPager(viewPager)




        imgPlayPause.setOnClickListener {

            if (!paused) {
                imgPlayPause.setImageResource(R.drawable.play_arrow_24)
                paused = true
            } else {
                imgPlayPause.setImageResource(R.drawable.ic_baseline_pause_24)
            }
        }
        imgSkipNext.setOnClickListener {

        }
        imgSkipPrevios.setOnClickListener {

        }

    }

    class ViewPagerAdapter(supportFragmentManager: FragmentManager, private val fragments: MutableList<Fragment>
                           , private val titles:MutableList<String>) : FragmentPagerAdapter(supportFragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getPageTitle(position: Int): CharSequence {
            return titles[position]
        }




    }
}