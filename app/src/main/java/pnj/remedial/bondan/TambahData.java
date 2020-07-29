package pnj.remedial.bondan;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import pnj.remedial.bondan.R;
import pnj.remedial.bondan.db.DatabaseAlumni;


public class TambahData extends AppCompatActivity implements View.OnClickListener {
    EditText edtNim, edtNama, edtTempat, edtTanggal, edtAlamat, edtAgama, edtTlp, edtThnMasuk, edtThnLulus, edtPekerjaan, edtJabatan;
    Button actionSimpan;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);
        edtNim          = findViewById(R.id.edtNim);
        edtNama         = findViewById(R.id.edtNama);
        edtTempat       = findViewById(R.id.edtTempat);
        edtTanggal      = findViewById(R.id.edtTanggal);
        edtAlamat       = findViewById(R.id.edtAlamat);
        edtAgama        = findViewById(R.id.edtAgama);
        edtTlp          = findViewById(R.id.edtTlp);
        edtThnMasuk     = findViewById(R.id.edtThnMasuk);
        edtThnLulus     = findViewById(R.id.edtThnLulus);
        edtPekerjaan    = findViewById(R.id.edtPekerjaan);
        edtJabatan      = findViewById(R.id.edtJabatan);
        actionSimpan    = findViewById(R.id.actionSimpan);

        actionSimpan.setOnClickListener(TambahData.this);
    }

    @Override
    public void onClick(View v) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Nim", Integer.parseInt(edtNim.getText().toString()));
        contentValues.put("Nama", edtNama.getText().toString());
        contentValues.put("Tempat", edtTempat.getText().toString());
        contentValues.put("Tanggal", edtTanggal.getText().toString());
        contentValues.put("Alamat", edtAlamat.getText().toString());
        contentValues.put("Agama", edtAgama.getText().toString());
        contentValues.put("Tlp", edtTlp.getText().toString());
        contentValues.put("ThnMasuk", edtThnMasuk.getText().toString());
        contentValues.put("ThnLulus", edtThnLulus.getText().toString());
        contentValues.put("Pekerjaan", edtPekerjaan.getText().toString());
        contentValues.put("Jabatan", edtJabatan.getText().toString());

        database = new DatabaseAlumni(this).getWritableDatabase();

        long insert = database.insert("tb_alumni", null, contentValues);

        Intent intent = new Intent(this, TambahData.class);

        if(insert!=-1) {
            Toast.makeText(this, "Simpan Berhasil", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Simpan Gagal", Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}