package com.sina.lotsofthing

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView

class SongAdapter(private val mContext: Context) : BaseAdapter() {
    private var songList = mutableListOf<String>()
    private val songInf: LayoutInflater = LayoutInflater.from(mContext)
    override fun getCount(): Int {
        return songList.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val songLay: LinearLayout =
            songInf.inflate(R.layout.song_layout, parent, false) as LinearLayout
        val tvSongTitle: TextView = songLay.findViewById(R.id.tvSongTitle)
        tvSongTitle.text = songList[position]
        songLay.tag = position
        return songLay
    }

    fun setList(songList: MutableList<String>) {
        this.songList = songList
    }

}