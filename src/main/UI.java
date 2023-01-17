package main;

import entity.Entity;
import object.OBJ_Heart;
import object.OBJ_FirstAidKit;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    BufferedImage heart_full, heart_half, heart_blank;
    Font arial_40, arial_80B;

    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinish = false;
    public int commandNum = 0;
    public String currentDialogue =" ";
    int subState = 0;

    public UI(GamePanel gp){
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD,80);

        // CREATE HUD OBJECT
        Entity heart = new OBJ_Heart(gp);
        heart_full = heart.image1;
        heart_half = heart.image2;
        heart_blank = heart.image3;

    }

    public void showMessage(String text){
        message = text;
        messageOn = true;

    }
    public void draw(Graphics2D g2){

       this.g2 = g2;

       g2.setFont(arial_40);
       g2.setColor(Color.white);

       // TITLE STATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }

       // PLAY STATE
       if(gp.gameState == gp.playState){
           drawPlayerLife();
       }

       // PAUSE STATE
       if(gp.gameState == gp.pauseState){
           drawPlayerLife();
           drawPauseScreen();
       }

        // DIALOGUE STATE
        if(gp.gameState == gp.dialogueState){
            drawPlayerLife();
            drawDialogueScreen();
        }
        // CHARACTER STATE
        if(gp.gameState == gp.characterState){
            drawCharacterScreen();
        }

        // OPTIONS STATE
        if(gp.gameState == gp.optionState){
            drawOptionsScreen();
        }

        // GAME OVER STATE
        if(gp.gameState == gp.gameOverState){
            drawGameOverScreen();
        }

        // FINISH STATE
        if(gp.gameState == gp.FinishState){
            drawFinishScreen();
        }

    }
    public void drawPlayerLife(){


        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;

        // DRAW MAX LIFE
        while(i< gp.player.maxLife/2){
            g2.drawImage(heart_blank,x,y,null);
            i++;
            x += gp.tileSize;
        }
        //RESET
        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i = 0;

        // DRAW CURRENT LIFE
        while(i < gp.player.life){
            g2.drawImage(heart_half,x,y,null);
            i++;
            if(i<gp.player.life){
                g2.drawImage(heart_full,x,y,null);
            }
            i++;
            x += gp.tileSize;
        }
    }
    public void drawTitleScreen(){

        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);


        // TITLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,80F));
        String text = "Andrew Reacher-Revenge";
        int x = getXforCenteredText(text);
        int y = gp.tileSize * 3;

        // SHADOW
        g2.setColor(Color.gray);
        g2.drawString(text,x+3,y+3);

        // MAIN COLOR
        g2.setColor(Color.white);
        g2.drawString(text,x,y);

        //REACHER IMAGE
        x = gp.screenWidth/2 - (gp.tileSize*2)/2;
        y += gp.tileSize*2;
        g2.drawImage(gp.player.right3f,x-50,y,gp.tileSize*6,gp.tileSize*6,null);

        // MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48f));

        text = "NEW GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize*9;
        g2.drawString(text,x,y);
        if(commandNum == 0){
            g2.drawString(">",x-gp.tileSize* 2,y);
        }

        text = "LOAD GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize*2;
        g2.drawString(text,x,y);
        if(commandNum == 1){
            g2.drawString(">",x-gp.tileSize*2,y);
        }

        text = "QUIT";
        x = getXforCenteredText(text);
        y += gp.tileSize*2;
        g2.drawString(text,x,y);
        if(commandNum == 2){
            g2.drawString(">",x-gp.tileSize*2,y);
        }


    }

    public void drawPauseScreen(){


        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text = "PAUSE";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight - 300;

        g2.drawString(text,x,y);
    }
    public void drawDialogueScreen(){

        // WINDOW
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;

        drawSubWindow(x,y,width,height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,32F));
        x += gp.tileSize;
        y += gp.tileSize;

        g2.drawString(currentDialogue,x,y);

    }
    public void drawCharacterScreen(){

        // CREATE A FRAME

        final int frameX = gp.tileSize;
        final int frameY = gp.tileSize;
        final int frameWidth = gp.tileSize*5;
        final int frameHeight = gp.tileSize*10;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);

        // TEXT
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(17F));

        int textX = frameX +20;
        int textY = frameY + gp.tileSize;
        final int lineHeight = 22;
        // NAMES
        g2.drawString("Level",textX,textY);
        textY+=lineHeight;
        g2.drawString("Life",textX,textY);
        textY+=lineHeight;
        g2.drawString("Strength",textX,textY);
        textY+=lineHeight;
        g2.drawString("Dexterity",textX,textY);
        textY+=lineHeight;
        g2.drawString("Attack",textX,textY);
        textY+=lineHeight;
        g2.drawString("Defense",textX,textY);
        textY+=lineHeight;
        g2.drawString("Exp",textX,textY);
        textY+=lineHeight;
        g2.drawString("Next Level",textX,textY);
        textY+=lineHeight;
        g2.drawString("Coin",textX,textY);
        textY+=lineHeight+10;
        g2.drawString("Weapon",textX,textY);
        textY+=lineHeight;
        g2.drawString("Shield",textX,textY);
        textY+=lineHeight;

        // VALUES

        int tailX= (frameX + frameWidth) - 30;
        //RESET textY

        textY = frameY + gp.tileSize;
        String value;

        value = String.valueOf(gp.player.level);
        textX = getXforAlignToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value = String.valueOf(gp.player.life + "/" + gp.player.maxLife );
        textX = getXforAlignToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value = String.valueOf(gp.player.strength);
        textX = getXforAlignToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value = String.valueOf(gp.player.dexterity);
        textX = getXforAlignToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value = String.valueOf(gp.player.attack);
        textX = getXforAlignToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value = String.valueOf(gp.player.defense);
        textX = getXforAlignToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value = String.valueOf(gp.player.exp);
        textX = getXforAlignToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value = String.valueOf(gp.player.nextLevelExp);
        textX = getXforAlignToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value = String.valueOf(gp.player.coin);
        textX = getXforAlignToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        g2.drawImage(gp.player.currentWeapon.down1,tailX - gp.tileSize , textY -14, null);
        textY += gp.tileSize;
        g2.drawImage(gp.player.currentShield.down1, tailX-gp.tileSize,textY -14,null);
    }

    public void drawFinishScreen(){
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,110f));

        text = "You saved Angela!";

        // Shadow
        g2.setColor(Color.black);
        x = getXforCenteredText(text);
        y = gp.tileSize*4;
        g2.drawString(text,x,y);

        // MAIN
        g2.setColor(Color.white);
        g2.drawString(text,x-4,y-4);

        g2.setFont(g2.getFont().deriveFont(50f));

        // Back to title screen
        text = "Quit";
        x = getXforCenteredText(text);
        y += 255;
        g2.drawString(text,x,y);

        if(commandNum == 0){
            g2.drawString(">",x-40,y);
        }

    }
    public void drawGameOverScreen(){

        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,110f));

        text = "Game Over";

        // Shadow
        g2.setColor(Color.black);
        x = getXforCenteredText(text);
        y = gp.tileSize*4;
        g2.drawString(text,x,y);

        // MAIn
        g2.setColor(Color.white);
        g2.drawString(text,x-4,y-4);

        // Retry
        g2.setFont(g2.getFont().deriveFont(50f));
        text = "Retry";
        x = getXforCenteredText(text);
        y+= gp.tileSize*4;
        g2.drawString(text,x,y);
        if(commandNum == 0){
            g2.drawString(">",x-40,y);
        }

        // Back to title screen

        text = "Quit";
        x = getXforCenteredText(text);
        y += 55;
        g2.drawString(text,x,y);

        if(commandNum == 1){
            g2.drawString(">",x-40,y);
        }
    }

    public void drawOptionsScreen(){

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(24F));

        //SUB WINDOW

        int frameX = gp.tileSize*12;
        int frameY = gp.tileSize*3;
        int frameWidth = gp.tileSize*13;
        int frameHeight = gp.tileSize*12;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);

        switch (subState){
            case 0:
                option_top(frameX,frameY);
                break;
            case 1:
                option_fullScreenNotification(frameX,frameY);
                break;
            case 2:
                options_control(frameX,frameY);
                break;
            case 3:
                options_endGameConfirmation(frameX,frameY);
                break;

        }

        gp.keyH.enterPressed = false;
    }

    public void option_top(int frameX, int frameY) {

        int textX;
        int textY;

        // TITLE
        String text = "Option";
        textX = getXforCenteredText(text)+30;
        textY = frameY + gp.tileSize + 5;
        g2.drawString(text,textX,textY);

        // FULL SCREEN ON/OFF
        textX = frameX + gp.tileSize;
        textY += gp.tileSize*2;
        g2.drawString("Full Screen",textX,textY);
        if(commandNum == 0){
            g2.drawString(">",textX - 23,textY);
            if(gp.keyH.enterPressed == true){
                if(gp.fullScreenOn == false){
                    gp.fullScreenOn = true;
                }
                else if(gp.fullScreenOn == true){
                    gp.fullScreenOn = false;
                }
                subState = 1;
            }

        }

        // MUSIC
        textY += gp.tileSize +15;
        g2.drawString("Music",textX,textY);
        if(commandNum == 1){
            g2.drawString(">",textX - 23,textY);
        }

        // SE
        textY += gp.tileSize +15;
        g2.drawString("SE",textX,textY);
        if(commandNum == 2){
            g2.drawString(">",textX - 23,textY);
        }

        // CONTROL
        textY += gp.tileSize +15;
        g2.drawString("Control",textX,textY);
        if(commandNum == 3){
            g2.drawString(">",textX - 23,textY);
            if(gp.keyH.enterPressed == true){
                subState = 2;
                commandNum = 0;
            }
        }

        // END GAME
        textY += gp.tileSize +15;
        g2.drawString("End Game",textX,textY);
        if(commandNum == 4){
            g2.drawString(">",textX - 23,textY);
            if(gp.keyH.enterPressed == true){
                subState = 3;
                commandNum = 0;
            }
        }

        // BACK
        textY += gp.tileSize*2;
        g2.drawString("Back",textX,textY);
        if(commandNum == 5){
            g2.drawString(">",textX - 23,textY);
            if(gp.keyH.enterPressed == true){
                gp.gameState = gp.playState;
                commandNum = 0;
            }
        }

        // FULL SCREEN CHECK BOX
        textX = frameX + gp.tileSize*8;
        textY = frameY + gp.tileSize*2+14;
        g2.setStroke(new BasicStroke((3)));
        g2.drawRect(textX,textY,24,24);
        if(gp.fullScreenOn == true){
            g2.fillRect(textX,textY,24,24);
        }


        // MUSIC VOLUME
        textY += gp.tileSize +15;
        g2.drawRect(textX,textY,120,24); // 120/5 = 24
        int volumeWidth = 24*gp.music.volumeSCale;
        g2.fillRect(textX,textY,volumeWidth,24);

        // SE VOLUME
        textY += gp.tileSize +15;
        g2.drawRect(textX ,textY,120,24);
        volumeWidth = 24*gp.se.volumeSCale;
        g2.fillRect(textX,textY,volumeWidth,24);

        gp.save.saveSalvare();
    }

    public void option_fullScreenNotification(int frameX,int frameY){

        int textX = frameX + gp.tileSize;
        int textY = frameY + gp.tileSize*3;

        currentDialogue = "The change will take \neffect after restarting \nthe game.";

        for(String line: currentDialogue.split("\n")){
            g2.drawString(line,textX,textY);
            textY += 40;
        }

        //BACK
        textY = frameY + gp.tileSize*11;
        g2.drawString("Back",textX,textY);
        if(commandNum == 0){
            g2.drawString(">",textX-25,textY);
            if(gp.keyH.enterPressed == true){
                subState = 0;
            }
        }
    }

    public void options_control(int frameX, int frameY){

        int textX;
        int textY;

        // TITLE
        String text = "Control";
        textX = getXforCenteredText(text);
        textY = frameY + gp.tileSize +10;
        g2.drawString(text,textX,textY);

        textX = frameX + gp.tileSize;
        textY += gp.tileSize+10;
        g2.drawString("Move",textX,textY);

        textY += gp.tileSize+10;
        g2.drawString("Confirm/Attack",textX,textY);

        textY += gp.tileSize+10;
        g2.drawString("Shoot/Cast",textX,textY);

        textY += gp.tileSize+10;
        g2.drawString("Character Screen",textX,textY);

        textY += gp.tileSize+10;
        g2.drawString("Pause",textX,textY);

        textY += gp.tileSize+10;
        g2.drawString("Options",textX,textY);
        textY += gp.tileSize+10;

        textX = frameX + gp.tileSize*9;
        textY = frameY + gp.tileSize*3-15;
        g2.drawString("WASD",textX,textY);
        textY += gp.tileSize+10;

        g2.drawString("ENTER",textX,textY);
        textY += gp.tileSize+10;

        g2.drawString("F",textX,textY);
        textY += gp.tileSize+10;

        g2.drawString("C",textX,textY);
        textY += gp.tileSize+10;

        g2.drawString("P",textX,textY);
        textY += gp.tileSize+10;

        g2.drawString("ESC",textX,textY);
        textY += gp.tileSize+10;

        // BACK

        textX = frameX + gp.tileSize;
        textY = frameY + gp.tileSize *11;
        g2.drawString("Back",textX,textY);
        if(commandNum == 0){
            g2.drawString(">", textX-23,textY);
            if(gp.keyH.enterPressed == true){
                subState = 0;
                commandNum = 3;
            }
        }
    }

    public void options_endGameConfirmation(int frameX, int frameY){

        int textX = frameX + gp.tileSize;
        int textY = frameY + gp.tileSize*3;

        currentDialogue = "Quit the game and \nreturn to the title screen?";

        for(String line: currentDialogue.split("\n")){
            g2.drawString(line,textX,textY);
            textY += 40;
        }

        // YES

        String text = "Yes";
        textX = getXforCenteredText(text);
        textY += gp.tileSize*3;
        g2.drawString(text,textX,textY);

        if(commandNum == 0){
            g2.drawString(">", textX-23,textY);
            if(gp.keyH.enterPressed == true){
                gp.config.saveConfig();
                subState = 0;
                gp.gameState = gp.titleState;
            }
        }


        // NO
        text = "No";
        textX = getXforCenteredText(text);
        textY += gp.tileSize;
        g2.drawString(text,textX,textY);

        if(commandNum == 1){
            g2.drawString(">", textX-23,textY);
            if(gp.keyH.enterPressed == true){
                subState = 0;
                commandNum = 4;
            }
        }
    }

    public void drawSubWindow(int x, int y, int width, int height){

        Color c = new Color(0,0,0,220);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width, height, 35,35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke( new BasicStroke(5));

        g2.drawRoundRect(x+5,y+5,width-10, height-10,25,25);
    }

    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }

    public int getXforAlignToRightText(String text, int tailX){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = tailX - length;
        return x;
    }
}
