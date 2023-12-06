package Atelier2;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jdk.jfr.Registered;

@Named
@RequestScoped
public class HelloBean {


    // properties
    private String messag  ;

    private String result ;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessag() {
        return messag;
    }

    public void setMessag(String messag) {
        this.messag = messag;
    }



    // actions

    public void sayHello(){


        this.result =  "Hello : " + this.messag ;
    }



}
