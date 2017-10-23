package actualsolusi.com.samplekelasb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TambahDokterActivity extends AppCompatActivity {
    private TextView etNia,etNama,etSpesialisasi,etAlamat,etPhoto;
    private Button btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_dokter);
    }
}
