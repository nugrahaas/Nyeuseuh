package com.example.nyeuseuh._fragment._package;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nyeuseuh.R;
import com.example.nyeuseuh._model.Outlet;
import com.example.nyeuseuh._model.Package;

import java.util.List;

public class OutletAdapter extends RecyclerView.Adapter<OutletAdapter.ViewHolder> {
    private List<Outlet> songList;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvNomor, tvNamaOutlet, tvAlamatOutlet;

        public ViewHolder(View v) {
            super(v);
            tvNomor = v.findViewById(R.id.tv_nomor_item_outlet);
            tvNamaOutlet = v.findViewById(R.id.tv_nama_item_outlet);
            tvAlamatOutlet = v.findViewById(R.id.tv_alamat_item_outlet);

        }
    }

    public OutletAdapter(List<Outlet> songList){
        this.songList = songList;

    }

    public OutletAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_outlet,parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;


    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        Outlet outlet= songList.get(position);
        holder.tvNomor.setText(String.valueOf(position+1) + ".");
        holder.tvNamaOutlet.setText(String.valueOf(outlet.getNamaOutlet()));
        holder.tvAlamatOutlet.setText(String.valueOf(outlet.getAlamatOutlet()));

    }

    public int getItemCount(){
        return songList.size();
    }


}
