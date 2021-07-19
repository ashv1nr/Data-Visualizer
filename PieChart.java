
import static java.lang.System.*;
import java.awt.*;
import java.util.*;

public class PieChart extends JDrawingFrame
{
   Scanner pcScan = new Scanner(in);
   
   private int totSec, totResp, stAng = 0, endAng, angSum, respTotal = 0, fs, boxDim, step, boxY = 40, labY;
   private String label, title, sourceBool, source= "";
   private double freq, pct;

   public void pcMain()
   {
      pcIntro();
      pcDimAdj();
      pcDraw();
   }
   
   private void pcIntro()
   {
      out.println("What is the title of your pie chart? ");
      title = pcScan.nextLine();
      
      out.println("Are you adding a source to your chart?(Yes or No)");
      sourceBool = pcScan.next();
      pcScan.nextLine();
         if(sourceBool.equalsIgnoreCase("Yes"))
         {
            out.println("What is the source for your pie chart?");
            source= pcScan.nextLine();
         }
      
      do
      {
      out.println("How many individual responses do you have?(input a positive whole number)");
      totResp = pcScan.nextInt();
      }while(totResp <1);
      
      do
      {
      out.println("How many sectors do you need in your pie chart?[amount of different responses](input a whole number from 1 - 33)");
      totSec = pcScan.nextInt();
      } while (totSec < 1 || totSec > 33);
      pcScan.nextLine();
   }
   
   private void pcDimAdj()
   {
      if(totSec>=26)
      {
         fs = 10;
         boxDim = 7;
         labY = 47;
         step = 15;
      }
         else if(totSec>=21)
         {
            fs = 15;
            boxDim = 10;
            labY = 50;
            step = 10;
         }
            else
            {  
               fs = 20;
               boxDim = 13;
               labY = 53;
               step = 25;
            }
   }
   
   private void pcDraw()
   {
      setFontSize(30);
      pen.drawString(title, 10,27);
      setFontSize(15);
      if(!source.equalsIgnoreCase(""))
      {
         pen.drawString("source: " + source, 10,515);
      }
      setFontSize(fs);
      for(int x = 0; x < totSec ; x++)
      {
         
         out.println("What is the label for sector " + (x + 1) + "?");
         label = pcScan.nextLine();
         if (x < totSec - 1)
         {
            do
            {
            out.println("How many responses do you have for \"" + label + "\"?(input a whole number)");
            freq = pcScan.nextInt();  
            } while((respTotal + freq) > totResp);
            pcScan.nextLine();
         }
         else if (x == totSec - 1)
         {
            freq = totResp - respTotal;
         } 
         
         respTotal += freq;  
         
         pct = freq/totResp;
         endAng = (int)Math.round((pct*360));
         angSum = stAng + endAng;
         pen.setColor(getRandomColor());
         pen.fillArc(50,50,450,450,stAng,endAng);
         pen.fillRect(535,boxY,boxDim,boxDim);
         pen.drawString(label + ": " + String.format("%.1f", (pct * 100)) + "%", 550, labY);
         stAng = angSum;
         boxY+=step;
         labY+=step; 
         
      }
   }
}