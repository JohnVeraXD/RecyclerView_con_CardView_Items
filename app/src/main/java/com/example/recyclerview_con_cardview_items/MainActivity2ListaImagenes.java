package com.example.recyclerview_con_cardview_items;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.Arrays;
import java.util.List;
import java.util.SimpleTimeZone;

import Adaptadores.AdaptadorImagenes;

public class MainActivity2ListaImagenes extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_lista_imagenes);

        recyclerView = (RecyclerView) findViewById(R.id.imagerecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Bundle b = this.getIntent().getExtras();
        String [] images = b.getStringArray("Images");
        List<String> lstImagenes = Arrays.asList(images);

        int resId = R.anim.layout_animation_down_to_up;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                resId);
        recyclerView.setLayoutAnimation(animation);

        AdaptadorImagenes adaptadorimages = new AdaptadorImagenes(this,lstImagenes);
        recyclerView.setAdapter(adaptadorimages);
    }
}