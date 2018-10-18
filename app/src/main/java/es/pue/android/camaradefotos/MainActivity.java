package es.pue.android.camaradefotos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnTakePhoto;
    private Button btnSendEmail;
    private ImageView iView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iView = (ImageView)findViewById(R.id.imageView);

        // Associate listener to buttons
        btnTakePhoto = (Button)findViewById(R.id.btnTakePhoto);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String message = getResources().getString(R.string.testButton);
                //Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                Button button = (Button)v;
                switch(button.getId()){
                    case R.id.btnTakePhoto:
                        takePicture();
                        break;
                    case R.id.btnSendEmail:
                        sendEmail(getString(R.string.emailDest), getString(R.string.emailSubject));
                        break;
                }

            }
        };

        btnTakePhoto.setOnClickListener(listener);

        btnSendEmail = (Button)findViewById(R.id.btnSendEmail);
        btnSendEmail.setOnClickListener(listener);
    }

    private void takePicture(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, 1);
        }
    }

    private void sendEmail(String dest, String subject){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + dest));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);

        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imgBmp = (Bitmap)extras.get("data");
            iView.setImageBitmap(imgBmp);
        }
    }
}
