package pnj.remedial.bondan;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import pnj.remedial.bondan.fragment.DetailAlumni;


public class FragmentActivityDetail extends AppCompatActivity {
    DetailAlumni detailAlumni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_detail);

        Bundle extras = getIntent().getExtras();
        detailAlumni = new DetailAlumni();

        if (extras!=null) {
            String nim = extras.getString("nim","");
            String nama = extras.getString("nama","");
            String tempat = extras.getString("tempat","");
            String tanggal = extras.getString("tanggal","");
            String alamat = extras.getString("alamat","");
            String agama = extras.getString("agama","");
            String tlp = extras.getString("tlp","");
            String thnMasuk = extras.getString("thnMasuk","");
            String thnLulus = extras.getString("thnLulus","");
            String pekerjaan = extras.getString("pekerjaan","");
            String jabatan = extras.getString("jabatan","");

            Bundle data = new Bundle();
            data.putString("nim",nim);
            data.putString("nama",nama);
            data.putString("tempat",tempat);
            data.putString("tanggal",tanggal);
            data.putString("alamat",alamat);
            data.putString("agama",agama);
            data.putString("tlp",tlp);
            data.putString("thnMasuk",thnMasuk);
            data.putString("thnLulus",thnLulus);
            data.putString("pekerjaan",pekerjaan);
            data.putString("jabatan",jabatan);

            detailAlumni.setArguments(data);
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.containerLayout , detailAlumni);
        ft.commit();
    }
}
