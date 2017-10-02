package actualsolusi.com.samplekelasb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.text.NumberFormat;

import models.Country;

public class DetailCountryActivity extends AppCompatActivity {
    private EditText etCountryName,etPopulation;
    private Button btnEdit,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_country);

        etCountryName = (EditText)findViewById(R.id.etCountryName);
        etPopulation = (EditText)findViewById(R.id.etPopulation);
        btnEdit = (Button)findViewById(R.id.btnEdit);
        btnDelete = (Button)findViewById(R.id.btnDelete);

        if(getIntent().getExtras()!=null){
            Bundle b = getIntent().getExtras();
            int pos = b.getInt("position");
            Country currCountry = SampleRecyclerView.listCountry.get(pos);

            etCountryName.setText(currCountry.getName());
            etPopulation.setText(
                    NumberFormat.getIntegerInstance().format(currCountry.getPopulation()));
        }
    }
}
