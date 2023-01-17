package main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;

    public boolean upPressed, downPressed, leftPressed, rightPressed, shiftPressed, spacePressed , enterPressed, shotKeyPressed;

    // DEBUG
    boolean showDebugText = false;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        // TITLE STATE
        if(gp.gameState == gp.titleState){
            titleState(code);
        }

        //PLAY STATE
        else if (gp.gameState == gp.playState) {
            playState(code);
        }
        // PAUSE STATE
        else if (gp.gameState == gp.pauseState) {
            pauseState(code);
        }

        // DIALOGUE
        else if (gp.gameState == gp.dialogueState){
            dialogueState(code);
        }

        // CHARACTER STATE
        else if(gp.gameState == gp.characterState){
            characterState(code);
        }

        // OPTION STATE
        else if(gp.gameState == gp.optionState){
            optionsState(code);
        }
        else if(gp.gameState == gp.loadGameState){
            loadGameState(code);
        }

        // Game OVER STATE
        else if(gp.gameState == gp.gameOverState){
            gameOverState(code);
        }

        // FINISH GAME
        else if(gp.gameState == gp.FinishState){
            FinishState(code);
        }

    }

    public void titleState(int code){

        if(code == KeyEvent.VK_W){
            gp.ui.commandNum--;
            if(gp.ui.commandNum<0){
                gp.ui.commandNum = 2;
            }
        }
        if(code == KeyEvent.VK_S){
            gp.ui.commandNum++;
            if(gp.ui.commandNum>2){
                gp.ui.commandNum = 0;
            }
        }
        if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.gameState = gp.playState;
                gp.playMusic(0);
            }
            if(gp.ui.commandNum == 1){
                gp.gameState = gp.loadGameState;
            }
            if(gp.ui.commandNum == 2){
                System.exit(0);
            }
        }
    }

    public void playState(int code){

        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }

        if (code == KeyEvent.VK_P) {
              gp.gameState = gp.pauseState;
        }

        if(code == KeyEvent.VK_C){
            gp.gameState =gp.characterState;
        }

        if (code == KeyEvent.VK_SHIFT) {
            shiftPressed = true;
        }

        if (code == KeyEvent.VK_SPACE) {
            spacePressed = true;
            shotKeyPressed = true;
        }

        if (code == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }
        if (code == KeyEvent.VK_F) {
            shotKeyPressed = true;
        }
        if (code == KeyEvent.VK_ESCAPE) {
            gp.gameState = gp.optionState;
        }

        // DEBUG
        if (code == KeyEvent.VK_T) {
            if (showDebugText == false) {
                showDebugText = true;
            } else if (showDebugText == true) {
                showDebugText = false;
            }
        }

        if (code == KeyEvent.VK_R) {
            switch (gp.currentMap){
                case 0:
                    gp.tileM.loadMap("/maps/map01.txt",0);
                    break;
                case 1:
                    gp.tileM.loadMap("/maps/map02.txt",1);
                    break;

            }
        }
    }

    public void pauseState(int code){

        if(code == KeyEvent.VK_P){
            gp.gameState = gp.playState;
        }
    }

    public void dialogueState(int code){

        if(code == KeyEvent.VK_ENTER){
            gp.gameState = gp.playState;
        }
    }

    public void loadGameState(int code){

        if(code == KeyEvent.VK_ENTER){
            gp.config.loadConfig();
            gp.gameState = gp.playState;
        }
    }

    public void characterState(int code){

        if(code == KeyEvent.VK_C){
            gp.gameState = gp.playState;
        }
    }

    public void optionsState(int code){

        if(code == KeyEvent.VK_ESCAPE){
            gp.gameState = gp.playState;
        }

        if(code == KeyEvent.VK_ENTER){
            enterPressed = true;
        }

        int maxCommandNum = 0;
        switch (gp.ui.subState){
            case 0: maxCommandNum = 5;
            break;
            case 3: maxCommandNum = 1;
            break;
        }

        if(code == KeyEvent.VK_W){
            gp.ui.commandNum--;
            gp.playSE(5);
            if(gp.ui.commandNum < 0){
                gp.ui.commandNum = maxCommandNum;
            }
        }

        if(code == KeyEvent.VK_S){
            gp.ui.commandNum++;
            gp.playSE(5);
            if(gp.ui.commandNum > maxCommandNum){
                gp.ui.commandNum = 0;
            }
        }

        if(code == KeyEvent.VK_A) {
            if (gp.ui.subState == 0) {
                if (gp.ui.commandNum == 1 && gp.music.volumeSCale > 0) {
                    gp.music.volumeSCale--;
                    gp.music.checkVolume();
                    gp.playSE(5);
                }
                if (gp.ui.commandNum == 2 && gp.se.volumeSCale > 0) {
                    gp.se.volumeSCale--;
                    gp.playSE(5);
                }
            }
        }
        if(code == KeyEvent.VK_D){
            if(gp.ui.subState == 0){
                if(gp.ui.commandNum == 1 && gp.music.volumeSCale < 5){
                    gp.music.volumeSCale++;
                    gp.music.checkVolume();
                    gp.playSE(5);
                }
                if (gp.ui.commandNum == 2 && gp.se.volumeSCale < 5) {
                    gp.se.volumeSCale++;
                    gp.playSE(5);
                }
            }
        }

    }

    public void FinishState(int code){

        if(code == KeyEvent.VK_W){
            gp.ui.commandNum--;
            if(gp.ui.commandNum < 0){
                gp.ui.commandNum = 1;
            }
            gp.playSE(5);
        }

        if(code == KeyEvent.VK_S){
            gp.ui.commandNum++;
            if(gp.ui.commandNum > 1){
                gp.ui.commandNum = 0;
            }
            gp.playSE(5);
        }

        if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.config.saveConfig();
                gp.gameState = gp.titleState;
                gp.restart();
            }
        }
    }

    public void gameOverState(int code){

        if(code == KeyEvent.VK_W){
            gp.ui.commandNum--;
            if(gp.ui.commandNum < 0){
                gp.ui.commandNum = 1;
            }
            gp.playSE(5);
        }

        if(code == KeyEvent.VK_S){
            gp.ui.commandNum++;
            if(gp.ui.commandNum > 1){
                gp.ui.commandNum = 0;
            }
            gp.playSE(5);
        }

        if(code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.gameState = gp.playState;
                gp.retry();
                gp.playMusic(0);
            }
            else if(gp.ui.commandNum == 1){
                gp.config.saveConfig();
                gp.gameState = gp.titleState;
                gp.restart();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        // TITLE STATE
        if(gp.gameState == gp.playState){
            if(code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0){
                    gp.ui.commandNum = 2;
                }
            }

            if(code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 2){
                    gp.ui.commandNum = 0;
                }
            }

            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                    gp.retry();
                }

                if(gp.ui.commandNum == 1){
                    //add later
                }

                if(gp.ui.commandNum == 2){
                    System.exit(0);
                }
            }

        }
        if(code == KeyEvent.VK_W) {
            upPressed=false;
        }

        if(code == KeyEvent.VK_S) {
            downPressed=false;
        }

        if(code == KeyEvent.VK_A) {
            leftPressed=false;
        }

        if(code == KeyEvent.VK_D) {
            rightPressed=false;
        }

        if(code == KeyEvent.VK_SHIFT) {
            shiftPressed=false;
        }

        if(code == KeyEvent.VK_SPACE) {
            spacePressed=false;
            shotKeyPressed = false;
        }

        if(code == KeyEvent.VK_ENTER) {
            enterPressed=false;
        }

    }
}
