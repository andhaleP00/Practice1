package com.example.practice1;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    ViewPager viewPager;
    CustomSwipeAdapter customSwipeAdapter;
    Context ctx;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   /* private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
      private OnFragmentInteractionListener mListener;


*///by pooja andhale

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
  /*  public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/  //by pooja andhale

  /*  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
*/   //by pooja andhale
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_home,container,false);
        viewPager=v.findViewById(R.id.viewPager);
        customSwipeAdapter=new CustomSwipeAdapter(getContext());
        viewPager.setAdapter(customSwipeAdapter);
        Timer t=new Timer();
        t.scheduleAtFixedRate(new MyTimerTask(),2000,4000);


        // Inflate the layout for this fragment
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
   /* public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/      //by pooja andhale

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ctx=context;

    }     //by pooja andhale

   /* @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/  //by pooja andhale

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/  //by pooja andhale

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager=getView().findViewById(R.id.viewPager);
        customSwipeAdapter=new CustomSwipeAdapter(getActivity());
        viewPager.setAdapter(customSwipeAdapter);

    }

    //class used to make all slides automatically sliding
    public class MyTimerTask extends TimerTask
    {
        int rev=0;

        @Override
        public void run() {
            //when we switch from one fragment to another getActivity() returns null to avoid that we should override onAttach() method in fragment through which Context parameter
            //passed by application itself through which we can get fragmentActivity again
            if(getActivity()==null)
            {
                FragmentActivity fa=(FragmentActivity)ctx;
                fa.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if((viewPager.getCurrentItem()==0)&&(rev==0))
                            {

                                viewPager.setCurrentItem(1);
                                /*prepareDots(viewPager.getCurrentItem());*/
                            }

                            else if((viewPager.getCurrentItem())==1&&(rev==0))
                            {
                                viewPager.setCurrentItem(2);
                                /*prepareDots(viewPager.getCurrentItem());*/
                            }
                            else if((viewPager.getCurrentItem()==2)&&(rev==0))
                            {
                                viewPager.setCurrentItem(3);
                                /* prepareDots(viewPager.getCurrentItem());*/
                                rev=1;
                            }
                            else if((viewPager.getCurrentItem()==3)&&(rev==1))
                            {
                                viewPager.setCurrentItem(2);
                                /* prepareDots(viewPager.getCurrentItem());*/


                            }
                   /* else if((viewPager.getCurrentItem()==4)&&(rev==0))
                    {
                        viewPager.setCurrentItem(3);

                        *//* prepareDots(viewPager.getCurrentItem());*//*
                    }
                    else if((viewPager.getCurrentItem()==3)&&(rev==1))
                    {
                        viewPager.setCurrentItem(2);
                        *//* prepareDots(viewPager.getCurrentItem());*//*
                    }*/
                            else if((viewPager.getCurrentItem()==2)&&(rev==1))
                            {
                                viewPager.setCurrentItem(1);
                                /*prepareDots(viewPager.getCurrentItem());*/
                            }
                            else if((viewPager.getCurrentItem()==1)&&(rev==1))
                            {
                                viewPager.setCurrentItem(0);
                                rev=0;
                                /*prepareDots(viewPager.getCurrentItem());*/
                            }


                        }


                });
            }
           else
            {
                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {



                        if((viewPager.getCurrentItem()==0)&&(rev==0))
                        {

                            viewPager.setCurrentItem(1);
                            /*prepareDots(viewPager.getCurrentItem());*/
                        }

                        else if((viewPager.getCurrentItem())==1&&(rev==0))
                        {
                            viewPager.setCurrentItem(2);
                            /*prepareDots(viewPager.getCurrentItem());*/
                        }
                        else if((viewPager.getCurrentItem()==2)&&(rev==0))
                        {
                            viewPager.setCurrentItem(3);
                            /* prepareDots(viewPager.getCurrentItem());*/
                            rev=1;
                        }
                        else if((viewPager.getCurrentItem()==3)&&(rev==1))
                        {
                            viewPager.setCurrentItem(2);
                            /* prepareDots(viewPager.getCurrentItem());*/


                        }
                   /* else if((viewPager.getCurrentItem()==4)&&(rev==0))
                    {
                        viewPager.setCurrentItem(3);

                        *//* prepareDots(viewPager.getCurrentItem());*//*
                    }
                    else if((viewPager.getCurrentItem()==3)&&(rev==1))
                    {
                        viewPager.setCurrentItem(2);
                        *//* prepareDots(viewPager.getCurrentItem());*//*
                    }*/
                        else if((viewPager.getCurrentItem()==2)&&(rev==1))
                        {
                            viewPager.setCurrentItem(1);
                            /*prepareDots(viewPager.getCurrentItem());*/
                        }
                        else if((viewPager.getCurrentItem()==1)&&(rev==1))
                        {
                            viewPager.setCurrentItem(0);
                            rev=0;
                            /*prepareDots(viewPager.getCurrentItem());*/
                        }


                    }

                });
            }

        }
}
}
