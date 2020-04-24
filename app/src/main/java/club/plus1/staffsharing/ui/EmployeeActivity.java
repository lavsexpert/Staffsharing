package club.plus1.staffsharing.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import club.plus1.staffsharing.R;

public class EmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee);
        setTitle(getString(R.string.employee_title));
    }
}
