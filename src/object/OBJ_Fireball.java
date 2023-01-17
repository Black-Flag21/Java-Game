package object;

import entity.Projectile;
import main.GamePanel;

public class OBJ_Fireball extends Projectile {

    GamePanel gp;

    public OBJ_Fireball(GamePanel gp) {
        super(gp);
        this.gp = gp;

        name = "Fireball";
        speed = 6;
        maxLife = 120;
        life = maxLife;
        attack = 2;
        useCost = 1;
        alive = false;
        getImage();
    }

    public void getImage(){
        up1 = setup("/projectile/bullet-up");
        up2 = setup("/projectile/bullet-up");
        down1 = setup("/projectile/bullet-down");
        down2 = setup("/projectile/bullet-down");
        left1 = setup("/projectile/bullet-left");
        left2 = setup("/projectile/bullet-left");
        right1 = setup("/projectile/bullet-right");
        right2 = setup("/projectile/bullet-right");
    }

}
