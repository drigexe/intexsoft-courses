package com.intexsoft.courses.vysocki.library.utils;

import com.intexsoft.courses.vysocki.library.model.LibraryDepartment;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParserUtil {

    public ArrayList<LibraryDepartment> parseDepartmentsJson(String jsonStr) {
        JSONArray jsonarray = new JSONArray(jsonStr);
        ArrayList<LibraryDepartment> libraryDepartments = new ArrayList<LibraryDepartment>();
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            String id = jsonobject.getString("id");
            String name = jsonobject.getString("name");
            String website = jsonobject.getString("website");
            String path = jsonobject.getString("path");
            LibraryDepartment libraryDepartment = new LibraryDepartment(name, website, path, id);
            libraryDepartments.add(libraryDepartment);
        }
        return libraryDepartments;
    }

}
