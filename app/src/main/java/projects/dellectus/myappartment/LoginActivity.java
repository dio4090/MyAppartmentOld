package projects.dellectus.myappartment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
                //All button logic
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
