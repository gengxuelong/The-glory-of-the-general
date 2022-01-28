package code.frame;

import UDP.Client;
import UDP.Server;
import code.Obj.FootHoldObject;
import code.Obj.GameObject;
import code.Obj.TroopObject;
import code.altas.Atlas;
import utils.MyPoint;
import utils.inteface.MyList;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author gengxuelong
 * @Date 2021/12/21 16:33
 */
public  abstract class Frame  extends JFrame {

    public abstract void loadingAtlas(Atlas atlas);

    public  abstract void paint(Graphics g);

    public abstract MyPoint getNowResource() ;

    public abstract Atlas getAtlas() ;

    public abstract MyList<TroopObject> getRemoveList() ;

    public abstract MyList<TroopObject> getAddList() ;

    public abstract MyList<TroopObject> getTroopsObjects() ;

    public abstract MyList<FootHoldObject> getFootHoldObjects() ;

    public abstract GameObject getChooseObj() ;

    public abstract GameObject getLastChoose() ;

    public  abstract int getxForBf() ;

    public abstract int getyForBf() ;

    public abstract Image getAtlas_image() ;

    public abstract int[] getCamps() ;

    public abstract int getCountOfHuihe() ;

    public abstract int getNumberOfTemp();

    public abstract int getNowCamp() ;

    public abstract void loading();

    public int getMyCamp(){return getNowCamp();}

    public Server getServer(){return null;}

    public Client getClient(){return null;}


}
