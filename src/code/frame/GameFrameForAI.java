package code.frame;

import ai.AI;
import code.Obj.FootHoldObject;
import code.Obj.GameObject;
import code.Obj.TroopObject;
import code.altas.Atlas;
import code.altas.Atlas_E_ShiChangHuaYuanXingDong;
import code.util.Tip;
import code.util.values;
import utils.MyPoint;
import utils.Play0;
import utils.implemetclass.MyLinkedList;
import utils.inteface.MyList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author lijie
 * @Date 2021/12/21 16:27
 */
public class GameFrameForAI  extends Frame {
    private GameFrameForAI frame = this;
    private Atlas atlas ;

    private final MyList<TroopObject> removeList = new MyLinkedList<>();
    private MyList<TroopObject> troopsObjects = new MyLinkedList<>();
    private MyList<FootHoldObject> footHoldObjects = new MyLinkedList<>();
    private MyList<TroopObject> addList = new MyLinkedList<>();

    private GameObject chooseObj;
    private GameObject lastChoose;

    private int xForBf ;
    private int yForBf ;

    private Image atlas_image;

    private int[] camps;

    private int countOfHuihe;
    private int numberOfTemp;

    private int nowCamp;
    private MyPoint nowResource ;
    private MyPoint[] resources;


    /**
     *
     * AI 专属
     */
    private int myCamp = GameObject.KMT;

    public int getMyCamp() {
        return myCamp;
    }

    public void setMyCamp(int myCamp) {
        this.myCamp = myCamp;
    }

    public GameFrameForAI(Atlas atlas, int myCamp){
        this.myCamp = myCamp;
        loadingAtlas(atlas);
        loading();
        if(nowCamp != myCamp){
            next();
        }

    }
    public void loadingAtlas(Atlas atlas){
        camps = atlas.getCamps();
        numberOfTemp = camps.length;
        this.atlas = atlas;
        this.xForBf = atlas.getxForBg();
        this.yForBf = atlas.getyForBg();
        atlas_image = atlas.getImage();
        nowCamp = camps[0];
        troopsObjects = atlas.troopList;
        footHoldObjects = atlas.footHoldList;
        for(TroopObject o : atlas.troopList){
            o.setFrame(this);
        }
        for(FootHoldObject o : atlas.footHoldList){
            o.setFrame(this);
        }

        resources = new MyPoint[numberOfTemp];
        for(int i = 0;i<numberOfTemp;i++){
            resources[i] = new MyPoint(500,300);
        }
        nowResource = resources[0];
    }




