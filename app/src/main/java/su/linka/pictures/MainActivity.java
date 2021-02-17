package su.linka.pictures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView view = (TextView) findViewById(R.id.textview);
        (new Runnable() {
            @Override
            public void run() {

                AssetManager assetManager = getAssets();
                try {

                    String path = getCacheDir().getAbsolutePath();
                    view.setText((getCacheDir().list().length)+"");
                    InputStream fileInputStream = getAssets().open("pictures.linka");
                    LinkaFileLoader.decompress(fileInputStream, path);
                    view.setText((getCacheDir().list().length)+"");

                } catch (IOException e) {
                    Log.e(this.getClass().getCanonicalName(), "onCreate: ", e);
                    e.printStackTrace();
                }
            }
        }).run();
    }
}