package com.fandor.challenge;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
        CarouselThread runCarousel = new CarouselThread();
        runCarousel.start();
    }

    public class CarouselThread extends Thread {
        public void run() {
            Carousel fandorCarousel = new Carousel();
            fandorCarousel.addText("\"Fandor is a pretty cool service!\"");
            fandorCarousel.addText("Watch award-winning movies from around the world");
            fandorCarousel.addText("\"I've been looking for new films to add to my list, Fandor has a whole catalog to add!\"");
            fandorCarousel.addText("\"Fandor is invaluable at finding great films\"");
            fandorCarousel.addText("Explore hand-picked movies from our top genres. New movies added daily");

            while(true) {
                TextView carousel_text = (TextView) getView().findViewById(R.id.carousel);
                carousel_text.setText(fandorCarousel.getText());
                try {
                    Thread.currentThread().sleep(6000);
                } catch (InterruptedException ex) {
                    System.out.print(ex);
                }
                fandorCarousel.showNext();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

}

