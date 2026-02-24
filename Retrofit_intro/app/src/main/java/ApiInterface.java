import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("json/get-designation")

    Call<String> getData();

}

