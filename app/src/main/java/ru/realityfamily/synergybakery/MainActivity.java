package ru.realityfamily.synergybakery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetPageTitle("Меню");
        setActionBar((Toolbar) findViewById(R.id.toolBar));

        final ImageButton ib = (ImageButton) findViewById(R.id.cart);
        final BottomNavigationView bnv = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetPageTitle("Корзина");
                bnv.setSelectedItemId(R.id.none);
                ib.setColorFilter(Color.BLACK);
            }
        });


        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu:
                        SetPageTitle("Меню");
                        ib.setColorFilter(Color.WHITE);
                        return true;
                    case R.id.sales:
                        SetPageTitle("Скидки");
                        ib.setColorFilter(Color.WHITE);
                        return true;
                    case R.id.client:
                        SetPageTitle("Личный кабинет");
                        ib.setColorFilter(Color.WHITE);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    public void SetPageTitle (String PageTitle) {
        ((TextView) findViewById(R.id.page_title)).setText(PageTitle);
    }
}