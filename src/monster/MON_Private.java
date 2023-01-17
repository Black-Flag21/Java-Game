package monster;

import entity.Entity;
import main.GamePanel;
import main.UtilityTool;
import object.OBJ_BulletEnemy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class MON_Private extends Entity {

    GamePanel gp;
    public final int screenX;
    public final int screenY;

    public MON_Private(GamePanel gp) {
        super(gp);

        this.gp = gp;
        screenX = gp.screenWidth/2  - (gp.tileSize/2);
        screenY = gp.screenHeight/4 - (gp.tileSize/2);

        type = 2;
        name = "Private";
        speed = 1;
        maxLife = 1;
        life = maxLife;
        attack = 5;
        defense = 0;
        exp = 2;
        projectile = new OBJ_BulletEnemy(gp);

        solidArea.x = 3;
        solidArea.y = 10;
        solidArea.width = 64;
        solidArea.height = 50;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {
        right1 = setup("WalkingSoldier1-right");
        right2 = setup("WalkingSoldier2-right");
        right3 = setup("WalkingSoldier1-right");
        right4 = setup("WalkingSoldier2-right");
        left1 = setup("WalkingSoldier1-left");
        left2 = setup("WalkingSoldier2-left");
        left3 = setup("WalkingSoldier1-left");
        left4 = setup("WalkingSoldier2-left");
        up1 = setup("WalkingSoldier1-right");
        up2 = setup("WalkingSoldier2-right");
        up3 = setup("WalkingSoldier1-right");
        up4 = setup("WalkingSoldier2-right");
        down1 = setup("WalkingSoldier1-right");
        down2 = setup("WalkingSoldier2-right");
        down3 = setup("WalkingSoldier1-right");
        down4 = setup("WalkingSoldier2-right");
    }

    public void setAction(){

        actionLockCounter++;

        if(actionLockCounter == 120){

            Random random = new Random();

            int i  = random.nextInt(50)+1;

            if(i <=25){
                direction = "left";
            }
            if(i > 25 && i <= 50){
                direction = "right";
            }

            actionLockCounter = 0;


        }
        int i = new Random().nextInt(50)+1;
        if(i >49 && projectile.alive == false && shotAvailableCounter == 30){
            projectile.set(worldX,worldY,direction,true,this);
            gp.projectileList.add(projectile);
            shotAvailableCounter = 0;

        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

       /* if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
            worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
            worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
            worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

        */

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                if (spriteNum == 4) {
                    image = up4;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
                if (spriteNum == 4) {
                    image = down4;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left2;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                if (spriteNum == 3) {
                    image = left3;
                }
                if (spriteNum == 4) {
                    image = left4;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                if (spriteNum == 3) {
                    image = right3;
                }
                if (spriteNum == 4) {
                    image = right4;
                }
                break;
        }

        if(life >0) {
            g2.drawImage(image, screenX, screenY, gp.tileSize * 4, gp.tileSize * 4, null);

        }
        else{
            solidArea.x = 0;
            solidArea.y = 0;
            solidArea.width = 0;
            solidArea.height = 0;
        }


        //}
    }

    public BufferedImage setup(String imageName) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/monster/" + imageName + ".png"));
            image = uTool.scaleImage(image, gp.tileSize * 4, gp.tileSize * 4);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;

    }
    public void damageReaction(){

        actionLockCounter = 0;
        direction = gp.player.direction;
    }
}
