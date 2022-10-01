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

public class Login extends AppCompatActivity {
    Button login;
    EditText username,password;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initSharedPref();

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String un=username.getText().toString();
                String pass=password.getText().toString();
                String[] preferences=getPrefernceValues();

                if(!(un.equals(""))){
                    if(!(pass.equals(""))){
                        if((un.equals(preferences[0])&&pass.equals(preferences[1]))){
                            Intent intent=new Intent(Login.this,LoadingList.class);
                            intent.putExtra("hello","I amani");
                            startActivity(intent);
                        }else{
                            Toast.makeText(Login.this, "Invalid Credentials,please enter correct", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Login.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Login.this, "Please Enter Username", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    public void initSharedPref(){
        sharedPreferences=getSharedPreferences("practicePreferences",MODE_PRIVATE);

    }
    public String[] getPrefernceValues(){
        String np=sharedPreferences.getString("Name","no Name");
        String nr=sharedPreferences.getString("Password","no Password");

        String[] signupValues={np,nr};
        return signupValues;
    }
}