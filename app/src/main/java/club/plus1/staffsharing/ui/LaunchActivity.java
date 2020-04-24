package club.plus1.staffsharing.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import club.plus1.staffsharing.R;
import club.plus1.staffsharing.common.App;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);
        showVersion();
        openEnterActivity();
    }

    private void showVersion(){
        TextView version = findViewById(R.id.version);
        version.setText(getString(R.string.app_version, App.versionName, App.versionCode));
    }

    private void openEnterActivity(){
        int LOADING_TIME = 2000;
        new Handler().postDelayed(() -> {
            Intent mainIntent = new Intent(this, EnterActivity.class);
            startActivity(mainIntent);
        }, LOADING_TIME);
    }
}
