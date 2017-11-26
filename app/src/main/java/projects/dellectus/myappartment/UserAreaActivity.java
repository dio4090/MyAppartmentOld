package projects.dellectus.myappartment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UserAreaActivity extends AppCompatActivity implements View.OnClickListener {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        this.mViewHolder.tvName = (TextView) findViewById(R.id.tvName);
        this.mViewHolder.tvUsername = (TextView) findViewById(R.id.tvUsername);
        this.mViewHolder.tvAge = (TextView) findViewById(R.id.tvAge);
        mViewHolder.btLogout = (Button) findViewById(R.id.btLogout);
        mViewHolder.btMaps = (Button) findViewById(R.id.btMaps);


        this.mViewHolder.btLogout.setOnClickListener(this);
        this.mViewHolder.btMaps.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();

        String name = extras.getString("name");
        String username = extras.getString("username");
        int age = extras.getInt("age", -1);

        this.mViewHolder.tvName.setText(name);
        this.mViewHolder.tvUsername.setText(username);
        this.mViewHolder.tvAge.setText(Integer.toString(age));

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

            case R.id.btMaps:
                startActivity(new Intent(UserAreaActivity.this, MapsActivity.class));
                break;
        }
    }

    private static class ViewHolder {
        TextView tvName;
        TextView tvAge;
        TextView tvUsername;
        Button btLogout;
        Button btMaps;
    }
}
