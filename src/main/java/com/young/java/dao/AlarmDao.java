package com.young.java.dao;

/**
 * Created by dell on 2015/12/31.
 */
public class AlarmDao extends BaseDao{
    public void setEventConfig(String enventId){
        String url = baseUrl+"/ISAPI/Event/triggers/"+enventId;

    }
}
