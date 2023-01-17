package entity;

import main.DataBase;
import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
import object.OBJ_Fireball;
import object.OBJ_Gun_Normal;
import object.OBJ_Shield_Wood;

import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics2D;

public class Player extends Entity{

   // GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    int standCounter = 0;
    public boolean attackCancel = false;
    public DataBase db ;



    public Player(GamePanel gp , KeyHandler keyH){

        super(gp);

        this.keyH = keyH;

        screenX = gp.screenWidth/2  - (gp.tileSize/2);
        screenY = gp.screenHeight/4 - (gp.tileSize/2);


        solidArea = new Rectangle(48,60,40,60 );

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;


        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){

        //worldX=gp.tileSize * 20;
        //worldY=gp.tileSize * 15;
        speed = 2;
        //direction ="right";

        // PLAYER STATUS;
        maxLife = 6;
        life = maxLife;
        level = 1;
        strength = 1;
        dexterity = 1;
        exp = 0;
        nextLevelExp = 5;
        coin = 0;
        currentWeapon = new OBJ_Gun_Normal(gp);
        currentShield = new OBJ_Shield_Wood(gp);
        attack = getAttack();
        defense = getDefense();
        projectile = new OBJ_Fireball(gp);
    }

    public void setDefaultPosition(){

        if(gp.currentMap == 0) {
            worldX = gp.tileSize * 20;
            worldY = gp.tileSize * 15;
            direction = "right";
        }

        if(gp.currentMap == 1){
            worldX=gp.tileSize * 45;
            worldY=gp.tileSize * 14;
            direction ="down";
        }

    }
    public void restoreLifeAndMana(){

        life = maxLife;
        mana = maxMana;
        invincible = false;
    }
    public int getAttack(){
        return attack = strength * currentWeapon.attackValue;
    }

    public int getDefense(){
        return defense = dexterity * currentShield.defenseValue;
    }

    public void getPlayerImage(){
            down1 = setup("char01_walk-diagonal-down-armed01");
            down2 = setup("char01_walk-diagonal-down-armed02");
            down3 = setup("char01_walk-diagonal-down-armed03");
            down4 = setup("char01_walk-diagonal-down-armed04");

            up1 = setup("char01_walk-diagonal-up-armed01");
            up2 = setup("char01_walk-diagonal-up-armed02");
            up3 = setup("char01_walk-diagonal-up-armed03");
            up4 = setup("char01_walk-diagonal-up-armed04");

            left1 = setup("char01_walk-left11-armed01");
            left2 = setup("char01_walk-left22-armed02");
            left3 = setup("char01_walk-left33-armed03");
            left4 = setup("char01_walk-left44-armed04");

            right1 = setup("char01_walk-right-armed01");
            right2 = setup("char01_walk-right-armed02");
            right3 = setup("char01_walk-right-armed03");
            right4 = setup("char01_walk-right-armed04");

            down1f = setup("char01_walk-diagonal-down-armed01_fire");
            down2f = setup("char01_walk-diagonal-down-armed02_fire");
            down3f = setup("char01_walk-diagonal-down-armed03_fire");
            down4f = setup("char01_walk-diagonal-down-armed04_fire");

            up1f = setup("char01_walk-diagonal-up-armed01_fire");
            up2f = setup("char01_walk-diagonal-up-armed02_fire");
            up3f = setup("char01_walk-diagonal-up-armed03_fire");
            up4f = setup("char01_walk-diagonal-up-armed04_fire");

            left1f = setup("char01_walk-left-armed01_fire");
            left2f = setup("char01_walk-left-armed02_fire");
            left3f = setup("char01_walk-left-armed03_fire");
            left4f = setup("char01_walk-left-armed04_fire");

            right1f = setup("char01_walk-right-armed01_fire");
            right2f = setup("char01_walk-right-armed02_fire");
            right3f = setup("char01_walk-right-armed03_fire");
            right4f = setup("char01_walk-right-armed04_fire");

    }


