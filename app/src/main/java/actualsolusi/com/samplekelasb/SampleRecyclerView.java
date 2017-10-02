package actualsolusi.com.samplekelasb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_recycler_view);

        rvCountry = (RecyclerView)findViewById(R.id.rvCountry);
        CountryAdapter adapter = new CountryAdapter(listCountry);
        rvCountry.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvCountry.setLayoutManager(llm);
    }
}
