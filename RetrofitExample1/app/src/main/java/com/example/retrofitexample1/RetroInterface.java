import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroInterface {


    @GET("json/Employee-List")
    Call<String> getData();
}
