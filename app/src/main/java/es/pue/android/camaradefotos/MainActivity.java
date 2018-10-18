package es.pue.android.camaradefotos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnTakePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associate listener to the button
        btnTakePhoto = (Button)findViewById(R.id.btnTakePhoto);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = getResources().getString(R.string.testButton);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        };

        btnTakePhoto.setOnClickListener(listener);
    }
}
