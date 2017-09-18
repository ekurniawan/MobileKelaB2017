package actualsolusi.com.samplekelasb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcActivity,btnKirimNilai;
    private EditText txtNim,txtNama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcActivity = (Button)findViewById(R.id.btnCalcActivity);
        btnCalcActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calcIntent = new Intent(MainActivity.this,
                        CalculatorActivity.class);
                startActivity(calcIntent);
            }
        });

        txtNim = (EditText)findViewById(R.id.txtNim);
        txtNama = (EditText)findViewById(R.id.txtNama);
        btnKirimNilai = (Button)findViewById(R.id.btnKirimNilai);

        btnKirimNilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentParsing = new Intent(MainActivity.this,ParsingNilaiActivity.class);
                Bundle b = new Bundle();
                b.putString("nim",txtNim.getText().toString());
                b.putString("nama",txtNama.getText().toString());
                intentParsing.putExtras(b);

                startActivity(intentParsing);
            }
        });
    }
}
