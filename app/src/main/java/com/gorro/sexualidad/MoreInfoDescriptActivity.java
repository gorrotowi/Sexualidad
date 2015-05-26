package com.gorro.sexualidad;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;

import com.github.ksoichiro.android.observablescrollview.ObservableListView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.gorro.adapters.AdapterMoreInfoDescr;
import com.gorro.entitys.ItemMoreInfo;
import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;


public class MoreInfoDescriptActivity extends ActionBarActivity implements ObservableScrollViewCallbacks {

    ObservableListView listHistorys;
    AdapterMoreInfoDescr adapter;
    Toolbar toolbar;
    private ImageView mImageView;
    private View mListBackgroundView;
    private int mParallaxImageHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info_descript);

        String title = getIntent().getExtras().getString("title", "");

        listHistorys = (ObservableListView) findViewById(R.id.listMoreInfoDesc);
        mImageView = (ImageView) findViewById(R.id.imgHeaderMoreInfoDescr);
        toolbar = (Toolbar) findViewById(R.id.toolbarMoreInfoDescr);
        toolbar.setTitle(title);
        toolbar.setBackgroundColor(ScrollUtils.getColorWithAlpha(1, getResources().getColor(R.color.primary)));

        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height_thin);

        listHistorys.setScrollViewCallbacks(this);
        View paddingView = new View(this);
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                mParallaxImageHeight);
        paddingView.setLayoutParams(lp);

        paddingView.setClickable(true);

        listHistorys.addHeaderView(paddingView);

        if (title.equals("Identidad")) {
            adapter = new AdapterMoreInfoDescr(MoreInfoDescriptActivity.this, R.layout.item_more_info_descr, getDataIdentidad());
            mImageView.setImageResource(R.drawable.identity);
        } else {
            adapter = new AdapterMoreInfoDescr(MoreInfoDescriptActivity.this, R.layout.item_more_info_descr, getDataOrientation());
            mImageView.setImageResource(R.drawable.orientation);
        }


        listHistorys.setAdapter(adapter);

        mListBackgroundView = findViewById(R.id.list_backgroundMoreInfoDescr);
        final View contentView = getWindow().getDecorView().findViewById(android.R.id.content);
        contentView.post(new Runnable() {
            @Override
            public void run() {
                mListBackgroundView.getLayoutParams().height = contentView.getHeight();
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private ArrayList<ItemMoreInfo> getDataIdentidad() {
        final ArrayList<ItemMoreInfo> item = new ArrayList<>();
        item.add(new ItemMoreInfo(R.drawable.sexo, "Sexo", "Marcador biológico que te es asignado al nacer"));
        item.add(new ItemMoreInfo(R.drawable.genero, "Género", "Expresión y rol en la sociedad modificable/variable basada en el sexo"));
        item.add(new ItemMoreInfo(R.drawable.transgenero, "Transgénero", "Persona cuya identidad de género es diferente a su sexo"));
        item.add(new ItemMoreInfo(R.drawable.cisgenero, "Cisgénero", "Persona cuya identidad de género es igual a su sexo"));
        item.add(new ItemMoreInfo(R.drawable.fluidgen, "Género fluido", "Persona cuya identidad de género varia"));
        item.add(new ItemMoreInfo(R.drawable.nogenero, "Sin género/Género no binario", "Persona cuyo género no entra en los estándares de mujer/hombre"));
        item.add(new ItemMoreInfo(R.drawable.intersex, "Intersexo", "Persona que al nacer tiene variaciones de órganos genitales externos o internos que no pueden clasificarse. Usualmente se les realiza una operación para que crezcan con un género determinado"));
        return item;
    }

    private ArrayList<ItemMoreInfo> getDataOrientation() {
        final ArrayList<ItemMoreInfo> item = new ArrayList<>();
        item.add(new ItemMoreInfo(R.drawable.heteroflag, "Heterosexual", "Experimenta atracción romántica/sexual hacia el sexo opuesto"));
        item.add(new ItemMoreInfo(R.drawable.gayflag, "Homosexual", "Experimenta atracción romántica/sexual hacia el mismo sexo"));
        item.add(new ItemMoreInfo(R.drawable.biflag, "Bisexual", "Experimenta atracción romántica/sexual hacia dos sexos"));
        item.add(new ItemMoreInfo(R.drawable.panflag, "Pansexual", "Experimenta atracción romántica/sexual hacia individuos sin importar sexo o género"));
        item.add(new ItemMoreInfo(R.drawable.demiflag, "Demisexual", "Sólo experimenta atracción romántica/sexual después de formar un vínculo emocional"));
        item.add(new ItemMoreInfo(R.drawable.asexualflag, "Asexual", "No experimenta atracción romántica o sexual"));
        return item;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onScrollChanged(listHistorys.getCurrentScrollY(), false, false);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        int baseColor = getResources().getColor(R.color.primary);
        float alpha = 1 - (float) Math.max(0, mParallaxImageHeight - scrollY) / mParallaxImageHeight;
        toolbar.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));
        ViewHelper.setTranslationY(mImageView, -scrollY / 2);

        // Translate list background
        ViewHelper.setTranslationY(mListBackgroundView, Math.max(0, -scrollY + mParallaxImageHeight));
    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }
}
