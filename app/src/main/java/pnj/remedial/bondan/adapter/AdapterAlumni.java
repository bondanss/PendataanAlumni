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

import pnj.remedial.bondan.R;
import pnj.remedial.bondan.model.ModelAlumni;


public class AdapterAlumni extends ArrayAdapter<ModelAlumni> {
    Context context;
    int resource;


    public AdapterAlumni(@androidx.annotation.NonNull Context context, int resource) {
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

            holder.avatar = convertView.findViewById(R.id.avatar);
            holder.txtNim = convertView.findViewById(R.id.txtNim);
            holder.txtNama = convertView.findViewById(R.id.txtNama);

            convertView.setTag(holder);
        }else {

            holder=(Holder) convertView.getTag();
        }

        holder.txtNim.setText(getItem(position).getNim());
        holder.txtNama.setText(getItem(position).getNama());

        return convertView;

    }

    public void setNotifyOnChange() {
    }

    class Holder {
        ImageView avatar;
        TextView txtNim,txtNama;
    }
}