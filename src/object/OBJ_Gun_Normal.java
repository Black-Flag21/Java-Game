package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Gun_Normal extends Entity {

    public OBJ_Gun_Normal(GamePanel gp) {
        super(gp);

        name = "Normal gun";
        down1 = setup("/objects/gun01-up-right");
        attackValue = 1;

    }
}