    public BufferedImage setup(String imageName){

        UtilityTool uTool = new UtilityTool();
        BufferedImage image= null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName +".png"));
            image = uTool.scaleImage(image, gp.tileSize*4,gp.tileSize*4);

        }catch(IOException e){
            e.printStackTrace();
        }
        return image;

    }

    public void update(){


        if(keyH.upPressed == true || keyH.downPressed == true ||
                keyH.leftPressed == true || keyH.rightPressed == true || keyH.enterPressed == true){

            if(keyH.upPressed == true)
            {
                direction ="up";
            }
            else if(keyH.downPressed == true)
            {
                direction ="down";
            }
            else if(keyH.leftPressed == true)
            {
                direction ="left";
            }
            else if(keyH.rightPressed == true)
            {
                direction ="right";
            }

            //CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this,true);
            pickUpObject(objIndex);

            //CHECK NPC COLLISION
           // int npcIndex = gp.cChecker.checkEntity(this, gp.npc);

            //CHECK MONSTER COLLISION
            int monsterIndex = gp.cChecker.checkEntity(this,gp.monster);
            contactMonster(monsterIndex);

            // CHECK EVENT
            gp.eHandler.checkEvent();

            gp.keyH.enterPressed = false;


            //IF COLLISION IS FALSE , PLAYER CAN MOVE
            if(collisionOn == false && keyH.enterPressed == false){
                switch (direction)
                {
                    case "up":
                        if(keyH.shiftPressed == true)
                        {
                            speed = 3;

                        }
                        worldY -= speed;
                        speed =2;
                        break;

                    case "down":
                        if(keyH.shiftPressed == true)
                        {
                            speed = 3;
                        }
                        worldY += speed;
                        speed =2;
                        break;

                    case "left":
                        if(keyH.shiftPressed == true)
                        {
                            speed = 3;
                        }
                        worldX -= speed;
                        speed = 2;
                        break;

                    case "right":
                        if(keyH.shiftPressed == true)
                        {
                            speed = 3;
                        }
                        worldX += speed;
                        speed = 2;
                        break;

                }
            }

            if(keyH.enterPressed = true && attackCancel == false){
                attacking = true;
                //spriteCounter = 0;
            }

            attackCancel = false;
            gp.keyH.enterPressed = false;

            spriteCounter++;
            if(spriteCounter > 8 )
            {
                if(spriteNum == 1) {
                    spriteNum = 2;
                }
                else if(spriteNum ==2){
                    spriteNum = 3;
                }
                else if(spriteNum ==3){
                    spriteNum = 4;
                }
                else if(spriteNum ==4){
                    spriteNum = 1;
                }
                spriteCounter= 0;
            }
        }

        if(gp.keyH.shotKeyPressed == true && projectile.alive == false && shotAvailableCounter == 30){

            // SET DEFAULT COORDINATES, DIRECTION AND USER
            projectile.set(worldX,worldY,direction,true,this);

            // ADD IT TO THE LIST
            gp.projectileList.add(projectile);

            shotAvailableCounter = 0;
        }

        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter > 60){
                invincible = false;
                invincibleCounter = 0;
            }
        }
        if(shotAvailableCounter < 30){
            shotAvailableCounter++;
        }

        if(life > maxLife){
            life = maxLife;
        }
        if(life <= 0){
            gp.gameState = gp.gameOverState;
            gp.ui.commandNum = -1;
           // gp.stopMusic();
            gp.playSE(6);
        }

        if(gp.player.worldX == 41 && gp.player.worldY == 27 || gp.player.worldY == 28 || gp.player.worldY == 29 || gp.player.worldY == 30){
            gp.gameState = gp.FinishState;
            gp.ui.commandNum = -1;
            gp.stopMusic();
            gp.playSE(8);

        }

    }

    public void pickUpObject(int i){

        if(i != 999) {

           // gp.gameState = gp.dialogueState;
        }

    }

    public void contactMonster(int i){
        if(i != 999){

            if(invincible == false && gp.monster[gp.currentMap][i].dying == false){

                int damage = gp.monster[gp.currentMap][i].attack - 1;//defense;
                if(damage < 0){
                    damage = 0;
                }
                gp.playSE(4);
                life -= damage;
                invincible = true;
            }
        }
    }
    public void damageMonster(int i,int attack){

        if( i!=999){
            if(gp.monster[gp.currentMap][i].invincible == false){
                int damage = attack - gp.monster[gp.currentMap][i].defense;
                if(damage < 0){
                    damage = 0;
                }
                gp.playSE(3);
                gp.monster[gp.currentMap][i].life -= damage;

                gp.monster[gp.currentMap][i].invincible = true;
                gp.monster[gp.currentMap][i].damageReaction();

                if(gp.monster[gp.currentMap][i].life <=0){
                    gp.monster[gp.currentMap][i].dying = true;
                    exp += gp.monster[gp.currentMap][i].exp;
                    //checkLevelUp(0);
                }
            }
        }
    }

    public void draw(Graphics2D g2){

        BufferedImage image = null;


        switch(direction){
            case "up":
                if(spriteNum == 1){
                    if(keyH.spacePressed == true)
                    {
                        image = up1f;
                        gp.playSE(2);

                    }
                    else {
                        image = up1;
                    }
                }
                if(spriteNum == 2){
                    if(keyH.spacePressed == true)
                    {
                        image = up2f;
                        gp.playSE(2);

                    }
                    else {
                        image = up2;
                    }
                }
                if(spriteNum == 3){
                    if(keyH.spacePressed == true) {
                        image = up3f;
                        gp.playSE(2);
                    }
                    else {
                        image = up3;
                    }
                }
                if(spriteNum == 4){
                    if(keyH.spacePressed == true)
                    {
                        image = up4f;
                        gp.playSE(2);

                    }
                    else {
                        image = up4;
                    }
                }
                break;
            case "down":
                if(spriteNum == 1){
                    if(keyH.spacePressed == true)
                    {
                        image = down1f;
                        gp.playSE(2);
                    }
                    else {
                        image = down1;
                    }
                }
                if(spriteNum == 2){
                    if(keyH.spacePressed == true)
                    {
                        image = down2f;
                        gp.playSE(2);
                    }
                    else {
                        image = down2;
                    }
                }
                if(spriteNum == 3){
                    if(keyH.spacePressed == true)
                    {
                        image = down3f;
                        gp.playSE(2);
                    }
                    else {
                        image = down3;
                    }
                }
                if(spriteNum == 4){
                    if(keyH.spacePressed == true)
                    {
                        image = down4f;
                        gp.playSE(2);
                    }
                    else {
                        image = down4;
                    }
                }
                break;
            case "left":
                if(spriteNum == 1){
                    if(keyH.spacePressed == true)
                    {
                        image = left1f;
                        gp.playSE(2);
                    }
                    else {
                        image = left1;
                    }
                }
                if(spriteNum == 2){
                    if(keyH.spacePressed == true)
                    {
                        image = left2f;
                        gp.playSE(2);
                    }
                    else {
                        image = left2;
                    }
                }
                if(spriteNum == 3){
                    if(keyH.spacePressed == true)
                    {
                        image = left3f;
                        gp.playSE(2);
                    }
                    else {
                        image = left3;
                    }
                }
                if(spriteNum == 4){
                    if(keyH.spacePressed == true)
                    {
                        image = left4f;
                        gp.playSE(2);
                    }
                    else {
                        image = left4;
                    }
                }
                break;
            case "right":
                if(spriteNum == 1){
                    if(keyH.spacePressed == true)
                    {
                        image = right1f;
                        gp.playSE(2);
                    }
                    else {
                        image = right1;
                    }
                }
                if(spriteNum == 2){
                    if(keyH.spacePressed == true)
                    {
                        image = right2f;
                        gp.playSE(2);
                    }
                    else {
                        image = right2;
                    }
                }
                if(spriteNum == 3){
                    if(keyH.spacePressed == true)
                    {
                        image = right3f;
                        gp.playSE(2);
                    }
                    else {
                        image = right3;
                    }
                }
                if(spriteNum == 4){
                    if(keyH.spacePressed == true)
                    {
                        image = right4f;
                        gp.playSE(2);
                    }
                    else {
                        image = right4;
                    }
                }
                break;
        }

       if(invincible == true)
       {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.3f));
        }

        g2.drawImage(image, screenX , screenY ,null);

        // Reset alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
    }
}
