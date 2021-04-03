package com.example.project2.utils

import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.project2.R

class ItemClickSupport {
    interface OnItemClickListener : AdapterView.OnItemClickListener {
        abstract fun onItemClicked(recyclerView: RecyclerView?, position: Int, v: View?)
    }

    interface OnItemLongClickListener : AdapterView. {
        fun onItemLongClicked(recyclerView: RecyclerView?, position: Int, v: View?): Boolean
    }
    var mRecyclerView: RecyclerView? = null
    var mOnItemClickListener: AdapterView.OnItemClickListener? = null
    var mOnItemLongClickListener: AdapterView.OnItemLongClickListener? = null
    var mOnClickListener = View.OnClickListener { v ->
        if (mOnItemClickListener != null) {
            val holder: RecyclerView.ViewHolder? = mRecyclerView?.getChildViewHolder(v)
            return@OnClickListener mOnItemClickListener?.onItemClicked(
                mRecyclerView,
                holder?.adapterPosition, v)?
        }
    }
    var mOnLongClickListener = View.OnLongClickListener { v ->
        if (mOnItemLongClickListener != null) {
            var holder: RecyclerView.ViewHolder? = mRecyclerView?.getChildViewHolder(v)
            return@OnLongClickListener mOnItemLongClickListener?.onItemLongClicked(
                mRecyclerView,
                holder?.adapterPosition,
                v
            )
        }
        false
    }
    var mAttachListener: RecyclerView.OnChildAttachStateChangeListener = object : RecyclerView.OnChildAttachStateChangeListener {
        override fun onChildViewAttachedToWindow(view: View) {
            if (mOnItemClickListener != null) {
                view.setOnClickListener(mOnClickListener)
            }
            if (mOnItemLongClickListener != null) {
                view.setOnLongClickListener(mOnLongClickListener)
            }
        }
        override fun onChildViewDetachedFromWindow(view: View) {
        }
    }
    private fun ItemClickSupport(recyclerView: RecyclerView): ItemClickSupport {
        mRecyclerView = recyclerView
        mRecyclerView?.setTag(R.id.item_click_support, this)
        mRecyclerView?.addOnChildAttachStateChangeListener(mAttachListener)
        return ItemClickSupport()
    }

    fun addTo(view: RecyclerView): ItemClickSupport? {
        var support = view.getTag(R.id.item_click_support) as ItemClickSupport
        if (support == null) {
            support = ItemClickSupport(view)
        }
        return support
    }
    fun removeFrom(view: RecyclerView): ItemClickSupport? {
        val support = view.getTag(R.id.item_click_support) as ItemClickSupport
        support.detach(view)
        return support
    }
    fun setOnItemClickListener(listener: OnItemClickListener?): ItemClickSupport? {
        mOnItemClickListener = listener
        return this
    }   
    fun setOnItemLongClickListener(listener: OnItemLongClickListener?): ItemClickSupport? {
        mOnItemLongClickListener = listener
        return this
    }
    private fun detach(view: RecyclerView) {
        view.removeOnChildAttachStateChangeListener(mAttachListener)
        view.setTag(R.id.item_click_support, null)
    }

}