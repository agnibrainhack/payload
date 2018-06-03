package com.darkdragon.comunication;

/**
 * Created by hp on 12-05-2018.
 */

public interface MVPContractMainActivity {

    interface View{
         void viewlogic(String message);
    }

    interface Presenter{
         void presenterlogic(String message);

    }
}
