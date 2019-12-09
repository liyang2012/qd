package cn.com.myproject.qd.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Passwd {
    public static Map<String,String[]> map = new HashMap<>();
    //下午
    public static Map<String,String[]> map1 = new HashMap<>();
    //晚上
    public static Map<String,String[]> map2 = new HashMap<>();

    public static Map<String,String[]> map298 = new HashMap<>();

    public static AtomicInteger goodsId = new AtomicInteger(-999);
    public static AtomicInteger promType = new AtomicInteger(-999);
    public static AtomicInteger specId = new AtomicInteger(-999);


    public static AtomicInteger goodsId298 = new AtomicInteger(-999);
    static{
        /**
         *上午
         */
        //李阳
        map.put("18600890788",new String[]{"1qazxsw23edcp","2"});
        map.put("18790557231",new String[]{"a123456b","2"});
        map.put("17516204802",new String[]{"a123456b","2"});


        //小跃
        map.put("18236935201",new String[]{"qingying0728","1"});
        map.put("18236914562",new String[]{"qingying0728","1"});
        map.put("18338803651",new String[]{"a123456","1"});
        map.put("18838813223",new String[]{"a123456","2"});
    //    map.put("15603916167",new String[]{"a123456","2"});

    //    map.put("17344881234",new String[]{"1234567890","1"});

        //雪涛
        map.put("15239785286",new String[]{"a123456","2"});
  //      map.put("15236773066",new String[]{"a123456","2"});
        //海伟
        map.put("19937123415",new String[]{"1234567890","2"});
   //     map.put("19942544468",new String[]{"a123456","2"});
    //    map.put("18236410760",new String[]{"a123456","1"});
     //   map.put("15039184229",new String[]{"a123456","1"});


       //外人
        map.put("18531958710",new String[]{"gyy150808","1"});
//        map.put("15512832589",new String[]{"721123mm","2"});
//        map.put("15210920463",new String[]{"xdn123456","1"});



        //  超哥 9个号

        map.put("16562209349",new String[]{"123456","2"});
        map.put("16562203247",new String[]{"123456","2"});
        map.put("16562205694",new String[]{"123456","2"});
        map.put("16562204475",new String[]{"123456","2"});
        map.put("16562204505",new String[]{"123456","2"});
        map.put("16562205674",new String[]{"123456","2"});
        map.put("16562204574",new String[]{"123456","2"});
        map.put("16562203244",new String[]{"123456","2"});
        map.put("16562206764",new String[]{"123456","2"});
//        map.put("15127436074",new String[]{"123456","2"});
//        map.put("15090472836",new String[]{"123456","2"});
//        map.put("15030486911",new String[]{"123456","2"});
//        map.put("13868853856",new String[]{"888999","2"});
//        map.put("15249690142",new String[]{"681047","2"});
//
//        map.put("18103216714",new String[]{"123456","2"});
//        map.put("15566351484",new String[]{"123456","2"});
//        map.put("15360194915",new String[]{"123456","2"});





        /****
         * 下午
         * **/
        map1.put("16562204585",new String[]{"123456","2"});
        map1.put("16562206714",new String[]{"123456","2"});
        map1.put("16562204473",new String[]{"123456","2"});
        map1.put("16562204542",new String[]{"123456","2"});


    //    map1.put("15890105560",new String[]{"123456","2"});
        /**
         * 晚上
         * */
//        map2.put("",new String[]{"","2"});

        /**
         * 298
         * */
        map298.put("",new String[]{"",""});
    }
}