    boolean isWin = true;
    public Image cache;
    public void paint(Graphics g){
        if(cache == null){
            cache  = this.createImage(atlas.getWidth(),atlas.getHeight());
        }
        Graphics gImage = cache.getGraphics();
        gImage.drawImage(atlas_image,0,0,atlas.getWidth(),atlas.getHeight(),this);

        for(FootHoldObject o : footHoldObjects){
            o.paintSelf(gImage);
        }
        for(TroopObject o : troopsObjects){
            o.paintSelf(gImage);
        }
        gImage.setColor(Color.GRAY);
        gImage.setFont(new Font(null,Font.BOLD,15));
        gImage.drawString("金币："+resources[countOfHuihe%numberOfTemp].x,40-xForBf,50-yForBf);
        gImage.drawString("工业值："+resources[countOfHuihe%numberOfTemp].y,40-xForBf,80-yForBf);
        gImage.setColor(Color.green);
        gImage.fillRect(20-xForBf,610-yForBf,100,30);
        gImage.setColor(Color.GRAY);
        gImage.setFont(new Font(null,Font.BOLD,20));
        gImage.drawString("下一回合",20-xForBf,630-yForBf);
        switch(nowCamp) {
            case GameObject.CPC:gImage.drawImage(values.FlagOfCPC,(1040-xForBf),30-yForBf,150,100,this);break;
            case GameObject.JAPAN:gImage.drawImage(values.FlagOfJapan,(1040-xForBf),30-yForBf,150,100,this);break;
            case GameObject.DENMARK:gImage.drawImage(values.FlagOfDenmark,(1040-xForBf),30-yForBf,150,100,this);break;
            case GameObject.POLAND:gImage.drawImage(values.FlagOfPoland,(1040-xForBf),30-yForBf,150,100,this);break;
            case GameObject.GERMAN:gImage.drawImage(values.FlagOfGerman,(1040-xForBf),30-yForBf,150,100,this);break;
            case GameObject.FRANCE:gImage.drawImage(values.FlagOfFrance,(1040-xForBf),30-yForBf,150,100,this);break;
            case GameObject.FINLAND:gImage.drawImage(values.FlagOfFinland,(1040-xForBf),30-yForBf,150,100,this);break;
            case GameObject.US:gImage.drawImage(values.FlagOfUS,(1040-xForBf),30-yForBf,150,100,this);break;
            case GameObject.USSR:gImage.drawImage(values.FlagOfUSSR,(1040-xForBf),30-yForBf,150,100,this);break;
            case GameObject.TURKEY:gImage.drawImage(values.FlagOfTurkey,(1040-xForBf),30-yForBf,150,100,this);break;
            case GameObject.SPAIN:gImage.drawImage(values.FlagOfSpain,(1040-xForBf),30-yForBf,150,100,this);break;
            case GameObject.UK:gImage.drawImage(values.FlagOfUK,(1040-xForBf),30-yForBf,150,100,this);break;
            case GameObject.KMT:gImage.drawImage(values.FlagOfKMT,(1040-xForBf),30-yForBf,150,100,this);break;
        }
        gImage.drawString("点击任一元素",(1040-xForBf),160-yForBf);
        gImage.drawString("按Q键可获取",(1040-xForBf),180-yForBf);
        gImage.drawString("相关说明信息",(1040-xForBf),200-yForBf);
        troopsObjects.removeAll(removeList);
        addList.removeAll(removeList);
        troopsObjects.addAll(addList);

        g.drawImage(cache,xForBf,yForBf,atlas.getWidth(),atlas.getHeight(),this);


        for(FootHoldObject o : footHoldObjects){
            if(o.getCamp()!=nowCamp){
                isWin = false;
            }
        }

    }

    public MyPoint getNowResource() {
        return nowResource;
    }

    public Atlas getAtlas() {
        return atlas;
    }



    public MyList<TroopObject> getRemoveList() {
        return removeList;
    }
    public MyList<TroopObject> getAddList() {
        return addList;
    }

    public MyList<TroopObject> getTroopsObjects() {
        return troopsObjects;
    }

    public MyList<FootHoldObject> getFootHoldObjects() {
        return footHoldObjects;
    }

    public GameObject getChooseObj() {
        return chooseObj;
    }

    public GameObject getLastChoose() {
        return lastChoose;
    }

    public int getxForBf() {
        return xForBf;
    }

    public int getyForBf() {
        return yForBf;
    }

    public Image getAtlas_image() {
        return atlas_image;
    }

    public int[] getCamps() {
        return camps;
    }

    public int getCountOfHuihe() {
        return countOfHuihe;
    }

    public int getNumberOfTemp() {
        return numberOfTemp;
    }

    public int getNowCamp() {
        return nowCamp;
    }




