package com.example.sherdonbrown.thecatapi.Network;



import com.example.sherdonbrown.thecatapi.ModelData.Objects;
import com.example.sherdonbrown.thecatapi.ModelData.Objects_Conteg;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
//import rx.Observable;

public class Connection_Service implements Cat_Interface {

    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;

    public Connection_Service() {
        getConnection();
    }

    public static Request_Interface getConnection() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(okHttpClient)
                .baseUrl(API_Request.BASE_URL).build();

        return retrofit.create(Request_Interface.class);
    }

    //  @Override
    //public Observable<List<Objects>> getCatList() {
    //   return getConnection().getListParams("",
    //             "",
    //            "");
//        return getConnection().getCatList();
    // }
    //@Override
    //public Observable<Objects> getListParams() {
    // return getConnection().getListParams("",
    //      "",
    //   "");
    //}
    @Override
    public Observable<Objects> getListParams() {
        return getConnection().getListParams("",
                "", "");

//        return getConnection().getCatList();


    }
}
