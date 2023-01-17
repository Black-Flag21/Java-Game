package main;

import java.sql.*;

public class DataBase {
    GamePanel gp;

    public DataBase(GamePanel gp) {
        this.gp = gp;
    }

    public void saveConfig() {

        Connection c;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:CONFIG.db");
            c.setAutoCommit(false);

            int coin = gp.player.coin;
            int level = gp.player.level;
            int maxLife = gp.player.maxLife;
            int life = gp.player.life;
            int exp = gp.player.exp;
            int nextLevelExp = gp.player.nextLevelExp;
            int strength = gp.player.strength;
            int dexterity = gp.player.dexterity;

            String sql = "INSERT INTO CONFIG (Coin,Level,maxLife,life,EXP,NextLevelExp,Strength,Dexterity)" + "VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement update = c.prepareStatement(sql);
            update.setInt(1,coin);
            update.setInt(2,level);
            update.setInt(3,maxLife);
            update.setInt(4,life);
            update.setInt(5,exp);
            update.setInt(6,nextLevelExp);
            update.setInt(7,strength);
            update.setInt(8,dexterity);

            update.executeUpdate();
            update.close();
            c.commit();
            c.close();


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Records saved");


    }

    public void loadConfig() {

        Connection c;
        Statement s;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:CONFIG.db");
            c.setAutoCommit(false);
            s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM CONFIG");

            while (rs.next())
            {
                gp.player.coin = rs.getInt("Coin");
                gp.player.level = rs.getInt("Level");
                gp.player.maxLife = rs.getInt("maxLife");
                gp.player.life = rs.getInt("life");
                gp.player.exp = rs.getInt("EXP");
                gp.player.nextLevelExp = rs.getInt("NextLevelExp");
                gp.player.strength = rs.getInt("Strength");
                gp.player.dexterity = rs.getInt("Dexterity");
            }

            rs.close();
            s.close();

            c.commit();
            c.close();

        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records loaded");
    }
}
