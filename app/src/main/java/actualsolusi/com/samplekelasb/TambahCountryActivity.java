package actualsolusi.com.samplekelasb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import models.Country;

public class TambahCountryActivity extends AppCompatActivity {

    private EditText etCountryName,etPopulation;
    private Button btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_country);

        etCountryName = (EditText)findViewById(R.id.etCountryName);
        etPopulation = (EditText)findViewById(R.id.etPopulation);
        btnTambah = (Button)findViewById(R.id.btnTambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Country newCountry = new Country();
                newCountry.setName(etCountryName.getText().toString());
                newCountry.setPopulation(Double.parseDouble(
                        etPopulation.getText().toString().replace(",","")));

                SampleRecyclerView.listCountry.add(newCountry);

                Toast.makeText(TambahCountryActivity.this,"Data country berhasil ditambah !",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
