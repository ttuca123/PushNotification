package com.mobile.zenus.pushnotification.vo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Tuca on 11/09/2017.
 */

public interface MyEndPointInterface {

    @FormUrlEncoded
    @POST("service.php")
    public Call<String> sendMensagem(@Field ("descricao") String descricao);


    @POST("/service.php")
    public String sendMensagemFcm(@Body Mensagem mensagem);

}
