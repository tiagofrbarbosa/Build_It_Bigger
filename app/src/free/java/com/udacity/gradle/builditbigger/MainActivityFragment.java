package com.udacity.gradle.builditbigger;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Button myButton;
    public static ProgressBar spinner;
    private InterstitialAd mInterstitial;
    private  AdView mAdView;
    AdRequest adRequest;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        adRequest = new AdRequest.Builder()
                //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                //.addTestDevice("ABCDEF012345")
                .build();

        mAdView = (AdView) root.findViewById(R.id.adView);
        mInterstitial = new InterstitialAd(getActivity());
        mInterstitial.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
        mInterstitial.loadAd(adRequest);

        spinner = (ProgressBar) root.findViewById(R.id.myProgressBar);
        spinner.setVisibility(View.GONE);
        myButton = (Button) root.findViewById(R.id.myButton);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);

                if(mInterstitial.isLoaded()) {
                    mInterstitial.setAdListener(new AdListener() {
                        @Override
                        public void onAdClosed() {
                            super.onAdClosed();

                            new EndpointsAsyncTask().execute(getActivity());
                        }
                    });

                    mInterstitial.show();
                }else{
                            new EndpointsAsyncTask().execute(getActivity());
                }
            }
        });

        mAdView.loadAd(adRequest);
        return root;
    }

    @Override
    public void onResume(){
        super.onResume();

        if(!mInterstitial.isLoaded()){
            mInterstitial.loadAd(adRequest);
        }
    }
}
