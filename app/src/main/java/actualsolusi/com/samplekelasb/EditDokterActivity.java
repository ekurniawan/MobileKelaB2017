package actualsolusi.com.samplekelasb;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        btnEdit = (Button)findViewById(R.id.btnEdit);
        btnDelete = (Button)findViewById(R.id.btnDelete);

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

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dokter editDokter = DokterActivity.listDokter.get(pos);
                editDokter.setNia(etNia.getText().toString());
                editDokter.setNama(etNama.getText().toString());
                editDokter.setSpesialisasi(etSpesialisasi.getText().toString());
                editDokter.setAlamat(etAlamat.getText().toString());
                Toast.makeText(getApplicationContext(),"Edit Data Dokter Berhasil !",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditDokterActivity.this);
                builder.setMessage("Apakah anda yakin untuk mendelete data ini ?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return;
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Dokter deleteDokter = DokterActivity.listDokter.remove(pos);
                                Toast.makeText(getApplicationContext(),"Data Berhasil Didelete !",Toast.LENGTH_LONG).show();
                                finish();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }
}
