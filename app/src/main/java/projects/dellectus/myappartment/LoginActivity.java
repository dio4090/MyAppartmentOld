package projects.dellectus.myappartment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.mViewHolder.tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        this.mViewHolder.etUsername = (EditText) findViewById(R.id.etUsermane);
        this.mViewHolder.etPassword = (EditText) findViewById(R.id.etPassword);
        this.mViewHolder.btLogin = (Button) findViewById(R.id.btLogin);

        this.mViewHolder.btLogin.setOnClickListener(this);
        this.mViewHolder.tvRegisterLink.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btLogin:
                    final String username = this.mViewHolder.etUsername.getText().toString();
                    final String password = this.mViewHolder.etPassword.getText().toString();

                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String strResponse) {
                            try {
                                //JSONObject jsonResponse = new JSONObject(strResponse);
                                //boolean success = jsonResponse.getBoolean("success");

                                boolean success = true;
                                JSONArray jsonResponse = new JSONArray(strResponse);

                                if (success) {

                                    String name = "";
                                    int age = 0;

                                    for(int i=0; i < jsonResponse.length(); i++) {
                                        JSONObject jsonobject = jsonResponse.getJSONObject(i);
                                        name = jsonobject.getString("name");
                                        age    = jsonobject.getInt("age");
                                    }

                                    //Logica de navegacao
                                    Intent intent = new Intent(LoginActivity.this, UserAreaActivity.class);
                                    intent.putExtra("username", username);
                                    intent.putExtra("name", name);
                                    intent.putExtra("age", age);
                                    startActivity(intent);

                                } else {
                                    //AlertDialog
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    };

                    LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                    queue.add(loginRequest);
                break;

            case R.id.tvRegisterLink:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }

    }

    private static class ViewHolder {
        TextView tvRegisterLink;
        EditText etUsername;
        EditText etPassword;
        Button btLogin;
    }
}
