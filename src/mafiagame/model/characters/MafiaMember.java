/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model.characters;

/**
 *
 * @author hekla
 */
import java.util.Scanner;
import mafiagame.model.Knowledge;
import mafiagame.model.Money;
import mafiagame.model.characters.Cop;

public class MafiaMember extends Human {

    private double deathChance = 0.0;

    public enum Family {
        CORVETTA, JULIO
    };

    private String hairColor;
    public Family belongsToFamily;
    private int money;
    private boolean gameOver;
    private Knowledge knowledge;

    public MafiaMember(String name, int age) {
        super(name, age);
    }

    public MafiaMember(String name,
            int age,
            Gender gender,
            Drink favoriteDrink,
            String hairColor,
            Family belongsToFamily,
            int money, boolean gameOver, Knowledge knowledge
    ) {
        super(name, age, gender, favoriteDrink);
        this.hairColor = hairColor;
        this.money = money;
        this.belongsToFamily = belongsToFamily;
        this.knowledge = knowledge;
        introduce();
    }

    public MafiaMember(String name,
            int age,
            Gender gender,
            Drink favoriteDrink,
            String hairColor,
            Family belongsToFamily,
            int money) {
        super(name, age, gender, favoriteDrink);
        this.hairColor = hairColor;
        this.money = money;
        this.belongsToFamily = belongsToFamily;
    }

    @Override
    public void introduce() {
        System.out.println("My name is " + this.getName() + ". You remember it, you keep it quiet. Got it?");
    }

    public void sellDrugs(BadCop badCop) {
          System.out.println("You don't want any problems and you need the money");
          System.out.println("So you slowly slide him the plastic bag and take the money from his outstretched hand");
          System.out.println("50 dollars, not bad !");
    }

    public String getHairColor() {
        return this.hairColor;
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }

    public void whereToBegin() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Night falls over the city. The streets smell like rain and trouble.");
        waitForEnter(keyboard);
        System.out.println("Where do you start your evening?");
        System.out.println("Head to the bar for a drink and maybe some gossip (b)");
        System.out.println("or go down to the docks to handle a drug deal (d).");
        System.out.println();
        System.out.print("Choose (b/d): ");

