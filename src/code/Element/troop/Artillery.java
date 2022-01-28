package code.Element.troop;

import code.Obj.TroopObject;

/**
 * This class is a basic class.
 *
 * @author lijie
 * @version 1.2
 */
public abstract class Artillery extends TroopObject {
    {
        size = 60;
    }

    public abstract void reAttack(TroopObject troopObject);

    public abstract boolean attack(TroopObject troopObject);

}
