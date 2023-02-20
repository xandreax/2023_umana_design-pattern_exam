package it.euris.academy2023.oldfashionpound;

import it.euris.academy2023.oldfashionpound.service.Application;

public class Main {

    public static void main(String[] args) {

        System.out.println(args[0]);
        Application application = new Application();
        application.run(args[0]);

    }

}
