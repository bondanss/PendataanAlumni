package pnj.remedial.bondan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pnj.remedial.bondan.R;


public class DetailAlumni extends Fragment {
    TextView txtNim, txtNama, txtTempat, txtTanggal, txtAlamat, txtAgama, txtTlp, txtThnMasuk, txtThnLulus, txtPekerjaan, txtJabatan;
    Button actionUpdate, actionDelete;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_detail_alumni, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtNim          = view.findViewById(R.id.txtNim);
        txtNama         = view.findViewById(R.id.txtNama);
        txtTempat       = view.findViewById(R.id.txtTempat);
        txtTanggal      = view.findViewById(R.id.txtTanggal);
        txtAlamat       = view.findViewById(R.id.txtAlamat);
        txtAgama        = view.findViewById(R.id.txtAgama);
        txtTlp          = view.findViewById(R.id.txtTlp);
        txtThnMasuk     = view.findViewById(R.id.txtThnMasuk);
        txtThnLulus     = view.findViewById(R.id.txtThnLulus);
        txtPekerjaan    = view.findViewById(R.id.txtPekerjaan);
        txtJabatan      = view.findViewById(R.id.txtJabatan);

        actionUpdate = view.findViewById(R.id.actionUpdate);
        actionDelete = view.findViewById(R.id.actionDelete);

        Bundle data = getArguments();
        txtNim.setText(data.getString("nim",""));
        txtNama.setText(data.getString("nama",""));
        txtTempat.setText(data.getString("tempat",""));
        txtTanggal.setText(data.getString("tanggal",""));
        txtAlamat.setText(data.getString("alamat",""));
        txtAgama.setText(data.getString("agama",""));
        txtTlp.setText(data.getString("tlp",""));
        txtThnMasuk.setText(data.getString("thnMasuk",""));
        txtThnLulus.setText(data.getString("thnLulus",""));
        txtPekerjaan.setText(data.getString("pekerjaan",""));
        txtJabatan.setText(data.getString("jabatan",""));

    }
}
