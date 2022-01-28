package Data;

import utils.implemetclass.MySimpleMap;
import utils.inteface.MyMap;

import java.io.*;

/**
 * @author KangZhaoXin
 * @Date 2021/12/16 16:03
 */
public class DataBase {
    public static final MyMap<Integer,String[]> myMap = new MySimpleMap<>();

    public static String talkingInfo = "";

    public static void readData(){
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("./Data/user.txt"));
            while(br.ready()){
                String string = br.readLine();
                String[] strings = string.split("-");
                int id = Integer.parseInt(strings[0]);
                String password = strings[1];
                String name = strings[2];
                String[] value = new String[]{password,name};
                myMap.put(id,value);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br = new BufferedReader(new FileReader("./Data/talkingInfo.txt"));
            StringBuilder sb = new StringBuilder();
            while(br.ready()){
                String string = br.readLine();
                sb.append(string).append("\n");
            }
            talkingInfo = sb.toString();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToTalkingInfo(String string){
        try{
            PrintWriter pw = new PrintWriter(new FileWriter("./Data/talkingInfo.txt"));
            pw.println(string);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
