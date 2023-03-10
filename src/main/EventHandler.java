package main;

import java.awt.*;

public class EventHandler {

    GamePanel gp;
    EventRect eventRect[][][];

    int previousEventX, previousEventY;
    boolean canTouchEvent = true;

    public EventHandler(GamePanel gp){
        this.gp = gp;

        eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];

        int map = 0;
        int col = 0;
        int row = 0;
        while(map < gp.maxMap && col< gp.maxWorldCol && row < gp.maxWorldRow){

            eventRect[map][col][row] = new EventRect();
            eventRect[map][col][row].x = 23;
            eventRect[map][col][row].y = 23;
            eventRect[map][col][row].width = 2;
            eventRect[map][col][row].height = 2;
            eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
            eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;

            col++;
            if(col == gp.maxWorldCol){
                col =0;
                row++;

                if(row == gp.maxWorldRow){
                    row=0;
                    map++;
                }
            }
        }

    }

    public void checkEvent(){

        //Check if the player character is more than 1 tile away from last event
        int xDistance = Math.abs(gp.player.worldX- previousEventX);
        int yDistance = Math.abs(gp.player.worldY- previousEventY);
        int distance = Math.max(xDistance,yDistance);//preia nr mai mare

        if(distance > gp.tileSize){
            canTouchEvent = true;
        }

        if(distance > gp.tileSize){
            canTouchEvent = true;
        }
        if(hit(0,46,34, "any")){
            gp.player.life = gp.player.maxLife;
        }
        if(hit(0,47,34, "any")){
            gp.player.life = gp.player.maxLife;
        }
        if(hit(1,47,37, "any")){
            gp.player.life = gp.player.maxLife;
        }
        if(hit(1,41,27, "any")){
            gp.gameState = gp.FinishState;
            gp.stopMusic();
            gp.playSE(8);
        }
        if(hit(1,41,28, "any")){
            gp.gameState = gp.FinishState;
            gp.stopMusic();
            gp.playSE(8);
        }
        if(hit(1,41,29, "any")){
            gp.gameState = gp.FinishState;
            gp.stopMusic();
            gp.playSE(8);
        }
        if(hit(1,41,30, "any")){
            gp.gameState = gp.FinishState;
            gp.stopMusic();
            gp.playSE(8);
        }


        if(canTouchEvent == true) {
            if (hit(0,30, 8, "right") == true) {
                damagePit(30, 8, gp.dialogueState);
            }
            else if (hit(0, 48, 37, "any") == true) {
                teleport(1, 45, 14);
            }
            else if (hit(1, 45, 14, "any") == true) {
                teleport(0, 48, 37);
            }

        }

    }

    public boolean hit(int map , int col , int row, String reqDirection){

        boolean hit = false;

        if(map == gp.currentMap) {

            gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
            gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
            eventRect[map][col][row].x = col * gp.tileSize + eventRect[map][col][row].x;
            eventRect[map][col][row].y = row * gp.tileSize + eventRect[map][col][row].y;

            if (gp.player.solidArea.intersects(eventRect[map][col][row]) && eventRect[map][col][row].eventDone == false) {
                if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) ;
                {
                    hit = true;

                    previousEventX = gp.player.worldX;
                    previousEventY = gp.player.worldY;
                }
            }

            gp.player.solidArea.x = gp.player.solidAreaDefaultX;
            gp.player.solidArea.y = gp.player.solidAreaDefaultY;
            eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
            eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
        }

        return hit;
    }

    public void damagePit(int col, int row, int gameState){

        gp.gameState = gameState;
        gp.ui.currentDialogue = "Te-ai lovit";
        gp.player.life -= 1;
        eventRect[gp.currentMap][col][row].eventDone = true;
        canTouchEvent = false;
    }

    public void healingPool(int gameState){

        if(gp.keyH.enterPressed == true){
            gp.gameState = gameState;
            gp.player.attackCancel = true;
            gp.ui.currentDialogue = "Life recovered";
            gp.player.life = gp.player.maxLife;
            gp.player.mana = gp.player.maxMana;
            gp.aSetter.setMonster();
        }
    }

    public void teleport(int map,int col,int row){

        gp.currentMap = map;
        gp.player.worldX = gp.tileSize * col;
        gp.player.worldY = gp.tileSize * row;
        previousEventX = gp.player.worldX;
        previousEventY = gp.player.worldY;
        canTouchEvent = false;
        gp.playSE(7);
    }
}
