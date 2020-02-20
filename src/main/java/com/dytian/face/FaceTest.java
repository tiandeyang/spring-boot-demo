package com.dytian.face;

import org.nutz.http.Header;
import org.nutz.http.Http;
import org.nutz.http.Response;
import org.nutz.json.Json;
import org.nutz.lang.util.NutMap;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class FaceTest {




    public static void main(String[] args) throws Exception {

        // 毛孔 黑头 肤质 肌肤年龄 痘痘  黑眼圈 肤色
        // 4   32768 8  1       65536  131072  256


        //app_id= 6203bdc2f2646ecd  密钥=4e9dd47415632020cbf22fe86e504ed8

        String url = "https://api.yimei.ai/v2/api/face/analysis/229645";
        String client_id = "6203bdc2f2646ecd";
        String client_secret = "4e9dd47415632020cbf22fe86e504ed8";
        String body="image=https://yuemee-test.oss-cn-beijing.aliyuncs.com/data/face.jpg";


        Header header = Header.create();
        header.set("Content-Type","application/x-www-form-urlencoded");
        header.set("Authorization","Basic " + new sun.misc.BASE64Encoder().encode((client_id+":"+client_secret).getBytes()));
        header.set("Content-Length",String.valueOf(body.length()));
        Response response = Http.post3(url, body, header, 30000, 60000);
        if (response.isOK()) {
            String content = response.getContent();
            System.out.println(content);

            // 肌肤年龄
            NutMap nutMap = Json.fromJson(NutMap.class, content);
            System.out.println(Json.toJson(nutMap));

            int code = nutMap.getInt("code", 1);
            NutMap age1 = nutMap.getAs("age", NutMap.class);

            if (age1 != null) {
                int age = age1.getInt("result", 0);
                System.out.println("肌肤年龄=======age=="+age);
            }

            // 痘痘
            NutMap pockmark = nutMap.getAs("pockmark", NutMap.class);
            List<NutMap> categorys = pockmark.getAsList("category", NutMap.class);
            for (NutMap category : categorys) {
                String cls = category.getString("cls");
                if (cls.equalsIgnoreCase("CC_DD")) {
                    int count = category.getInt("count", 0);
                    int score = category.getInt("score", 0);
                    System.out.println("痘痘个数=="+count);
                    System.out.println("得分=="+score);
                }
                if (cls.equalsIgnoreCase("CC_DY")) {
                    int count = category.getInt("count", 0);
                    int score = category.getInt("score", 0);
                    System.out.println("痘印个数=="+count);
                    System.out.println("得分=="+score);
                }
            }


            // 黑头
            NutMap blackhead = nutMap.getAs("blackhead", NutMap.class);
            if (blackhead != null) {
                int count = blackhead.getInt("count", 0);
                String level = blackhead.getString("level");
                // severe（严重）； moderately（中度）； lightly（轻度）； none（无）；
                String score = blackhead.getString("score");
                String filename = blackhead.getString("filename");
                System.out.println("黑头个数==="+count);
            }


            try {
                NutMap color = nutMap.getAs("color", NutMap.class);
                if (color != null) {
                    // 肤色
                    String fuse = color.getString("result");
                    System.out.println("肤色======="+fuse);
                }
//            toubai（透白）色值：#f9e5d9、
//            baixi（白皙）色值：#f2d5c3、
//            ziran（自然）色值：#efc2a7、
//            xiaomai（小麦）色值：#c19b88、
//            anchen（暗沉）色值：#99715f、
//            youhei（黝黑）色值：#684a42
            } catch (Exception e) {
                e.printStackTrace();
            }
//            "count":1,
//                    "level":"lightly",
//                    "score":"99",
//                    "area":0.0204304251819849,
//                    "filename":"prd-apiout0/2019/0930/cf8f54d8e68bfa9c9a3e20f0ac718bc9-2251799824523916.jpg"
            // 毛孔
            NutMap pore = nutMap.getAs("pore", NutMap.class);
            if (pore != null) {
                //            "count":8,
//                    "level":"lightly",
//                    "score":"98",
//                    "area":0.13682246208190918,
//                    "filename":"prd-apiout0/2019/0930/f11ec11352d42eebe383f3252d6c8295-2251799824524877.jpg"

                int count = pore.getInt("count", 0);
                String level = pore.getString("level");
                // severe（严重）； moderately（中度）； lightly（轻度）； none（无）；
                String score = pore.getString("score");
                String filename = pore.getString("filename");

                System.out.println("毛孔个数==========="+count);

            }



            NutMap skin_type = nutMap.getAs("skin_type", NutMap.class);
            if (skin_type != null) {
                int score = skin_type.getInt("score");

                System.out.println("肤质分数==="+score);

                String type = skin_type.getString("type");
               // 肤质类型：mid（中性）；dry（干性）；oil：（油性）；
                System.out.println("肤质类型===="+type);

                List<NutMap> category = skin_type.getAsList("category", NutMap.class);

                for (NutMap map : category) {
                    String cls = map.getString("cls");
                    String type1 = map.getString("type");
                    String level = map.getString("level");
                    int score1 = map.getInt("score");

                    System.out.println("cls==="+cls);
                    System.out.println("type=="+type1);
                    System.out.println("level=="+level);
                    System.out.println("score=="+score1);

                    switch (cls){
                        case "forehead":
                            break;
                        case "nose":
                            break;
                        case "left_cheek":
                            break;
                        case "right_cheek":
                            break;
                        case "chin":
                            break;

                    }
                }

            }


        }

        if (1 == 1) {
            System.out.println("end is over");
            return;
        }



    //    System.out.println("POST parameter : " + parameterBuffer.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(url).openConnection();
        httpURLConnection.setDoOutput(true);
        try {
            httpURLConnection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }




        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Authorization", "Basic " + new sun.misc.BASE64Encoder().encode((client_id+":"+client_secret).getBytes()));
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(body.length()));

        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;
        try {
            //
            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(body);
            outputStreamWriter.flush();
            //响应失败
//            if (httpURLConnection.getResponseCode() != 200) {
//                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
//            }
            //接收响应流
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);
            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }

