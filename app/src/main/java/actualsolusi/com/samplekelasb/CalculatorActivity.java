package actualsolusi.com.samplekelasb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class CalculatorActivity extends AppCompatActivity {

    private EditText txtBil1,txtBil2,txtHasil;
    private RadioButton rdTambah,rdKurang,rdKali,rdBagi;
    private Button btnHitung;

    private double hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        txtBil1 = (EditText)findViewById(R.id.txtBil1);
        txtBil2 = (EditText)findViewById(R.id.txtBil2);
        txtHasil = (EditText)findViewById(R.id.txtHasil);
        rdTambah = (RadioButton)findViewById(R.id.rdTambah);
        rdKurang = (RadioButton)findViewById(R.id.rdKurang);
        rdKali = (RadioButton)findViewById(R.id.rdKali);
        rdBagi = (RadioButton)findViewById(R.id.rdBagi);
        btnHitung = (Button)findViewById(R.id.btnHitung);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bil1 = Double.parseDouble(txtBil1.getText().toString());
                double bil2 = Double.parseDouble(txtBil2.getText().toString());
                if(rdTambah.isChecked()){
                    hasil = Tambah(bil1,bil2);
                }else if(rdKurang.isChecked()){
                    hasil = Kurang(bil1,bil2);
                }else if(rdKali.isChecked()){
                    hasil = Kali(bil1,bil2);
                }else{
                    hasil = Bagi(bil1,bil2);
                }
                txtHasil.setText(String.valueOf(hasil));
            }
        });
    }

    private double Tambah(double bil1,double bil2){
        return bil1+bil2;
    }

    private double Kurang(double bil1,double bil2){
        return bil1-bil2;
    }

    private double Kali(double bil1,double bil2){
        return bil1*bil2;
    }

    private double Bagi(double bil1,double bil2){
        return bil1/bil2;
    }


}
