package code.frame;

import UDP.Client;
import code.Obj.FootHoldObject;
import code.Obj.GameObject;
import code.Obj.TroopObject;
import code.altas.Atlas;
import code.altas.Atlas_E_JiFuZhanYi;
import code.util.Tip;
import code.util.values;
import utils.MyPoint;
import utils.implemetclass.MyLinkedList;
import utils.inteface.MyList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @author gengxuelong
 * @Date 2021/12/22 10:48
 *
 * 10.27.226.168我的电脑的ip
 */
public class GameFrameForUDPForClient extends Frame {
    private GameFrameForUDPForClient frame = this;
    private Atlas atlas ;

    private final MyList<TroopObject> removeList = new MyLinkedList<>();
    private MyList<TroopObject> troopsObjects = new MyLinkedList<>();
    private MyList<FootHoldObject> footHoldObjects = new MyLinkedList<>();
    private final MyList<TroopObject> addList = new MyLinkedList<>();

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

    private int myCamp;

    private Client client ;




    public void setxForBf(int xForBf) {
        this.xForBf = xForBf;
    }

    public void setyForBf(int yForBf) {
        this.yForBf = yForBf;
    }

    public void setNowResource(MyPoint nowResource) {
        this.nowResource = nowResource;
    }

    @Override
    public Client getClient(){
        return client;
    }



    /*
    通信必要数据
     */
    private String enemyIP;
    private int enemyPort;
    private int myPort;

