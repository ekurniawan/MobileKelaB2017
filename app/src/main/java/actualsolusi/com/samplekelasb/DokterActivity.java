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

import models.Dokter;

public class DokterActivity extends AppCompatActivity {

    private RecyclerView rvDokter;

    public static List<Dokter> listDokter = new ArrayList<>();

    static {
        IsiData();
    }

    private static void IsiData(){
        Dokter dokter = new Dokter();
        dokter.setNama("drg. Vina Setya");
        dokter.setSpesialisasi("Ortodentis");
        dokter.setAlamat("Jl Mangga 12, Yogyakarta");
        dokter.setNia("123123");
        dokter.setPhoto("https://pdgi.blob.core.windows.net/pdgicontainer/dokter1.png");
        listDokter.add(dokter);

        Dokter dokter2 = new Dokter();
        dokter2.setNama("drg. Chris Riedfield");
        dokter2.setSpesialisasi("Prostodentis");
        dokter2.setAlamat("Jl Salak 12, Yogyakarta");
        dokter2.setNia("222333");
        dokter2.setPhoto("https://pdgi.blob.core.windows.net/pdgicontainer/dokter2.png");
        listDokter.add(dokter2);

        Dokter dokter3 = new Dokter();
        dokter3.setNama("drg. Jill Valentine");
        dokter3.setSpesialisasi("Bedah Mulut");
        dokter3.setAlamat("Jl Batik 22, Yogyakarta");
        dokter3.setNia("111333");
        dokter3.setPhoto("https://pdgi.blob.core.windows.net/pdgicontainer/dokter3.png");
        listDokter.add(dokter3);

        Dokter dokter4 = new Dokter();
        dokter4.setNama("drg. Jin Kazama");
        dokter4.setSpesialisasi("Prostodentis");
        dokter4.setAlamat("Jl Manggis 12, Yogyakarta");
        dokter4.setNia("555666");
        dokter4.setPhoto("https://pdgi.blob.core.windows.net/pdgicontainer/dokter4.png");
        listDokter.add(dokter4);

        Dokter dokter5 = new Dokter();
        dokter5.setNama("drg. Joe Higashi");
        dokter5.setSpesialisasi("Bedah Mulut");
        dokter5.setAlamat("Jl Cokroaminoto 15, Yogyakarta");
        dokter5.setNia("777888");
        dokter5.setPhoto("https://pdgi.blob.core.windows.net/pdgicontainer/dokter5.png");
        listDokter.add(dokter5);
    }

    private void SetDataAdapter(){
        rvDokter = (RecyclerView)findViewById(R.id.rvDokter);
        DokterAdapter adapter = new DokterAdapter(listDokter);
        rvDokter.setAdapter(adapter);

        rvDokter.addOnItemTouchListener(new RecyclerItemListener(getApplicationContext(),
                rvDokter, new RecyclerItemListener.RecyclerTouchListener() {
            @Override
            public void OnClickItem(View v, int position) {
                Intent intentDokter = new Intent(DokterActivity.this,EditDokterActivity.class);
                Bundle b = new Bundle();
                b.putInt("position",position);
                intentDokter.putExtras(b);
                startActivity(intentDokter);
            }

            @Override
            public void OnLongClickItem(View v, int position) {

            }
        }));

        rvDokter.addItemDecoration(new DividerItemDecoration(ContextCompat.getDrawable(getApplicationContext(),R.drawable.item_decoration)));
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvDokter.setLayoutManager(llm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dokter_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuTambah:
                Intent intentDokter = new Intent(DokterActivity.this,
                        TambahDokterActivity.class);
                startActivity(intentDokter);
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
        setContentView(R.layout.activity_dokter);

        SetDataAdapter();

    }
}
