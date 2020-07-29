package pnj.remedial.bondan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import pnj.remedial.bondan.R;
import pnj.remedial.bondan.model.ModelBerita;


public class AdapterBerita extends ArrayAdapter<ModelBerita> {

    Context context;
    int resource;


    public AdapterBerita(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);

            holder.imgBerita = convertView.findViewById(R.id.imgBerita);
            holder.txtJudul = convertView.findViewById(R.id.txtJudul);
            holder.txtDeskripsi = convertView.findViewById(R.id.txtDeskripsi);

            convertView.setTag(holder);
        }else {

            holder=(Holder) convertView.getTag();
        }

        holder.txtJudul.setText(getItem(position).getJudul());
        holder.txtDeskripsi.setText(getItem(position).getDeskripsi());
        Picasso.get().load(getItem(position).getImgBerita()).into(holder.imgBerita);

        return convertView;

    }

    public void setNotifyOnChange() {
    }

    class Holder {
        ImageView imgBerita;
        TextView txtJudul,txtDeskripsi;
    }
}