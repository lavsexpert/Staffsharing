package club.plus1.staffsharing.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import club.plus1.staffsharing.R;

public class CompanyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company);
        setTitle(getString(R.string.company_title));
    }
}
