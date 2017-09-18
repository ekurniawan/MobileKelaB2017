package actualsolusi.com.samplekelasb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcActivity;

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

    }
}
