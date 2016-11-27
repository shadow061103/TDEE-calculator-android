package map90.iii.org.tw.tdee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Actmain extends Activity {
    String sex="Male";

    Double activityParam=0.0;
    Double goalParam=0.0;
    Double BMR=0.0;

    private AdapterView.OnItemSelectedListener spnActivity_selected
            = new AdapterView.OnItemSelectedListener()
    {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View v, int position, long id)
        {
           switch(adapterView.getSelectedItemPosition()){
               case 0:
                   activityParam=1.2;
                   break;
               case 1:
                   activityParam=1.38;
                   break;
               case 2:
                   activityParam=1.42;
                   break;
               case 3:
                   activityParam=1.46;
                   break;
               case 4:
                   activityParam=1.5;
                   break;
               case 5:
                   activityParam=1.64;
                   break;
          }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0)
        {
            // TODO Auto-generated method stub
        }
    };

    private AdapterView.OnItemSelectedListener spnGoal_selected
            = new AdapterView.OnItemSelectedListener()
    {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View v, int position, long id)
        {
            switch(adapterView.getSelectedItemPosition()){
                case 0:
                    goalParam=0.05;
                    break;
                case 1:
                    goalParam=0.1;
                    break;
                case 2:
                    goalParam=0.15;
                    break;
                case 3:
                    goalParam=-0.15;
                    break;
                case 4:
                    goalParam=-0.2;
                    break;
                case 5:
                    goalParam=-0.25;
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0)
        {
            // TODO Auto-generated method stub
        }
    };
    private RadioGroup.OnCheckedChangeListener rdgSex_change = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
           if(checkedId ==0)
                sex="Male";
            else
               sex="Female";

        }
    };

    private View.OnClickListener btnCalculate_click= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Double age = Double.parseDouble(txtAge.getText().toString());
            Double weight=Double.parseDouble(txtWeight.getText().toString());
            Double height=Double.parseDouble(txtHeight.getText().toString());
             if(sex.equals("Male")){
                 BMR=(10*weight)+(6.25*height)-(5*age)+5;
              }
            else if(sex.equals("Female")){
                 BMR=(10*weight)+(6.25*height)-(5*age)-161;

             }

              Double TDEE=BMR*activityParam*(1+goalParam);


            Bundle bund=new Bundle();
            bund.putDouble("tdee",TDEE);
            bund.putDouble("weight",weight);
            Intent intent =new Intent(Actmain.this,Actdetail.class);
            intent.putExtras(bund);
            startActivity(intent);


        }
    };
    private View.OnClickListener btnFat_click= new View.OnClickListener() {
        @Override
        public void onClick(View view) {

startActivity(new Intent(Actmain.this,Actfat.class));

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        Initialcomponent();
    }

    private void Initialcomponent() {
        rdgSex=(RadioGroup)findViewById(R.id.rdgSex);
        rdgSex.setOnCheckedChangeListener(rdgSex_change);
        rdbMale=(RadioButton)findViewById(R.id.rdbMale);
        rdbFemale=(RadioButton)findViewById(R.id.rdbFemale);
        txtAge=(EditText)findViewById(R.id.txtAge);
        txtWeight=(EditText)findViewById(R.id.txtWeight);
        txtHeight=(EditText)findViewById(R.id.txtHeight);
        spnActivity=(Spinner)findViewById(R.id.spnActivity);
        spnActivity.setOnItemSelectedListener(spnActivity_selected);
        spnGoal=(Spinner)findViewById(R.id.spnGoal);
        spnGoal.setOnItemSelectedListener(spnGoal_selected);
        btnCalculate=(Button)findViewById(R.id.btnCalculate);
         btnCalculate.setOnClickListener(btnCalculate_click);
        btnFat=(Button)findViewById(R.id.btnFat);
        btnFat.setOnClickListener(btnFat_click);

    }
    Spinner spnGoal;
    Spinner spnActivity;
RadioGroup rdgSex;
    RadioButton rdbMale;
    RadioButton rdbFemale;
    EditText txtAge;
    EditText txtWeight;
    EditText txtHeight;
    Button btnCalculate;
    Button btnFat;
}
