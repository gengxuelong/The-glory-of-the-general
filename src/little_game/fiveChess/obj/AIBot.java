package little_game.fiveChess.obj;


import little_game.fiveChess.page.MyFrame;
import little_game.fiveChess.utils.util;
import utils.MyPoint;

import java.util.Random;

/**
 * @author: WenRui
 * @Date:2021/12/15 
 */
public class AIBot {
    private MyFrame myFrame;
    private Random random = new Random();

    public AIBot(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    private void chessInRandom(){
        int x = random.nextInt(15);
        int y = random.nextInt(15);

        MyPoint gridPoint = new MyPoint(x,y);
        if(util.isEmpty(gridPoint)){
            LuoQiDian luoQiDian = myFrame.luoQiDians[y][x];
            luoQiDian.setKind(2);
        }else{
            chessInRandom();
        }
    }

    public void chessInCount(){
        int index = 0;
        LuoQiDian[][] luoQiDians = myFrame.luoQiDians;
        LuoQiDian[] luoQiDians1 = new LuoQiDian[225];
        for(int i = 0;i<15;i++){
            for(int j= 0;j<15;j++){
                luoQiDians1[index++] = luoQiDians[i][j];
            }
        }
        sort(luoQiDians1);
        if(luoQiDians1[0].count == 0){
            chessInRandom();
            return;
        }
        MyPoint gridPoint = luoQiDians1[0].gridMyPoint;
        if(util.isEmpty(gridPoint)){
            LuoQiDian luoQiDian = myFrame.luoQiDians[gridPoint.y][gridPoint.x];
            luoQiDian.setKind(2);
        }
    }

    public void calculateTheCount() {
        LuoQiDian[][] luoQiDians = myFrame.luoQiDians;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                LuoQiDian l = luoQiDians[i][j];
                if (l.getKind()!=0) {
                    l.count = -10;
                }else{
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            doComplex(l);
                        }
                    }).start();
                }
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(luoQiDians[i][j].count+"\t\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();


    }



    private void doComplex(LuoQiDian l) {
        int x = l.gridMyPoint.x;
        int y = l.gridMyPoint.y;
        LuoQiDian[][] luoQiDians = myFrame.luoQiDians;

                /*
        判五子，当步可绝杀
         */
        {
            //x方向
            if (x < 11 && luoQiDians[y][x + 1].getKind() == 2 && luoQiDians[y][x + 2].getKind() == 2 && luoQiDians[y][x + 3].getKind() == 2 && luoQiDians[y][x + 4].getKind() == 2) {
                l.count = 2430;
                return;
            }
            if (x >= 4 && luoQiDians[y][x - 1].getKind() == 2 && luoQiDians[y][x - 2].getKind() == 2 && luoQiDians[y][x - 3].getKind() == 2&& luoQiDians[y][x - 4].getKind() == 2) {
                l.count = 2420;
                return;
            }
            if (x >= 1 && x < 12 && (luoQiDians[y][x - 1].getKind() == 2 && luoQiDians[y][x + 1].getKind() == 2&& luoQiDians[y][x + 2].getKind() == 2&& luoQiDians[y][x + 3].getKind() == 2)) {
                l.count = 2410;
                return;
            }
            if (x >= 2 && x < 13 && (luoQiDians[y][x - 1].getKind() == 2 && luoQiDians[y][x - 2].getKind() == 2&& luoQiDians[y][x + 1].getKind() == 2&& luoQiDians[y][x + 2].getKind() == 2)) {
                l.count = 2410;
                return;
            }
            if (x >= 3 && x < 14 && (luoQiDians[y][x - 1].getKind() == 2 && luoQiDians[y][x - 2].getKind() == 2&& luoQiDians[y][x - 3].getKind() == 2&& luoQiDians[y][x + 1].getKind() == 2)) {
                l.count = 2410;
                return;
            }



            if (x < 11 && luoQiDians[y][x + 1].getKind() == 1 && luoQiDians[y][x + 2].getKind() == 1 && luoQiDians[y][x + 3].getKind() == 1 && luoQiDians[y][x + 4].getKind() == 1) {
                l.count = 1430;
                return;
            }
            if (x >= 4 && luoQiDians[y][x - 1].getKind() == 1 && luoQiDians[y][x - 2].getKind() == 1 && luoQiDians[y][x - 3].getKind() == 1&& luoQiDians[y][x - 4].getKind() == 1) {
                l.count = 1420;
                return;
            }
            if (x >= 1 && x < 12 && (luoQiDians[y][x - 1].getKind() == 1 && luoQiDians[y][x + 1].getKind() == 1&& luoQiDians[y][x + 2].getKind() == 1&& luoQiDians[y][x + 3].getKind() == 1)) {
                l.count = 1410;
                return;
            }
            if (x >= 2 && x < 13 && (luoQiDians[y][x - 1].getKind() == 1 && luoQiDians[y][x - 2].getKind() == 1&& luoQiDians[y][x + 1].getKind() == 1&& luoQiDians[y][x + 2].getKind() == 1)) {
                l.count = 1410;
                return;
            }
            if (x >= 3 && x < 14 && (luoQiDians[y][x - 1].getKind() == 1 && luoQiDians[y][x - 2].getKind() == 1&& luoQiDians[y][x - 3].getKind() == 1&& luoQiDians[y][x + 1].getKind() == 1)) {
                l.count = 1410;
                return;
            }

            //Y方向
            if (y < 11 && luoQiDians[y+1][x].getKind() == 2 && luoQiDians[y+2][x].getKind() == 2 && luoQiDians[y+3][x].getKind() == 2 && luoQiDians[y+4][x].getKind() == 2) {
                l.count = 2430;
                return;
            }
            if (y >= 4 && luoQiDians[y-1][x].getKind() == 2 && luoQiDians[y-2][x].getKind() == 2 && luoQiDians[y-3][x].getKind() == 2&& luoQiDians[y-4][x].getKind() == 2) {
                l.count = 2420;
                return;
            }
            if (y >= 1 && y < 12 && (luoQiDians[y-1][x].getKind() == 2 && luoQiDians[y+1][x].getKind() == 2&& luoQiDians[y+2][x].getKind() == 2&& luoQiDians[y+3][x].getKind() == 2)) {
                l.count = 2410;
                return;
            }
            if (y >= 2 && y < 13 && (luoQiDians[y-1][x].getKind() == 2 && luoQiDians[y-2][x].getKind() == 2&& luoQiDians[y+1][x].getKind() == 2&& luoQiDians[y+2][x].getKind() == 2)) {
                l.count = 2410;
                return;
            }
            if (y >= 3 && y < 14 && (luoQiDians[y-1][x].getKind() == 2 && luoQiDians[y-2][x].getKind() == 2&& luoQiDians[y-3][x].getKind() == 2&& luoQiDians[y+1][x].getKind() == 2)) {
                l.count = 2410;
                return;
            }



            if (y < 11 && luoQiDians[y+1][x].getKind() == 1 && luoQiDians[y+2][x].getKind() == 1 && luoQiDians[y+3][x].getKind() == 1 && luoQiDians[y+4][x].getKind() == 1) {
                l.count = 1430;
                return;
            }
            if (y >= 4 && luoQiDians[y-1][x].getKind() == 1 && luoQiDians[y-2][x].getKind() == 1 && luoQiDians[y-3][x].getKind() == 1&& luoQiDians[y-4][x].getKind() == 1) {
                l.count = 1420;
                return;
            }
            if (y >= 1 && y < 12 && (luoQiDians[y-1][x].getKind() == 1 && luoQiDians[y+1][x].getKind() == 1&& luoQiDians[y+2][x].getKind() == 1&& luoQiDians[y+3][x].getKind() == 1)) {
                l.count = 1410;
                return;
            }
            if (y >= 2 && y < 13 && (luoQiDians[y-1][x].getKind() == 1 && luoQiDians[y-2][x].getKind() == 1&& luoQiDians[y+1][x].getKind() == 1&& luoQiDians[y+2][x].getKind() == 1)) {
                l.count = 1410;
                return;
            }
            if (y >= 3 && y < 14 && (luoQiDians[y-1][x].getKind() == 1 && luoQiDians[y-2][x].getKind() == 1&& luoQiDians[y-3][x].getKind() == 1&& luoQiDians[y+1][x].getKind() == 1)) {
                l.count = 1410;
                return;
            }

            //向下方向
            if (y < 11 &&x < 11 && luoQiDians[y+1][x + 1].getKind() == 2 && luoQiDians[y+2][x + 2].getKind() == 2 && luoQiDians[y+3][x + 3].getKind() == 2 && luoQiDians[y+4][x + 4].getKind() == 2) {
                l.count = 2430;
                return;
            }
            if (y >= 4 && x >= 4 && luoQiDians[y-1][x - 1].getKind() == 2 && luoQiDians[y-2][x - 2].getKind() == 2 && luoQiDians[y-3][x - 3].getKind() == 2&& luoQiDians[y-4][x - 4].getKind() == 2) {
                l.count = 2420;
                return;
            }
            if (y >= 1 && y < 12 && x >= 1 && x < 12 && (luoQiDians[y-1][x - 1].getKind() == 2 && luoQiDians[y+1][x + 1].getKind() == 2&& luoQiDians[y+2][x + 2].getKind() == 2&& luoQiDians[y+3][x + 3].getKind() == 2)) {
                l.count = 2410;
                return;
            }
            if (y >= 2 && y < 13 &&x >= 2 && x < 13 && (luoQiDians[y-1][x - 1].getKind() == 2 && luoQiDians[y-2][x - 2].getKind() == 2&& luoQiDians[y+1][x + 1].getKind() == 2&& luoQiDians[y+2][x + 2].getKind() == 2)) {
                l.count = 2410;
                return;
            }
            if (y >= 3 && y < 14 && x >= 3 && x < 14 && (luoQiDians[y-1][x - 1].getKind() == 2 && luoQiDians[y-2][x - 2].getKind() == 2&& luoQiDians[y-3][x - 3].getKind() == 2&& luoQiDians[y+1][x + 1].getKind() == 2)) {
                l.count = 2410;
                return;
            }
            ////
            if (y < 11 &&x < 11 && luoQiDians[y+1][x + 1].getKind() == 1 && luoQiDians[y+2][x + 2].getKind() == 1 && luoQiDians[y+3][x + 3].getKind() == 1 && luoQiDians[y+4][x + 4].getKind() == 1) {
                l.count = 1430;
                return;
            }
            if (y >= 4 && x >= 4 && luoQiDians[y-1][x - 1].getKind() == 1 && luoQiDians[y-2][x - 2].getKind() == 1 && luoQiDians[y-3][x - 3].getKind() == 1&& luoQiDians[y-4][x - 4].getKind() == 1) {
                l.count = 1420;
                return;
            }
            if (y >= 1 && y < 12 &&x >= 1 && x < 12 && (luoQiDians[y-1][x - 1].getKind() == 1 && luoQiDians[y+1][x + 1].getKind() == 1&& luoQiDians[y+2][x + 2].getKind() == 1&& luoQiDians[y+3][x + 3].getKind() == 1)) {
                l.count = 1410;
                return;
            }
            if (y >= 2 && y < 13 &&x >= 2 && x < 13 && (luoQiDians[y-1][x - 1].getKind() == 1 && luoQiDians[y-2][x - 2].getKind() == 1&& luoQiDians[y+1][x + 1].getKind() == 1&& luoQiDians[y+2][x + 2].getKind() == 1)) {
                l.count = 1410;
                return;
            }
            if (y >= 3 && y < 14 &&x >= 3 && x < 14 && (luoQiDians[y-1][x - 1].getKind() == 1 && luoQiDians[y-2][x - 2].getKind() == 1&& luoQiDians[y-3][x - 3].getKind() == 1&& luoQiDians[y+1][x + 1].getKind() == 1)) {
                l.count = 1410;
                return;
            }



            //向上方向
            if (y >=4 &&x < 11 && luoQiDians[y-1][x + 1].getKind() == 2 && luoQiDians[y-2][x + 2].getKind() == 2 && luoQiDians[y-3][x + 3].getKind() == 2 && luoQiDians[y-4][x + 4].getKind() == 2) {
                l.count = 2430;
                return;
            }
            if (y <11 &&x >= 4 && luoQiDians[y+1][x - 1].getKind() == 2 && luoQiDians[y+2][x - 2].getKind() == 2 && luoQiDians[y+3][x - 3].getKind() == 2&& luoQiDians[y+4][x - 4].getKind() == 2) {
                l.count = 2420;
                return;
            }
            if (y >= 3 && y < 14 &&x >= 1 && x < 12 && (luoQiDians[y+1][x - 1].getKind() == 2 && luoQiDians[y-1][x + 1].getKind() == 2&& luoQiDians[y-2][x + 2].getKind() == 2&& luoQiDians[y-3][x + 3].getKind() == 2)) {
                l.count = 2410;
                return;
            }
            if (y >= 2 && y < 13 &&x >= 2 && x < 13 && (luoQiDians[y+1][x - 1].getKind() == 2 && luoQiDians[y+2][x - 2].getKind() == 2&& luoQiDians[y-1][x + 1].getKind() == 2&& luoQiDians[y-2][x + 2].getKind() == 2)) {
                l.count = 2410;
                return;
            }
            if (y >= 1 && y < 12 && x >= 3 && x < 14 && (luoQiDians[y+1][x - 1].getKind() == 2 && luoQiDians[y+2][x - 2].getKind() == 2&& luoQiDians[y+3][x - 3].getKind() == 2&& luoQiDians[y-1][x + 1].getKind() == 2)) {
                l.count = 2410;
                return;
            }



            if (y >=4 &&x < 11 && luoQiDians[y-1][x + 1].getKind() == 1 && luoQiDians[y-2][x + 2].getKind() == 1 && luoQiDians[y-3][x + 3].getKind() == 1 && luoQiDians[y-4][x + 4].getKind() == 1) {
                l.count = 1430;
                return;
            }
            if (y <11 &&x >= 4 && luoQiDians[y+1][x - 1].getKind() == 1 && luoQiDians[y+2][x - 2].getKind() == 1 && luoQiDians[y+3][x - 3].getKind() == 1&& luoQiDians[y+4][x - 4].getKind() == 1) {
                l.count = 1420;
                return;
            }
            if (y >= 3 && y < 14 &&x >= 1 && x < 12 && (luoQiDians[y+1][x - 1].getKind() == 1 && luoQiDians[y-1][x + 1].getKind() == 1&& luoQiDians[y-2][x + 2].getKind() == 1&& luoQiDians[y-3][x + 3].getKind() == 1)) {
                l.count = 1410;
                return;
            }
            if (y >= 2 && y < 13 &&x >= 2 && x < 13 && (luoQiDians[y+1][x - 1].getKind() == 1 && luoQiDians[y+2][x - 2].getKind() == 1&& luoQiDians[y-1][x + 1].getKind() == 1&& luoQiDians[y-2][x + 2].getKind() == 1)) {
                l.count = 1410;
                return;
            }
            if (y >= 1 && y < 12 && x >= 3 && x < 14 && (luoQiDians[y+1][x - 1].getKind() == 1 && luoQiDians[y+2][x - 2].getKind() == 1&& luoQiDians[y+3][x - 3].getKind() == 1&& luoQiDians[y-1][x + 1].getKind() == 1)) {
                l.count = 1410;
                return;
            }


        }





        /*
        判断四子
         */
        {
            //x方向,带气泡,下步可绝杀
            if(x>=1&&x<11&&(luoQiDians[y][x - 1].getKind() == 0 && luoQiDians[y][x + 1].getKind() == 2 && luoQiDians[y][x + 2].getKind() == 2 && luoQiDians[y][x + 3].getKind() == 2 && luoQiDians[y][x + 4].getKind() == 0)){
                l.count = 1100;
            }
            if (x >= 2 && x < 12 && ( luoQiDians[y][x - 2].getKind() == 0&&luoQiDians[y][x - 1].getKind() == 2 && luoQiDians[y][x + 1].getKind() == 2&& luoQiDians[y][x + 2].getKind() == 2&& luoQiDians[y][x + 3].getKind() == 0)) {
                l.count = 1100;
                return;
            }
            if (x >= 3 && x < 13 && (luoQiDians[y][x - 1].getKind() == 2 && luoQiDians[y][x - 2].getKind() == 2&& luoQiDians[y][x - 3].getKind() == 0&& luoQiDians[y][x + 1].getKind() == 2&& luoQiDians[y][x + 2].getKind() == 0)) {
                l.count = 1100;
                return;
            }
            if (x >= 4 && x < 14 && (luoQiDians[y][x - 1].getKind() == 2 && luoQiDians[y][x - 2].getKind() == 2&& luoQiDians[y][x - 3].getKind() == 2 &&luoQiDians[y][x - 4].getKind() == 0&& luoQiDians[y][x + 1].getKind() == 0)) {
                l.count = 1100;
                return;
            }
            ////对敌
            if(x>=1&&x<11&&(luoQiDians[y][x - 1].getKind() == 0 && luoQiDians[y][x + 1].getKind() == 1 && luoQiDians[y][x + 2].getKind() == 1 && luoQiDians[y][x + 3].getKind() == 1 && luoQiDians[y][x + 4].getKind() == 0)){
                l.count = 1000;
            }
            if (x >= 2 && x < 12 && ( luoQiDians[y][x - 2].getKind() == 0&&luoQiDians[y][x - 1].getKind() == 1 && luoQiDians[y][x + 1].getKind() == 1&& luoQiDians[y][x + 2].getKind() == 1&& luoQiDians[y][x + 3].getKind() == 0)) {
                l.count = 1000;
                return;
            }
            if (x >= 3 && x < 13 && (luoQiDians[y][x - 3].getKind() == 0&&luoQiDians[y][x - 2].getKind() == 1 && luoQiDians[y][x - 1].getKind() == 1&& luoQiDians[y][x + 1].getKind() == 1&& luoQiDians[y][x + 2].getKind() == 0)) {
                l.count = 1000;
                return;
            }
            if (x >= 4 && x < 14 && ( luoQiDians[y][x - 4].getKind() == 0&&luoQiDians[y][x - 1].getKind() == 1 && luoQiDians[y][x - 2].getKind() == 1&& luoQiDians[y][x - 3].getKind() == 1 && luoQiDians[y][x + 1].getKind() == 0)) {
                l.count = 1000;
                return;
            }


            //Y方向带气泡
            if (y>=1&&y < 11  && luoQiDians[y-1][x].getKind() == 0&&luoQiDians[y+1][x].getKind() == 2 && luoQiDians[y+2][x].getKind() == 2 && luoQiDians[y+3][x].getKind() == 2 && luoQiDians[y+4][x].getKind() ==0) {
                l.count = 1100;
                return;
            }
            if (y >= 2 && y < 12 && (luoQiDians[y-2][x].getKind() == 0 &&luoQiDians[y-1][x].getKind() == 2 && luoQiDians[y+1][x].getKind() == 2&& luoQiDians[y+2][x].getKind() == 2&& luoQiDians[y+3][x].getKind() == 0)) {
                l.count = 1100;
                return;
            }
            if (y >= 3 && y < 13 && (luoQiDians[y-3][x].getKind() == 0 &&luoQiDians[y-1][x].getKind() == 2 && luoQiDians[y-2][x].getKind() == 2&& luoQiDians[y+1][x].getKind() == 2&& luoQiDians[y+2][x].getKind() == 0)) {
                l.count = 1100;
                return;
            }
            if (y >= 4 && y < 14 && (luoQiDians[y-4][x].getKind() ==0 &&luoQiDians[y-1][x].getKind() == 2 && luoQiDians[y-2][x].getKind() == 2&& luoQiDians[y-3][x].getKind() == 2&& luoQiDians[y+1][x].getKind() == 0)) {
                l.count = 1100;
                return;
            }
            ////对敌
            if (y>=1&&y < 11  && luoQiDians[y-1][x].getKind() == 0&&luoQiDians[y+1][x].getKind() == 1 && luoQiDians[y+2][x].getKind() == 1 && luoQiDians[y+3][x].getKind() == 1 && luoQiDians[y+4][x].getKind() ==0) {
                l.count = 1000;
                return;
            }
            if (y >= 2 && y < 12 && (luoQiDians[y-2][x].getKind() == 0 &&luoQiDians[y-1][x].getKind() == 1 && luoQiDians[y+1][x].getKind() == 1&& luoQiDians[y+2][x].getKind() == 1&& luoQiDians[y+3][x].getKind() == 0)) {
                l.count = 1000;
                return;
            }
            if (y >= 3 && y < 13 && (luoQiDians[y-3][x].getKind() == 0 &&luoQiDians[y-1][x].getKind() == 1 && luoQiDians[y-2][x].getKind() == 1&& luoQiDians[y+1][x].getKind() == 1&& luoQiDians[y+2][x].getKind() == 0)) {
                l.count = 1000;
                return;
            }
            if (y >= 4 && y < 14 && (luoQiDians[y-4][x].getKind() ==0 &&luoQiDians[y-1][x].getKind() == 1 && luoQiDians[y-2][x].getKind() == 1&& luoQiDians[y-3][x].getKind() == 1&& luoQiDians[y+1][x].getKind() == 0)) {
                l.count = 1000;
                return;
            }


            //向下方向带气泡
            if (y>=1&&x>=1&&y < 11 &&x < 11 && luoQiDians[y-1][x - 1].getKind() == 0 &&luoQiDians[y+1][x + 1].getKind() == 2 && luoQiDians[y+2][x + 2].getKind() == 2 && luoQiDians[y+3][x + 3].getKind() == 2 && luoQiDians[y+4][x + 4].getKind() ==0) {
                l.count = 1100;
                return;
            }
            if (y >= 2 && y < 12 && x >= 2 && x < 12 && (luoQiDians[y-2][x - 2].getKind() == 0 &&luoQiDians[y-1][x - 1].getKind() == 2 && luoQiDians[y+1][x + 1].getKind() == 2&& luoQiDians[y+2][x + 2].getKind() == 2&& luoQiDians[y+3][x + 3].getKind() == 0)) {
                l.count = 1100;
                return;
            }
            if (y >= 3 && y < 13 &&x >= 3 && x < 13 && (luoQiDians[y-3][x - 3].getKind() == 0 &&luoQiDians[y-1][x - 1].getKind() == 2 && luoQiDians[y-2][x - 2].getKind() == 2&& luoQiDians[y+1][x + 1].getKind() == 2&& luoQiDians[y+2][x + 2].getKind() == 0)) {
                l.count = 1100;
                return;
            }
            if (y >= 4 && y < 14 && x >= 4 && x < 14 && (luoQiDians[y-4][x - 4].getKind() == 0 &&luoQiDians[y-1][x - 1].getKind() == 2 && luoQiDians[y-2][x - 2].getKind() == 2&& luoQiDians[y-3][x - 3].getKind() == 2&& luoQiDians[y+1][x + 1].getKind() == 0)) {
                l.count = 1100;
                return;
            }
            ////对敌
            if (y>=1&&x>=1&&y < 11 &&x < 11 && luoQiDians[y-1][x - 1].getKind() == 0 &&luoQiDians[y+1][x + 1].getKind() == 1 && luoQiDians[y+2][x + 2].getKind() == 1 && luoQiDians[y+3][x + 3].getKind() == 1 && luoQiDians[y+4][x + 4].getKind() ==0) {
                l.count = 1000;
                return;
            }
            if (y >= 2 && y < 12 && x >= 2 && x < 12 && (luoQiDians[y-2][x - 2].getKind() == 0 &&luoQiDians[y-1][x - 1].getKind() == 1 && luoQiDians[y+1][x + 1].getKind() == 1&& luoQiDians[y+2][x + 2].getKind() == 1&& luoQiDians[y+3][x + 3].getKind() == 0)) {
                l.count = 1000;
                return;
            }
            if (y >= 3 && y < 13 &&x >= 3 && x < 13 && (luoQiDians[y-3][x - 3].getKind() == 0 &&luoQiDians[y-1][x - 1].getKind() == 1 && luoQiDians[y-2][x - 2].getKind() == 1&& luoQiDians[y+1][x + 1].getKind() == 1&& luoQiDians[y+2][x + 2].getKind() == 0)) {
                l.count = 1000;
                return;
            }
            if (y >= 4 && y < 14 && x >= 4 && x < 14 && (luoQiDians[y-4][x - 4].getKind() == 0 &&luoQiDians[y-1][x - 1].getKind() == 1 && luoQiDians[y-2][x - 2].getKind() == 1&& luoQiDians[y-3][x - 3].getKind() == 1&& luoQiDians[y+1][x + 1].getKind() == 0)) {
                l.count = 1000;
                return;
            }

            //向上方向有气泡
            if (y >=4&& y<14&&x < 11&&x>=1 && luoQiDians[y+1][x - 1].getKind() == 0 && luoQiDians[y-1][x + 1].getKind() == 2 && luoQiDians[y-2][x + 2].getKind() == 2 && luoQiDians[y-3][x + 3].getKind() == 2 && luoQiDians[y-4][x + 4].getKind() == 0) {
                l.count = 1100;
                return;
            }
            if (y >= 3 && y < 13 &&x >= 2 && x < 12 && (luoQiDians[y+2][x - 2].getKind() == 2 &&luoQiDians[y+1][x - 1].getKind() == 2 && luoQiDians[y-1][x + 1].getKind() == 2&& luoQiDians[y-2][x + 2].getKind() == 2&& luoQiDians[y-3][x + 3].getKind() == 0)) {
                l.count = 1100;
                return;
            }
            if (y >= 2 && y < 12 &&x >= 3 && x < 13 && (luoQiDians[y+3][x - 3].getKind() == 2 &&luoQiDians[y+1][x - 1].getKind() == 2 && luoQiDians[y+2][x - 2].getKind() == 2&& luoQiDians[y-1][x + 1].getKind() == 2&& luoQiDians[y-2][x + 2].getKind() == 0)) {
                l.count = 1100;
                return;
            }
            if (y >= 1 && y < 11 && x >= 4 && x < 14 && (luoQiDians[y+4][x - 4].getKind() == 2 &&luoQiDians[y+1][x - 1].getKind() == 2 && luoQiDians[y+2][x - 2].getKind() == 2&& luoQiDians[y+3][x - 3].getKind() == 2&& luoQiDians[y-1][x + 1].getKind() ==0)) {
                l.count = 1100;
                return;
            }
            ////对敌
            if (y >=4&& y<14&&x < 11&&x>=1 && luoQiDians[y+1][x - 1].getKind() == 0 && luoQiDians[y-1][x + 1].getKind() == 1 && luoQiDians[y-2][x + 2].getKind() == 1 && luoQiDians[y-3][x + 3].getKind() == 1 && luoQiDians[y-4][x + 4].getKind() == 0) {
                l.count = 1000;
                return;
            }
            if (y >= 3 && y < 13 &&x >= 2 && x < 12 && (luoQiDians[y+2][x - 2].getKind() == 0 &&luoQiDians[y+1][x - 1].getKind() == 1&& luoQiDians[y-1][x + 1].getKind() == 1&& luoQiDians[y-2][x + 2].getKind() == 1&& luoQiDians[y-3][x + 3].getKind() == 0)) {
                l.count = 1000;
                return;
            }
            if (y >= 2 && y < 12 &&x >= 3 && x < 13 && (luoQiDians[y+3][x - 3].getKind() == 0 &&luoQiDians[y+1][x - 1].getKind() == 1 && luoQiDians[y+2][x - 2].getKind() == 1&& luoQiDians[y-1][x + 1].getKind() == 1&& luoQiDians[y-2][x + 2].getKind() == 0)) {
                l.count = 1000;
                return;
            }
            if (y >= 1 && y < 11 && x >= 4 && x < 14 && (luoQiDians[y+4][x - 4].getKind() == 0 &&luoQiDians[y+1][x - 1].getKind() == 1 && luoQiDians[y+2][x - 2].getKind() == 1&& luoQiDians[y+3][x - 3].getKind() == 1&& luoQiDians[y-1][x + 1].getKind() ==0)) {
                l.count = 1000;
                return;
            }







             /*
        判断绝杀招数
         */
            if(x < 13 &&x >= 2 &&y < 13 &&y >= 2){
                boolean x_direction = luoQiDians[y][x + 1].getKind() == 2 && luoQiDians[y][x + 2].getKind() == 2|| luoQiDians[y][x - 1].getKind() == 2 && luoQiDians[y][x - 2].getKind() == 2;
                boolean y_direction = luoQiDians[y + 1][x].getKind() == 2 && luoQiDians[y + 2][x].getKind() == 2||luoQiDians[y - 1][x].getKind() == 2 && luoQiDians[y - 2][x].getKind() == 2;
                boolean down_direction = luoQiDians[y + 1][x + 1].getKind() == 2 && luoQiDians[y + 2][x + 2].getKind() == 2||luoQiDians[y - 1][x - 1].getKind() == 2 && luoQiDians[y - 2][x - 2].getKind() == 2;
                boolean up_direction = luoQiDians[y - 1][x + 1].getKind() == 2 && luoQiDians[y - 2][x + 2].getKind() == 2||luoQiDians[y + 1][x - 1].getKind() == 2 && luoQiDians[y + 2][x - 2].getKind() == 2;
                if(x_direction&&y_direction||x_direction&&up_direction||x_direction&&down_direction||y_direction&&up_direction||y_direction&&down_direction||up_direction&&down_direction){
                    l.count = 300;
                    return;
                }

                boolean x_direction1 = luoQiDians[y][x + 1].getKind() == 1 && luoQiDians[y][x + 2].getKind() == 1|| luoQiDians[y][x - 1].getKind() == 1 && luoQiDians[y][x - 2].getKind() == 1;
                boolean y_direction1 = luoQiDians[y + 1][x].getKind() == 1 && luoQiDians[y + 2][x].getKind() == 1||luoQiDians[y - 1][x].getKind() == 1 && luoQiDians[y - 2][x].getKind() == 1;
                boolean down_direction1 = luoQiDians[y + 1][x + 1].getKind() == 1 && luoQiDians[y + 2][x + 2].getKind() == 1||luoQiDians[y - 1][x - 1].getKind() == 1 && luoQiDians[y - 2][x - 2].getKind() == 1;
                boolean up_direction1 = luoQiDians[y - 1][x + 1].getKind() == 1 && luoQiDians[y - 2][x + 2].getKind() == 1||luoQiDians[y + 1][x - 1].getKind() == 1 && luoQiDians[y + 2][x - 2].getKind() == 1;
                if(x_direction1&&y_direction1||x_direction1&&up_direction1||x_direction1&&down_direction1||y_direction1&&up_direction1||y_direction1&&down_direction1||up_direction1&&down_direction1){
                    l.count = 270;
                    return;
                }

            }

            if(x < 14 &&x >= 1 &&y < 14 &&y >= 1){
                boolean x_direction = luoQiDians[y][x + 1].getKind() == 2 && luoQiDians[y][x-1].getKind() == 2;
                boolean y_direction = luoQiDians[y+1][x].getKind() == 2 && luoQiDians[y-1][x].getKind() == 2;
                boolean up_direction = luoQiDians[y+1][x + 1].getKind() == 2 && luoQiDians[y-1][x-1].getKind() == 2;
                boolean down_direction = luoQiDians[y-1][x + 1].getKind() == 2 && luoQiDians[y+1][x-1].getKind() == 2;
                if(x_direction&&y_direction||x_direction&&up_direction||x_direction&&down_direction||y_direction&&up_direction||y_direction&&down_direction||up_direction&&down_direction){
                    l.count = 300;
                    return;
                }

                boolean x_direction1 = luoQiDians[y][x + 1].getKind() == 1 && luoQiDians[y][x-1].getKind() == 1;
                boolean y_direction1 = luoQiDians[y+1][x].getKind() == 1 && luoQiDians[y-1][x].getKind() == 1;
                boolean up_direction1 = luoQiDians[y+1][x + 1].getKind() == 1 && luoQiDians[y-1][x-1].getKind() == 1;
                boolean down_direction1 = luoQiDians[y-1][x + 1].getKind() == 1 && luoQiDians[y+1][x-1].getKind() == 1;
                if(x_direction1&&y_direction1||x_direction1&&up_direction1||x_direction1&&down_direction1||y_direction1&&up_direction1||y_direction1&&down_direction1||up_direction1&&down_direction1){
                    l.count = 270;
                    return;
                }


            }




            /*
            判断四子，无气泡检验
             */

            //x 方向，有隔档，无气泡检验
            if (x < 12 && luoQiDians[y][x + 1].getKind() == 2 && luoQiDians[y][x + 2].getKind() == 2 && luoQiDians[y][x + 3].getKind() == 2 ) {
                l.count = 243;
                return;
            }
            if (x >= 3 && luoQiDians[y][x - 1].getKind() == 2 && luoQiDians[y][x - 2].getKind() == 2 && luoQiDians[y][x - 3].getKind() == 2) {
                l.count = 242;
                return;
            }
            if (x >= 1 && x < 13 && (luoQiDians[y][x - 1].getKind() == 2 && luoQiDians[y][x + 1].getKind() == 2&& luoQiDians[y][x + 2].getKind() == 2)) {
                l.count = 241;
                return;
            }
            if (x >= 2 && x < 14 && (luoQiDians[y][x - 1].getKind() == 2 && luoQiDians[y][x - 2].getKind() == 2&& luoQiDians[y][x + 1].getKind() == 2)) {
                l.count = 241;
                return;
            }
            if (x >= 3 && x < 15 && (luoQiDians[y][x - 1].getKind() == 2 && luoQiDians[y][x - 2].getKind() == 2&& luoQiDians[y][x - 3].getKind() == 2)) {
                l.count = 241;
                return;
            }
            /////
            if (x < 12 && luoQiDians[y][x + 1].getKind() == 1 && luoQiDians[y][x + 2].getKind() == 1 && luoQiDians[y][x + 3].getKind() == 1 ) {
                l.count = 143;
                return;
            }
            if (x >= 3 && luoQiDians[y][x - 1].getKind() == 1 && luoQiDians[y][x - 2].getKind() == 1 && luoQiDians[y][x - 3].getKind() == 1) {
                l.count = 142;
                return;
            }
            if (x >= 1 && x < 13 && (luoQiDians[y][x - 1].getKind() == 1 && luoQiDians[y][x + 1].getKind() == 1&& luoQiDians[y][x + 2].getKind() == 1)) {
                l.count = 141;
                return;
            }
            if (x >= 2 && x < 14 && (luoQiDians[y][x - 1].getKind() == 1 && luoQiDians[y][x - 2].getKind() == 1&& luoQiDians[y][x + 1].getKind() == 1)) {
                l.count = 141;
                return;
            }
            if (x >= 3 && x < 15 && (luoQiDians[y][x - 1].getKind() == 1 && luoQiDians[y][x - 2].getKind() == 1&& luoQiDians[y][x - 3].getKind() == 1)) {
                l.count = 141;
                return;
            }




            //Y方向无气泡检验
            if (y < 12 && luoQiDians[y+1][x].getKind() == 2 && luoQiDians[y+2][x].getKind() == 2 && luoQiDians[y+3][x].getKind() == 2 ) {
                l.count = 243;
                return;
            }
            if (y >= 3 && luoQiDians[y-1][x].getKind() == 2 && luoQiDians[y-2][x].getKind() == 2 && luoQiDians[y-3][x].getKind() == 2) {
                l.count = 242;
                return;
            }
            if (y >= 1 && y < 13 && (luoQiDians[y-1][x].getKind() == 2 && luoQiDians[y+1][x].getKind() == 2&& luoQiDians[y+2][x].getKind() == 2)) {
                l.count = 241;
                return;
            }
            if (y >= 2 && y < 14 && (luoQiDians[y-1][x].getKind() == 2 && luoQiDians[y-2][x].getKind() == 2&& luoQiDians[y+1][x].getKind() == 2)) {
                l.count = 241;
                return;
            }
            if (y >= 3 && y < 15 && (luoQiDians[y-1][x].getKind() == 2 && luoQiDians[y-2][x].getKind() == 2&& luoQiDians[y-3][x].getKind() == 2)) {
                l.count = 241;
                return;
            }
            ////
            if (y < 12 && luoQiDians[y+1][x].getKind() == 1 && luoQiDians[y+2][x].getKind() == 1 && luoQiDians[y+3][x].getKind() == 1 ) {
                l.count = 143;
                return;
            }
            if (y >= 3 && luoQiDians[y-1][x].getKind() == 1 && luoQiDians[y-2][x].getKind() == 1 && luoQiDians[y-3][x].getKind() == 1) {
                l.count = 142;
                return;
            }
            if (y >= 1 && y < 13 && (luoQiDians[y-1][x].getKind() == 1 && luoQiDians[y+1][x].getKind() == 1&& luoQiDians[y+2][x].getKind() == 1)) {
                l.count = 141;
                return;
            }
            if (y >= 2 && y < 14 && (luoQiDians[y-1][x].getKind() == 1 && luoQiDians[y-2][x].getKind() == 1&& luoQiDians[y+1][x].getKind() == 1)) {
                l.count = 141;
                return;
            }
            if (y >= 3 && y < 15 && (luoQiDians[y-1][x].getKind() == 1 && luoQiDians[y-2][x].getKind() == 1&& luoQiDians[y-3][x].getKind() == 1&& luoQiDians[y+1][x].getKind() == 1)) {
                l.count = 141;
                return;
            }




            //向下方向无气泡检验
            if (y < 12 &&x < 12 && luoQiDians[y+1][x + 1].getKind() == 2 && luoQiDians[y+2][x + 2].getKind() == 2 && luoQiDians[y+3][x + 3].getKind() == 2 ) {
                l.count = 243;
                return;
            }
            if (y >= 3 && x >= 3 && luoQiDians[y-1][x - 1].getKind() == 2 && luoQiDians[y-2][x - 2].getKind() == 2 && luoQiDians[y-3][x - 3].getKind() == 2) {
                l.count = 242;
                return;
            }
            if (y >= 1 && y < 13&& x >= 1 && x < 13 && (luoQiDians[y-1][x - 1].getKind() == 2 && luoQiDians[y+1][x + 1].getKind() == 2&& luoQiDians[y+2][x + 2].getKind() == 2)) {
                l.count = 241;
                return;
            }
            if (y >= 2 && y < 14 &&x >= 2 && x < 14 && (luoQiDians[y-1][x - 1].getKind() == 2 && luoQiDians[y-2][x - 2].getKind() == 2&& luoQiDians[y+1][x + 1].getKind() == 2)) {
                l.count = 241;
                return;
            }
            if (y >= 3 && y < 15 && x >= 3 && x < 15 && (luoQiDians[y-1][x - 1].getKind() == 2 && luoQiDians[y-2][x - 2].getKind() == 2&& luoQiDians[y-3][x - 3].getKind() == 2)) {
                l.count = 241;
                return;
            }
            ////
            if (y < 12 &&x < 12 && luoQiDians[y+1][x + 1].getKind() == 1 && luoQiDians[y+2][x + 2].getKind() == 1 && luoQiDians[y+3][x + 3].getKind() == 1 ) {
                l.count = 143;
                return;
            }
            if (y >= 3 && x >= 3 && luoQiDians[y-1][x - 1].getKind() == 1 && luoQiDians[y-2][x - 2].getKind() == 1 && luoQiDians[y-3][x - 3].getKind() == 1) {
                l.count = 142;
                return;
            }
            if (y >= 1 && y < 13 &&x >= 1 && x < 13 && (luoQiDians[y-1][x - 1].getKind() == 1 && luoQiDians[y+1][x + 1].getKind() == 1&& luoQiDians[y+2][x + 2].getKind() == 1)) {
                l.count = 141;
                return;
            }
            if (y >= 2 && y < 14 &&x >= 2 && x < 14 && (luoQiDians[y-1][x - 1].getKind() == 1 && luoQiDians[y-2][x - 2].getKind() == 1&& luoQiDians[y+1][x + 1].getKind() == 1)) {
                l.count = 141;
                return;
            }
            if (y >= 3 && y < 15 &&x >= 3 && x < 15 && (luoQiDians[y-1][x - 1].getKind() == 1 && luoQiDians[y-2][x - 2].getKind() == 1&& luoQiDians[y-3][x - 3].getKind() == 1)) {
                l.count = 141;
                return;
            }




            //向上，无气泡检测
            if (y >=3 &&x < 12 && luoQiDians[y-1][x + 1].getKind() == 2 && luoQiDians[y-2][x + 2].getKind() == 2 && luoQiDians[y-3][x + 3].getKind() == 2 ) {
                l.count = 243;
                return;
            }
            if (y <12 &&x >= 3 && luoQiDians[y+1][x - 1].getKind() == 2 && luoQiDians[y+2][x - 2].getKind() == 2 && luoQiDians[y+3][x - 3].getKind() == 2) {
                l.count = 242;
                return;
            }
            if (y >= 2 && y < 14 &&x >= 1 && x < 13 && (luoQiDians[y+1][x - 1].getKind() == 2 && luoQiDians[y-1][x + 1].getKind() == 2&& luoQiDians[y-2][x + 2].getKind() == 2)) {
                l.count = 241;
                return;
            }
            if (y >= 1 && y < 13 &&x >= 2 && x < 14 && (luoQiDians[y+1][x - 1].getKind() == 2 && luoQiDians[y+2][x - 2].getKind() == 2&& luoQiDians[y-1][x + 1].getKind() == 2)) {
                l.count = 241;
                return;
            }
            if (y >= 0 && y < 12 && x >= 3 && x < 15 && (luoQiDians[y+1][x - 1].getKind() == 2 && luoQiDians[y+2][x - 2].getKind() == 2&& luoQiDians[y+3][x - 3].getKind() == 2)) {
                l.count = 241;
                return;
            }
            ////
            if (y >=3 &&x < 12 && luoQiDians[y-1][x + 1].getKind() == 1 && luoQiDians[y-2][x + 2].getKind() == 1 && luoQiDians[y-3][x + 3].getKind() == 1 ) {
                l.count = 143;
                return;
            }
            if (y <12 &&x >= 3 && luoQiDians[y+1][x - 1].getKind() == 1 && luoQiDians[y+2][x - 2].getKind() == 1 && luoQiDians[y+3][x - 3].getKind() == 1) {
                l.count = 142;
                return;
            }
            if (y >= 2 && y < 14 &&x >= 1 && x < 13 && (luoQiDians[y+1][x - 1].getKind() == 1 && luoQiDians[y-1][x + 1].getKind() == 1&& luoQiDians[y-2][x + 2].getKind() == 1)) {
                l.count = 141;
                return;
            }
            if (y >= 1 && y < 13 &&x >= 2 && x < 14 && (luoQiDians[y+1][x - 1].getKind() == 1 && luoQiDians[y+2][x - 2].getKind() == 1&& luoQiDians[y-1][x + 1].getKind() == 1)) {
                l.count = 141;
                return;
            }
            if (y >= 0 && y < 12 && x >= 3 && x < 15 && (luoQiDians[y+1][x - 1].getKind() == 1 && luoQiDians[y+2][x - 2].getKind() == 1&& luoQiDians[y+3][x - 3].getKind() == 1)) {
                l.count = 141;
                return;
            }

        }



        /*
        判断三子
         */
         {

            //x方向
            if (x < 13 && luoQiDians[y][x + 1].getKind() == 2 && luoQiDians[y][x + 2].getKind() == 2) {
                l.count = 33;
                return;
            }
            if (x >= 2 && luoQiDians[y][x - 1].getKind() == 2 && luoQiDians[y][x - 2].getKind() == 2) {
                l.count = 32;
                return;
            }
            if (x >= 1 && x < 14 && luoQiDians[y][x - 1].getKind() == 2 && luoQiDians[y][x + 1].getKind() == 2) {
                l.count = 31;
                return;
            }

            if ((x < 13 && luoQiDians[y][x + 1].getKind() == 1 && luoQiDians[y][x + 2].getKind() == 1)) {
                l.count = 23;
                return;
            }
            if (x >= 2 && luoQiDians[y][x - 1].getKind() == 1 && luoQiDians[y][x - 2].getKind() == 1) {
                l.count = 22;
                return;
            }
            if (x >= 1 && x < 14 && luoQiDians[y][x - 1].getKind() == 1 && luoQiDians[y][x + 1].getKind() == 1) {
                l.count = 21;
                return;
            }






            //Y方向
            if (y < 13 && luoQiDians[y + 1][x].getKind() == 2 && luoQiDians[y + 2][x].getKind() == 2) {
                l.count = 33 - 1;
                return;
            }
            if (y >= 2 && luoQiDians[y - 1][x].getKind() == 2 && luoQiDians[y - 2][x].getKind() == 2) {
                l.count = 32 - 1;
                return;
            }
            if (y >= 1 && y < 14 && luoQiDians[y - 1][x].getKind() == 2 && luoQiDians[y + 1][x].getKind() == 2) {
                l.count = 31 - 1;
                return;
            }

            if (y < 13 && luoQiDians[y + 1][x].getKind() == 1 && luoQiDians[y + 2][x].getKind() == 1) {
                l.count = 23 - 1;
                return;
            }
            if (y >= 2 && luoQiDians[y - 1][x].getKind() == 1 && luoQiDians[y - 2][x].getKind() == 1) {
                l.count = 22 - 1;
                return;
            }
            if (y >= 1 && y < 14 && luoQiDians[y - 1][x].getKind() == 1 && luoQiDians[y + 1][x].getKind() == 1) {
                l.count = 21 - 1;
                return;
            }


            //向下方向
            if (y < 13 && x < 13 && luoQiDians[y + 1][x + 1].getKind() == 2 && luoQiDians[y + 2][x + 2].getKind() == 2) {
                l.count = 33 - 2;
                return;
            }
            if (y >= 2 && x >= 2 && luoQiDians[y - 1][x - 1].getKind() == 2 && luoQiDians[y - 2][x - 2].getKind() == 2) {
                l.count = 32 - 2;
                return;
            }
            if (y >= 1 && y < 14 && x >= 1 && x < 14 && luoQiDians[y - 1][x - 1].getKind() == 2 && luoQiDians[y + 1][x + 1].getKind() == 2) {
                l.count = 31 - 2;
                return;
            }

            if (y < 13 && x < 13 && luoQiDians[y + 1][x + 1].getKind() == 1 && luoQiDians[y + 2][x + 2].getKind() == 1) {
                l.count = 23 - 2;
                return;
            }
            if (y >= 2 && x >= 2 && luoQiDians[y - 1][x - 1].getKind() == 1 && luoQiDians[y - 2][x - 2].getKind() == 1) {
                l.count = 22 - 2;
                return;
            }
            if (y >= 1 && y < 14 && x >= 1 && x < 14 && luoQiDians[y - 1][x - 1].getKind() == 1 && luoQiDians[y + 1][x + 1].getKind() == 1) {
                l.count = 21 - 2;
                return;
            }


            //向上方向
            if (y >= 2 && x < 13 && luoQiDians[y - 1][x + 1].getKind() == 2 && luoQiDians[y - 2][x + 2].getKind() == 2) {
                l.count = 33 - 3;
                return;
            }
            if (y < 13 && x >= 2 && luoQiDians[y + 1][x - 1].getKind() == 2 && luoQiDians[y + 2][x - 2].getKind() == 2) {
                l.count = 32 - 3;
                return;
            }
            if (y >= 1 && y < 14 && x >= 1 && x < 14 && luoQiDians[y + 1][x - 1].getKind() == 2 && luoQiDians[y - 1][x + 1].getKind() == 2) {
                l.count = 31 - 3;
                return;
            }

            if (y >= 2 && x < 13 && luoQiDians[y - 1][x + 1].getKind() == 1 && luoQiDians[y-2][x + 2].getKind() == 1) {
                l.count = 23 - 3;
                return;
            }
            if (y < 13 && x >= 2 && luoQiDians[y + 1][x - 1].getKind() == 1 && luoQiDians[y + 2][x - 2].getKind() == 1) {
                l.count = 22 - 3;
                return;
            }
            if (y >= 1 && y < 14 && x >= 1 && x<14&&luoQiDians[y+1][x - 1].getKind() == 1 && luoQiDians[y - 1][x + 1].getKind() == 1) {
                l.count = 21 - 3;
                return;
            }
        }

        /*
        判断两子
         */
        if(x>=1&&x<14&&y>=1&&y<14&&(luoQiDians[y][x+1].getKind() == 2 ||luoQiDians[y+1][x].getKind() == 2 ||luoQiDians[y][x - 1].getKind() == 2 ||luoQiDians[y-1][x].getKind() == 2 ||luoQiDians[y+1][x - 1].getKind() ==2 ||luoQiDians[y-1][x + 1].getKind() == 2 ||luoQiDians[y+1][x + 1].getKind() == 2 ||luoQiDians[y-1][x - 1].getKind() == 2  )){
            l.count = 4;return;
        }
        if(x>=1&&x<14&&y>=1&&y<14&&(luoQiDians[y][x+1].getKind() == 1 ||luoQiDians[y+1][x].getKind() == 1 ||luoQiDians[y][x - 1].getKind() == 1 ||luoQiDians[y-1][x].getKind() == 1 ||luoQiDians[y+1][x - 1].getKind() == 1 ||luoQiDians[y-1][x + 1].getKind() == 1 ||luoQiDians[y+1][x + 1].getKind() == 1 ||luoQiDians[y-1][x - 1].getKind() == 1  )){
            l.count = 2;return;
        }
    }
    private void sort(LuoQiDian[] luoQiDians1) {
        for(int i = 0;i<luoQiDians1.length-1;i++){
            for(int j=0;j<luoQiDians1.length-1-i;j++){
                if(luoQiDians1[j].compareTo(luoQiDians1[j+1])==-1){
                    LuoQiDian temp = null;
                    temp = luoQiDians1[j];
                    luoQiDians1[j] = luoQiDians1[j+1];
                    luoQiDians1[j+1] = temp;
                }
            }
        }
    }
}
