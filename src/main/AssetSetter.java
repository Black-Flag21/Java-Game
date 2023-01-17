package main;

import monster.MON_Angela;
import monster.MON_Private;
import object.OBJ_FirstAidKit;


public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
    }

    public void setMonster() {
        int mapNum = 0;
        gp.monster[mapNum][0] = new MON_Private(gp);
        gp.monster[mapNum][0].worldX = gp.tileSize * 28;
        gp.monster[mapNum][0].worldY = gp.tileSize * 28;

        gp.monster[mapNum][1] = new MON_Private(gp);
        gp.monster[mapNum][1].worldX = gp.tileSize * 24;
        gp.monster[mapNum][1].worldY = gp.tileSize * 27;

        gp.monster[mapNum][2] = new MON_Private(gp);
        gp.monster[mapNum][2].worldX = gp.tileSize*43;
        gp.monster[mapNum][2].worldY = gp.tileSize*36;

        gp.monster[mapNum][3] = new MON_Private(gp);
        gp.monster[mapNum][3].worldX = gp.tileSize*45;
        gp.monster[mapNum][3].worldY = gp.tileSize*35;

        gp.monster[mapNum][4] = new MON_Private(gp);
        gp.monster[mapNum][4].worldX = gp.tileSize*44;
        gp.monster[mapNum][4].worldY = gp.tileSize*34;


        mapNum = 1;

        gp.monster[mapNum][5] = new MON_Private(gp);
        gp.monster[mapNum][5].worldX = gp.tileSize*21;
        gp.monster[mapNum][5].worldY = gp.tileSize*16;

        gp.monster[mapNum][6] = new MON_Private(gp);
        gp.monster[mapNum][6].worldX = gp.tileSize*22;
        gp.monster[mapNum][6].worldY = gp.tileSize*27;

        gp.monster[mapNum][7] = new MON_Private(gp);
        gp.monster[mapNum][7].worldX = gp.tileSize*39;
        gp.monster[mapNum][7].worldY = gp.tileSize*36;

        gp.monster[mapNum][8] = new MON_Private(gp);
        gp.monster[mapNum][8].worldX = gp.tileSize*41;
        gp.monster[mapNum][8].worldY = gp.tileSize*38;

        gp.monster[mapNum][9] = new MON_Private(gp);
        gp.monster[mapNum][9].worldX = gp.tileSize*41;
        gp.monster[mapNum][9].worldY = gp.tileSize*26;

        gp.monster[mapNum][10] = new MON_Private(gp);
        gp.monster[mapNum][10].worldX = gp.tileSize*41;
        gp.monster[mapNum][10].worldY = gp.tileSize*31;

        gp.monster[mapNum][11] = new MON_Angela(gp);
        gp.monster[mapNum][11].worldX = gp.tileSize*43;
        gp.monster[mapNum][11].worldY = gp.tileSize*27;

    }
}

