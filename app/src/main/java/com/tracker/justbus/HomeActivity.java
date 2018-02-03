package com.tracker.justbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try{
                            JSONObject jsonResponse = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                System.out.println("Success");
                            }else{
                                System.out.println("Failure");
                            }

                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequestActivity registerRequestActivity = new RegisterRequestActivity("1055246", "Parth", "Kulkarni",
                        "Mahesh", "Neha", "9011004706", "8392028367", "9011004706", 23.563, 12.924, 105, "mahesh@example.com",
                        "neha@example.com", "1997-03-24", "O+ve", "https://firebase.com/parth_image.jpg", "Saurabh", "6798453729",
                        1, "Kondhwa Rd, Pune", responseListener);

                RequestQueue requestQueue = Volley.newRequestQueue(HomeActivity.this);
                requestQueue.add(registerRequestActivity);
            }
        });


    }
}
