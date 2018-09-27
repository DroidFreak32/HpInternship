package com.hptask.Registration_MYSQL_PHP;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String url = "http://192.168.1.102" + "/regi.php";
    private static final String signinurl = "http://192.168.1.102" + "/regi.php";
    EditText userNameText, userEmail, userPassword;
    RadioGroup rb;
    Button btn, displayButton;
    String username, password, emailid;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameText = findViewById(R.id.name);
        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);
        rb = findViewById(R.id.gender);
        btn = findViewById(R.id.register_button);
        displayButton = findViewById(R.id.displayButton);
        progressDialog = new ProgressDialog(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
//        displayButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, DisplayActivity.class);
//                startActivity(i);
//            }
//        });

        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                username = userNameText.getText().toString();
                password = userPassword.getText().toString();
                emailid = userEmail.getText().toString();
//                i.putExtra("username",userNameText.getText().toString());
//                i.putExtra("password",userPassword.getText().toString());
                sendDetails();
                startActivity(i);
            }
        });

    }

    private void sendDetails() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, signinurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONArray array = new JSONArray(response);

                            for (int i = 0; i < array.length(); i++) {

                                JSONObject product = array.getJSONObject(i);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void Register() {
        StringRequest stringRequest;
        final String username = userNameText.getText().toString().trim();
        final String email = userEmail.getText().toString();
        final String password = userPassword.getText().toString();
        RadioButton selectedGender = findViewById(rb.getCheckedRadioButtonId());
        final String gender = selectedGender.getText().toString();
        progressDialog.setMessage("Requesting");
        progressDialog.show();


        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(s);

                            Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }


                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.hide();
                        Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("email", email);
                params.put("password", password);
                params.put("gender", gender);
                return params;
            }


        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);


    }


}
