package actualsolusi.com.samplekelasb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import models.Dokter;

public class EditDokterActivity extends AppCompatActivity {
    private TextView etNia,etNama,etSpesialisasi,etAlamat,etPhoto;
    private Button btnEdit,btnDelete;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dokter);

        etNia = (TextView)findViewById(R.id.etNia);
        etNama = (TextView)findViewById(R.id.etNama);
        etSpesialisasi = (TextView)findViewById(R.id.etSpesialisasi);
        etAlamat = (TextView)findViewById(R.id.etAlamat);
        etPhoto = (TextView)findViewById(R.id.etPhoto);

        if(getIntent().getExtras()!=null){
            Bundle b = getIntent().getExtras();
            pos = b.getInt("position");
            Dokter currDokter = DokterActivity.listDokter.get(pos);

            etNia.setText(currDokter.getNia());
            etNama.setText(currDokter.getNama());
            etSpesialisasi.setText(currDokter.getSpesialisasi());
            etAlamat.setText(currDokter.getAlamat());
            etPhoto.setText(currDokter.getPhoto());
        }


    }
}
