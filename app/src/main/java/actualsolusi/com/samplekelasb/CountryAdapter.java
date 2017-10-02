package actualsolusi.com.samplekelasb;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import models.Country;

/**
 * Created by erick on 25/09/2017.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder>{
    private List<Country> listCountry;

    public CountryAdapter(List<Country> listCountry){
        this.listCountry = listCountry;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCountryName, tvPopulation;
        private CardView cvCountry;
        public MyViewHolder(View itemView) {
            super(itemView);
            cvCountry = (CardView)itemView.findViewById(R.id.cvCountry);
            tvCountryName = (TextView)itemView.findViewById(R.id.tvCountryName);
            tvPopulation = (TextView)itemView.findViewById(R.id.tvPopulation);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_country,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Country c = listCountry.get(position);
        holder.tvCountryName.setText(c.getName());
        holder.tvPopulation.setText(String.format("%.0f",c.getPopulation()));
    }

    @Override
    public int getItemCount() {
        return listCountry.size();
    }

}
