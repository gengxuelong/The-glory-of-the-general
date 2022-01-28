package ai;

import code.Element.footHold.*;
import code.Obj.FootHoldObject;
import code.Obj.GameObject;
import code.Obj.TroopObject;
import code.frame.GameFrameForAI;
import utils.MyPoint;
import utils.implemetclass.MyLinkedList;
import utils.inteface.MyList;

import java.util.Random;

/**
 * 人机模式中的ai，包括ai掌握的游戏元素和行动逻辑
 * @author lijie
 * @Date 2021/12/19 16:07
 * @see TroopObject
 * @see FootHoldObject
 * @see GameObject
 * @see GameFrameForAI
 */
public class AI {
     int AICamp ;
    AI mySelf = this;
     MyList<TroopObject> troopObjects;//双方的军队
     MyList<FootHoldObject> footHoldObjects ;//双方的据点
     MyList<GameObject> MyObjects = new MyLinkedList<>() ;//玩家的元素
     MyList<TroopObject> AITroopObjects = new MyLinkedList<>();//ai的军队
     MyList<FootHoldObject> AIFootHoldObjects = new MyLinkedList<>() ;//ai的据点
     GameFrameForAI frame;
    public AI(GameFrameForAI ai){
        frame = ai;
    }

    /**
     * ai的行动逻辑
     */
    public void doSomeThing(){
    	
    	//从游戏中获取所有元素
        GameFrameForAI AIframe = frame;
        AICamp = frame.getNowCamp();
        troopObjects = frame.getTroopsObjects();
        footHoldObjects = frame.getFootHoldObjects();
        
        //将游戏中的元素按照阵营区分玩家和ai所拥有的
        for(FootHoldObject o : footHoldObjects){
            if(o.getCamp()==AICamp){
                AIFootHoldObjects.add(o);
            }
        }
        for(TroopObject o : troopObjects){
            if(o.getCamp()==AICamp){
                AITroopObjects.add(o);
            }
        }
        for(TroopObject o : troopObjects){
            if(o.getCamp()==frame.getMyCamp()){
                MyObjects.add(o);
            }
        }
        for(FootHoldObject o : footHoldObjects){
            if(o.getCamp()==frame.getMyCamp()){
                MyObjects.add(o);
            }
        }
        
        //ai的行动：控制军队操作
        for(TroopObject o : AITroopObjects){

            int a = o.getStep();
            for(int i = 0; i<a;i++){
                new MyThead2(o).start();
            }
        }

        //ai的行动：控制据点操作
        for(FootHoldObject o :AIFootHoldObjects){
            if(Math.random()<0.2)
                 new MyThead(o).start();
        }
        
        new Clock();//过场动画
        new MyThead3().start();//游戏下一回合
        System.gc();
    }

