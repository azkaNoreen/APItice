package apitice.azka.noreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadingList extends AppCompatActivity {
    Toolbar toolba;
    TextView tn;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_list);

        toolba=findViewById(R.id.toolba);
        tn=findViewById(R.id.n);
        pb=findViewById(R.id.progressBar);
        toolba.setTitle("Azka Noreen");
        setSupportActionBar(toolba); //set toolbar to act as action bar
        getAllUser();
    }
    private void getAllUser(){
        RetrofitClient retrofitClient= new RetrofitClient();
        Call<Users> userDetail= retrofitClient.getUserService().getUserDetail(1);
        Call<List<Users>> userCall= retrofitClient.getUserService().getAllUsers();
        userCall.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                if(response!=null){
                    List<Users> dataList= response.body();
                    if(dataList != null && dataList.size()>0){
                        String name= dataList.get(3).getName();
                        pb.setVisibility(View.GONE);
                        tn.setText(name);
                    }
                }
            }
            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

            }
        });
    }
}