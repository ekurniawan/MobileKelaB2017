package actualsolusi.com.samplekelasb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import models.Country;

public class SampleRecyclerView extends AppCompatActivity {

    private RecyclerView rvCountry;
    public static List<Country> listCountry = new ArrayList<>();

    static {
        IsiData();
    }

    private static void IsiData(){
        Country country1 = new Country();
        country1.setName("Indonesia");
        country1.setPopulation(250000000);

        Country country2 = new Country();
        country2.setName("Japan");
        country2.setPopulation(125000000);

        Country country3 = new Country();
        country3.setName("Thailand");
        country3.setPopulation(75000000);

        listCountry.add(country1);
        listCountry.add(country2);
        listCountry.add(country3);
    }

    private void SetDataAdapter(){
        rvCountry = (RecyclerView)findViewById(R.id.rvCountry);
        CountryAdapter adapter = new CountryAdapter(listCountry);
        rvCountry.setAdapter(adapter);

        rvCountry.addOnItemTouchListener(new RecyclerItemListener(getApplicationContext(),
                rvCountry, new RecyclerItemListener.RecyclerTouchListener() {
            @Override
            public void OnClickItem(View v, int position) {
                //String country = listCountry.get(position).getName();
                //Toast.makeText(SampleRecyclerView.this,"Anda memilih "+country,Toast.LENGTH_SHORT).show();
                Intent intentCounty = new Intent(SampleRecyclerView.this,DetailCountryActivity.class);
                Bundle b = new Bundle();
                b.putInt("position",position);
                intentCounty.putExtras(b);
                startActivity(intentCounty);
            }

            @Override
            public void OnLongClickItem(View v, int position) {

            }
        }));

        rvCountry.addItemDecoration(new DividerItemDecoration(
                ContextCompat.getDrawable(getApplicationContext(),R.drawable.item_decoration)));

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvCountry.setLayoutManager(llm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.country_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuTambah:
                Intent intentTambah = new Intent(SampleRecyclerView.this,
                        TambahCountryActivity.class);
                startActivity(intentTambah);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SetDataAdapter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_recycler_view);

        SetDataAdapter();
    }
}
