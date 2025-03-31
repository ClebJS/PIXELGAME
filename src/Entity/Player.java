//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        this.setDefaultValues();
        this.getPlayerImage();
    }

    public void setDefaultValues() {
        this.x = 100;
        this.y = 100;
        this.speed = 4;
        this.direction = "down";
    }

    public void getPlayerImage() {
        try {
            this.up1 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_costas_1.png"));
            this.up2 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_costas_2.png"));
            this.down1 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_frente_1.png"));
            this.down2 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_frente_2.png"));
            this.left1 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_esquerda_1.png"));
            this.left2 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_esquerda_2.png"));
            this.right1 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_direita_1.png"));
            this.right2 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_direita_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        if (this.keyH.upPressed ==true|| this.keyH.downPressed ==true|| this.keyH.leftPressed ==true|| this.keyH.rightPressed==true) {
            if (this.keyH.upPressed) {
                this.direction = "up";
                this.y -= this.speed;
            } else if (this.keyH.downPressed) {
                this.direction = "down";
                this.y += this.speed;
            } else if (this.keyH.leftPressed) {
                this.direction = "left";
                this.x -= this.speed;
            } else if (this.keyH.rightPressed) {
                this.direction = "right";
                this.x += this.speed;
            }

            ++this.spriteCounter;
            if (this.spriteCounter > 10) {
                if (this.spriteNum == 1) {
                    this.spriteNum = 2;
                } else if (this.spriteNum == 2) {
                    this.spriteNum = 1;
                }

                this.spriteCounter = 0;
            }
        }

    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (this.direction) {
            case "up":
                if (this.spriteNum == 1) {
                    image = this.up1;
                } else if (this.spriteNum == 2) {
                    image = this.up2;
                }
                break;
            case "down":
                if (this.spriteNum == 1) {
                    image = this.down1;
                } else if (this.spriteNum == 2) {
                    image = this.down2;
                }
                break;
            case "left":
                if (this.spriteNum == 1) {
                    image = this.left1;
                } else if (this.spriteNum == 2) {
                    image = this.left2;
                }
                break;
            case "right":
                if (this.spriteNum == 1) {
                    image = this.right1;
                } else if (this.spriteNum == 2) {
                    image = this.right2;
                }
        }

        int var10002 = this.x;
        int var10003 = this.y;
        Objects.requireNonNull(this.gp);
        Objects.requireNonNull(this.gp);
        g2.drawImage(image, var10002, var10003, 64, 64, (ImageObserver)null);
    }
}
