package com.example.mholt2587.boredapp.model;

import com.example.mholt2587.boredapp.R;

public class Story {
    private Page[] pages;

    public Story() {
        pages = new Page[8];

        pages[0] = new Page(R.string.page0);
                new Choice(R.string.page0_choice1, 1),
                new Choice(R.string.page0_choice2, 2);
    }
}