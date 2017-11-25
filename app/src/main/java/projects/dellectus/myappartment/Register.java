package projects.dellectus.myappartment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener {

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
            case R.id.btRegister:
                //All button logic
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
