package actualsolusi.com.samplekelasb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContohPreferenceActivity extends AppCompatActivity {

    private EditText txtSetting;
    private Button btnSetPref,btnShowPref,btnShowPrefScreen,btnShowScreenPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contoh_preference);

        txtSetting = (EditText)findViewById(R.id.txtSetting);
        btnSetPref = (Button)findViewById(R.id.btnSetPref);
        btnShowPref = (Button)findViewById(R.id.btnShowPref);

        btnSetPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs =
                        ContohPreferenceActivity.this.getSharedPreferences("myPref",MODE_PRIVATE);
                SharedPreferences.Editor edit = prefs.edit();
                edit.putString("setting",txtSetting.getText().toString());
                edit.putBoolean("ismute",true);
                edit.commit();

                Toast.makeText(ContohPreferenceActivity.this, "Data preference berhasil disimpan",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnShowPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs =
                        ContohPreferenceActivity.this.getSharedPreferences("myPref",MODE_PRIVATE);
                String strSetting = prefs.getString("setting","tidak ditemukan");
                boolean ismute = prefs.getBoolean("ismute",false);

                Toast.makeText(ContohPreferenceActivity.this,
                        "Setting : "+strSetting+" IsMute: "+String.valueOf(ismute),
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnShowPrefScreen = (Button)findViewById(R.id.btnShowPrefScreen);
        btnShowPrefScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPref = new Intent(ContohPreferenceActivity.this,
                        MyPreferencesActivity.class);
                startActivity(intentPref);
            }
        });

        btnShowScreenPref = (Button)findViewById(R.id.btnShowScreenPref);
        btnShowScreenPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs =
                        PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                String username = prefs.getString("username","belum diisi");
                boolean ismute = prefs.getBoolean("ismute",false);
                String bahasa = prefs.getString("bahasa","");

                Toast.makeText(ContohPreferenceActivity.this,
                        "Username: "+username +
                                " Ismute : "+String.valueOf(ismute)+
                                " Bahasa : "+bahasa, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
