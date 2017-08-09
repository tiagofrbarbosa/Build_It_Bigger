package infofun.tech.jokes;

import java.io.Serializable;

public class Joker implements Serializable{

    String joke;

    public Joker(String joke){
        this.joke = joke;
    }

    public void setJoke(String joke){
        this.joke = joke;
    }

   public String getJoke() {

       return this.joke;
       //return "This is totally a funny joke";
        }
}
