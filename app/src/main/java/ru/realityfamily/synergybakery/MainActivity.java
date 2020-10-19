package ru.realityfamily.synergybakery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.realityfamily.synergybakery.Fragments.CartFragment;
import ru.realityfamily.synergybakery.Fragments.ClientFragment;
import ru.realityfamily.synergybakery.Fragments.MenuFragment;
import ru.realityfamily.synergybakery.Fragments.SalesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetPageTitle("Меню");
        setActionBar((Toolbar) findViewById(R.id.toolBar));

        getSupportFragmentManager().beginTransaction().replace(R.id.content, new MenuFragment()).commit();

        final ImageButton ib = (ImageButton) findViewById(R.id.cart);
        final BottomNavigationView bnv = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetPageTitle("Корзина");
                bnv.setSelectedItemId(R.id.none);
                ib.setColorFilter(Color.BLACK);
                getSupportFragmentManager().beginTransaction().replace(R.id.content, new CartFragment()).commit();
            }
        });


        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu:
                        SetPageTitle("Меню");
                        ib.setColorFilter(Color.WHITE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, new MenuFragment()).commit();
                        return true;
                    case R.id.sales:
                        SetPageTitle("Скидки");
                        ib.setColorFilter(Color.WHITE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, new SalesFragment()).commit();
                        return true;
                    case R.id.client:
                        SetPageTitle("Личный кабинет");
                        ib.setColorFilter(Color.WHITE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, new ClientFragment()).commit();
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