import java.util.Scanner;

// Superclass KarakterGame
class KarakterGame {
    private String nama;
    private int health;

    public KarakterGame(String nama, int health) {
        this.nama = nama;
        this.health = health;
    }

    public String getNama() {
        return nama;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void serang(KarakterGame target, int damage, String jenisSerangan) {
        System.out.println(nama + " menyerang " + target.getNama() + " menggunakan " + jenisSerangan + "!");
        target.setHealth(target.getHealth() - damage);
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getHealth() + "\n");
    }
}

// Subclass Monarch
class Monarch extends KarakterGame {
    public Monarch(String nama, int health) {
        super(nama, health);
    }
}

// Subclass Musuh
class Enemy extends KarakterGame {
    public Enemy(String nama, int health) {
        super(nama, health);
    }
}

// Kelas utama
public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Monarch Lucifer = new Monarch("Lucifer", 1000000);
        Enemy Tathagata = new Enemy("Tathagata", 10000000);

        System.out.println("Pertarungan dimulai!" + "\n");
        System.out.println(Lucifer.getNama() + " vs " + Tathagata.getNama());

        int round = 1;

        while (Lucifer.getHealth() > 0 && Tathagata.getHealth() > 0) {
            System.out.println("Round " + round);
            round++;
            System.out.println("Status: " + Lucifer.getNama() + ":");
            System.out.println("1. Holy Flame (100.000 damage)");
            System.out.println("2. Astral Destruction (300.000 damage)");
            System.out.println("3. Fate Manipulate (500.000 damage)");
            System.out.println("4. Devine Judgment (5.000.000 damage)");
            System.out.println("5. Health Status");
            System.out.print("Choose your option: ");
            int pilihan = scanner.nextInt();

            if (pilihan == 1) {
                Lucifer.serang(Tathagata, 100000, "Holy Flame");
            } else if (pilihan == 2) {
                Lucifer.serang(Tathagata, 300000, "Astral Destruction");
            } else if (pilihan == 3) {
                Lucifer.serang(Tathagata, 500000, "Fate Manipulate");
            }else if (pilihan == 4) {
                Lucifer.serang(Tathagata, 5000000, "Devine Judgment");
            }else if (pilihan == 5) {
                System.out.println("\n" + Lucifer.getNama() + " Nyawa anda " + Lucifer.getHealth() + "\n");
                continue;
            }else {
                System.out.println("Pilihan tidak valid!");
                continue;
            }

            if (Tathagata.getHealth() > 0) {
                System.out.println(Tathagata.getNama() + " menyerang kembali!");
                int seranganMusuh = (int) (Math.random() * 3) + 1;
                switch (seranganMusuh){
                    case 1:
                        Tathagata.serang(Lucifer, 150000, "Orbital Fall");
                        break;
                    case 2:
                        Tathagata.serang(Lucifer, 100000, "Radiant UP");
                        break;
                    case 3:
                        Tathagata.serang(Lucifer, 250000, "Code Breaker");
                }

            }
        }

        if (Lucifer.getHealth() > 0) {
            System.out.println(Lucifer.getNama() + " telah memenangkan pertarungan!");
        } else {
            System.out.println(Tathagata.getNama() + " telah memenangkan pertarungan!");
        }
        scanner.close();
    }
}
