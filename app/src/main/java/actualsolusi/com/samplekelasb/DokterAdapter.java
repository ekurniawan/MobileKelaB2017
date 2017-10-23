package actualsolusi.com.samplekelasb;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import models.Dokter;

/**
 * Created by erick on 07/10/2017.
 */

public class DokterAdapter extends RecyclerView.Adapter<DokterAdapter.MyViewHolder> {
    private List<Dokter> listDokter;

    public DokterAdapter(List<Dokter> listDokter){
        this.listDokter = listDokter;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNamaDokter,tvSpesialisasi,tvAlamat;
        private ImageView imgPhoto;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvNamaDokter = (TextView)itemView.findViewById(R.id.tvNamaDokter);
            tvSpesialisasi = (TextView)itemView.findViewById(R.id.tvSpesialisasi);
            tvAlamat = (TextView)itemView.findViewById(R.id.tvAlamat);
            imgPhoto = (ImageView)itemView.findViewById(R.id.imgPhoto);
        }
    }

    @Override
    public DokterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from((parent.getContext()))
                .inflate(R.layout.row_dokter,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DokterAdapter.MyViewHolder holder, int position) {
        Dokter c = listDokter.get(position);
        holder.tvNamaDokter.setText(c.getNama());
        holder.tvSpesialisasi.setText(c.getSpesialisasi());
        holder.tvAlamat.setText(c.getAlamat());
        Uri myUri = Uri.parse(c.getPhoto());
        Picasso.with(holder.imgPhoto.getContext()).load(myUri).into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return listDokter.size();
    }


}
