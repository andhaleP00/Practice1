package com.example.practice1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomSwipeAdapter extends PagerAdapter {
    private int[] imageResources={R.drawable.kitty1,R.drawable.supermom,R.drawable.tiger1,R.drawable.watch1};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdapter(Context ctx)
    {
        this.ctx=ctx;
    }
    @Override
    public int getCount() {
        return imageResources.length;
    }


//this method reprsent each view or page which we will display in viewpager
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //initialize layout inflater object
        layoutInflater=(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //create view as
        View viewItem=layoutInflater.inflate(R.layout.swipe_layout,container,false);
        //create object of imageView as
        ImageView imageView=(ImageView) viewItem.findViewById(R.id.image_view);
        imageView.setImageResource(imageResources[position]);
        container.addView(viewItem);
        return viewItem;
       /* return super.instantiateItem(container, position);*/
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        /*super.destroyItem(container, position, object);*/
        //if user move or swipe from one page to another then we should destroy previous displaying page as
        container.removeView((LinearLayout)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        //here we can do validation for specific view
        return false;


    }
}
