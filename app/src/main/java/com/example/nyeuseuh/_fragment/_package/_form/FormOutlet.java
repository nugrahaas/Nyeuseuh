package com.example.nyeuseuh._fragment._package._form;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nyeuseuh.R;
import com.example.nyeuseuh._model.Outlet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FormOutlet extends AppCompatActivity {

    EditText namaOutlet, alamatOutlet, notelpOutlet;
    String namaOutlets, alamatOutlets, notelpOutlets;
    DatabaseReference databaseReference, dbr;
    String id = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_outlet);

        databaseReference = FirebaseDatabase.getInstance().getReference("outlet");
        dbr = FirebaseDatabase.getInstance().getReference("outlet");

        Intent intentfeed = getIntent();
        Bundle b = intentfeed.getExtras();

        if (b != null) {
            id = (String) b.get("PostID");
            Toast.makeText(FormOutlet.this, id, Toast.LENGTH_SHORT).show();
        }

        namaOutlet = findViewById(R.id.et_nama_form_outlet);
        alamatOutlet = findViewById(R.id.et_alamat_form_outlet);
        notelpOutlet = findViewById(R.id.et_notelp_form_outlet);

    }

    @Override
    protected void onStart() {
        super.onStart();

        dbr.orderByChild("id").equalTo(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Outlet post = new Outlet();
                String osid = null;
                String nama = null;
                String alamat = null;
                String notelp = null;
                for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()) {
                    post = artistSnapshot.getValue(Outlet.class);
                    osid = post.getId();
                    nama = post.getNamaOutlet();
                    alamat = post.getAlamatOutlet();
                    notelp = post.getNotelpOutlet();

                    namaOutlet.setText(nama);
                    alamatOutlet.setText(alamat);
                    notelpOutlet.setText(notelp);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void addOutlet(){
        namaOutlets = namaOutlet.getText().toString().trim();
        alamatOutlets = alamatOutlet.getText().toString().trim();
        notelpOutlets = notelpOutlet.getText().toString().trim();

        if (!TextUtils.isEmpty(namaOutlets)) {
            String id = databaseReference.push().getKey();

            Outlet artists = new Outlet(id, namaOutlets, alamatOutlets, notelpOutlets);

            databaseReference.child(id).setValue(artists);

            Toast.makeText(this, "Outlet Added", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "You should enter a name", Toast.LENGTH_SHORT).show();

        }

        startActivity(new Intent(this, com.example.nyeuseuh._fragment._package.Outlet.class));

    }

    private boolean updateOutlet(String id, String nama, String alamat, String notelp) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("outlet").child(id);

        //updating artist
        Outlet artist = new Outlet(id, nama, alamat, notelp);
        dR.setValue(artist);
        Toast.makeText(getApplicationContext(), "Artist Updated", Toast.LENGTH_LONG).show();
        return true;
    }

    public void addOutlet(View view) {
        if (id.equals("")){
            addOutlet();
        } else{

            namaOutlets = namaOutlet.getText().toString().trim();
            alamatOutlets = alamatOutlet.getText().toString().trim();
            notelpOutlets = notelpOutlet.getText().toString().trim();

            updateOutlet(id, namaOutlets,alamatOutlets, notelpOutlets);
        }


    }
}