    public void loading(){

        
        new Play0("./resource/sound/fire.wav").start();
        this.setSize(1200,660);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("将军的荣耀");
        setVisible(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case 37:
                        if (xForBf <= -30)
                            xForBf += 30;
                        break;
                    case 38:
                        if (yForBf <= -30)
                            yForBf += 30;
                        break;
                    case 39:
                        if (xForBf > -(atlas.getWidth()-1200))
                            xForBf -= 30;
                        break;
                    case 40:
                        if (yForBf > -(atlas.getHeight()-660))
                            yForBf -= 30;
                        break;
                    default:
                        if(chooseObj!=null)
                            (chooseObj).keyPressed(e);
                }
                repaint();
            }
        });



         /*
        鼠标监听器
         */
        this.addMouseListener(new MyMouse());

      timer = new Timer(50, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              repaint();
              if(isWin){
                  JOptionPane.showMessageDialog(mySelf,values.getCountry(nowCamp)+"  获得胜利",null,1,new ImageIcon(values.getFlag(nowCamp)));
                  timer.stop();
              }
          }
      });
      timer.start();
    }
    private GameFrameForAI mySelf = this;
    private Timer timer;

    public void next(){


        for(TroopObject troopObject:troopsObjects){
            troopObject.setSTEP();
        }
        for(FootHoldObject f : footHoldObjects){
            if(f.getCamp() == nowCamp){
                f.produceResource();
            }
        }
        countOfHuihe++;
        int index = countOfHuihe%numberOfTemp;
        nowCamp = camps[index];
        nowResource = resources[index];


        if(nowCamp == myCamp){
            Tip.alive = true;
            JOptionPane.showMessageDialog(this,values.getCountry(nowCamp)+"\n"+"指挥官，这是你的回合"+"您的资源：金币"+nowResource.x+"  工业值"+nowResource.y,null,1,new ImageIcon(values.getFlag(nowCamp)));

        } else{
            Tip.alive=false;
            AI ai = new AI(this);
            ai.doSomeThing();
        }
    }


    private class MyMouse extends MouseAdapter {

        public void mousePressed(MouseEvent e) {

            int x = e.getX();
            int y = e.getY();
            int relativeX = x - xForBf;
            int relativeY = y - yForBf;
            MyPoint clickPoint = new MyPoint(relativeX, relativeY);
            System.out.println(relativeX + ";" + relativeY);

            if (x > 20 && x < 120 && y > 610 && y < 640) {
                next();
                return;
            }

            if (chooseObj != null) {
                chooseObj.setChoose(false);
                lastChoose = chooseObj;
                chooseObj = null;
            } else {
                lastChoose = null;
            }


            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean isChooseTroop = false;
                    boolean isChooseFootHold = false;
                    for (TroopObject o : troopsObjects) {
                        //观看选择点是否是作战元素所在地
                        if ( o.canClick(clickPoint)) {
                            if(o.getCamp() == nowCamp){
                                chooseObj = o;
                                o.setChoose(true);
                                return ;
                            }
                            isChooseTroop = true;
                            chooseObj = o;
                            break;
                        }
                    }
                    if(!isChooseTroop){
                        //如果没选中作战元素，再看是否选中城市，防止士兵与据点重合时点中据点而不是士兵
                        for (FootHoldObject o : footHoldObjects) {
                            //观看选择点是否是元素所在地
                            if ( o.canClick(clickPoint)) {
                                if(o.getCamp() == nowCamp ){
                                    chooseObj = o;
                                    o.setChoose(true);
                                }
                                isChooseFootHold = true;
                                chooseObj = o;
                                break;
                            }
                        }
                    }

                    if(lastChoose!=null&&lastChoose.getCamp() == nowCamp&&lastChoose instanceof TroopObject){

                        if(((TroopObject) lastChoose).getStep()>0){

                            if(chooseObj!=null&&chooseObj.getCamp()!= nowCamp){
                                if(isChooseTroop){
                                    ((TroopObject) lastChoose).attack((TroopObject) chooseObj);//攻击
                                }else{
                                    ((TroopObject) lastChoose).occupy((FootHoldObject) chooseObj);//占领
                                }
                            }else if(chooseObj!=null&&chooseObj.getCamp()==nowCamp&&chooseObj instanceof FootHoldObject){
                                ((TroopObject) lastChoose).entry((FootHoldObject) chooseObj);//进入自己方城市
                            } else{
                                ((TroopObject) lastChoose).move(clickPoint);//移动
                            }
                        }else{
                            addList.add(new Tip(lastChoose.getFrame(),"移动步数不足",lastChoose.getMyPoint()));
                        }
                    }
                }
            }).start();
        }
    }

}
