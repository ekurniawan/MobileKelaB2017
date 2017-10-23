package actualsolusi.com.samplekelasb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import models.Dokter;

public class TambahDokterActivity extends AppCompatActivity {
    private EditText etNia,etNama,etSpesialisasi,etAlamat,etPhoto;
    private Button btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_dokter);

        etNia = (EditText)findViewById(R.id.etNia);
        etNama = (EditText)findViewById(R.id.etNama);
        etSpesialisasi = (EditText)findViewById((R.id.etSpesialisasi));
        etAlamat = (EditText)findViewById((R.id.etAlamat));
        etPhoto = (EditText)findViewById(R.id.etPhoto);

        btnTambah = (Button)findViewById(R.id.btnTambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dokter newDokter = new Dokter();
                newDokter.setNia(etNia.getText().toString());
                newDokter.setNama(etNama.getText().toString());
                newDokter.setSpesialisasi(etSpesialisasi.getText().toString());
                newDokter.setAlamat(etAlamat.getText().toString());
                newDokter.setPhoto(etPhoto.getText().toString());

                DokterActivity.listDokter.add(newDokter);
                Toast.makeText(TambahDokterActivity.this,
                        "Tambah Data Dokter berhasil !", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
