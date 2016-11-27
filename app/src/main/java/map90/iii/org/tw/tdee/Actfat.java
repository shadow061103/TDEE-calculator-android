package map90.iii.org.tw.tdee;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Actfat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actfat);
        img=(ImageView)findViewById(R.id.img);
    }
    ImageView img;
}
