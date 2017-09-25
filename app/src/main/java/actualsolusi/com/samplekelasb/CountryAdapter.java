package actualsolusi.com.samplekelasb;

import android.support.v7.widget.RecyclerView;
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
        public MyViewHolder(View itemView) {
            super(itemView);
            tvCountryName = (TextView)itemView.findViewById(R.id.tvCountryName);
            tvPopulation = (TextView)itemView.findViewById(R.id.tvPopulation);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }






}
