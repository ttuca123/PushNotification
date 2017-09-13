package com.mobile.zenus.pushnotification;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.JsonObject;
import com.mobile.zenus.pushnotification.util.EnuServicos;
import com.mobile.zenus.pushnotification.util.Utilitarios;
import com.mobile.zenus.pushnotification.vo.Mensagem;
import com.mobile.zenus.pushnotification.vo.MyEndPointInterface;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {


    TextView texto;

    EditText editText;

    public static String TOKEN = "AIzaSyB253E-j_S2OwgMzc1dUHhYiEU7JoMhrDY";

    public static final String BASE_URL = "https://fcm.googleapis.com/fcm/send";

    public static final String BASE_URL2 = "http://192.168.25.9/papo-service/web/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.notification);

        editText = (EditText) findViewById(R.id.edtNotification);

        FirebaseMessaging.getInstance().subscribeToTopic("admin");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();

        if( intent.getStringExtra("mensagem")!=null && !intent.getStringExtra("mensagem").isEmpty()){

            String mensagem = intent.getStringExtra("mensagem");

            texto.setText(mensagem);
        }

    }

    public void enviar(View view) {


        if(!editText.getText().toString().isEmpty()) {

            String mensagem = editText.getText().toString();

            new Consulta().execute(mensagem);
        }else{
            Toast.makeText(getBaseContext(), "Favor digitar uma mensagem", Toast.LENGTH_SHORT).show();
        }

    }



    class Consulta extends AsyncTask<String, Void, Boolean>{


        @Override
        protected Boolean doInBackground(String... mensagem) {



            try {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL2)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                MyEndPointInterface apiService =
                        retrofit.create(MyEndPointInterface.class);

                Call<String> resultado = apiService.sendMensagem( mensagem[0]);

                String body = resultado.execute().message();

                Log.d("mensagem", body);

            } catch (Exception e) {
                e.printStackTrace();
            }


            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);


        }
    }


}
