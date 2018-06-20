package za.co.projects.android.pmoloi.winterolympics.data.remote;

public class RetrofitUtility {
    public static final String BASE_URL="https://api.sportradar.us/olympics/testing/v3/en/";
    public static RetrofitService getRetrofitService()
    {
        return RetrofitClient.getClient(BASE_URL).create(RetrofitService.class);
    }
}
