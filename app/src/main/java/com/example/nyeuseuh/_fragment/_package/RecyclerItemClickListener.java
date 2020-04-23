package com.example.nyeuseuh._fragment._package;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    private OnItemClickListener mListener;
    GestureDetector mGesturDetector;

    public interface OnItemClickListener{
        public void onItemClick(View view, int position);
    }

    public RecyclerItemClickListener(Context context, OnItemClickListener listener){
        mListener = listener;
        mGesturDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e){
        View childView = rv.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener!=null && mGesturDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView, rv.getChildAdapterPosition(childView));
            return true;
        }
        return false;


    }

    public void onTouchEvent(RecyclerView rv, MotionEvent e){

    }

    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept){

    }



}
