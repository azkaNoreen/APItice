package apitice.azka.noreen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

////https://gorest.co.in/public/v2/users

public interface UserService {
    @GET("public/v2/users")
    Call<List<Users>> getAllUsers();
    @GET("public/v2/users/{id}")
    Call<Users> getUserDetail(@Path("id") int id);
}
