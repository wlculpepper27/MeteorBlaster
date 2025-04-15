//Weston Culpepper
//03/28/25
//Comp167-003
//This is the main/driver class that is used to call all the methods that allow the program to output the final output.

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//
//        //MovingSprite Test
//        //MovingSprite ms = new MovingSprite();
//        //System.out.print(ms.toString());
//        System.out.print("\n");
//
//
//        //Torpedo Test
//        Torpedo t = new Torpedo();
//        System.out.print(t.toString());
//        System.out.print("\n");
//
//
//        //PhotonTorpedo Test
//        PhotonTorpedo pt = new PhotonTorpedo(0,0,0);
//        System.out.print(pt.toString());
//        System.out.print("\n");
//
//
//        //RadialBomb Test
//        RadialBomb rb = new RadialBomb(0,0,0);
//        System.out.print(rb.toString());
//        System.out.print("\n");
//
//
//        //Craft Test
//        CraftData cd = new CraftData();
//        cd.addImageFile("images/space.jpg");
//        Craft c = new Craft(cd);
//        System.out.print(c.toString());
//        c.addTorpedo(pt);
//        c.rotate(30);
//        System.out.print(c.getTorpedoSize());
//        System.out.print(c.getTorpedo(0));
//        System.out.print(c.removeTorpedo(0));
//        c.decreaseSpeed();
//        System.out.print("\n");
//
//
//        //PowerUp Test
//        PowerUp pu = new PowerUp();
//        System.out.print(pu.toString());
//        System.out.print("\n");


//        //DamageBoost Test
//        DamageBoost db = new DamageBoost(0,0,0);
//        System.out.print(db.toString());
//        System.out.print("\n");


//        //ShieldBoost Test
//        ShieldBoost sb = new ShieldBoost(0,0,0);
//        System.out.print(sb.toString());
//        System.out.print("\n");


        //Meteor Test
        //MeteorData md = new MeteorData();
        //Meteor m = new Meteor(md,"meteor.jpg",0,0);
        //System.out.print(m.toString());
        //System.out.print("\n");


        //MeteorField Test
        //MeteorData md1 = new MeteorData();
        //MeteorField mf = new MeteorField(md1);
        //System.out.print(mf.toString());
        //System.out.print("\n");


        //GameUniverse Test
        //MeteorBlasterConfigData mbcd = new MeteorBlasterConfigData();
        GameUniverse gu = new GameUniverse();
        String sgd = "saveGameData.txt";
        gu.loadGame(sgd);
        gu.saveGame(sgd);
        System.out.print(gu.toString());
    }
}