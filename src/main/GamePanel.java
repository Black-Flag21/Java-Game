package main;

import entity.Entity;
import entity.Player;
import tile.TileManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

    //SCREEN SETTINGS
    final int originalTitleSize=16;//16x16
    final int scale=2;
    public final int tileSize = originalTitleSize * scale;//32 X 32 tile
    public final int maxScreenCol = 32;
    public final int maxScreenRow = 18;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //FOR FULL SCREEN
    int screenWidth2 = screenWidth;
    int screenHeight2 = screenHeight;
    BufferedImage tempScreen;
    Graphics2D g2;
    public boolean fullScreenOn = false;


    // WORLD SETTINGS
    public final int maxWorldCol = 68;
    public final int maxWorldRow = 54;
    public final int maxMap = 2;
    public int currentMap = 0;

    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeigth = tileSize * maxWorldRow;
    //public DataBase db;

    // FPS
    int FPS = 60;

    // SYSTEM
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    DataBase config = new DataBase(this);
    Config save = new Config(this);
    Thread gameThread;

    //ENTITY OBJECT
    public Player player = new Player(this, keyH);
    public Entity obj[][] = new Entity[maxMap][10];
    public Entity npc[] = new Entity[10];
    public Entity monster[][] = new Entity[maxMap][20];
    public ArrayList<Entity> projectileList = new ArrayList<>();
    ArrayList<Entity> entityList = new ArrayList<>();

    //GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState= 4;
    public final int optionState = 5;
    public final int gameOverState = 6;
    public int loadGameState = 7;
    public final int FinishState = 8;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void setupGame(){

        aSetter.setObject();
        aSetter.setMonster();

        //playMusic(0);

        gameState = titleState;

        tempScreen = new BufferedImage(screenWidth,screenHeight,BufferedImage.TYPE_INT_ARGB);
        g2 = (Graphics2D)tempScreen.getGraphics();

        if(fullScreenOn == true) {
            setFullScreen();
        }

    }
    public void retry(){

        player.setDefaultPosition();
        player.restoreLifeAndMana();
        aSetter.setMonster();

    }

    public void restart(){

        player.setDefaultValues();
        player.setDefaultPosition();
        player.restoreLifeAndMana();
        aSetter.setMonster();
        aSetter.setObject();
    }

    public void setFullScreen(){

        // GET LOCAL SCREEN DEVICE
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(Main.window);

        // GET FULL SCREEN WINDOW
        screenWidth2 = Main.window.getWidth();
        screenHeight2 = Main.window.getHeight();
    }

    public void startGameThread(){

        gameThread=new Thread(this);
        gameThread.start();
    }

    public void run() {

        double drawInterval= 1000000000/FPS;
        double delta =0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer+=(currentTime - lastTime);
            lastTime= currentTime;

            if(delta >= 1) {
                update();
                drawToTempScreen(); // draw everything to the buffered image
                drawToScreen(); // draw the buffered image to the screen
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
               // System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }

    }

    public void update(){

        if(gameState == playState) {
            // PLAYER
            player.update();
            //SOLDIER
            for(int i = 0; i < monster[1].length; i++){
                if(monster[currentMap][i] != null){
                    if(monster[currentMap][i].alive == true && monster[currentMap][i].dying == false){
                        monster[currentMap][i].update();
                    }
                    if(monster[currentMap][i].alive == false){
                        monster[currentMap][i] = null;
                    }
                }
            }

            for(int i = 0; i < projectileList.size(); i++){
                if(projectileList.get(i).alive == true){
                    projectileList.get(i).update();
                }
                if(projectileList.get(i).alive == false){
                    projectileList.remove(i);
                }
            }
        }

        if(gameState == pauseState){
            // nothing
        }
        //db.saveConfig();
    }

    public void drawToTempScreen(){
        // DEBUG
        long drawStart = 0;
        if(keyH.showDebugText == true){
            drawStart = System.nanoTime();
        }

        // TITLE SCREEN
        if(gameState == titleState){
            ui.draw(g2);

        }
        // OTHERS
        else{
            // TILE
            tileM.draw(g2);

            // ADD ENTITY TO THE LIST
            entityList.add(player);

            for(int i = 0; i < obj[1].length; i++){
                if(obj[currentMap][i] != null){
                    entityList.add(obj[currentMap][i]);
                }
            }
            for(int i = 0; i < monster[1].length; i++){
                if(monster[currentMap][i] != null){
                    entityList.add(monster[currentMap][i]);
                }
            }

            for(int i = 0; i < projectileList.size(); i++){
                if(projectileList.get(i) != null){
                    entityList.add(projectileList.get(i));
                }
            }


            // SORT
            Collections.sort(entityList, new Comparator<Entity>() {
                @Override
                public int compare(Entity e1, Entity e2) {

                    int result = Integer.compare(e1.worldY,e2.worldY);
                    return result;
                }
            });

            // DRAW ENTITY LIST
            for(int i = 0; i < entityList.size(); i++){
                entityList.get(i).draw(g2);
            }

            // EMPTY ENTITY LIST
            entityList.clear();

            // UI
            ui.draw(g2);
        }

        if(keyH.showDebugText == true){
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;

            g2.setFont(new Font("Arial", Font.PLAIN,20));
            g2.setColor(Color.white);
            int x = 10;
            int y = 400;
            int lineHeight = 20;

            g2.drawString("WorldX " + player.worldX,x,y); y+= lineHeight;
            g2.drawString("WorldY " + player.worldY,x,y);y+= lineHeight;
            g2.drawString("Col " + (player.worldX + player.solidArea.x)/tileSize,x,y);
            y+= lineHeight;
            g2.drawString("Row " + (player.worldY + player.solidArea.y)/tileSize,x,y);
            y+= lineHeight;

            g2.drawString("Draw Time: " + passed,x,y);
            System.out.println("Draw Time: "+passed);
        }
        //db.saveConfig();
    }

    public void drawToScreen(){

        Graphics g = getGraphics();
        g.drawImage(tempScreen,0,0,screenWidth2,screenHeight2,null);
        g.dispose();
    }

    public void playMusic(int i){

        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic(){

        music.stop();
    }

    public void playSE(int i){

        se.setFile(i);
        se.play();
    }

}
