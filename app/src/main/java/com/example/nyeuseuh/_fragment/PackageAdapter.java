package com.example.nyeuseuh._fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nyeuseuh.R;
import com.example.nyeuseuh._model.Package;

import java.util.List;

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.ViewHolder> {
    private List<Package> songList;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvTitlePackage;

        public ViewHolder(View v) {
            super(v);
            tvTitlePackage = v.findViewById(R.id.tv_nama_item_package);

        }
    }

    public PackageAdapter(List<Package> songList){
        this.songList = songList;

    }

    public PackageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_package,parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        Package aPackage= songList.get(position);
        holder.tvTitlePackage.setText(String.valueOf(aPackage.getTitle_package()));

    }

    public int getItemCount(){
        return songList.size();
    }


}
