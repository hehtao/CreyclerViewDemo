package com.example.lijiangbing.recyclerviewdemo

import android.view.View

/**
 * Created by lijiangbing on 2017/7/28.
 */
interface RecyclerItemClickListenner {
    fun onRecyclerViewItemClick(view: View, position: Int);
}