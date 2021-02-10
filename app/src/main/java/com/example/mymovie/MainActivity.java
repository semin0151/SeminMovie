package com.example.mymovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView tv_error;

    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;

    private String rank;
    private String movieNm;
    private String audiAcc;
    private String rankInten;

    private String strDate  = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis() - 1000*60*60*24));
    private String myKey = "bb6545665f4d39c4f1f0c9f954210e2e";

    private MovieAdapter movieAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_error = (TextView)findViewById(R.id.tv_error);
        recyclerView = (RecyclerView)findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        movieAdapter = new MovieAdapter();
        recyclerView.setAdapter(movieAdapter);

        CallRetrofit();
    }

    public void CallRetrofit(){
        try {
            retrofitClient = RetrofitClient.getInstance();
            retrofitInterface = RetrofitClient.getRetrofitInterface();

            retrofitInterface.getData(myKey, strDate).enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    Result result = response.body();

                    for(int i = 0; i < result.getBoxOfficeResult().getDailyBoxOfficeList().size(); i++) {
                        rank = result.getBoxOfficeResult().getDailyBoxOfficeList().get(i).getRank();
                        movieNm = result.getBoxOfficeResult().getDailyBoxOfficeList().get(i).getMovieNm();
                        audiAcc = result.getBoxOfficeResult().getDailyBoxOfficeList().get(i).getAudiAcc();
                        rankInten = result.getBoxOfficeResult().getDailyBoxOfficeList().get(i).getRankInten();
                        movieAdapter.addItem(rank, movieNm, audiAcc, rankInten);
                    }
                    recyclerView.setAdapter(movieAdapter);
                    tv_error.setText(strDate);
                }
                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    tv_error.setText(t.getMessage());
                }
            });

        }catch (Exception e){
            tv_error.setText(e.getMessage());
        }
    }
}