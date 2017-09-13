package com.mobile.zenus.pushnotification.com.mobile.zenus.firebase;

import android.util.Log;


import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import com.google.firebase.messaging.FirebaseMessaging;
import com.mobile.zenus.pushnotification.MainActivity;

/**
 * Created by Tuca on 11/09/2017.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String REG_TOKEN = "REG_TOKEN";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String recent_token = FirebaseInstanceId.getInstance().getToken();

        Log.d(REG_TOKEN, recent_token);

        FirebaseMessaging.getInstance().subscribeToTopic("papo");



    }






}