        String where = keyboard.nextLine().trim().toLowerCase();
        if (where.equals("b")) {
            goToTheBar();
        } else {
            drugDeal();
        }
    }

    public void whereToGoNext() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("The night isn’t over yet.");
        System.out.println("What’s your next move?");
        System.out.println("Hit the bar for another round (b),");
        System.out.println("head back to the docks for another deal (d),");
        System.out.println("or visit the hairdresser to change your look (h).");
        System.out.println();
        System.out.print("Choose (b/d/h): ");
        String where = keyboard.nextLine().trim().toLowerCase();

        switch (where) {
            case "b" -> goToTheBar();
            case "d" -> drugDeal();
            default -> changeHairColor();
        }
    }
    
    public void goToTheBar() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("You push open the door to your regular bar.");
        System.out.println("The air is thick with smoke. Glasses clink, people mumble.");
        waitForEnter(keyboard);
        System.out.println("You order a large " + this.getFavoriteDrink() + ", your favorite. The bartender nods without asking.");
        waitForEnter(keyboard);
        System.out.println("You feel a presence behind you. Heavy footsteps. A shadow on the floor.");
        waitForEnter(keyboard);
        System.out.println("You turn around...");
        waitForEnter(keyboard);
        System.out.println("A cop. Wrong place, wrong time.");
        waitForEnter(keyboard);
        double random =Math.random();
        if(random<0.5){
            Cop cop = new Cop();
            this.meetCop(cop);
        } else {
            BadCop badCop=new BadCop("Harold", 11);
            badCop.introduce();
            sellDrugs(badCop);
        }
        
       
        waitForEnter(keyboard);

        
    }

    public static void waitForEnter(Scanner sc) {
        String line;
        do {
            line = sc.nextLine();
        } while (!line.isEmpty()); // only continue if input == ""
    }

    public void drugDeal() {
        Scanner keyboard = new Scanner(System.in);
        DockWorker dockWorker = new DockWorker();

        System.out.println("You make your way down to the docks.");
        System.out.println("It's cold and dark.");
        waitForEnter(keyboard);
        System.out.println("You know the Dock Worker might see something he shouldn’t.");
        System.out.println("You can try to buy his silence for 70 dollars.");
        System.out.println("Right now, you have " + this.getMoney() + " dollars.");
        System.out.println();
        System.out.print("Do you bribe him or take your chances? (bribe/not bribe): ");

        String bribe = keyboard.nextLine().trim().toLowerCase();
        if (bribe.equals("bribe")) {
            bribeWorker(dockWorker);
            waitForEnter(keyboard);
            System.out.println("The Dock Worker pockets the cash and looks away, pretending not to see you.");
        } else {
            System.out.println("You decide to save your money and leave to do the drug deal hoping for the best.");
            double random = Math.random();
            if (random > 0.5) {
                System.out.println("The Dock Worker hesitates, then reaches for his phone...");
                dockWorker.callsCops(Boolean.TRUE, this);
            } else {
                System.out.println("The Dock Worker shrugs and lights a cigarette. Maybe he doesn’t care enough to call.");
                waitForEnter(keyboard);

        System.out.println("The dock is almost empty. Just a hunched figure sitting alone on a bench.");
        System.out.println("Exactly where he said he’d be.");
        waitForEnter(keyboard);
        System.out.println("You walk over, hand him the package, and he slides 50 dollars into your pocket.");
        this.money += 50;
        waitForEnter(keyboard);
        System.out.println("Deal done. No shots. No sirens. Could’ve gone worse.");
        waitForEnter(keyboard);
        System.out.println("You head home and collapse into bed.");
        waitForEnter(keyboard);
        System.out.println("A new day begins. The city never sleeps, and neither does trouble.");
        waitForEnter(keyboard);
            }
        }
        
    }

    public void changeHairColor() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("You catch your reflection in a shop window and don’t like what you see.");
        System.out.println("Too recognizable. Too familiar. Too easy to find.");
        waitForEnter(keyboard);

        HairDresser hairDresser = new HairDresser("Brad Pitt");
        hairDresser.introduce();
        waitForEnter(keyboard);

        System.out.println("You step into the hair salon.");
        System.out.println("Haircut or new hair color?");
        waitForEnter(keyboard);

        System.out.println("Right now, your hair color is: " + this.getHairColor());
        waitForEnter(keyboard);

        System.out.println("If you change it completely, it’ll be harder for anyone to track you down.");
        System.out.println("A full color change costs 30 dollars.");
        System.out.println("You currently have " + getMoney() + " dollars.");
        System.out.println();

        if (this.getMoney() > 30) {

            System.out.println("The hairdresser seems chatty. Chatty people hear things.");
            System.out.println("Maybe you’ll walk out with a new look… and some new gossip.");
            System.out.print("What do you want? Just a cut or a full color change? (cut/change): ");
            String colorChange = keyboard.nextLine().trim().toLowerCase();

            if (colorChange.equals("change")) {
                String newColor = this.hairColor;
                while (this.hairColor.equals(newColor)) {
                    System.out.println("Choose your new hair color (blonde/brunette/red/blue): ");
                    newColor = keyboard.nextLine().trim().toLowerCase();
                    if (!newColor.equals("blonde") && !newColor.equals("brunette")
                            && !newColor.equals("red") && !newColor.equals("blue")) {
                        System.out.println("That’s not a color we do. Type blonde, brunette, red, or blue.");
                        break;
                    }
                }
                // You might also want to actually assign this.hairColor = newColor here
                this.money -= 30;
                System.out.println("The scissors dance, dye burns, and time passes...");
                waitForEnter(keyboard);
                hairDresser.talk();
                hairDresser.gossip(this);
                waitForEnter(keyboard);
                System.out.println("You leave the salon looking like a different person.");
                System.out.println("And you’ve got fresh gossip that the cops might pay for one day.");
                System.out.println("“I could make some real money with this info,” you think.");
            } else {
                System.out.println("You settle for a simple cut. Cleaner, sharper, but still you.");
                waitForEnter(keyboard);
                System.out.println("The hairdresser spins the chair around. \"Looks good,\" they say.");
            }
        } else {
            System.out.println("You check your pockets. Not enough cash for a color change.");
            System.out.println("All you can afford is a basic cut.");
            waitForEnter(keyboard);
            System.out.println("You sit down anyway. No new identity today, just shorter hair.");
            waitForEnter(keyboard);
            System.out.println("The cut is done. \"Have a great day!\" the hairdresser says.");
        }
        waitForEnter(keyboard);
    }

    public void meetCop(Cop cop) {
        Scanner keyboard = new Scanner(System.in);
        cop.introduce();
        int amountOfInfo = this.getKnowledge().size();
        if (amountOfInfo == 0) {
            System.out.println("You rack your brain, but you don’t really have anything on the boss yet.");
        } else {
            System.out.println("You remember the secrets you’ve picked up over time...");
            System.out.println("You know some valuable things about the boss: " + this.getKnowledge().getInfo());
            waitForEnter(keyboard);
            System.out.println("The cop leans closer. \"You look like someone who’s tired of taking orders,\" he says.");
            System.out.println("Do you want to snitch on your Mafia Boss?");
            System.out.println("If you talk, you could walk away with serious money...");
            System.out.println("But if the boss finds out, you’re as good as dead.");
            System.out.println();

            String valid;
            while (true) {
                System.out.print("Snitch or stay loyal? (y/n): ");
                valid = keyboard.nextLine().trim().toLowerCase();

                if (valid.equals("y") || valid.equals("n")) {
                    break;
                }

                System.out.println("That’s not an option. You either snitch (y) or you keep your mouth shut (n).");
            }

            boolean sn = valid.equals("y");
            this.snitch(sn);
        }
    }

    public void snitch(Boolean s) {
        if (s == true) {
            // this does not work!!!!! – logic left as-is per your comment
            this.getKnowledge().getInfo().remove(0);
            money += 100;
            System.out.println();
            System.out.println("You take a deep breath and start talking.");
            System.out.println("Names. Places. Deals. You spill it all.");
            Cop.copApplausesMM(this);

            deathChance += 0.2;
            System.out.println("Word like that doesn’t stay secret for long.");
            System.out.println("If the boss hears about this, you’re done.");
            System.out.println("But for now, you walk away with " + this.money + " dollars.");
        } else {
            System.out.println("You stare at the cop, then look away.");
            System.out.println("\"I don’t know anything,\" you say.");
            System.out.println("Loyalty might save you. Or doom you.");
        }
    }

    public boolean doYouDie() {
        System.out.println("Your current chance of getting whacked is: " + (deathChance * 100) + "%");
        double roll = Math.random();
        System.out.println("The night rolls the dice... (" + roll + ")");
        if (roll < deathChance) {
            String bossName = "Don " + this.getFamily();
            MafiaBoss mafiaBoss = new MafiaBoss(bossName, 72, this.getFamily());
            mafiaBoss.introduce();
            System.out.println();
            System.out.println("GAME OVER");
            gameOver = true;
        }
        return gameOver;
    }

    public int getMoney() {
        return this.money;
    }

    public Family getFamily() {
        return this.belongsToFamily;
    }

    public void bribeWorker(DockWorker dockWorker) {
        this.introduce();
        dockWorker.introduce();
        System.out.println("You pull the Dock Worker aside, away from prying eyes.");
        System.out.println("\"You didn’t see anything tonight,\" you whisper.");
        System.out.println("You press a wad of cash into his hand.");
        this.money -= 70;
        System.out.println("He nods slowly. Fear does the rest.");
    }

    public boolean getGameOver() {
        return this.gameOver;
    }
    
    public void setGameOver(boolean bool){
        this.gameOver=bool;
    }

}