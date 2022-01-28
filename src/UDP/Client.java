package UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

import code.Element.cartoon.BigBurst;
import code.Element.cartoon.Bomber;
import code.Element.cartoon.Fighter;
import code.Obj.FootHoldObject;
import code.Obj.TroopObject;
import code.frame.GameFrameForUDPForClient;
import code.util.Tip;
import utils.MyPoint;

/**
 * @author lijie
 */
public class Client
{

    public   DatagramSocket ds;
    GameFrameForUDPForClient frame;


    private String enemyIP;
    private int enemyPort;
    private int myPort;
    public Client(GameFrameForUDPForClient frame,String enemyIP,int enemyPort,int myPort){
        this.frame = frame;
        this.enemyIP = enemyIP;
        this.enemyPort = enemyPort;
        this.myPort = myPort;

        try {
            ds = new DatagramSocket(myPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


    public  void send(String str) throws UnknownHostException {
        Scanner sc=new Scanner(System.in);
        byte[]fa=str.getBytes();
        DatagramPacket dp =new DatagramPacket(fa,fa.length, InetAddress.getByName(enemyIP),enemyPort);
        try {
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public GameObject fun(int x,int y){
//
//    }

    public void receiving(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                    while(true)
                    {
                        byte[] shou=new byte[1024];
                        DatagramPacket dp=new DatagramPacket(shou,shou.length);
                        try {
                            ds.receive(dp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        byte[] data=dp.getData();
                        String str=new String(data,0,dp.getLength());
                        System.out.println(str);
                        String [] strings = str.split("_");
                        if(strings[0].equals("key")&&strings[1].equals("pingmu")){
                            int xForBf = Integer.parseInt(strings[2]);
                            int yForBf = Integer.parseInt(strings[3]);
                            frame.setxForBf(xForBf);
                            frame.setyForBf(yForBf);
                            System.out.println("....."+xForBf+"+++"+yForBf);
                            frame.repaint();
                        }
                        if(strings[0].equals("attack")){
                            for(TroopObject troopObject: frame.getTroopsObjects()){
                                if(troopObject.getMyPoint().getX()==Integer.parseInt(strings[1])
                                && troopObject.getMyPoint().getY()==Integer.parseInt(strings[2])){
                                    frame.getTroopsObjects().add(new Tip(frame,"-"+(troopObject.getBlood()-Integer.parseInt(strings[3])),troopObject.getMyPoint()));
                                    frame.getTroopsObjects().add(new BigBurst(frame,troopObject.getMyPoint(),(troopObject.getBlood()-Integer.parseInt(strings[3]))*1.0/100));
                                    troopObject.setBlood(Integer.parseInt(strings[3]));
                                    break;
                                }
                            }
                            for(TroopObject troopObject: frame.getTroopsObjects()){
                                if(troopObject.getMyPoint().getX()==Integer.parseInt(strings[4])
                                        && troopObject.getMyPoint().getY()==Integer.parseInt(strings[5])){
                                    frame.getTroopsObjects().add(new BigBurst(frame,troopObject.getMyPoint(),(troopObject.getBlood()-Integer.parseInt(strings[3]))*1.0/100));
                                    frame.getTroopsObjects().add(new Tip(frame,"-"+(troopObject.getBlood()-Integer.parseInt(strings[6])),troopObject.getMyPoint()));
                                    troopObject.setBlood(Integer.parseInt(strings[6]));
                                    break;
                                }
                            }
                        }

                        if(strings[0].equals("occupy")){
                            TroopObject lastTroopObject = null;
                            FootHoldObject afterFootHoldObject = null;
                            for(TroopObject troopObject: frame.getTroopsObjects()){
                                if(troopObject.getMyPoint().getX()==Integer.parseInt(strings[1])
                                        && troopObject.getMyPoint().getY()==Integer.parseInt(strings[2])){
                                    lastTroopObject = troopObject;
                                    break;
                                }
                            }
                            for(FootHoldObject footHoldObject: frame.getFootHoldObjects()){
                                if(footHoldObject.getMyPoint().getX()==Integer.parseInt(strings[3])
                                        && footHoldObject.getMyPoint().getY()==Integer.parseInt(strings[4])){
                                  afterFootHoldObject = footHoldObject;
                                    break;
                                }
                            }
                            lastTroopObject.occupy(afterFootHoldObject);
                            frame.repaint();
                        }

                        if(strings[0].equals("entry")){
                            TroopObject lastTroopObject = null;
                            FootHoldObject afterFootHoldObject = null;
                            for(TroopObject troopObject: frame.getTroopsObjects()){
                                if(troopObject.getMyPoint().getX()==Integer.parseInt(strings[1])
                                        && troopObject.getMyPoint().getY()==Integer.parseInt(strings[2])){
                                    lastTroopObject = troopObject;
                                    break;
                                }
                            }
                            for(FootHoldObject footHoldObject: frame.getFootHoldObjects()){
                                if(footHoldObject.getMyPoint().getX()==Integer.parseInt(strings[3])
                                        && footHoldObject.getMyPoint().getY()==Integer.parseInt(strings[4])){
                                    afterFootHoldObject = footHoldObject;
                                    break;
                                }
                            }
                            lastTroopObject.entry(afterFootHoldObject);
                            frame.repaint();
                        }

                        if(strings[0].equals("move")){
                            TroopObject lastTroopObject = null;
                            for(TroopObject troopObject: frame.getTroopsObjects()){
                                if(troopObject.getMyPoint().getX()==Integer.parseInt(strings[1])
                                        && troopObject.getMyPoint().getY()==Integer.parseInt(strings[2])){
                                    lastTroopObject = troopObject;
                                    break;
                                }
                            }
                            lastTroopObject.move(new MyPoint(Integer.parseInt(strings[3]),
                                    Integer.parseInt(strings[4])));
                            frame.repaint();
                        }

                        if(strings[0].equals("hold")){
                            FootHoldObject lastFootHoldObject = null;
                            for(FootHoldObject footHoldObject : frame.getFootHoldObjects()){
                                if(footHoldObject.getMyPoint().getX()==Integer.parseInt(strings[1])
                                        && footHoldObject.getMyPoint().getY()==Integer.parseInt(strings[2])){
                                    lastFootHoldObject = footHoldObject;
                                    break;
                                }
                            }
                            lastFootHoldObject.produceTroop(Integer.parseInt(strings[3]));
                            frame.repaint();
                        }

                        if(strings[0].equals("next")){
                            frame.next();
                            frame.repaint();
                        }

                        if(strings[0].equals("bomber")){
                            FootHoldObject lastF;
                            for(FootHoldObject footHoldObject: frame.getFootHoldObjects()){
                                if(footHoldObject.getMyPoint().getX()==Integer.parseInt(strings[1])
                                        && footHoldObject.getMyPoint().getY()==Integer.parseInt(strings[2])){
                                    lastF = footHoldObject;
                                    frame.getNowResource().setX(Integer.parseInt(strings[3]));
                                    frame.getNowResource().setY(Integer.parseInt(strings[4]));
                                    break;
                                }
                            }
                        }

                        if(strings[0].equals("fighter")){
                            FootHoldObject lastF;
                            for(FootHoldObject footHoldObject: frame.getFootHoldObjects()){
                                if(footHoldObject.getMyPoint().getX()==Integer.parseInt(strings[1])
                                        && footHoldObject.getMyPoint().getY()==Integer.parseInt(strings[2])){
                                    lastF = footHoldObject;
                                    frame.getNowResource().setX(Integer.parseInt(strings[3]));
                                    frame.getNowResource().setY(Integer.parseInt(strings[4]));
                                    break;
                                }
                            }
                        }

                        if(strings[0].equals("bomberAttack")){
                            for(TroopObject troopObject: frame.getTroopsObjects()){
                                if(troopObject.getMyPoint().getX()==Integer.parseInt(strings[1])
                                        && troopObject.getMyPoint().getY()==Integer.parseInt(strings[2])){
                                    frame.getTroopsObjects().add(new Tip(frame,"-"+Integer.parseInt(strings[3]),troopObject.getMyPoint()));
                                    frame.getTroopsObjects().add(new Bomber(frame,troopObject.getMyPoint(),frame.getNowCamp()));
                                    troopObject.setBlood(troopObject.getBlood()-Integer.parseInt(strings[3]));
                                    break;
                                }
                            }
                        }

                        if(strings[0].equals("fighterAttack")){
                            for(TroopObject troopObject: frame.getTroopsObjects()){
                                if(troopObject.getMyPoint().getX()==Integer.parseInt(strings[1])
                                        && troopObject.getMyPoint().getY()==Integer.parseInt(strings[2])){
                                    frame.getTroopsObjects().add(new Tip(frame,"-"+Integer.parseInt(strings[3]),troopObject.getMyPoint()));
                                    frame.getTroopsObjects().add(new Fighter(frame,troopObject.getMyPoint(),frame.getNowCamp()));
                                    troopObject.setBlood(troopObject.getBlood()-Integer.parseInt(strings[3]));
                                    break;
                                }
                            }
                        }



                    }
            }
        }).start();
    }

}