    public GameFrameForUDPForClient(Atlas atlas,String enemyIP,int enemyPort,int myPort){
        this.enemyIP = enemyIP;
        this.enemyPort = enemyPort;
        this.myPort = myPort;
        client = new Client(this,enemyIP,enemyPort,myPort);
        try {
            client.send("start_"+getLocalIp()+"_"+myPort);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        loadingAtlas(atlas);
        loading();
        client.receiving();
    }
    public void loadingAtlas(Atlas atlas){
        camps = atlas.getCamps();
        numberOfTemp = camps.length;
        this.atlas = atlas;
        this.xForBf = atlas.getxForBg();
        this.yForBf = atlas.getyForBg();
        atlas_image = atlas.getImage();
        nowCamp = camps[0];
        myCamp = camps[1];
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





    public void loading() {

        this.setSize(1200, 660);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("将军的荣耀");
        setVisible(true);
        System.out.println("====="+nowCamp+"    "+myCamp);
            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(nowCamp == myCamp) {
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
                                if (xForBf > -(atlas.getWidth() - 1200))
                                    xForBf -= 30;
                                break;
                            case 40:
                                if (yForBf > -(atlas.getHeight() - 660))
                                    yForBf -= 30;
                                break;
                            default:
                                if (chooseObj != null)
                                    (chooseObj).keyPressed(e);
                        }

                        try {
                            client.send("key_pingmu_" + xForBf + "_" + yForBf);
                        } catch (UnknownHostException unknownHostException) {
                            unknownHostException.printStackTrace();
                        }
                        repaint();
                    }
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
    private GameFrameForUDPForClient mySelf = this;
    private Timer timer;
    private boolean isWin = true;

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
        System.out.println(myCamp+"+++++"+nowCamp);
        JOptionPane.showMessageDialog(this,values.getCountry(nowCamp)+"\n"+"您的资源：金币"+nowResource.x+"  工业值"+nowResource.y,null,1,new ImageIcon(values.getFlag(nowCamp)));
    }


    private class MyMouse extends MouseAdapter{

        public void mousePressed(MouseEvent e) {
            if (nowCamp == myCamp) {

                int x = e.getX();
                int y = e.getY();
                int relativeX = x - xForBf;
                int relativeY = y - yForBf;
                MyPoint clickPoint = new MyPoint(relativeX, relativeY);
                System.out.println(relativeX + ";" + relativeY);

                if (x > 20 && x < 120 && y > 610 && y < 640) {
                    try {
                        client.send("next_0");
                    } catch (UnknownHostException ex) {
                        ex.printStackTrace();
                    }
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
                            if (o.canClick(clickPoint)) {
                                if (o.getCamp() == nowCamp) {
                                    chooseObj = o;
                                    o.setChoose(true);
                                    return;
                                }
                                isChooseTroop = true;
                                chooseObj = o;
                                break;
                            }
                        }
                        if (!isChooseTroop) {
                            //如果没选中作战元素，再看是否选中城市，防止士兵与据点重合时点中据点而不是士兵
                            for (FootHoldObject o : footHoldObjects) {
                                //观看选择点是否是元素所在地
                                if (o.canClick(clickPoint)) {
                                    if (o.getCamp() == nowCamp) {
                                        chooseObj = o;
                                        o.setChoose(true);
                                    }
                                    isChooseFootHold = true;
                                    chooseObj = o;
                                    break;
                                }
                            }
                        }

                        if (lastChoose != null && lastChoose.getCamp() == nowCamp && lastChoose instanceof TroopObject) {

                            if (((TroopObject) lastChoose).getStep() > 0) {

                                if (chooseObj != null && chooseObj.getCamp() != nowCamp) {
                                    if (isChooseTroop) {
                                        ((TroopObject) lastChoose).attack((TroopObject) chooseObj);//攻击
                                        new Thread(new Runnable() {
                                            @Override
                                            public void run() {
                                                try {
                                                    Thread.sleep(2100);
                                                    try {
                                                        client.send("attack"+"_"+lastChoose.getMyPoint().getX()+"_"
                                                                +lastChoose.getMyPoint().getY()+"_"+((TroopObject) lastChoose).getBlood()
                                                                +"_"+chooseObj.getMyPoint().getX()+"_"+chooseObj.getMyPoint().getY()
                                                                +"_"+((TroopObject) chooseObj).getBlood());
                                                    } catch (UnknownHostException ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } catch (InterruptedException ex) {
                                                    ex.printStackTrace();
                                                }
                                            }
                                        }).start();
                                    } else { try {
                                        client.send("occupy"+"_"+lastChoose.getMyPoint().getX()+"_"
                                                +lastChoose.getMyPoint().getY()+ "_"+chooseObj.getMyPoint().getX()+"_"
                                                +chooseObj.getMyPoint().getY());
                                    } catch (UnknownHostException ex) {
                                        ex.printStackTrace();
                                    }
                                        ((TroopObject) lastChoose).occupy((FootHoldObject) chooseObj);//占领
                                    }
                                } else if (chooseObj != null && chooseObj.getCamp() == nowCamp && chooseObj instanceof FootHoldObject) {
                                    try {
                                        client.send("entry"+"_"+lastChoose.getMyPoint().getX()+"_"
                                                +lastChoose.getMyPoint().getY()+ "_"+chooseObj.getMyPoint().getX()+"_"
                                                +chooseObj.getMyPoint().getY());
                                    } catch (UnknownHostException ex) {
                                        ex.printStackTrace();
                                    }
                                    ((TroopObject) lastChoose).entry((FootHoldObject) chooseObj);//进入自己方城市
                                } else {
                                    try {
                                        client.send("move"+"_"+lastChoose.getMyPoint().getX()+"_"
                                                +lastChoose.getMyPoint().getY()+"_"+clickPoint.getX()
                                                +"_"+clickPoint.getY());
                                    } catch (UnknownHostException ex) {
                                        ex.printStackTrace();
                                    }
                                    ((TroopObject) lastChoose).move(clickPoint);//移动
                                }
                            } else {
                                addList.add(new Tip(lastChoose.getFrame(), "移动步数不足", lastChoose.getMyPoint()));
                            }
                        }
                    }
                }).start();
            }
        }
    }


    public static String getLocalIp() {
        Enumeration<NetworkInterface> netInterfaces = null;
        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface nif = netInterfaces.nextElement();
                Enumeration<InetAddress> InetAddress = nif.getInetAddresses();
                while (InetAddress.hasMoreElements()) {
                    String ip = InetAddress.nextElement().getHostAddress();
                    if (ip.startsWith("192.168")) {
                        return ip;
                    }
                }
            }
        } catch (SocketException e) {
        }
        return "127.0.0.1";
    }

}
