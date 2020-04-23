package com.example.nyeuseuh._fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nyeuseuh.R;
import com.example.nyeuseuh._fragment._package.Member;
import com.example.nyeuseuh._fragment._package.Outlet;
import com.example.nyeuseuh._fragment._package.Pengguna;
import com.example.nyeuseuh._fragment._package.ProdukPaket;
import com.example.nyeuseuh._model.Package;

import java.util.ArrayList;
import java.util.List;

public class PackageActivity extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Package> packageList;
    private PackageAdapter packageAdapter;

    String[] title = {"Outlet","Pengguna","Produk/Paket","Member"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_package, container, false);

        mRecyclerView = view.findViewById(R.id.rv_package);
        if (mRecyclerView != null){
            mRecyclerView.setHasFixedSize(true);

        }

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        packageList = new ArrayList<>();

        for (int i = 0; i < title.length; i++){
            Package aPackage = new Package(title[i]);
            packageList.add(aPackage);

        }

        packageAdapter = new PackageAdapter(packageList);

        mRecyclerView.setAdapter(packageAdapter);
        packageAdapter.notifyDataSetChanged();

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "Card at " + position+ " is clicked", Toast.LENGTH_SHORT).show();
                if(position == 0){
                    startActivity(new Intent(getContext(), Outlet.class));
                }
                else if(position == 1){
                    startActivity(new Intent(getContext(), Pengguna.class));
                }
                else if(position == 2){
                    startActivity(new Intent(getContext(), ProdukPaket.class));
                }
                else if(position == 3){
                    startActivity(new Intent(getContext(), Member.class));
                }
            }
        }));

        return view;
    }
}
