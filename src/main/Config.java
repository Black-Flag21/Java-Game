package main;

import java.io.*;
import java.nio.Buffer;

public class Config {

    GamePanel gp;

    public  Config(GamePanel gp){
        this.gp = gp;
    }

    public void saveSalvare(){

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("salvare.txt"));

            // Full screen
            if(gp.fullScreenOn == true){
                bw.write("On");
            }
            if(gp.fullScreenOn == false){
                bw.write("Off");
            }
            bw.newLine();

            // Music volume
            bw.write(String.valueOf(gp.music.volumeSCale));
            bw.newLine();

            // SE volume
            bw.write(String.valueOf(gp.se.volumeSCale));
            bw.newLine();

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadSalvare(){

        try {
            BufferedReader br = new BufferedReader(new FileReader("salvare.txt"));

            String s = br.readLine();

            // Full screen
            if(s.equals("On")){
                gp.fullScreenOn = true;
            }

            if(s.equals("Off")){
                gp.fullScreenOn = false;
            }

            // Music volume
            s = br.readLine();
            gp.music.volumeSCale = Integer.parseInt(s);

            // SE volume
            s = br.readLine();
            gp.se.volumeSCale = Integer.parseInt(s);

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
