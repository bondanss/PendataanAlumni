package pnj.remedial.bondan;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import pnj.remedial.bondan.adapter.AdapterAlumni;
import pnj.remedial.bondan.db.DatabaseAlumni;
import pnj.remedial.bondan.model.ModelAlumni;


public class DataAlumni extends AppCompatActivity {
    ListView listView;
    AdapterAlumni adapterAlumni;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_alumni);

        listView = findViewById(R.id.listview);
        adapterAlumni = new AdapterAlumni(this, R.layout.item_list_view);
        listView.setAdapter(adapterAlumni);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long L) {
                ModelAlumni data = (ModelAlumni) adapterView.getAdapter().getItem(i);
                Intent intent = new Intent(DataAlumni.this, FragmentActivityDetail.class);
                intent.putExtra("nim", data.getNim());
                intent.putExtra("nama",data.getNama());
                intent.putExtra("tempat",data.getTempat());
                intent.putExtra("tanggal",data.getTanggal());
                intent.putExtra("alamat",data.getAlamat());
                intent.putExtra("agama",data.getAgama());
                intent.putExtra("tlp",data.getTlp());
                intent.putExtra("thnMasuk",data.getThnMasuk());
                intent.putExtra("thnLulus",data.getThnLulus());
                intent.putExtra("pekerjaan",data.getPekerjaan());
                intent.putExtra("jabatan",data.getJabatan());
                startActivity(intent);

            }
        });

        buatData();
    }

    void buatData() {
        ArrayList<ModelAlumni> data = new ArrayList<>();

        database = new DatabaseAlumni(this).getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM tb_alumni", null);
        if (cursor.moveToFirst()){
            do {
                ModelAlumni itemPenduduk = new ModelAlumni();
                itemPenduduk.setNim(""+cursor.getInt(0));
                itemPenduduk.setNama(cursor.getString(1));
                itemPenduduk.setTempat(cursor.getString(2));
                itemPenduduk.setTanggal(cursor.getString(3));
                itemPenduduk.setAlamat(cursor.getString(4));
                itemPenduduk.setAgama(cursor.getString(5));
                itemPenduduk.setTlp(cursor.getString(6));
                itemPenduduk.setThnMasuk(cursor.getString(7));
                itemPenduduk.setThnLulus(cursor.getString(8));
                itemPenduduk.setPekerjaan(cursor.getString(9));
                itemPenduduk.setJabatan(cursor.getString(10));
                data.add(itemPenduduk);
            }
            while (cursor.moveToNext());

        }
        database.close();
        adapterAlumni.addAll(data);
        adapterAlumni.setNotifyOnChange();

    }
}
