package com.latsykroman.kolo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Latsyk Roman on 05.04.2018.
 */

public class UserModel {
    String name, key, client, author;

    int kilkist;

    public UserModel(){}

    public UserModel(String name,  String key, int kilkist,  String client, String author) {
        this.name = name;
        this.key = key;
        this.kilkist = kilkist;
        this.client = client;
        this.author = author;


    }
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("key", key);
        result.put("kilkist", kilkist);
        result.put("client", client);
        result.put("author", author);
        return result;
    }



}