//            InputStream errorStream = httpURLConnection.getErrorStream();
//            System.out.println(errorStream == null);
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
//            System.out.println("error:"+in.readLine());

            System.out.println("result"+resultBuffer.toString());
        } finally {
            if (outputStreamWriter != null)outputStreamWriter.close();
            if (outputStream != null)outputStream.close();
            if (reader != null)reader.close();
            if (inputStreamReader != null)inputStreamReader.close();
            if (inputStream != null)inputStream.close();
        }

// 肌肤年龄
//        {
//                "code":0,
//                "error_detect_types":0,
//                "filename":"prd-api0/2019/0929/f0a10aa62fd22e6fec85cd447c391d5d-2251799824470749.jpg",
//                "detect_types":"1",
//                "age":{
//                  "result":25 // 肌肤年龄
//                 },
//            "face_box":{
//                     "x0":114,
//                    "y0":256,
//                    "x1":893,
//                    "y1":1354
//             },
//            "id":"7d442c5d2ccaf6d00f292b42c73146e1"
//        }


// 斑点
//        {
//            "code":0,
//                "error_detect_types":0,
//                "filename":"prd-api0/2019/0929/2c8b69232336c65f02d5090d6969eeff-2251799824471148.jpg",
//                "detect_types":"2",
//                "spot":{
//                  "count":7,
//                    "score":93,
//                    "category":[
//            {
//                "cls":"Z_Z",
//                    "count":4,
//                    "score":89,
//                    "level":"moderately"
//            },
//            {
//                "cls":"B_QTB",
//                    "count":2,
//                    "score":96,
//                    "level":"lightly"
//            },
//            {
//                "cls":"B_QB",
//                    "count":1,
//                    "score":98,
//                    "level":"lightly"
//            }
//        ],
//            "filename":"prd-apiout0/2019/0929/d948e18f9a8f19d5dfaa9f53eba184ac-2251799824471251.jpg"
//        },
//            "face_box":{
//            "x0":114,
//                    "y0":256,
//                    "x1":893,
//                    "y1":1354
//        },
//            "id":"0ab280104a3d64315167ac2f28ffc5d3"
//        }