    /**
     * 该线程用于开始下一回合
     * @author lijie
     *
     */
    public class MyThead3 extends Thread{
        MyThead3 mySelf  = this;
        public void run(){
            try {
                sleep(5000);
                frame.next();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 该线程是ai操控据点的逻辑
     * @author lijie
     *
     */
    public class MyThead extends Thread{
        MyThead mySelf = this;
        private final FootHoldObject o;
        
        public MyThead(FootHoldObject o){
            this.o  = o;
        }
        
        public void run() {
        	
        	//如果据点上有军队，则无法操作
            for(TroopObject tro : troopObjects){
                if(o.canClick(tro.getMyPoint())){
                    return;
                }
            }
            
            //按照据点类型不同，随机地创造军队
            //城市创造普通步兵
            if(o instanceof SmallCity){
                o.produceTroop(SmallCity.NI);
            }else if(o instanceof MiddleCity){
                o.produceTroop(MiddleCity.NI);
            }else if (o instanceof LargeCity){
                o.produceTroop(LargeCity.NI);
            }
            //兵工厂随机造兵
            else if(o instanceof SmallArmsFactory) {
                Random r = new Random();
                int random = r.nextInt(3);
                switch (random) {
                    case 0:
                        o.produceTroop(SmallArmsFactory.ARMORED);
                    case 1:
                        o.produceTroop(SmallArmsFactory.LIGHT_ARTILLERY);
                    case 2:
                        o.produceTroop(SmallArmsFactory.LIGHT_TANK);
                }
            }else if(o instanceof MiddleArmsFactory){
                Random r =new Random();
                int random = r.nextInt(5) ;
                switch (random) {
                    case 0 : o.produceTroop(SmallArmsFactory.ARMORED);
                    case 1 : o.produceTroop(SmallArmsFactory.LIGHT_ARTILLERY);
                    case 2 : o.produceTroop(SmallArmsFactory.LIGHT_TANK);
                    case 3 : o.produceTroop(SmallArmsFactory.MIDDLE_TANK);
                    case 4 : o.produceTroop(SmallArmsFactory.HEAVY_ARTILLERY);
                }
            }else if(o instanceof LargeArmsFactory){
                Random r =new Random();
                int random = r.nextInt(5) ;
                switch (random) {
                    case 0 : o.produceTroop(SmallArmsFactory.ARMORED);
                    case 1 : o.produceTroop(SmallArmsFactory.LIGHT_ARTILLERY);
                    case 2 : o.produceTroop(SmallArmsFactory.LIGHT_TANK);
                    case 3 : o.produceTroop(SmallArmsFactory.MIDDLE_TANK);
                    case 4 : o.produceTroop(SmallArmsFactory.HEAVY_ARTILLERY);
                    case 5 : o.produceTroop(SmallArmsFactory.HEAVY_TANK);
                    case 6 : o.produceTroop(SmallArmsFactory.ROCKET_GUN);
                }
            }else if(o instanceof Airport){
                Random r =new Random();
                int random = r.nextInt(2) ;
                switch (random) {
                    case 0 : o.produceTroop(SmallArmsFactory.ARMORED);
                    case 1 : o.produceTroop(SmallArmsFactory.LIGHT_ARTILLERY);
                }
            }
            frame.repaint();
            mySelf.stop();
        }
    }

    /**
     * 该线程是ai操控军队的逻辑
     * @author lijie
     *
     */
    public class MyThead2 extends Thread{
    	
        private final MyThead2 mySelf = this;
        TroopObject o ;
        
        public MyThead2(TroopObject o){
            this.o = o;
        }
        
        public void run() {
            GameObject target = null;
            if(MyObjects.size()!=0) {

                    //遍历玩家元素，找到距离当前ai元素最近的一个
                    target = MyObjects.get(0);
                    for (GameObject go : MyObjects) {
                        int sum1 = Math.abs(target.getMyPoint().getX() - o.getMyPoint().getX()) + Math.abs(target.getMyPoint().getY() - o.getMyPoint().getY());
                        int sum2 = Math.abs(go.getMyPoint().getX() - o.getMyPoint().getX()) + Math.abs(go.getMyPoint().getY() - o.getMyPoint().getY());
                        if (sum1 > sum2) {
                            target = go;
                        }
                    }

                    //在攻击范围内，是军队则攻击，是据点则占领
                    if (o.canFire(target)) {
                        if (target instanceof TroopObject) {
                            if (o.getStep() > 0)
                                o.attack((TroopObject) target);
                        } else {
                            if (o.getStep() > 0) {
                                o.occupy((FootHoldObject) target);
                            }
                        }
                    }else{


                        //在移动范围内，尽可能地靠近目标
                        if (o.canReach(target.getMyPoint())) {

                            MyPoint point1 = new MyPoint(target.getMyPoint().x - o.getSize(), target.getMyPoint().y - o.getSize());
                            MyPoint point2 = new MyPoint(target.getMyPoint().x + o.getSize(), target.getMyPoint().y - o.getSize());
                            MyPoint point3 = new MyPoint(target.getMyPoint().x + o.getSize(), target.getMyPoint().y + o.getSize());
                            MyPoint point4 = new MyPoint(target.getMyPoint().x - o.getSize(), target.getMyPoint().y + o.getSize());
                            MyPoint[] myPoints = new MyPoint[]{point1, point2, point3, point4};
                            for (int i = 0; i < 4; i++) {
                                if (o.move(myPoints[i])) {
                                    break;
                                }
                            }
                        } else//不在移动范围内
                        {
                            int spacex = target.getMyPoint().getX() - o.getMyPoint().getX();
                            int spacey = target.getMyPoint().getY() - o.getMyPoint().getY();
                            int space = (int) Math.sqrt(spacex * spacex + spacey * spacey);
                            MyPoint point = new MyPoint(o.getMyPoint().getX() + spacex * o.getMoveRange() / space,
                                    o.getMyPoint().getY() + spacey * o.getMoveRange() / space);
                            boolean flag = true;
                            flag = o.move(point);
                            while (!flag) {
                                point.setX(point.getX() + target.getSize() * spacex / Math.abs(spacex));
                                point.setY(point.getY() + target.getSize() * spacey / Math.abs(spacey));
                                flag = o.move(point);
                            }
                        }

                    }



            }
            mySelf.stop();
            frame.repaint();
        }

    }
}
