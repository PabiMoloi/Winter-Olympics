package za.co.projects.android.pmoloi.winterolympics.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit client = null;
    public static Retrofit getClient(String baseURL)
    {
        if (client == null)
        {
            client = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return client;
    }
}
