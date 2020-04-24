package club.plus1.staffsharing.ui.offer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import club.plus1.staffsharing.R;

public class OfferActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    OfferAdapter adapter;
    List<OfferItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offer);
        setData();
        adapter = new OfferAdapter(this, list);
        recyclerView = findViewById(R.id.listOffer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        setTitle(getString(R.string.offer_title));
    }

    private void setData() {
        list = new ArrayList<>();
        list.add(new OfferItem("Ищем 10 программистов"));
        list.add(new OfferItem("Мы ищем охранника"));
        list.add(new OfferItem("Нужны 5 человек на обзвоны"));
    }
}