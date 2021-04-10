package com.chloneda.dynamicdbsource;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created by chloneda
 * @Description:切换数据源
 */
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder=new ThreadLocal<String>();

    public static List<String> dataSourceIds=new ArrayList<String>();

    public static void setDataSource(String dataSourceType){
        contextHolder.set(dataSourceType);
    }

    public static String getDataSource(){
        return contextHolder.get();
    }

    public static void removeDataSource(){
        contextHolder.remove();
    }

    public static void reset(){
        contextHolder.set("master");
    }

    public static boolean containsDataSource(DataSources dataSourceType){
        return dataSourceIds.contains(dataSourceType);
    }

}
