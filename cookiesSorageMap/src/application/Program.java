package application;

import javax.sound.midi.Soundbank;
import java.util.Map;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) {

        //Map storing cookies, with key: String and value: String
        Map<String, String> cookies = new TreeMap<>();

        //Adding elements on Map
        cookies.put("username", "Maria");
        cookies.put("email", "maria@gmail.com");
        cookies.put("phone", "999333735");

        //Removing from Map the entry's with the email key.
        cookies.remove("email");
        //
        cookies.put("phone", "929292929");

        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
        System.out.println("Phone number: " + cookies.get("phone"));
        System.out.println("Size: " + cookies.size());


        System.out.println("ALL COOKIES:");
        /*
        Taking the keys from Map in form of set, and them going through
        this set calling each element by the nickname
        */

        for (String key : cookies.keySet()) {
            //Printing the key and the element associated
            System.out.println(key + ": " + cookies.get(key));
        }
    }
}
