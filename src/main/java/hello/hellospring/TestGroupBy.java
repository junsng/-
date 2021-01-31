package hello.hellospring;

import java.util.*;

public class TestGroupBy {

    public static void main(String[] args){
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("data",20201102);
        dataMap.put("code","001");
        dataMap.put("checkTime","05:24:11");
        dataList.add(dataMap);

        dataMap.put("data",20201102);
        dataMap.put("code","002");
        dataMap.put("checkTime","15:00:19");
        dataList.add(dataMap);

        dataMap.put("data",20201103);
        dataMap.put("code","001");
        dataMap.put("checkTime","05:23:53");
        dataList.add(dataMap);

        dataMap.put("data",20201103);
        dataMap.put("code","002");
        dataMap.put("checkTime","15:00:11");
        dataList.add(dataMap);

        /*data = [
                    {date=20201102, code=001, checktime=05:24:11},
                    {date=20201102, code=002, checktime=15:00:19},
                    {date=20201103, code=001, checktime=05:23:53},
                    {date=20201103, code=002, checktime=15:00:07}
                ]*/



           // System.out.println("초기데이터::"+data);


    }

}
