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

public class MON_Angela extends  Entity {

    GamePanel gp;
    public final int screenX;
    public final int screenY;

    public MON_Angela(GamePanel gp) {

        super(gp);
        this.gp = gp;
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 4 - (gp.tileSize / 2);

        type = 2;
        name = "Angela";
        speed = 1;
        maxLife = 1000;
        life = maxLife;
        attack = 0;
        defense = 0;
        exp = 2;

        solidArea.x = 3;
        solidArea.y = 10;
        solidArea.width = 64;
        solidArea.height = 50;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {
        right1 = setup("Angela1-right");
        right2 = setup("Angela2-right");
        right3 = setup("Angela3-right");
        right4 = setup("Angela4-right");
        left1 = setup("Angela1-left");
        left2 = setup("Angela2-left");
        left3 = setup("Angela2-left");
        left4 = setup("Angela2-left");
        up1 = setup("Angela1-up");
        up2 = setup("Angela2-up");
        up3 = setup("Angela3-up");
        up4 = setup("Angela4-up");
        down1 = setup("Angela1-down");
        down2 = setup("Angela1-down");
        down3 = setup("Angela1-down");
        down4 = setup("Angela1-down");
    }

    public void setAction() {

        actionLockCounter++;

        if (actionLockCounter == 120) {

            Random random = new Random();

            int i = random.nextInt(100) + 1;

            if (i <= 25) {
                direction = "left";
            }
            if (i > 25 && i <= 50) {
                direction = "right";
            }
            if (i > 50 && i <= 75) {
                direction = "up";
            }
            if (i > 75 && i <= 100) {
                direction = "down";
            }

            actionLockCounter = 0;


        }


    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;


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
            g2.drawImage(image, screenX, screenY, gp.tileSize * 4, gp.tileSize * 4, null);

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

}

