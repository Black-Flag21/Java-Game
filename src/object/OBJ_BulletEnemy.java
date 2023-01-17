package object;

import entity.Projectile;
import main.GamePanel;

public class OBJ_BulletEnemy extends Projectile {

    GamePanel gp;

    public OBJ_BulletEnemy(GamePanel gp) {
        super(gp);
        this.gp = gp;

        name = "Rock";
        speed = 8;
        maxLife = 120;
        life = maxLife;
        attack = 2;
        useCost = 1;
        alive = false;
        getImage();
    }

    public void getImage(){
        up1 = setup("/projectile/bullet-enemy-left");
        up2 = setup("/projectile/bullet-enemy-left");
        down1 = setup("/projectile/bullet-enemy-right");
        down2 = setup("/projectile/bullet-enemy-right");
        left1 = setup("/projectile/bullet-enemy-left");
        left2 = setup("/projectile/bullet-enemy-left");
        right1 = setup("/projectile/bullet-enemy-right");
        right2 = setup("/projectile/bullet-enemy-right");
    }
}
