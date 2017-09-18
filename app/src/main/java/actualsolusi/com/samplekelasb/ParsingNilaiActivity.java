package actualsolusi.com.samplekelasb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ParsingNilaiActivity extends AppCompatActivity {

    private Button btnShowNilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsing_nilai);

        btnShowNilai = (Button)findViewById(R.id.btnShowNilai);
        btnShowNilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getIntent().getExtras()!=null){
                    Bundle b = getIntent().getExtras();
                    String nim = b.getString("nim");
                    String nama = b.getString("nama");
                    Toast.makeText(ParsingNilaiActivity.this, "Nim: "+nim+" "+
                            "Nama : "+nama, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
