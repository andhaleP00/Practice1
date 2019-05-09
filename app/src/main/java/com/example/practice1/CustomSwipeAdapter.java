package com.example.practice1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class CustomSwipeAdapter extends PagerAdapter {
    private int[] imageResources={R.drawable.kitty1,R.drawable.supermom,R.drawable.tiger1,R.drawable.watch1};
    private Context ctx;
    private LayoutInflater layoutInflater;
    private LinearLayout dotsLayout;

    public CustomSwipeAdapter(Context ctx)
    {
        this.ctx=ctx;
        this.layoutInflater=(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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

        //create view as
        View viewItem=layoutInflater.inflate(R.layout.swipe_layout,container,false);
        //create object of imageView as
        ImageView imageView=(ImageView) viewItem.findViewById(R.id.image_view);
        dotsLayout=(LinearLayout) viewItem.findViewById(R.id.dotsContainer);
        imageView.setImageResource(imageResources[position]);
        prepareDots(position);
        container.addView(viewItem);

        return viewItem;
       /* return super.instantiateItem(container, position);*/
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        /*super.destroyItem(container, position, object);*/
        //if user move or swipe from one page to another then we should destroy previous displaying page as
        container.removeView((RelativeLayout)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        //here we can do validation for specific view
        return view == ((RelativeLayout) o);


    }
    private void prepareDots(int currentSlidePosition)
    {
        dotsLayout.removeAllViews();
        ImageView dots[]=new ImageView[4];
        for(int i=0;i<4;i++)
        {
            dots[i]=new ImageView(ctx);
            if(i==currentSlidePosition)
                dots[i].setImageDrawable(ContextCompat.getDrawable(ctx,R.drawable.active_dots));
            else
                dots[i].setImageDrawable(ContextCompat.getDrawable(ctx,R.drawable.inactive_dots));
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(4,0,4,0);
            dotsLayout.addView(dots[i],layoutParams);


        }

    }

}

