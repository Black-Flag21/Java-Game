package object;

import entity.Entity;
import main.GamePanel;


public class OBJ_FirstAidKit extends Entity {

    public OBJ_FirstAidKit(GamePanel gp){

        super(gp);

        name = "FirstAidKit";
        right1 = setup("/objects/FirstAidKit");


    }

}
