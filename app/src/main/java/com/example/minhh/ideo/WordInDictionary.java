package com.example.minhh.ideo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minhh on 11/22/2016.
 */

public class WordInDictionary {

    private List<String> _Id = new ArrayList<String>();
    private List<String> _Name;

    public WordInDictionary(List<String> id, List<String> name) {
        _Id = id;
        _Name = name;
    }

    public WordInDictionary() {
    }

    public List<String> getName() {
        return _Name;
    }

    public void setName(List<String> name) {
        _Name = name;
        for (int i = 0; i < _Name.size(); i++) {
            _Id.add(String.valueOf(i));
        }
    }


    public List<String> getId() {
        return _Id;
    }

    public void setId(List<String> id) {
        _Id = id;
    }

    public void SetToTo(String name) {
        _Name.add(name);
        _Id.add(String.valueOf(_Name.size() + 1));
    }

    public String GetNameToTo(int id) {
        return _Name.get(id);
    }

    public String GetIdToTo(int id) {
        return _Id.get(id);
    }
}
