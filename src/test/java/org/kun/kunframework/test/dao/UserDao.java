package org.kun.kunframework.test.dao;

import org.kun.kunframework.beans.factory.DisposableBean;
import org.kun.kunframework.beans.factory.InitializingBean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod(){
        System.out.println("执行：init-method");
        hashMap.put("1", "2");
        hashMap.put("2", "3");
        hashMap.put("3", "4");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String id) {
        return hashMap.get(id);
    }

}
