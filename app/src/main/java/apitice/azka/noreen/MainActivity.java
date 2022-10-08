package apitice.azka.noreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,password,repassword,email,status;
    Button signup;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSharedPref();


        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);
        status=findViewById(R.id.status);
        repassword=findViewById(R.id.repassword);

        signup=findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=name.getText().toString();
                String passwor=password.getText().toString();
                String repasswor=repassword.getText().toString();
                if(passwor.equals(repasswor)){
                putPrefernceValues(username,passwor);
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Please enter same password and repassword", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public void initSharedPref(){
        sharedPreferences=getSharedPreferences("practicePreferences",MODE_PRIVATE);
        sharedPreferencesEditor=sharedPreferences.edit();

    }
    public void putPrefernceValues(String n, String p){
        sharedPreferencesEditor.putString("Name",n);
        sharedPreferencesEditor.putString("Password",p);
        sharedPreferencesEditor.apply();
    }
}