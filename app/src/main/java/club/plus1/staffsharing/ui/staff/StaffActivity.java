package club.plus1.staffsharing.ui.staff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import club.plus1.staffsharing.R;
import club.plus1.staffsharing.ui.offer.OfferItem;

public class StaffActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    StaffAdapter adapter;
    List<StaffItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff);
        setData();
        adapter = new StaffAdapter(this, list);
        recyclerView = findViewById(R.id.listStaff);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        setTitle(getString(R.string.staff_title));
    }

    private void setData() {
        list = new ArrayList<>();
        list.add(new StaffItem("Есть 10 программистов"));
        list.add(new StaffItem("Готов работать охранником"));
        list.add(new StaffItem("Подбираем любые команды под проект"));
    }
}