// 肤质 {"code":0,"error_detect_types":0,"filename":"prd-api0\/2019\/0929\/ead3c1b7a4d5b60ff5d4d5c611bd029d-2251799824474531.jpg","detect_types":"32780","blackhead":{"count":1,"level":"lightly","score":"99","area":0.0204304251819849,"filename":"prd-apiout0\/2019\/0929\/f90791fd781f571537bba5434643ee36-2251799824474533.jpg"},"pore":{"count":8,"level":"lightly","score":"98","area":0.13682246208190918,"filename":"prd-apiout0\/2019\/0929\/c9f5de1d7c0eeb654715506fdd742bd1-2251799824474534.jpg"},"skin_type":{"score":67,"category":[{"cls":"forehead","type":"oil","level":"lightly","score":67},{"cls":"nose","type":"oil","level":"lightly","score":67},{"cls":"left_cheek","type":"oil","level":"lightly","score":67},{"cls":"right_cheek","type":"oil","level":"lightly","score":67},{"cls":"chin","type":"oil","level":"lightly","score":67}],"type":"oil"},"face_box":{"x0":114,"y0":256,"x1":893,"y1":1354},"id":"d438618c0522681f4ed22ec1fdb962e1"}
//        {
//            "code":0,
//                "error_detect_types":0,
//                "filename":"prd-api0/2019/0929/ead3c1b7a4d5b60ff5d4d5c611bd029d-2251799824474531.jpg",
//                "detect_types":"32780",
//                "blackhead":{
//            "count":1,
//                    "level":"lightly",
//                    "score":"99",
//                    "area":0.0204304251819849,
//                    "filename":"prd-apiout0/2019/0929/f90791fd781f571537bba5434643ee36-2251799824474533.jpg"
//        },
//            "pore":{
//            "count":8,
//                    "level":"lightly",
//                    "score":"98",
//                    "area":0.13682246208190918,
//                    "filename":"prd-apiout0/2019/0929/c9f5de1d7c0eeb654715506fdd742bd1-2251799824474534.jpg"
//        },
//            "skin_type":{
//            "score":67,
//                    "category":[
//            {
//                "cls":"forehead",
//                    "type":"oil",
//                    "level":"lightly",
//                    "score":67
//            },
//            {
//                "cls":"nose",
//                    "type":"oil",
//                    "level":"lightly",
//                    "score":67
//            },
//            {
//                "cls":"left_cheek",
//                    "type":"oil",
//                    "level":"lightly",
//                    "score":67
//            },
//            {
//                "cls":"right_cheek",
//                    "type":"oil",
//                    "level":"lightly",
//                    "score":67
//            },
//            {
//                "cls":"chin",
//                    "type":"oil",
//                    "level":"lightly",
//                    "score":67
//            }
//        ],
//            "type":"oil"
//        },
//            "face_box":{
//            "x0":114,
//                    "y0":256,
//                    "x1":893,
//                    "y1":1354
//        },
//            "id":"d438618c0522681f4ed22ec1fdb962e1"
//        }

        // 黑眼圈 {"code":0,"error_detect_types":0,"filename":"prd-api0\/2019\/0929\/3768955b6e1b1763fb6da8a16de93a74-2251799824475472.jpg","detect_types":"131072","dark_circle":{"type":"XGX","level":"moderately","score":61,"filename":"prd-apiout0\/2019\/0929\/52b3a1d5c45d27423e8ea2a7a6c47d3e-2251799824475434.jpg"},"face_box":{"x0":114,"y0":256,"x1":893,"y1":1354},"id":"d6646f137fffe8ba813eca5fad6ef700"}
        // 水分  {"code":0,"error_detect_types":0,"filename":"prd-api0\/2019\/0929\/0869b6aea2e501a537e3d7bc40d235ff-2251799824475865.jpg","detect_types":"4096","moisture":{"filename":"prd-apiout0\/2019\/0929\/fee3c7c348a86bcdaae618920a22be3f-2251799824475867.jpg","result":"0.155","score":"75","class":[{"result":0.511,"class":"left_cheek"},{"result":0.083,"class":"right_cheek"},{"result":0,"class":"forehead"},{"result":0,"class":"chin"}]},"face_box":{"x0":114,"y0":256,"x1":893,"y1":1354},"id":"9f7a5e92f4c63e1f52c357bcfadedb9e"}
        // 痘痘 {"code":0,"error_detect_types":0,"filename":"prd-api0\/2019\/0930\/dcb4f9429d71c9bf9ebe1bd41dcfb4c5-2251799824523273.jpg","detect_types":"65536","pockmark":{"category":[{"cls":"CC_DD","count":0,"score":100},{"cls":"CC_DY","count":0,"score":100}],"count":0,"score":100,"filename":"prd-apiout0\/2019\/0930\/6469642f2d07d2cb81ff11415e92c6eb-2251799824523274.jpg"},"face_box":{"x0":114,"y0":256,"x1":893,"y1":1354},"id":"756bd7ea27daa731cb8b5a489d27bceb"}
        // 黑头 {"code":0,"error_detect_types":0,"filename":"prd-api0\/2019\/0930\/1377a2c0539ee70c3771af5e2bd29876-2251799824523915.jpg","detect_types":"32768","blackhead":{"count":1,"level":"lightly","score":"99","area":0.0204304251819849,"filename":"prd-apiout0\/2019\/0930\/cf8f54d8e68bfa9c9a3e20f0ac718bc9-2251799824523916.jpg"},"face_box":{"x0":114,"y0":256,"x1":893,"y1":1354},"id":"779f4c8da495cb45eab1517bf9523da3"}
        // 毛孔 {"code":0,"error_detect_types":0,"filename":"prd-api0\/2019\/0930\/9ee8df0b623f566ae7f76e9f6e5dbeaa-2251799824524849.jpg","detect_types":"4","pore":{"count":8,"level":"lightly","score":"98","area":0.13682246208190918,"filename":"prd-apiout0\/2019\/0930\/f11ec11352d42eebe383f3252d6c8295-2251799824524877.jpg"},"face_box":{"x0":114,"y0":256,"x1":893,"y1":1354},"id":"1f60b9c03f803954eb00b419d11b2957"}
        // 肤色 {"code":0,"error_detect_types":0,"filename":"prd-api0\/2019\/0930\/576db601ea8e9ef78b9d1131776ed8bd-2251799824525141.jpg","detect_types":"256","color":{"result":"ziran"},"face_box":{"x0":114,"y0":256,"x1":893,"y1":1354},"id":"c791bb70d6879ed708736670f6dccc6c"}

    }

}
