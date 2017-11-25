package projects.dellectus.myappartment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserAreaActivity extends AppCompatActivity implements View.OnClickListener {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        mViewHolder.etName = (EditText) findViewById(R.id.etName);
        mViewHolder.etAge= (EditText) findViewById(R.id.etAge);
        mViewHolder.etUsername = (EditText) findViewById(R.id.etUsername);
        mViewHolder.btLogout = (Button) findViewById(R.id.btLogout);

        this.mViewHolder.btLogout.setOnClickListener(this);
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
            case R.id.btLogout:
                startActivity(new Intent(UserAreaActivity.this, LoginActivity.class));
                break;
        }
    }

    private static class ViewHolder {
        EditText etName;
        EditText etAge;
        EditText etUsername;
        Button btLogout;
    }
}
