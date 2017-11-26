package projects.dellectus.myappartment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mViewHolder.etName = (EditText) findViewById(R.id.etName);
        mViewHolder.etAge= (EditText) findViewById(R.id.etAge);
        mViewHolder.etUsername = (EditText) findViewById(R.id.etUsername);
        mViewHolder.etPassword = (EditText) findViewById(R.id.etPassword);
        mViewHolder.btRegister = (Button) findViewById(R.id.btRegister);

        this.mViewHolder.btRegister.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btRegister:
                final String name = this.mViewHolder.etName.getText().toString();
                final String username = this.mViewHolder.etUsername.getText().toString();
                final String password = this.mViewHolder.etPassword.getText().toString();
                final int age = Integer.parseInt(this.mViewHolder.etAge.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = (Boolean) jsonResponse.getBoolean("success");

                            if(success) {
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            } else {
                                // AlertDialog
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(name, username, age, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
                break;
        }
    }

    private static class ViewHolder {
        EditText etName;
        EditText etAge;
        EditText etUsername;
        EditText etPassword;
        Button btRegister;
    }
}
