package com.darkdragon.comunication;

/**
 * Created by hp on 12-05-2018.
 */

public class Presenter implements MVPContractMainActivity.Presenter {

    private final MVPContractMainActivity.View view;

    public Presenter(MVPContractMainActivity.View view) {

        this.view = view;
    }

    @Override
    public void presenterlogic(String message) {
        view.viewlogic(message);
    }


}
