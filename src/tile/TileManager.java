package tile;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;


public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][][];

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[7105];

        mapTileNum = new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];


        getTileImage();
        loadMap("/maps/map01.txt",0);
        loadMap("/maps/map02.txt",1);
    }

    public void getTileImage() {


            setup(0,"BlocPerete",true);
            setup(1,"podea",false);
            setup(2,"BlocPereteSimplu",false);
            setup(3998,"fakLVL01",false);
            setup(3999,"fakLVL02",false);
            setup(4000,"BlocLvl",false);
            setup(7101,"ss",false);
            setup(7102,"ds",false);
            setup(7103,"sj",false);
            setup(7104,"dj",false);


            setup(3,"0-3",false);
            setup(4,"0-4",false);
            setup(5,"0-5",false);
            setup(6,"0-6",false);
            setup(7,"0-7",false);
            setup(8,"0-8",false);
            setup(9,"0-9",false);
            setup(10,"0-10",false);
            setup(11,"0-11",false);
            setup(12,"0-12",false);
            setup(13,"0-13",false);
            setup(14,"0-14",false);
            setup(15,"0-15",false);
            setup(16,"0-16",false);
            setup(17,"0-17",false);
            setup(18,"0-18",false);
            setup(19,"0-19",false);
            setup(20,"0-20",false);
            setup(21,"0-21",false);
            setup(22,"0-22",false);
            setup(23,"0-23",false);
            setup(24,"0-24",false);
            setup(25,"0-25",false);
            setup(26,"0-26",false);
            setup(27,"0-27",false);
            setup(28,"0-28",false);
            setup(29,"0-29",false);
            setup(30,"0-30",false);


            //SECOND LINE

            setup(103,"1-3",false);
            setup(104,"1-4",false);
            setup(105,"1-5",false);
            setup(106,"1-6",false);
            setup(107,"1-7",false);
            setup(108,"1-8",false);
            setup(109,"1-9",false);
            setup(110,"1-10",false);
            setup(111,"1-11",false);
            setup(112,"1-12",false);
            setup(113,"1-13",false);
            setup(114,"1-14",false);
            setup(115,"1-15",false);
            setup(116,"1-16",false);
            setup(117,"1-17",false);
            setup(118,"1-18",false);
            setup(119,"1-19",false);
            setup(120,"1-20",false);
            setup(121,"1-21",false);
            setup(122,"1-22",false);
            setup(123,"1-23",false);
            setup(124,"1-24",false);
            setup(125,"1-25",false);
            setup(126,"1-26",false);
            setup(127,"1-27",true);
            setup(128,"1-28",true);
            setup(129,"1-29",true);
            setup(130,"1-30",true);

            //THIRD LINE

            setup(201,"2-1",true);
            setup(202,"2-2",true);
            setup(203,"2-3",false);
            setup(204,"2-4",false);
            setup(205,"2-5",false);
            setup(206,"2-6",false);
            setup(207,"2-7",false);
            setup(208,"2-8",false);
            setup(209,"2-9",false);
            setup(210,"2-10",false);
            setup(211,"2-11",false);
            setup(212,"2-12",false);
            setup(213,"2-13",false);
            setup(214,"2-14",false);
            setup(215,"2-15",false);
            setup(216,"2-16",false);
            setup(217,"2-17",false);
            setup(218,"2-18",false);
            setup(219,"2-19",false);
            setup(220,"2-20",false);
            setup(221,"2-21",false);
            setup(222,"2-22",false);
            setup(223,"2-23",false);
            setup(224,"2-24",false);
            setup(225,"2-25",false);
            setup(226,"2-26",false);
            setup(227,"2-27",true);
            setup(228,"2-28",false);
            setup(229,"2-29",false);
            setup(230,"2-30",false);

            //FORTH LINE
            setup(301,"3-1",false);
            setup(302,"3-2",false);
            setup(303,"3-3",true);
            setup(304,"3-4",true);
            setup(305,"3-5",true);
            setup(306,"3-6",true);
            setup(307,"3-7",true);
            setup(308,"3-8",true);
            setup(309,"3-9",true);
            setup(310,"3-10",true);
            setup(311,"3-11",true);
            setup(312,"3-12",true);
            setup(313,"3-13",true);
            setup(314,"3-14",true);
            setup(315,"3-15",true);
            setup(316,"3-16",true);
            setup(317,"3-17",true);
            setup(318,"3-18",true);
            setup(319,"3-19",true);
            setup(320,"3-20",true);
            setup(321,"3-21",true);
            setup(322,"3-22",true);
            setup(323,"3-23",true);
            setup(324,"3-24",true);
            setup(325,"3-25",true);
            setup(326,"3-26",true);
            setup(327,"3-27",true);

            //FIFTH LINE

            setup(401,"4-1",false);
            setup(402,"4-2",false);
            setup(403,"4-3",false);
            setup(404,"4-4",false);
            setup(405,"4-5",false);
            setup(406,"4-6",false);
            setup(407,"4-7",false);
            setup(408,"4-8",false);
            setup(409,"4-9",false);
            setup(410,"4-10",false);
            setup(411,"4-11",false);
            setup(412,"4-12",false);
            setup(413,"4-13",false);
            setup(414,"4-14",false);
            setup(415,"4-15",false);
            setup(416,"4-16",false);
            setup(417,"4-17",false);
            setup(418,"4-18",false);
            setup(419,"4-19",false);
            setup(420,"4-20",false);
            setup(421,"4-21",false);
            setup(422,"4-22",false);
            setup(423,"4-23",false);
            setup(424,"4-24",false);
            setup(425,"4-25",false);
            setup(426,"4-26",false);
            setup(427,"4-27",false);
            //SIXTH LINE


            setup(503,"5-3",false);
            setup(504,"5-4",false);
            setup(505,"5-5",false);
            setup(506,"5-6",false);
            setup(507,"5-7",false);
            setup(508,"5-8",false);
            setup(509,"5-9",false);
            setup(510,"5-10",false);
            setup(511,"5-11",false);
            setup(512,"5-12",false);
            setup(513,"5-13",false);
            setup(514,"5-14",false);
            setup(515,"5-15",false);
            setup(516,"5-16",false);
            setup(517,"5-17",false);
            setup(518,"5-18",false);
            setup(519,"5-19",false);
            setup(520,"5-20",false);
            setup(521,"5-21",false);
            setup(522,"5-22",false);
            setup(523,"5-23",false);
            setup(524,"5-24",false);
            setup(525,"5-25",false);
            setup(526,"5-26",false);
            setup(527,"5-27",false);

            //10 LINE

            setup(1001,"10-1",true);
            setup(1002,"10-2",true);
            setup(1009,"10-9",true);
            setup(1010,"10-10",true);
            setup(1011,"10-11",true);
            setup(1012,"10-12",true);
            setup(1013,"10-13",true);
            setup(1014,"10-14",true);

            //11 LINE


            setup(1101,"11-1",false);
            setup(1102,"11-2",false);
            setup(1103,"11-3",false);
            setup(1104,"11-4",false);
            setup(1105,"11-5",false);
            setup(1106,"11-6",false);
            setup(1107,"11-7",false);
            setup(1108,"11-8",false);
            setup(1109,"11-9",false);
            setup(1110,"11-10",false);
            setup(1111,"11-11",false);
            setup(1112,"11-12",false);
            setup(1113,"11-13",false);
            setup(1114,"11-14",false);
            setup(1119,"11-19",false);
            setup(1120,"11-20",false);

            //12 LINE

            setup(1201,"12-1",true);
            setup(1202,"12-2",true);
            setup(1203,"12-3",false);
            setup(1204,"12-4",false);
            setup(1205,"12-5",false);
            setup(1206,"12-6",false);
            setup(1207,"12-7",false);
            setup(1208,"12-8",false);
            setup(1209,"12-09",false);
            setup(1210,"12-10",false);
            setup(1211,"12-11",false);
            setup(1212,"12-12",false);
            setup(1213,"12-13",false);
            setup(1214,"12-14",false);
            setup(1216,"12-16",false);
            setup(1217,"12-17",false);
            setup(1218,"12-18",false);
            setup(1219,"12-19",false);
            setup(1220,"12-20",false);

            //13 LINE

            setup(1301,"13-1",false);
            setup(1302,"13-2",false);
            setup(1303,"13-3",true);
            setup(1304,"13-4",true);
            setup(1305,"13-5",true);
            setup(1306,"13-6",true);
            setup(1307,"13-7",true);
            setup(1308,"13-8",true);
            setup(1310,"13-10",true);
            setup(1311,"13-11",true);
            setup(1312,"13-12",true);
            setup(1313,"13-13",true);
            setup(1316,"13-16",true);
            setup(1317,"13-17",true);
            setup(1318,"13-18",true);
            setup(1319,"13-19",true);
            setup(1320,"13-20",true);

            //14LINE

            setup(1401,"14-1",false);
            setup(1402,"14-2",false);
            setup(1403,"14-3",false);
            setup(1404,"14-4",false);
            setup(1405,"14-5",true);
            setup(1406,"14-6",true);
            setup(1407,"14-7",true);
            setup(1408,"14-8",false);
            setup(1410,"14-10",false);
            setup(1411,"14-11",false);
            setup(1412,"14-12",false);
            setup(1413,"14-13",false);
            setup(1416,"14-16",false);
            setup(1417,"14-17",false);
            setup(1418,"14-18",false);
            setup(1419,"14-19",false);
            setup(1420,"14-20",false);
            //setup(1421,"14-21",false);

            //16 LINE

            setup(1505,"15-5",false);
            setup(1506,"15-6",false);

            //17 LINE

            setup(1605,"16-5",false);
            setup(1606,"16-6",false);

            //24 LINE

            setup(2310,"23-10",true);
            setup(2311,"23-11",true);
            setup(2317,"23-17",true);
            setup(2318,"23-18",true);
            setup(2322,"23-22",true);
            setup(2323,"23-23",true);
            setup(2324,"23-24",true);
            setup(2325,"23-25",true);
            setup(2326,"23-26",true);
            setup(2327,"23-27",true);

            //25 LINE

            setup(2410,"24-10",true);
            setup(2411,"24-11",true);
            setup(2416,"24-16",true);
            setup(2417,"24-17",true);
            setup(2418,"24-18",true);
            setup(2419,"24-19",true);
            setup(2422,"24-22",true);
            setup(2423,"24-23",true);
            setup(2424,"24-24",true);
            setup(2425,"24-25",true);
            setup(2426,"24-26",true);
            setup(2427,"24-27",true);

            //26 LINE

            setup(2509,"25-9",false);
            setup(2510,"25-10",true);
            setup(2511,"25-11",true);
            setup(2514,"25-14",true);
            setup(2515,"25-15",true);
            setup(2516,"25-16",true);
            setup(2517,"25-17",true);
            setup(2518,"25-18",true);
            setup(2519,"25-19",true);
            setup(2520,"25-20",true);
            setup(2521,"25-21",true);
            setup(2522,"25-22",false);
            setup(2523,"25-23",false);
            setup(2524,"25-24",false);
            setup(2525,"25-25",false);
            setup(2526,"25-26",false);
            setup(2527,"25-27",false);

            //27 line

            setup(2609,"26-9",false);
            setup(2610,"26-10",false);
            setup(2611,"26-11",false);
            setup(2614,"26-14",true);
            setup(2615,"26-15",true);
            setup(2616,"26-16",true);
            setup(2617,"26-17",true);
            setup(2618,"26-18",true);
            setup(2619,"26-19",true);
            setup(2620,"26-20",true);
            setup(2621,"26-21",true);
            setup(2622,"26-22",false);

            ///28 LINE

            setup(2709,"27-9",false);
            setup(2710,"27-10",false);
            setup(2711,"27-11",false);
            setup(2714,"27-14",false);
            setup(2715,"27-15",false);
            setup(2716,"27-16",false);
            setup(2717,"27-17",false);
            setup(2718,"27-18",false);
            setup(2719,"27-19",false);
            setup(2720,"27-20",false);
            setup(2721,"27-21",false);
            setup(2722,"27-22",false);

            //29 LINE

            setup(2801,"28-1",false);
            setup(2802,"28-2",false);
            setup(2816,"28-16",false);
            setup(2817,"28-17",false);
            setup(2819,"28-19",false);

            //30 Line

            setup(2901,"29-1",true);
            setup(2902,"29-2",false);

            //31 LINE

            setup(3001,"30-1",true);
            setup(3002,"30-2",false);
            setup(3014,"30-14",true);
            setup(3015,"30-15",true);
            setup(3016,"30-16",true);

            //32 LINE

            setup(3101,"31-1",true);
            setup(3102,"31-2",false);
            setup(3114,"31-14",true);
            setup(3115,"31-15",true);
            setup(3116,"31-16",true);

            // 2 MAP
            setup(3200,"Zid2",true);
            setup(3201,"Zid2",false);
            setup(3202,"Pod",false);

            // 1 LINE
            setup(4001,"1.0-1",false);
            setup(4002,"1.0-2",false);
            setup(4003,"1.0-3",false);
            setup(4004,"1.0-4",false);
            setup(4005,"1.0-5",false);
            setup(4006,"1.0-6",false);
            setup(4007,"1.0-7",false);
            setup(4008,"1.0-8",false);
            setup(4009,"1.0-9",false);
            setup(4010,"1.0-10",false);
            setup(4011,"1.0-11",false);
            setup(4012,"1.0-12",false);
            setup(4013,"1.0-13",false);
            setup(4014,"1.0-14",false);
            setup(4015,"1.0-15",false);
            setup(4016,"1.0-16",false);
            setup(4017,"1.0-17",false);
            setup(4018,"1.0-18",false);
            setup(4019,"1.0-19",false);
            setup(4020,"1.0-20",false);
            setup(4021,"1.0-21",false);
            setup(4022,"1.0-22",false);
            setup(4023,"1.0-23",false);
            setup(4024,"1.0-24",false);
            setup(4025,"1.0-25",false);
            setup(4027,"1.0-27",false);
            setup(4028,"1.0-28",false);
            setup(4029,"1.0-29",false);

            // 2 LINE
            setup(4101,"1.1-1",false);
            setup(4102,"1.1-2",false);
            setup(4103,"1.1-3",false);
            setup(4104,"1.1-4",false);
            setup(4105,"1.1-5",false);
            setup(4106,"1.1-6",false);
            setup(4107,"1.1-7",false);
            setup(4108,"1.1-8",false);
            setup(4109,"1.1-9",false);
            setup(4110,"1.1-10",false);
            setup(4111,"1.1-11",false);
            setup(4112,"1.1-12",false);
            setup(4113,"1.1-13",false);
            setup(4114,"1.1-14",false);
            setup(4115,"1.1-15",false);
            setup(4116,"1.1-16",false);
            setup(4117,"1.1-17",false);
            setup(4118,"1.1-18",false);
            setup(4119,"1.1-19",false);
            setup(4120,"1.1-20",false);
            setup(4121,"1.1-21",false);
            setup(4122,"1.1-22",false);
            setup(4123,"1.1-23",false);
            setup(4124,"1.1-24",false);
            setup(4125,"1.1-25",false);
            setup(4126,"1.1-26",false);
            setup(4127,"1.1-27",false);
            setup(4128,"1.1-28",false);
            setup(4129,"1.1-29",false);
            setup(4130,"1.1-30",false);

            // 3 LINE
            setup(4201,"1.2-1",false);
            setup(4202,"1.2-2",false);
            setup(4203,"1.2-3",false);
            setup(4204,"1.2-4",false);
            setup(4205,"1.2-5",false);
            setup(4206,"1.2-6",false);
            setup(4207,"1.2-7",false);
            setup(4208,"1.2-8",false);
            setup(4209,"1.2-9",false);
            setup(4210,"1.2-10",false);
            setup(4211,"1.2-11",false);
            setup(4212,"1.2-12",false);
            setup(4213,"1.2-13",false);
            setup(4214,"1.2-14",false);
            setup(4215,"1.2-15",false);
            setup(4216,"1.2-16",false);
            setup(4217,"1.2-17",false);
            setup(4218,"1.2-18",false);
            setup(4219,"1.2-19",false);
            setup(4220,"1.2-20",false);
            setup(4221,"1.2-21",false);
            setup(4222,"1.2-22",false);
            setup(4223,"1.2-23",false);
            setup(4224,"1.2-24",false);
            setup(4225,"1.2-25",false);
            setup(4226,"1.2-26",false);
            setup(4227,"1.2-27",false);
            setup(4228,"1.2-28",false);
            setup(4229,"1.2-29",false);
            setup(4230,"1.2-30",false);

            // 4 LINE
            setup(4301,"1.3-1",true);
            setup(4302,"1.3-2",true);
            setup(4303,"1.3-3",true);
            setup(4304,"1.3-4",true);
            setup(4305,"1.3-5",true);
            setup(4306,"1.3-6",true);
            setup(4307,"1.3-7",true);
            setup(4308,"1.3-8",true);
            setup(4309,"1.3-9",true);
            setup(4310,"1.3-10",true);
            setup(4311,"1.3-11",true);
            setup(4312,"1.3-12",true);
            setup(4313,"1.3-13",true);
            setup(4314,"1.3-14",true);
            setup(4315,"1.3-15",true);
            setup(4316,"1.3-16",true);
            setup(4317,"1.3-17",true);
            setup(4318,"1.3-18",true);
            setup(4319,"1.3-19",true);
            setup(4320,"1.3-20",true);
            setup(4321,"1.3-21",true);
            setup(4322,"1.3-22",true);
            setup(4323,"1.3-23",true);
            setup(4324,"1.3-24",true);
            setup(4325,"1.3-25",true);
            setup(4326,"1.3-26",true);
            setup(4327,"1.3-27",true);
            setup(4328,"1.3-28",true);
            setup(4329,"1.3-29",true);
            setup(4330,"1.3-30",true);

            // 5 LINE
            setup(4401,"1.4-1",false);
            setup(4402,"1.4-2",false);
            setup(4403,"1.4-3",false);
            setup(4404,"1.4-4",false);
            setup(4405,"1.4-5",false);
            setup(4406,"1.4-6",false);
            setup(4407,"1.4-7",false);
            setup(4408,"1.4-8",false);
            setup(4409,"1.4-9",false);
            setup(4410,"1.4-10",false);
            setup(4411,"1.4-11",false);
            setup(4412,"1.4-12",false);
            setup(4413,"1.4-13",false);
            setup(4414,"1.4-14",false);
            setup(4415,"1.4-15",false);
            setup(4416,"1.4-16",false);
            setup(4417,"1.4-17",false);
            setup(4418,"1.4-18",false);
            setup(4419,"1.4-19",false);
            setup(4420,"1.4-20",false);
            setup(4421,"1.4-21",false);
            setup(4422,"1.4-22",false);
            setup(4423,"1.4-23",false);
            setup(4424,"1.4-24",false);
            setup(4425,"1.4-25",false);
            setup(4426,"1.4-26",false);
            setup(4427,"1.4-27",true);
            setup(4429,"1.4-29",false);
            setup(4430,"1.4-30",true);

            // 6 LINE
            setup(4501,"1.5-1",false);
            setup(4502,"1.5-2",false);
            setup(4503,"1.5-3",false);
            setup(4504,"1.5-4",false);
            setup(4505,"1.5-5",false);
            setup(4506,"1.5-6",false);
            setup(4507,"1.5-7",false);
            setup(4508,"1.5-8",false);
            setup(4509,"1.5-9",false);
            setup(4510,"1.5-10",false);
            setup(4511,"1.5-11",false);
            setup(4512,"1.5-12",false);
            setup(4513,"1.5-13",false);
            setup(4514,"1.5-14",false);
            setup(4515,"1.5-15",false);
            setup(4516,"1.5-16",false);
            setup(4517,"1.5-17",false);
            setup(4518,"1.5-18",false);
            setup(4519,"1.5-19",false);
            setup(4520,"1.5-20",false);
            setup(4521,"1.5-21",false);
            setup(4522,"1.5-22",false);
            setup(4523,"1.5-23",false);
            setup(4524,"1.5-24",false);

            // 10 LINE
            setup(4901,"1.9-1",true);
            setup(4902,"1.9-2",true);
            setup(4903,"1.9-3",true);
            setup(4904,"1.9-4",true);
            setup(4905,"1.9-5",true);
            setup(4906,"1.9-6",true);
            setup(4907,"1.9-7",true);

            // 11 LINE
            setup(5001,"1.10-1",false);
            setup(5002,"1.10-2",false);
            setup(5003,"1.10-3",false);
            setup(5004,"1.10-4",false);
            setup(5005,"1.10-5",false);
            setup(5006,"1.10-6",false);
            setup(5007,"1.10-7",false);
            setup(5015,"1.10-15",true);
            setup(5016,"1.10-16",true);
            setup(5017,"1.10-17",true);
            setup(5018,"1.10-18",false);
            setup(5019,"1.10-19",false);

            // 12 LINE
            setup(5101,"1.11-1",false);
            setup(5102,"1.11-2",false);
            setup(5103,"1.11-3",false);
            setup(5104,"1.11-4",false);
            setup(5105,"1.11-5",false);
            setup(5106,"1.11-6",false);
            setup(5107,"1.11-7",false);
            setup(5115,"1.11-15",true);
            setup(5116,"1.11-16",true);
            setup(5117,"1.11-17",true);
            setup(5118,"1.11-18",true);
            setup(5119,"1.11-19",true);
            setup(5120,"1.11-20",true);

            // 13 LINE
            setup(5201,"1.12-1",true);
            setup(5202,"1.12-2",true);
            setup(5203,"1.12-3",true);
            setup(5204,"1.12-4",true);
            setup(5205,"1.12-5",true);
            setup(5206,"1.12-6",true);
            setup(5207,"1.12-7",true);
            setup(5215,"1.12-15",true);
            setup(5216,"1.12-16",true);
            setup(5217,"1.12-17",true);
            setup(5218,"1.12-18",true);
            setup(5219,"1.12-19",true);
            setup(5220,"1.12-20",true);
            setup(5221,"1.12-21",true);
            setup(5222,"1.12-22",true);
            setup(5223,"1.12-23",true);
            setup(5224,"1.12-24",true);
            setup(5225,"1.12-25",true);
            setup(5226,"1.12-26",true);
            setup(5227,"1.12-27",true);
            setup(5228,"1.12-28",true);
            setup(5229,"1.12-29",true);
            setup(5230,"1.12-30",true);

            // 14 LINE
            setup(5301,"1.13-1",false);
            setup(5302,"1.13-2",false);
            setup(5303,"1.13-3",false);
            setup(5304,"1.13-4",false);
            setup(5305,"1.13-5",false);
            setup(5306,"1.13-6",false);
            setup(5307,"1.13-7",false);
            setup(5315,"1.13-15",false);
            setup(5316,"1.13-16",false);
            setup(5317,"1.13-17",false);
            setup(5318,"1.13-18",false);
            setup(5319,"1.13-19",false);
            setup(5320,"1.13-20",false);
            setup(5321,"1.13-21",false);
            setup(5322,"1.13-22",false);
            setup(5323,"1.13-23",false);
            setup(5324,"1.13-24",false);
            setup(5325,"1.13-25",false);
            setup(5326,"1.13-26",false);
            setup(5327,"1.13-27",false);
            setup(5328,"1.13-28",false);
            setup(5329,"1.13-29",false);
            setup(5330,"1.13-30",false);

            // 15 LINE
            setup(5401,"1.14-1",true);
            setup(5402,"1.14-2",true);
            setup(5415,"1.14-15",false);
            setup(5416,"1.14-16",false);
            setup(5417,"1.14-17",false);
            setup(5418,"1.14-18",false);
            setup(5419,"1.14-19",false);
            setup(5420,"1.14-20",false);
            setup(5421,"1.14-21",false);
            setup(5422,"1.14-22",false);
            setup(5423,"1.14-23",false);
            setup(5424,"1.14-24",false);
            setup(5425,"1.14-25",false);
            setup(5426,"1.14-26",false);
            setup(5427,"1.14-27",false);
            setup(5428,"1.14-28",false);
            setup(5429,"1.14-29",false);
            setup(5430,"1.14-30",false);

            // 16 LINE
            setup(5501,"1.15-1",true);
            setup(5502,"1.15-2",true);
            setup(5515,"1.15-15",true);
            setup(5516,"1.15-16",true);
            setup(5517,"1.15-17",true);
            setup(5518,"1.15-18",true);
            setup(5519,"1.15-19",true);
            setup(5520,"1.15-20",true);
            setup(5521,"1.15-21",true);
            setup(5522,"1.15-22",true);
            setup(5523,"1.15-23",true);
            setup(5524,"1.15-24",true);
            setup(5525,"1.15-25",true);
            setup(5526,"1.15-26",true);
            setup(5527,"1.15-27",true);
            setup(5528,"1.15-28",true);
            setup(5529,"1.15-29",false);
            setup(5530,"1.15-30",false);

            // 17 LINE
            setup(5601,"1.16-1",true);
            setup(5602,"1.16-2",true);
            setup(5603,"1.16-3",true);
            setup(5615,"1.16-15",false);
            setup(5616,"1.16-16",false);
            setup(5617,"1.16-17",false);
            setup(5618,"1.16-18",false);
            setup(5619,"1.16-19",false);
            setup(5620,"1.16-20",false);
            setup(5621,"1.16-21",false);
            setup(5622,"1.16-22",false);
            setup(5623,"1.16-23",false);
            setup(5624,"1.16-24",false);
            setup(5625,"1.16-25",false);
            setup(5626,"1.16-26",false);
            setup(5627,"1.16-27",false);
            setup(5628,"1.16-28",true);
            setup(5629,"1.16-29",false);
            setup(5630,"1.16-30",false);

            // 18 LINE
            setup(5701,"1.17-1",true);
            setup(5702,"1.17-2",true);
            setup(5703,"1.17-3",true);
            setup(5715,"1.17-15",false);
            setup(5716,"1.17-16",false);
            setup(5717,"1.17-17",false);
            setup(5718,"1.17-18",false);
            setup(5719,"1.17-19",false);
            setup(5720,"1.17-20",false);
            setup(5721,"1.17-21",false);
            setup(5722,"1.17-22",false);
            setup(5723,"1.17-23",false);
            setup(5724,"1.17-24",false);
            setup(5725,"1.17-25",false);
            setup(5726,"1.17-26",false);
            setup(5727,"1.17-27",false);
            setup(5728,"1.17-28",true);
            setup(5729,"1.17-29",false);
            setup(5730,"1.17-30",false);

            // 19 LINE
            setup(5801,"1.18-1",true);
            setup(5802,"1.18-2",true);
            setup(5803,"1.18-3",true);
            setup(5828,"1.18-28",true);
            setup(5829,"1.18-29",false);
            setup(5830,"1.18-30",false);

            // 20 LINE
            setup(5901,"1.19-1",true);
            setup(5902,"1.19-2",true);
            setup(5928,"1.19-28",true);
            setup(5929,"1.19-29",false);
            setup(5930,"1.19-30",false);

            // 21 LINE
            setup(6001,"1.20-1",true);
            setup(6002,"1.20-2",true);
            setup(6003,"1.20-3",true);
            setup(6028,"1.20-28",true);
            setup(6029,"1.20-29",false);
            setup(6030,"1.20-30",false);

            // 22 LINE
            setup(6101,"1.21-1",true);
            setup(6102,"1.21-2",true);
            setup(6103,"1.21-3",true);
            setup(6111,"1.21-11",true);
            setup(6112,"1.21-12",true);
            setup(6113,"1.21-13",true);
            setup(6114,"1.21-14",true);
            setup(6128,"1.21-28",true);
            setup(6129,"1.21-29",false);
            setup(6130,"1.21-30",false);

            // 23 LINE
            setup(6201,"1.22-1",true);
            setup(6202,"1.22-2",true);
            setup(6203,"1.22-3",true);
            setup(6211,"1.22-11",true);
            setup(6212,"1.22-12",true);
            setup(6213,"1.22-13",true);
            setup(6214,"1.22-14",true);
            setup(6228,"1.22-28",true);
            setup(6229,"1.22-29",false);
            setup(6230,"1.22-30",false);

            // 24 LINE
            setup(6301,"1.23-1",false);
            setup(6302,"1.23-2",false);
            setup(6303,"1.23-3",false);
            setup(6311,"1.23-11",false);
            setup(6312,"1.23-12",false);
            setup(6313,"1.23-13",true);
            setup(6314,"1.23-14",false);
            setup(6328,"1.23-28",true);
            setup(6329,"1.23-29",false);
            setup(6330,"1.23-30",false);

            // 25 LINE
            setup(6413,"1.24-13",false);
            setup(6415,"1.24-15",true);
            setup(6418,"1.24-18",true);
            setup(6423,"1.24-23",true);
            setup(6424,"1.24-24",true);
            setup(6425,"1.24-25",true);
            setup(6426,"1.24-26",true);
            setup(6427,"1.24-27",true);
            setup(6428,"1.24-28",true);

            // 26 LINE
            setup(6515,"1.25-15",true);
            setup(6518,"1.25-18",true);
            setup(6523,"1.25-23",true);
            setup(6524,"1.25-24",true);
            setup(6525,"1.25-25",true);
            setup(6526,"1.25-26",true);
            setup(6527,"1.25-27",true);
            setup(6528,"1.25-28",true);

            // 27 LINE
            setup(6615,"1.26-15",false);
            setup(6618,"1.26-18",false);
            setup(6623,"1.26-23",false);
            setup(6624,"1.26-24",false);
            setup(6625,"1.26-25",false);
            setup(6626,"1.26-26",false);
            setup(6627,"1.26-27",false);
            setup(6628,"1.26-28",false);

            // 28 LINE
            setup(6701,"1.27-1",false);
            setup(6702,"1.27-2",false);

            // 29 LINE
            setup(6801,"1.28-1",true);
            setup(6802,"1.28-2",true);

            // 30 LINE
            setup(6901,"1.29-1",true);
            setup(6902,"1.29-2",true);

            // 31 LINE
            setup(7001,"1.30-1",true);
            setup(7002,"1.30-2",true);


    }
    public void setup(int index,String imageName,boolean collision){

        UtilityTool uTool = new UtilityTool();

        try{
            tile[index] = new Tile();
            tile[index].image=ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName +".png"));
            tile[index].image= uTool.scaleImage(tile[index].image,gp.tileSize,gp.tileSize);
            tile[index].collision = collision;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath, int map) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

                String line = br.readLine();

                while (col < gp.maxWorldCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[map][col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        }
        catch (Exception e) {
        }
    }

    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            g2.drawImage(tile[tileNum].image, screenX, screenY , null);

            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;

            }
        }

    }
}
