package com.gorro.sexualidad;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.gorro.adapters.AdapterNews;
import com.squareup.picasso.Picasso;

import org.sufficientlysecure.htmltextview.HtmlTextView;


public class FragmentNews extends Fragment {

    ImageView image;
    TextView txtTitle, txtMore;
    HtmlTextView txtContent;
    ScrollView layoutContainer;
    AdapterNews adapterNews;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_new, container, false);

        image = (ImageView) viewRoot.findViewById(R.id.imgNewBackground);
        txtTitle = (TextView) viewRoot.findViewById(R.id.txtNewTitle);
        txtContent = (HtmlTextView) viewRoot.findViewById(R.id.txtNewContent);
        txtMore = (TextView) viewRoot.findViewById(R.id.txtNewMoreContent);
        layoutContainer = (ScrollView) viewRoot.findViewById(R.id.relativeNewContainer);

        txtTitle.setText(getArguments().getString("title") + "");
        txtContent.setHtmlFromString(getArguments().getString("content"), false);
        if (getArguments().getString("imagebackground").isEmpty()) {
            image.setBackgroundColor(getArguments().getInt("color"));
        } else {
            Picasso.with(getActivity()).load(getArguments().getString("imagebackground")).into(image);
            layoutContainer.setBackground(getResources().getDrawable(R.drawable.shape_btn_transparent));
        }

        txtMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://ed-usex.rhcloud.com/")));
            }
        });

        return viewRoot;
    }

    public void setAdapter(AdapterNews madapterNews) {
        adapterNews = madapterNews;
    }

}
