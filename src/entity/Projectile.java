package entity;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Projectile extends Entity{

    Entity user;

    public Projectile(GamePanel gp) {
        super(gp);
    }

    public void set(int worldX, int worldY,String direction, boolean alive, Entity user){

        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.alive = alive;
        this.user = user;
        this.life = this.maxLife;
    }

    public void update(){

        if(user == gp.player){
            int monsterIndex = gp.cChecker.checkEntity(this,gp.monster);
            if(monsterIndex != 999){
                gp.player.damageMonster(monsterIndex,attack);
                alive = false;
            }
        }
        if(user != gp.player){
            boolean contactPlayer = gp.cChecker.checkPlayer(this);
            if(gp.player.invincible == false && contactPlayer == true){
                damagePlayer(attack);
                alive = false;
            }
        }

        switch (direction){
            case "up": worldY -= speed;
            break;
            case "down": worldY += speed;
            break;
            case "left": worldX -= speed;
            break;
            case "right": worldX += speed;
            break;
        }
        life--;
        if(life <= 0){
            alive = false;
        }

        spriteCounter++;
        if(spriteCounter >12){
            if(spriteCounter ==1){
                spriteNum = 2;
            }
            else if(spriteCounter ==2){
                spriteNum = 1;
            }
            spriteCounter = 0;
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
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left2;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize*4, gp.tileSize*4,null);


    }

}
