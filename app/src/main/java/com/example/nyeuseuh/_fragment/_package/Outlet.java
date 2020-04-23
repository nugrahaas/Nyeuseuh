package com.example.nyeuseuh._fragment._package;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.nyeuseuh.R;
import com.example.nyeuseuh._fragment.PackageAdapter;
import com.example.nyeuseuh._fragment._package._form.FormOutlet;
import com.example.nyeuseuh._model.Package;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Outlet extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<com.example.nyeuseuh._model.Outlet> outletList;
    private OutletAdapter outletAdapter;
    DatabaseReference database;
    ArrayList<com.example.nyeuseuh._model.Outlet> postArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outlet);

        database = FirebaseDatabase.getInstance().getReference().child("outlet");
        // Setup the RecyclerView
        mRecyclerView = findViewById(R.id.rv_outlet);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        outletAdapter = new OutletAdapter(postArrayList);
        mRecyclerView.setAdapter(outletAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                postArrayList.clear();

                com.example.nyeuseuh._model.Outlet post = new com.example.nyeuseuh._model.Outlet();
                String id = null;
                for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()) {
                    post = artistSnapshot.getValue(com.example.nyeuseuh._model.Outlet.class);
                    id = post.getId();
                    postArrayList.add(post);
                }

                OutletAdapter adapter = new OutletAdapter( postArrayList);
                mRecyclerView.setAdapter(adapter);

                final String finalId = id;
                mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(Outlet.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        position += 1;

                        Toast.makeText(Outlet.this, "Card at " + position + " is clicked", Toast.LENGTH_SHORT).show();

                        final MaterialDialog fotoDialog = new MaterialDialog.Builder(Outlet.this)
                                .title("Aksi")
                                .positiveText("Edit")
                                .negativeText("Delete")
                                .autoDismiss(false)
                                .show();

                    }

                }));



            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void gotoFormOutlet(View view) {
        startActivity(new Intent(this, FormOutlet.class));
    }
}
