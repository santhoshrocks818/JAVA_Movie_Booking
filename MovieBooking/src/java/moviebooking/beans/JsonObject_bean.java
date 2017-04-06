package moviebooking.beans;


import moviebooking.beans.MovieList_details_home_bean;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tcs
 */
public class JsonObject_bean {
    JSONObject jsonobject;
    Object[] obj;
    JSONArray moviesObj;
    
    public JsonObject_bean(){
    }

    public JSONArray getMoviesObj() {
        return moviesObj;
    }

    public void setMoviesObj(JSONArray moviesObj) {
        this.moviesObj = moviesObj;
    }

    public Object[] getObj() {
        return obj;
    }

    public void setObj(Object[] obj) {
        this.obj = obj;
    }
    MovieList_details_home_bean mlist;

    public MovieList_details_home_bean getMlist() {
        return mlist;
    }

    public void setMlist(MovieList_details_home_bean mlist) {
        this.mlist = mlist;
    }

    public JSONObject getJsonobject() {
        return jsonobject;
    }

    public void setJsonobject(JSONObject jsonobject) {
        this.jsonobject = jsonobject;
    }
    
}
