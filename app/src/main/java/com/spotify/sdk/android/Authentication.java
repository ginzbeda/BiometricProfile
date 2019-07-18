package com.spotify.sdk.android;

import com.spotify.android.appremote.api.SpotifyAppRemote;

//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.design.widget.Snackbar;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.TextView;
//
//import com.spotify.sdk.android.authentication.AuthenticationClient;
//import com.spotify.sdk.android.authentication.AuthenticationRequest;
//import com.spotify.sdk.android.authentication.AuthenticationResponse;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.util.Locale;

import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;

import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.PlayerState;
import com.spotify.protocol.types.Track;

public class Authentication extends AppCompatActivity {
    private static final String TAG = "SPOTIFY_AUTH";
    //Spotify Credentials
    private static final String CLIENT_ID = "897664b46ec84e14838f852fed266631";
    private static final String REDIRECT_URI = "https%3A%2F%2Fawning.app%2F";
    private SpotifyAppRemote mSpotifyAppRemote;
//    public static final String CLIENT_ID = "089d841ccc194c10a77afad9e1c11d54";
//    public static final int AUTH_TOKEN_REQUEST_CODE = 0x10;
//    public static final int AUTH_CODE_REQUEST_CODE = 0x11;
//
//    private final OkHttpClient mOkHttpClient = new OkHttpClient();
//    private String mAccessToken;
//    private String mAccessCode;
//    private Call mCall;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        getSupportActionBar().setTitle(String.format(
//                Locale.US, "Spotify Auth Sample %s", com.spotify.sdk.android.authentication.BuildConfig.VERSION_NAME));
    }
//
    @Override
    protected void onDestroy() {
//        cancelCall();
//        super.onDestroy();
    }
//
    public void onGetUserProfileClicked(View view) {
//        if (mAccessToken == null) {
//            final Snackbar snackbar = Snackbar.make(findViewById(R.id.activity_main), R.string.warning_need_token, Snackbar.LENGTH_SHORT);
//            snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
//            snackbar.show();
//            return;
//        }
//
//        final Request request = new Request.Builder()
//                .url("https://api.spotify.com/v1/me")
//                .addHeader("Authorization","Bearer " + mAccessToken)
//                .build();
//
//        cancelCall();
//        mCall = mOkHttpClient.newCall(request);
//
//        mCall.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                setResponse("Failed to fetch data: " + e);
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                try {
//                    final JSONObject jsonObject = new JSONObject(response.body().string());
//                    setResponse(jsonObject.toString(3));
//                } catch (JSONException e) {
//                    setResponse("Failed to parse data: " + e);
//                }
//            }
//        });
    }

    public void onRequestCodeClicked(View view) {
//        final AuthenticationRequest request = getAuthenticationRequest(AuthenticationResponse.Type.CODE);
//        AuthenticationClient.openLoginActivity(this, AUTH_CODE_REQUEST_CODE, request);
    }

    public void onRequestTokenClicked(View view) {
//        final AuthenticationRequest request = getAuthenticationRequest(AuthenticationResponse.Type.TOKEN);
//        AuthenticationClient.openLoginActivity(this, AUTH_TOKEN_REQUEST_CODE, request);
    }

    private AuthenticationRequest getAuthenticationRequest(AuthenticationResponse.Type type) {
//        return new AuthenticationRequest.Builder(CLIENT_ID, type, getRedirectUri().toString())
//                .setShowDialog(false)
//                .setScopes(new String[]{"user-read-email"})
//                .setCampaign("your-campaign-token")
//                .build();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        final AuthenticationResponse response = AuthenticationClient.getResponse(resultCode, data);
//
//        if (AUTH_TOKEN_REQUEST_CODE == requestCode) {
//            mAccessToken = response.getAccessToken();
//            updateTokenView();
//        } else if (AUTH_CODE_REQUEST_CODE == requestCode) {
//            mAccessCode = response.getCode();
//            updateCodeView();
//        }
    }
//
    private void setResponse(final String text) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                final TextView responseView = findViewById(R.id.response_text_view);
//                responseView.setText(text);
//            }
//        });
    }

    private void updateTokenView() {
//        final TextView tokenView = findViewById(R.id.token_text_view);
//        tokenView.setText(getString(R.string.token, mAccessToken));
    }

    private void updateCodeView() {
//        final TextView codeView = findViewById(R.id.code_text_view);
//        codeView.setText(getString(R.string.code, mAccessCode));
    }

    private void cancelCall() {
//        if (mCall != null) {
//            mCall.cancel();
//        }
    }

    private Uri getRedirectUri() {
//        return new Uri.Builder()
//                .scheme(getString(R.string.com_spotify_sdk_redirect_scheme))
//                .authority(getString(R.string.com_spotify_sdk_redirect_host))
//                .build();
//    }
}