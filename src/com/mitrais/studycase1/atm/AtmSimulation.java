package com.mitrais.studycase1.atm;

import com.mitrais.studycase1.atm.view.WelcomeScreen;


public class AtmSimulation {

    public static void main(String[] args) {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        while (true) {
            welcomeScreen.show();
        }
    }
}
