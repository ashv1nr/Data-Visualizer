
import static java.lang.System.*;
import java.awt.*;
import java.util.*;
import java.lang.Math;
import java.util.Arrays;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

class BoxAndWhisker extends JDrawingFrame
{
   Scanner bwScan = new Scanner(in);

   private int totNum, totResp, fs, total;
   private double min, max, median, quartile1, quartile3, exit;
 
   
   public void bwMain()
   
   {
   out.println("How many numbers would you like to enter? (at least 5 numbers).");
   totResp = bwScan.nextInt();
   while (totResp < 5)
   {
   out.println("How many numbers would you like to enter? (at least 5 numbers).");
   totResp = bwScan.nextInt();
   }
   Double [] totNum = new Double [totResp];
   out.println("Enter in " + totResp + " whole numbers from 0-100.");
   for (int i=0; i < totNum.length; i++)
      {
      totNum [i]= bwScan.nextDouble();
      }
   
      
 
    double min = (double) Collections.min(Arrays.asList(totNum));
    double max = (double) Collections.max(Arrays.asList(totNum));
    this.min = min;
    this.max = max;
   


        
    Arrays.sort(totNum);
         
           
        
        if (totNum.length % 2 == 0)
        {
        median =  ((double)totNum[totNum.length/2] + (double)totNum[totNum.length/2 - 1])/2;
        int s = totNum.length/2;
        }
        
        else if (totNum.length % 2 == 1)
        {
        median = (double) totNum[totNum.length/2];
        int s = totNum.length/2;
        }
        
        if (totNum.length/2 % 2 == 0)
        {

        int s = totNum.length/2;
        
        quartile1 = ((double)totNum[totNum.length/2/2 -1] + (double)totNum [totNum.length/2/2]) /2;
        
        
        quartile3 = ((double)totNum [totNum.length-1 - (s/2)] + (double)totNum [totNum.length - (s/2)]) /2;
        

               

        }
       
        else if (totNum.length/2 % 2 == 1)
        {
        int s = totNum.length/2;
        
        quartile1 = ((double)totNum[s/2] + (double)totNum [s/2]) /2;
        System.out.println("Q1: " + quartile1);
        
        quartile3 =  totNum [totNum.length-1 - (s/2)] ;
        System.out.println("Q3: " + quartile3);
        
        
        }
        bwDraw();
   }

        
        public void bwDraw ()
        {
        setBackground(Color.BLACK);
        setFontSize(fs);
        
        
        if (min >= 0 && max <= 10)
        {
        pen.setStroke(new BasicStroke(3));
        pen.setColor(Color.BLUE);
        pen.draw(new Line2D.Double(quartile1 * 50 + 25, 100, quartile3 * 50 + 25, 100));
        pen.draw(new Line2D.Double(quartile1 * 50 + 25, 250, quartile3 * 50 + 25, 250));
        pen.draw(new Line2D.Double(quartile1 * 50 + 25, 100, quartile1 * 50 + 25, 250));
        pen.draw(new Line2D.Double(quartile3 * 50 + 25, 100, quartile3 * 50 + 25, 250));
        pen.draw(new Line2D.Double(median * 50 + 25, 100, median * 50 + 25, 250));
        pen.draw(new Line2D.Double(min * 50 + 25, 175,  quartile1 * 50 + 25, 175));
        pen.draw(new Line2D.Double(quartile3 * 50 + 25, 175, max * 50 + 25, 175));
        pen.draw(new Line2D.Double(min * 50 + 25, 160, min * 50 + 25, 190));
        pen.draw(new Line2D.Double(max * 50 + 25, 160, max * 50 + 25, 190));
        

        pen.setColor(Color.WHITE);
        pen.draw(new Line2D.Double(25, 312.5, 525, 312.5));
        pen.draw(new Line2D.Double(25, 300,  25, 325));
        pen.draw(new Line2D.Double(75, 300, 75, 325));
        pen.draw(new Line2D.Double(125, 300, 125, 325));
        pen.draw(new Line2D.Double(175, 300, 175, 325));
        pen.draw(new Line2D.Double(225, 300, 225, 325));
        pen.draw(new Line2D.Double(275, 300, 275, 325));
        pen.draw(new Line2D.Double(325, 300, 325, 325));
        pen.draw(new Line2D.Double(375, 300, 375, 325));
        pen.draw(new Line2D.Double(425, 300, 425, 325));
        pen.draw(new Line2D.Double(475, 300, 475, 325));
        pen.draw(new Line2D.Double(525, 300, 525, 325));
        
        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pen.setPaint(Color.WHITE);
        pen.setFont(new Font("Sans Serif", Font.BOLD, 20));
        
        pen.drawString("0", 20, 375);
        pen.drawString("1", 70, 375);
        pen.drawString("2", 120, 375);
        pen.drawString("3", 170, 375);
        pen.drawString("4", 220, 375);
        pen.drawString("5", 270, 375);
        pen.drawString("6", 320, 375);
        pen.drawString("7", 370, 375);
        pen.drawString("8", 420, 375);
        pen.drawString("9", 470, 375);
        pen.drawString("10", 515, 375);
        
        pen.drawString("minimum: " + min, 30, 450);
        pen.drawString("maximum: " + max, 30, 500); 
        pen.drawString("quartile 1: " + quartile1, 250, 430);
        pen.drawString("median (aka quartile 2): " + median, 250, 475);
        pen.drawString("quartile 3: " + quartile3, 250, 520);
        }
        else if (min >= 0 && max <= 20)
        {
        pen.setStroke(new BasicStroke(3));
        pen.setColor(Color.BLUE);
        pen.draw(new Line2D.Double((quartile1 * 50 + 50)/2, 100, (quartile3 * 50 + 50)/2, 100));
        pen.draw(new Line2D.Double((quartile1 * 50 + 50)/2, 250, (quartile3 * 50 + 50)/2, 250));
        pen.draw(new Line2D.Double((quartile1 * 50 + 50)/2, 100, (quartile1 * 50 + 50)/2, 250));
        pen.draw(new Line2D.Double((quartile3 * 50 + 50)/2, 100, (quartile3 * 50 + 50)/2, 250));
        pen.draw(new Line2D.Double((median * 50 + 50)/2, 100, (median * 50 + 50)/2, 250));
        pen.draw(new Line2D.Double((min * 50 + 50)/2, 175,  (quartile1 * 50 + 50)/2, 175));
        pen.draw(new Line2D.Double((quartile3 * 50 + 50)/2, 175, (max * 50 + 50)/2, 175));
        pen.draw(new Line2D.Double((min * 50 + 50)/2, 160, (min * 50 + 50)/2, 190));
        pen.draw(new Line2D.Double((max * 50 + 50)/2, 160, (max * 50 + 50)/2, 190));
       
        pen.setColor(Color.WHITE);
        pen.draw(new Line2D.Double(25, 312.5, 525, 312.5));
        pen.draw(new Line2D.Double(25, 300, 25, 325));
        pen.draw(new Line2D.Double(75, 300, 75, 325));
        pen.draw(new Line2D.Double(125, 300, 125, 325));
        pen.draw(new Line2D.Double(175, 300, 175, 325));
        pen.draw(new Line2D.Double(225, 300, 225, 325));
        pen.draw(new Line2D.Double(275, 300, 275, 325));
        pen.draw(new Line2D.Double(325, 300, 325, 325));
        pen.draw(new Line2D.Double(375, 300, 375, 325));
        pen.draw(new Line2D.Double(425, 300, 425, 325));
        pen.draw(new Line2D.Double(475, 300, 475, 325));
        pen.draw(new Line2D.Double(525, 300, 525, 325));
        
        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pen.setPaint(Color.WHITE);
        pen.setFont(new Font("Sans Serif", Font.BOLD, 20));       
        pen.drawString("0", 20, 375);
        pen.drawString("2", 70 , 375);
        pen.drawString("4", 120, 375);
        pen.drawString("6", 170, 375);
        pen.drawString("8", 220, 375);
        pen.drawString("10", 265, 375);
        pen.drawString("12", 315, 375);
        pen.drawString("14", 365, 375);
        pen.drawString("16", 415, 375);
        pen.drawString("18", 465, 375);
        pen.drawString("20", 515, 375);
        
        pen.drawString("minimum: " + min, 30, 450);
        pen.drawString("maximum: " + max, 30, 500); 
        pen.drawString("quartile 1: " + quartile1, 250, 430);
        pen.drawString("median (aka quartile 2): " + median, 250, 475);
        pen.drawString("quartile 3: " + quartile3, 250, 520);

        
        }
        else if (min >= 0 && max <= 30)
        {
        pen.setStroke(new BasicStroke(3));
        pen.setColor(Color.BLUE);
        pen.draw(new Line2D.Double((quartile1/2) * 50 + 15, 100, (quartile3/2) * 50 + 15, 100));
        pen.draw(new Line2D.Double((quartile1/2) * 50 + 15, 250, (quartile3/2) * 50 + 15, 250));
        pen.draw(new Line2D.Double((quartile1/2) * 50 + 15, 100, (quartile1/2) * 50 + 15, 250));
        pen.draw(new Line2D.Double((quartile3/2) * 50 + 15, 100, (quartile3/2) * 50 + 15, 250));
        pen.draw(new Line2D.Double((median/2) * 50 + 15, 100, (median/2) * 50 + 15, 250));
        pen.draw(new Line2D.Double((min/2) * 50 + 15, 175,  (quartile1/2) * 50 + 15, 175));
        pen.draw(new Line2D.Double((quartile3/2) * 50 + 15, 175, (max/2) * 50 + 15, 175));
        pen.draw(new Line2D.Double((min/2) * 50 + 15, 160, (min/2) * 50 + 15, 190));
        pen.draw(new Line2D.Double((max/2) * 50 +15, 160, (max/2) * 50 +15, 190));

        
        pen.setColor(Color.WHITE);
        pen.draw(new Line2D.Double(15, 312.5, 765, 312.5));
        pen.draw(new Line2D.Double(15, 300, 15, 325));
        pen.draw(new Line2D.Double(65, 300, 65, 325));   
        pen.draw(new Line2D.Double(115, 300, 115, 325));
        pen.draw(new Line2D.Double(165, 300, 165, 325));
        pen.draw(new Line2D.Double(215, 300, 215, 325));
        pen.draw(new Line2D.Double(265, 300, 265, 325));
        pen.draw(new Line2D.Double(315, 300, 315, 325));
        pen.draw(new Line2D.Double(365, 300, 365, 325));
        pen.draw(new Line2D.Double(415, 300, 415, 325));
        pen.draw(new Line2D.Double(465, 300, 465, 325));
        pen.draw(new Line2D.Double(515, 300, 515, 325));
        pen.draw(new Line2D.Double(565, 300, 565, 325));
        pen.draw(new Line2D.Double(615, 300, 615, 325));
        pen.draw(new Line2D.Double(665, 300, 665, 325));
        pen.draw(new Line2D.Double(715, 300, 715, 325));
        pen.draw(new Line2D.Double(765, 300, 765, 325));
       
        
        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pen.setPaint(Color.WHITE);
        pen.setFont(new Font("Sans Serif", Font.BOLD, 20));       
        pen.drawString("0", 10, 375);
        pen.drawString("2", 60 , 375);
        pen.drawString("4", 110, 375);
        pen.drawString("6", 160, 375);
        pen.drawString("8", 210, 375);
        pen.drawString("10", 255, 375);
        pen.drawString("12", 305, 375);
        pen.drawString("14", 355, 375);
        pen.drawString("16", 405, 375);
        pen.drawString("18", 455, 375);
        pen.drawString("20", 505, 375);
        pen.drawString("22", 555, 375);
        pen.drawString("24", 605, 375);
        pen.drawString("26", 655, 375);
        pen.drawString("28", 705, 375);
        pen.drawString("30", 755, 375);


        
        pen.drawString("minimum: " + min, 30, 450);
        pen.drawString("maximum: " + max, 30, 500); 
        pen.drawString("quartile 1: " + quartile1, 250, 430);
        pen.drawString("median (aka quartile 2): " + median, 250, 475);
        pen.drawString("quartile 3: " + quartile3, 250, 520);
        }
        else if (min >= 0 && max <= 40)
        {
        pen.setStroke(new BasicStroke(3));
        pen.setColor(Color.BLUE);
        pen.draw(new Line2D.Double((quartile1 * 17.5) + 20, 100, (quartile3 * 17.5) + 20, 100));
        pen.draw(new Line2D.Double((quartile1 * 17.5) + 20, 250, (quartile3 * 17.5) + 20, 250));
        pen.draw(new Line2D.Double((quartile1 * 17.5) + 20, 100, (quartile1 * 17.5) + 20, 250));
        pen.draw(new Line2D.Double((quartile3 * 17.5) + 20, 100, (quartile3 * 17.5) + 20, 250));
        pen.draw(new Line2D.Double((median * 17.5) + 20, 100, (median * 17.5) + 20, 250));
        pen.draw(new Line2D.Double((min * 17.5) + 20, 175,  (quartile1 * 17.5) + 20, 175));
        pen.draw(new Line2D.Double((quartile3 * 17.5) + 20, 175, (max * 17.5) + 20, 175));
        pen.draw(new Line2D.Double((min * 17.5) + 20, 160, (min * 17.5) + 20, 190));
        pen.draw(new Line2D.Double((max * 17.5) + 20, 160, (max * 17.5) + 20, 190));
              
        pen.setColor(Color.WHITE);
        pen.draw(new Line2D.Double(20, 312.5, 720, 312.5));
        pen.draw(new Line2D.Double(20, 300, 20, 325));   
        pen.draw(new Line2D.Double(55, 300, 55, 325));   
        pen.draw(new Line2D.Double(90, 300, 90, 325));
        pen.draw(new Line2D.Double(125, 300, 125, 325));
        pen.draw(new Line2D.Double(160, 300, 160, 325));
        pen.draw(new Line2D.Double(195, 300, 195, 325));
        pen.draw(new Line2D.Double(230, 300, 230, 325));
        pen.draw(new Line2D.Double(265, 300, 265, 325));
        pen.draw(new Line2D.Double(300, 300, 300, 325));
        pen.draw(new Line2D.Double(335, 300, 335, 325));
        pen.draw(new Line2D.Double(370, 300, 370, 325));
        pen.draw(new Line2D.Double(405, 300, 405, 325));
        pen.draw(new Line2D.Double(440, 300, 440, 325));
        pen.draw(new Line2D.Double(475, 300, 475, 325));
        pen.draw(new Line2D.Double(510, 300, 510, 325));
        pen.draw(new Line2D.Double(545, 300, 545, 325));
        pen.draw(new Line2D.Double(580, 300, 580, 325));
        pen.draw(new Line2D.Double(615, 300, 615, 325));
        pen.draw(new Line2D.Double(650, 300, 650, 325));
        pen.draw(new Line2D.Double(685, 300, 685, 325));
        pen.draw(new Line2D.Double(720, 300, 720, 325));
        
        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pen.setPaint(Color.WHITE);
        pen.setFont(new Font("Sans Serif", Font.BOLD, 20));    
        pen.drawString("0", 15, 375);
        pen.drawString("2", 50 , 375);
        pen.drawString("4", 85, 375);
        pen.drawString("6", 120, 375);
        pen.drawString("8", 155, 375);
        pen.drawString("10", 185, 375);
        pen.drawString("12", 220, 375);
        pen.drawString("14", 255, 375);
        pen.drawString("16", 290, 375);
        pen.drawString("18", 325, 375);
        pen.drawString("20", 360, 375);
        pen.drawString("22", 395, 375);
        pen.drawString("24", 430, 375);
        pen.drawString("26", 465, 375);
        pen.drawString("28", 500, 375);
        pen.drawString("30", 535, 375);
        pen.drawString("32", 570, 375);
        pen.drawString("34", 605, 375);
        pen.drawString("36", 640, 375);
        pen.drawString("38", 675, 375);
        pen.drawString("40", 710, 375);        
        
        pen.drawString("minimum: " + min, 30, 450);
        pen.drawString("maximum: " + max, 30, 500); 
        pen.drawString("quartile 1: " + quartile1, 250, 430);
        pen.drawString("median (aka quartile 2): " + median, 250, 475);
        pen.drawString("quartile 3: " + quartile3, 250, 520);
        }
        else if (min >= 0 && max <= 50)
        {
        pen.setStroke(new BasicStroke(3));
        pen.setColor(Color.BLUE);
        pen.draw(new Line2D.Double((quartile1 * 14) + 25, 100, (quartile3 * 14) + 25, 100));
        pen.draw(new Line2D.Double((quartile1 * 14) + 25, 250, (quartile3 * 14) + 25, 250));
        pen.draw(new Line2D.Double((quartile1 * 14) + 25, 100, (quartile1 * 14) + 25, 250));
        pen.draw(new Line2D.Double((quartile3 * 14) + 25, 100, (quartile3 * 14) + 25, 250));
        pen.draw(new Line2D.Double((median * 14) + 25, 100, (median * 14) + 25, 250));
        pen.draw(new Line2D.Double((min * 14) + 25, 175,  (quartile1 * 14) + 25, 175));
        pen.draw(new Line2D.Double((quartile3 * 14) + 25, 175, (max * 14) + 25, 175));
        pen.draw(new Line2D.Double((min * 14) + 25, 160, (min * 14) + 25, 190));
        pen.draw(new Line2D.Double((max * 14) + 25, 160, (max * 14) + 25, 190));
        
                
        pen.setColor(Color.WHITE);
        pen.draw(new Line2D.Double(25, 312.5, 725, 312.5));
        pen.draw(new Line2D.Double(25, 300, 25, 325));   
        pen.draw(new Line2D.Double(95, 300, 95, 325));   
        pen.draw(new Line2D.Double(165, 300, 165, 325));
        pen.draw(new Line2D.Double(235, 300, 235, 325));
        pen.draw(new Line2D.Double(305, 300, 305, 325));
        pen.draw(new Line2D.Double(375, 300, 375, 325));
        pen.draw(new Line2D.Double(445, 300, 445, 325));
        pen.draw(new Line2D.Double(515, 300, 515, 325));
        pen.draw(new Line2D.Double(585, 300, 585, 325));
        pen.draw(new Line2D.Double(655, 300, 655, 325));
        pen.draw(new Line2D.Double(725, 300, 725, 325));
   
        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pen.setColor(Color.WHITE);
        pen.setFont(new Font("Sans Serif", Font.BOLD, 20));
        pen.drawString("0", 20, 375);
        pen.drawString("5", 90, 375);
        pen.drawString("10", 155, 375);
        pen.drawString("15", 225, 375);
        pen.drawString("20", 295, 375);
        pen.drawString("25", 365, 375);
        pen.drawString("30", 435, 375);
        pen.drawString("35", 505, 375);
        pen.drawString("40", 575, 375);
        pen.drawString("45", 645, 375);
        pen.drawString("50", 715, 375);
        
        pen.drawString("minimum: " + min, 30, 450);
        pen.drawString("maximum: " + max, 30, 500); 
        pen.drawString("quartile 1: " + quartile1, 250, 430);
        pen.drawString("median (aka quartile 2): " + median, 250, 475);
        pen.drawString("quartile 3: " + quartile3, 250, 520);
        }
        else if (min >= 0 && max <= 60)
        {
        pen.setStroke(new BasicStroke(3));
        pen.setColor(Color.BLUE);
        pen.draw(new Line2D.Double((quartile1 * 12) + 25, 100, (quartile3 * 12) + 25, 100));
        pen.draw(new Line2D.Double((quartile1 * 12) + 25, 250, (quartile3 * 12) + 25, 250));
        pen.draw(new Line2D.Double((quartile1 * 12) + 25, 100, (quartile1 * 12) + 25, 250));
        pen.draw(new Line2D.Double((quartile3 * 12) + 25, 100, (quartile3 * 12) + 25, 250));
        pen.draw(new Line2D.Double((median * 12) + 25, 100, (median * 12) + 25, 250));
        pen.draw(new Line2D.Double((min * 12) + 25, 175,  (quartile1 * 12) + 25, 175));
        pen.draw(new Line2D.Double((quartile3 * 12) + 25, 175, (max * 12) + 25, 175));
        pen.draw(new Line2D.Double((min * 12) + 25, 160, (min * 12) + 25, 190));
        pen.draw(new Line2D.Double((max * 12) + 25, 160, (max * 12) + 25, 190));
        
        pen.setColor(Color.WHITE);
        pen.draw(new Line2D.Double(25, 312.5, 745, 312.5));
        pen.draw(new Line2D.Double(25, 300, 25, 325));   
        pen.draw(new Line2D.Double(85, 300, 85, 325));   
        pen.draw(new Line2D.Double(145, 300, 145, 325));
        pen.draw(new Line2D.Double(205, 300, 205, 325));
        pen.draw(new Line2D.Double(265, 300, 265, 325));
        pen.draw(new Line2D.Double(325, 300, 325, 325));
        pen.draw(new Line2D.Double(385, 300, 385, 325));
        pen.draw(new Line2D.Double(445, 300, 445, 325));
        pen.draw(new Line2D.Double(505, 300, 505, 325));
        pen.draw(new Line2D.Double(565, 300, 565, 325));
        pen.draw(new Line2D.Double(625, 300, 625, 325));
        pen.draw(new Line2D.Double(685, 300, 685, 325));
        pen.draw(new Line2D.Double(745, 300, 745, 325)); 
        
        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pen.setColor(Color.WHITE);
        pen.setFont(new Font("Sans Serif", Font.BOLD, 20));
        pen.drawString("0", 20, 375);
        pen.drawString("5", 80 , 375);
        pen.drawString("10", 135, 375);
        pen.drawString("15", 195, 375);
        pen.drawString("20", 255, 375);
        pen.drawString("25", 315, 375);
        pen.drawString("30", 375, 375);
        pen.drawString("35", 435, 375);
        pen.drawString("40", 495, 375);
        pen.drawString("45", 555, 375);
        pen.drawString("50", 615, 375);
        pen.drawString("55", 675, 375);
        pen.drawString("60", 735, 375);
               
        
        pen.drawString("minimum: " + min, 30, 450);
        pen.drawString("maximum: " + max, 30, 500); 
        pen.drawString("quartile 1: " + quartile1, 250, 430);
        pen.drawString("median (aka quartile 2): " + median, 250, 475);
        pen.drawString("quartile 3: " + quartile3, 250, 520);

        }
        else if (min >= 0 && max <= 70)
        {
        pen.setStroke(new BasicStroke(3));
        pen.setColor(Color.BLUE);
        pen.draw(new Line2D.Double((quartile1 * 10) + 25, 100, (quartile3 * 10) + 25, 100));
        pen.draw(new Line2D.Double((quartile1 * 10) + 25, 250, (quartile3 * 10) + 25, 250));
        pen.draw(new Line2D.Double((quartile1 * 10) + 25, 100, (quartile1 * 10) + 25, 250));
        pen.draw(new Line2D.Double((quartile3 * 10) + 25, 100, (quartile3 * 10) + 25, 250));
        pen.draw(new Line2D.Double((median * 10) + 25, 100, (median * 10) + 25, 250));
        pen.draw(new Line2D.Double((min * 10) + 25, 175,  (quartile1 * 10) + 25, 175));
        pen.draw(new Line2D.Double((quartile3 * 10) + 25, 175, (max * 10) + 25, 175));
        pen.draw(new Line2D.Double((min * 10) + 25, 160, (min * 10) + 25, 190));
        pen.draw(new Line2D.Double((max * 10) + 25, 160, (max * 10) + 25, 190));


        pen.setColor(Color.WHITE);
        pen.draw(new Line2D.Double(25, 312.5, 725, 312.5));
        pen.draw(new Line2D.Double(25, 300, 25, 325));   
        pen.draw(new Line2D.Double(75, 300, 75, 325));   
        pen.draw(new Line2D.Double(125, 300, 125, 325));
        pen.draw(new Line2D.Double(175, 300, 175, 325));
        pen.draw(new Line2D.Double(225, 300, 225, 325));
        pen.draw(new Line2D.Double(275, 300, 275, 325));
        pen.draw(new Line2D.Double(325, 300, 325, 325));
        pen.draw(new Line2D.Double(375, 300, 375, 325));
        pen.draw(new Line2D.Double(425, 300, 425, 325));
        pen.draw(new Line2D.Double(475, 300, 475, 325));
        pen.draw(new Line2D.Double(525, 300, 525, 325));
        pen.draw(new Line2D.Double(575, 300, 575, 325));
        pen.draw(new Line2D.Double(625, 300, 625, 325)); 
        pen.draw(new Line2D.Double(675, 300, 675, 325));
        pen.draw(new Line2D.Double(725, 300, 725, 325)); 
         
        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pen.setColor(Color.WHITE);
        pen.setFont(new Font("Sans Serif", Font.BOLD, 20));
        pen.drawString("0", 20, 375);
        pen.drawString("5", 70 , 375);
        pen.drawString("10", 115, 375);
        pen.drawString("15", 165, 375);
        pen.drawString("20", 215, 375);
        pen.drawString("25", 265, 375);
        pen.drawString("30", 315, 375);
        pen.drawString("35", 365, 375);
        pen.drawString("40", 415, 375);
        pen.drawString("45", 465, 375);
        pen.drawString("50", 515, 375);
        pen.drawString("55", 565, 375);
        pen.drawString("60", 615, 375);
        pen.drawString("65", 665, 375);
        pen.drawString("70", 715, 375);

        pen.drawString("minimum: " + min, 30, 450);
        pen.drawString("maximum: " + max, 30, 500); 
        pen.drawString("quartile 1: " + quartile1, 250, 430);
        pen.drawString("median (aka quartile 2): " + median, 250, 475);
        pen.drawString("quartile 3: " + quartile3, 250, 520);

        }
        else if (min >= 0 && max <= 80)
        {
        pen.setStroke(new BasicStroke(3));
        pen.setColor(Color.BLUE);
        pen.draw(new Line2D.Double((quartile1 * 9) + 25, 100, (quartile3 * 9) + 25, 100));
        pen.draw(new Line2D.Double((quartile1 * 9) + 25, 250, (quartile3 * 9) + 25, 250));
        pen.draw(new Line2D.Double((quartile1 * 9) + 25, 100, (quartile1 * 9) + 25, 250));
        pen.draw(new Line2D.Double((quartile3 * 9) + 25, 100, (quartile3 * 9) + 25, 250));
        pen.draw(new Line2D.Double((median * 9) + 25, 100, (median * 9) + 25, 250));
        pen.draw(new Line2D.Double((min * 9) + 25, 175,  (quartile1 * 9) + 25, 175));
        pen.draw(new Line2D.Double((quartile3 * 9) + 25, 175, (max * 9) + 25, 175));
        pen.draw(new Line2D.Double((min * 9) + 25, 160, (min * 9) + 25, 190));
        pen.draw(new Line2D.Double((max * 9) + 25, 160, (max * 9) + 25, 190));
        

        pen.setColor(Color.WHITE);
        pen.draw(new Line2D.Double(25, 312.5, 745, 312.5));
        pen.draw(new Line2D.Double(25, 300, 25, 325));   
        pen.draw(new Line2D.Double(70, 300, 70, 325));   
        pen.draw(new Line2D.Double(115, 300, 115, 325));
        pen.draw(new Line2D.Double(160, 300, 160, 325));
        pen.draw(new Line2D.Double(205, 300, 205, 325));
        pen.draw(new Line2D.Double(250, 300, 250, 325));
        pen.draw(new Line2D.Double(295, 300, 295, 325));
        pen.draw(new Line2D.Double(340, 300, 340, 325));
        pen.draw(new Line2D.Double(385, 300, 385, 325));
        pen.draw(new Line2D.Double(430, 300, 430, 325));
        pen.draw(new Line2D.Double(475, 300, 475, 325));
        pen.draw(new Line2D.Double(520, 300, 520, 325));
        pen.draw(new Line2D.Double(565, 300, 565, 325)); 
        pen.draw(new Line2D.Double(610, 300, 610, 325));
        pen.draw(new Line2D.Double(655, 300, 655, 325)); 
        pen.draw(new Line2D.Double(700, 300, 700, 325));
        pen.draw(new Line2D.Double(745, 300, 745, 325)); 

             
        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pen.setColor(Color.WHITE);
        pen.setFont(new Font("Sans Serif", Font.BOLD, 20));
        pen.drawString("0", 20, 375);
        pen.drawString("5", 65 , 375);
        pen.drawString("10", 105, 375);
        pen.drawString("15", 150, 375);
        pen.drawString("20", 195, 375);
        pen.drawString("25", 240, 375);
        pen.drawString("30", 285, 375);
        pen.drawString("35", 330, 375);
        pen.drawString("40", 375, 375);
        pen.drawString("45", 420, 375);
        pen.drawString("50", 465, 375);
        pen.drawString("55", 510, 375);
        pen.drawString("60", 555, 375);
        pen.drawString("65", 600, 375);
        pen.drawString("70", 645, 375);
        pen.drawString("75", 690, 375);
        pen.drawString("80", 735, 375);

        
        
        pen.drawString("minimum: " + min, 30, 450);
        pen.drawString("maximum: " + max, 30, 500); 
        pen.drawString("quartile 1: " + quartile1, 250, 430);
        pen.drawString("median (aka quartile 2): " + median, 250, 475);
        pen.drawString("quartile 3: " + quartile3, 250, 520);
        }
        
        else if (min >= 0 && max <= 100)
        {
        pen.setStroke(new BasicStroke(3));
        pen.setColor(Color.BLUE);
        pen.draw(new Line2D.Double((quartile1 * 7) + 25, 100, (quartile3 * 7) + 25, 100));
        pen.draw(new Line2D.Double((quartile1 * 7) + 25, 250, (quartile3 * 7) + 25, 250));
        pen.draw(new Line2D.Double((quartile1 * 7) + 25, 100, (quartile1 * 7) + 25, 250));
        pen.draw(new Line2D.Double((quartile3 * 7) + 25, 100, (quartile3 * 7) + 25, 250));
        pen.draw(new Line2D.Double((median * 7) + 25, 100, (median * 7) + 25, 250));
        pen.draw(new Line2D.Double((min * 7) + 25, 175,  (quartile1 * 7) + 25, 175));
        pen.draw(new Line2D.Double((quartile3 * 7) + 25, 175, (max * 7) + 25, 175));
        pen.draw(new Line2D.Double((min * 7) + 25, 160, (min * 7) + 25, 190));
        pen.draw(new Line2D.Double((max * 7) + 25, 160, (max * 7) + 25, 190));

        
        pen.setColor(Color.WHITE);
        pen.draw(new Line2D.Double(25, 312.5, 725, 312.5));
        pen.draw(new Line2D.Double(25, 300, 25, 325));   
        pen.draw(new Line2D.Double(95, 300, 95, 325));   
        pen.draw(new Line2D.Double(165, 300, 165, 325));
        pen.draw(new Line2D.Double(235, 300, 235, 325));
        pen.draw(new Line2D.Double(305, 300, 305, 325));
        pen.draw(new Line2D.Double(375, 300, 375, 325));
        pen.draw(new Line2D.Double(445, 300, 445, 325));
        pen.draw(new Line2D.Double(515, 300, 515, 325));
        pen.draw(new Line2D.Double(585, 300, 585, 325));
        pen.draw(new Line2D.Double(655, 300, 655, 325));
        pen.draw(new Line2D.Double(725, 300, 725, 325));
        
 
        pen.setStroke(new BasicStroke(1));
        pen.draw(new Line2D.Double(60, 305, 60, 320));   
        pen.draw(new Line2D.Double(130, 305, 130, 320));   
        pen.draw(new Line2D.Double(200, 305, 200, 320));
        pen.draw(new Line2D.Double(270, 305, 270, 320));
        pen.draw(new Line2D.Double(340, 305, 340, 320));
        pen.draw(new Line2D.Double(410, 305, 410, 320));
        pen.draw(new Line2D.Double(480, 305, 480, 320));
        pen.draw(new Line2D.Double(550, 305, 550, 320));
        pen.draw(new Line2D.Double(620, 305, 620, 320));
        pen.draw(new Line2D.Double(690, 305, 690, 320));
  
        
        
        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pen.setColor(Color.WHITE);
        pen.setFont(new Font("Sans Serif", Font.BOLD, 20));
        pen.drawString("0", 20, 375);
        pen.drawString("10", 85 , 375);
        pen.drawString("20", 155, 375);
        pen.drawString("30", 225, 375);
        pen.drawString("40", 295, 375);
        pen.drawString("50", 365, 375);
        pen.drawString("60", 435, 375);
        pen.drawString("70", 505, 375);
        pen.drawString("80", 575, 375);
        pen.drawString("90", 645, 375);
        pen.drawString("100", 710, 375);

        
        pen.drawString("minimum: " + min, 30, 450);
        pen.drawString("maximum: " + max, 30, 500); 
        pen.drawString("quartile 1: " + quartile1, 250, 430);
        pen.drawString("median (aka quartile 2): " + median, 250, 475);
        pen.drawString("quartile 3: " + quartile3, 250, 520);

        }
	else if (min < 0 || max > 100)
        {
        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        pen.setPaint(Color.WHITE);
        pen.setFont(new Font("Sans Serif", Font.BOLD, 20));
        pen.drawString("There are invalid numbers in your response.", 150, 300);
        pen.drawString("Try again by entering numbers in the range 0-100.", 125, 375);

        }


        
        }
       
    }