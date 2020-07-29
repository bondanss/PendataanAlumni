package pnj.remedial.bondan.ui.berita;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import pnj.remedial.bondan.DetailBeritaActivity;
import pnj.remedial.bondan.R;
import pnj.remedial.bondan.adapter.AdapterBerita;
import pnj.remedial.bondan.model.ModelBerita;

public class BeritaFragment extends Fragment {

    ListView listView;
    AdapterBerita adapterBerita;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listView);
        adapterBerita = new AdapterBerita(getActivity(),R.layout.item_list_berita);
        listView.setAdapter(adapterBerita);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ModelBerita datas = (ModelBerita) parent.getAdapter().getItem(position);

                Intent intent = new Intent(getActivity(), DetailBeritaActivity.class);
                intent.putExtra("judul", datas.getJudul());
                intent.putExtra("deskripsi", datas.getDeskripsi());
                intent.putExtra("image", datas.getImgBerita());

                startActivity(intent);



            }
        });

        buatDataBerita();
    }

    void buatDataBerita() {
        String [] judul = {
                "7 Pembaruan yang Dihadirkan iOS 14 untuk iPhone Anda",
                "Pakai Snapdragon 665, Nokia 5.3 Dirilis Harga Rp 2,999 Juta",
                "Google Tambah Pintasan Peramban Baru untuk Meet",
                "Mantan CEO Google Beberkan Alasan AS Melarang Huawei",
                "Gambar iPhone Flip Bocor, Mirip Samsung Galaxy Z Flip"
        };

        String [] deskripsi = {
                "TEMPO.CO, Jakarta - Apple merilis sistem operasi terbaru untuk iPhone, iOS 14, dalam konferensi pengembang WWDC 2020 yang digelar virtual Senin 22 Juni 2020. Sejumlah pembaruan dilakukan melalui peningkatan performa maupun penambahan aplikasi.\n" +
                        "\n" +
                        "App Library, misalnya. Fitur ini mirip dengan laci aplikasi Android yang memungkinkan pengguna untuk menyembunyikan aplikasi dari layar beranda utama. App Library dilengkapi dengan beberapa fitur tambahan, seperti pembagian berdasarkan kategori aplikasi atau berdasarkan pola penggunaan. Dia juga memiliki fitur pencarian dengan tampilan aplikasi berbentuk daftar yang memungkinkan pengguna mencari aplikasi yang telah diinstal dengan lebih cepat di iPhone.",
                "TEMPO.CO, Jakarta - Pemegang merek Nokia HMD Global resmi mengumumkan kehadiran smartphone terbaru Nokia 5.3 di Indonesia. Ponsel ini dibekali chip Snapdragon 665 dengan pengaturan quad camera yang didukung dengan teknologi kecerdasan buatan atau AI.\n" +
                        "General Manager Indonesia di HMD Global, Karel Holub, mengatakan Nokia 5.3 sebagai perangkat future proof yang siap untuk  Android 11. Dia memastikan penggunanya akan mendapatkan upgrade software Android selama dua tahun dan pembaruan sistem keamanan secara berkala selama tiga tahun.",
                "TEMPO.CO, Jakarta - Google menambahkan pintasan peramban baru untuk Meet, layanan konferensi video yang diperluas Google dalam beberapa bulan terakhir karena peningkatan penggunaan menyusul kebutuhan untuk tetap terhubung selama pendemi Covid-19.\n" +
                        "\n" +
                        "Dikutip dari The Verge, Senin, 22 Juni 2020, mirip pintasan yang telah diluncurkan Google untuk sejumlah layanannya, seperti docs.new, sheet.new dan slide.new, dengan mengetik meet.new di peramban, pengguna akan secara otomatis membuka sesi baru Google Meet.\n" +
                        "\n" +
                        "Selain itu, seperti pintasan Google Documents, pengguna dapat menambahkan angka untuk digunakan pada beberapa akun sehingga mudah untuk ditandai. Misalnya, pengguna dapat menandai meet.new/1 untuk akun pribadi dan meet.new/2 untuk bekerja pada menubar.\n",
                "TEMPO.CO, Jakarta - Mantan CEO Google Eric Schmidt membeberkan alasan Amerika Serikat menyerang produsen smartphone asal Cina, Huawei. Schmidt yang sekarang memimpin Dewan Inovasi Pertahanan Pentagon itu mengatakan bahwa Huawei merupakan ancaman keamanan yang sah.\n" +
                        "Berbicara dengan BBC Radio untuk film dokumenter audio, Schmidt berkata, \"Tidak ada keraguan bahwa Huawei telah terlibat dalam beberapa praktik yang tidak dapat diterima dalam keamanan nasional.\".",
                "TEMPO.CO, Jakarta - Pembocor informasi gadget bernama Jon Prosser membeberkan beberapa detail desain ponsel lipat pertama Apple, iPhone Flip, yang sangat berbeda dengan Galaxy Fold atau Huawei Mate X.\n" +
                        "Informasi ponsel lipat Apple yang dibocorkan Prosser lebih mirip dengan Galaxy Z Flip yang sudah dijual awal tahun ini, demikian dikutip laman Toms Guide, pekan lalu."
        };

        String [] image = {
                "https://statik.tempo.co/data/2020/06/23/id_947452/947452_720.jpg",
                "https://statik.tempo.co/data/2020/06/23/id_947376/947376_720.jpg",
                "https://statik.tempo.co/data/2020/06/18/id_946248/946248_720.jpg",
                "https://statik.tempo.co/data/2019/05/29/id_845279/845279_720.jpg",
                "https://statik.tempo.co/data/2020/06/22/id_947049/947049_720.jpg"
        };

        ArrayList<ModelBerita> data = new ArrayList<>();

        for (int i=0; i < image.length; i++) {
            ModelBerita model = new ModelBerita();
            model.setImgBerita(image[i]);
            model.setJudul(judul[i]);
            model.setDeskripsi(deskripsi[i]);
            data.add(model);
        }

        adapterBerita.addAll(data);
        adapterBerita.notifyDataSetChanged();
    }
}
