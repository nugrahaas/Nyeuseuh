package com.example.nyeuseuh._fragment._package._form;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormOutlet extends AppCompatActivity {

    EditText namaOutlet, alamatOutlet, notelpOutlet;
    String namaOutlets, alamatOutlets, notelpOutlets;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_outlet);

        databaseReference = FirebaseDatabase.getInstance().getReference("outlet");

        namaOutlet = findViewById(R.id.et_nama_form_outlet);
        alamatOutlet = findViewById(R.id.et_alamat_form_outlet);
        notelpOutlet = findViewById(R.id.et_notelp_form_outlet);

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

    public void addOutlet(View view) {
        addOutlet();
    }
}
