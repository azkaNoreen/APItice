package apitice.azka.noreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import apitice.azka.noreen.api2students.RetroResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText name,password,repassword,email,status;
    Button signup;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;
    ProgressBar progressBar;

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
        progressBar=findViewById(R.id.progressBar2);

        signup=findViewById(R.id.signup);
        progressBar.setVisibility(View.GONE);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=name.getText().toString();
                String passwor=password.getText().toString();
                String repasswor=repassword.getText().toString();
                String emai=email.getText().toString();
                String statu=status.getText().toString();


                if(passwor.equals(repasswor)){
                putPrefernceValues(username,passwor);
                    progressBar.setVisibility(View.VISIBLE);
                    insertStudent(username,emai,passwor,statu);

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
    private void insertStudent(String n,String e,String p,String s){
        RetrofitClient retrofitClient= new RetrofitClient();
        Call<RetroResponse> studentCall= retrofitClient.getStudentService().addStudent(n,p,e,s);

//        studentCall.getRe
        studentCall.enqueue(new Callback<RetroResponse>() {
            @Override
            public void onResponse(Call<RetroResponse> call, Response<RetroResponse> response) {
                progressBar.setVisibility(View.GONE);
                if(response!=null){
                    RetroResponse dataList= response.body();
                    if(dataList != null){
                        String resp=dataList.getResponse();
                        if(resp.contains("successfully")){
                            Toast.makeText(MainActivity.this, resp, Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(MainActivity.this,Login.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(MainActivity.this, "Account already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<RetroResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Signup Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}