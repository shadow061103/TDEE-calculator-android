package map90.iii.org.tw.tdee;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Actdetail extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actdetail);
        lbldetail=(TextView)findViewById(R.id.lbldetail);

        Intent intent=getIntent();
        Bundle bund=intent.getExtras();
        Double TDEE=bund.getDouble("tdee");
        Double weight=(bund.getDouble("weight"))*2.2;
        protein=weight;
        fat=weight*0.4;
        Carbohydrate=(TDEE-(protein*4)-(fat*9))/4.0;
        DecimalFormat df=new DecimalFormat("#.##");
        String tdee=df.format(TDEE);
        String protein1=df.format(protein);
        String fat1=df.format(fat);
        String cal=df.format(Carbohydrate);



        detail="您的每日消耗總熱量為"+tdee+"\r\n蛋白質攝取量為:"+protein1+"克";
        detail+="\r\n脂肪攝取量為:"+fat1+"克";
        detail+="\r\n碳水攝取量為:"+cal+"克";
        lbldetail.setText(detail);

    }
    TextView lbldetail;
    String detail;
    Double protein;
    Double Carbohydrate;
    Double fat;
}
