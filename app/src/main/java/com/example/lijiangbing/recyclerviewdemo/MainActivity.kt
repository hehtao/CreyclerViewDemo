package com.example.lijiangbing.recyclerviewdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.lijiangbing.recyclerviewdemo.R.id.id_recyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cell.view.*




class MainActivity : AppCompatActivity(),RecyclerItemClickListenner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        id_recyclerView.layoutManager = LinearLayoutManager(this);
        id_recyclerView.adapter =  myAdapter(this, initData());
        id_recyclerView.setHasFixedSize(true);
    }


    // item 点击回调
    override fun onRecyclerViewItemClick(view: View, position: Int) {

        Log.e("view----:$view","position----:$position")
    }
}


fun initData():ArrayList<String>{
    var mDatas: ArrayList<String> = arrayListOf();
    var i: Char = 'A';
    while (i < 'Z'){
        mDatas.add(i.toString());
        i ++;
    }
    return mDatas;
}


class myAdapter(val mOnItemClickLitener: RecyclerItemClickListenner?,val mDatas: ArrayList<String>): RecyclerView.Adapter<myAdapter.myHolderView>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): myHolderView {

         return myHolderView(LayoutInflater.from(parent?.context).inflate(R.layout.cell,parent,false))
    }

    override fun onBindViewHolder(holder: myHolderView?, position: Int) {

        holder?.tv?.text = mDatas.get(position);

        mOnItemClickLitener?.let {
            holder?.itemView?.setOnClickListener {
                mOnItemClickLitener.onRecyclerViewItemClick(holder?.itemView,position);
            }
        }
    }

    override fun getItemCount(): Int {
        return mDatas.count();

    }

     class myHolderView(view: View): RecyclerView.ViewHolder(view){
        val tv: TextView;
        init {
            tv = view.cell_textView
        }

    }


}