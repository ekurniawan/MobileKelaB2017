package actualsolusi.com.samplekelasb;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProgressDialogActivity extends AppCompatActivity {
    private Button btnShowProgress;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);

        btnShowProgress = (Button)findViewById(R.id.btnShowProgress);

        btnShowProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(ProgressDialogActivity.this);
                progressDialog.setMessage("Loading Mmengunduh Data.....");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

                final Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            handler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

                thread.start();
                progressDialog.show();
            }
        });
    }

    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            progressDialog.dismiss();
        }
    };

}
