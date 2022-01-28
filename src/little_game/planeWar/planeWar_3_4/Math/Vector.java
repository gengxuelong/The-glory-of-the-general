package little_game.planeWar.planeWar_3_4.Math;

/**
 * This class is a basic class.
 *
 * @author lijie
 * @version 1.0
 */
public class Vector {

    public int x;
    public int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void add(Vector vector){
        x += vector.getX();
        y += vector.getY();
    }

    public void minus(Vector vector){
        x -= vector.getX();
        y -= vector.getY();
    }

    public int ji(){
        return x*x+y*y;
    }

    public void cheng(double tangle){
        x+=(int)(x*(Math.cos(Math.PI/30*(tangle%30))));
        y+=(int)(y*(Math.sin(Math.PI/30*(tangle%30))));
    }

}
