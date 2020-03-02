package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);

        if (!sharedPreferences.getString("username", "").equals("")) {
            String username = sharedPreferences.getString("username", "");

            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void onLoginButtonClick(View view) {
        username = findViewById(R.id.username_input);
        password = findViewById(R.id.password_input);

        String username_string = username.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username",username_string).apply();

        Intent intent = new Intent(view.getContext(), Main2Activity.class);
        intent.putExtra("username", username_string);
        startActivity(intent);
    }
}
