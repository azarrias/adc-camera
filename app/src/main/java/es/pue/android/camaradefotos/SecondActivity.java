package es.pue.android.camaradefotos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String nombre = getIntent().getStringExtra("name");
        Toast.makeText(this, nombre, Toast.LENGTH_LONG).show();
    }
}
