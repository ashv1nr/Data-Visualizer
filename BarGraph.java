
import static java.lang.System.*;
import java.awt.*;
import java.util.*;

public class BarGraph extends JDrawingFrame
{
   Scanner bgScan = new Scanner(in);
   
   private String title, xLabel, yLabel, barLabel, source="", yOrN;
   private int amtBars, barWidth,spaceBtwBars, barStart, yMax, amtPoints, spaceBtwPoints, axisFS, axisStart,  barHeight, index, offset;
   private double  yScale, barHeightNum, above, tempHeight, percent, cent;
   private ArrayList<Double> axisPoints = new ArrayList<Double>();
   private ArrayList<Integer> yValues = new ArrayList<Integer>();
   
   public void bgMain()
   {
      bgIntro();
      bgDimAdj();
      bgDraw();
   }
   
   private void bgIntro()
   {
      out.println("What is the title of your bar graph?");
      title = bgScan.nextLine();
      out.println("Are you adding a source to your bar graph?(Yes or No)");
      yOrN = bgScan.next();
      bgScan.nextLine();
      if(yOrN.equalsIgnoreCase("Yes"))
      {
         out.println("What is the source for your bar graph?");
         source=bgScan.nextLine();
      }
      out.println("What is the title of your x-axis?");
      xLabel = bgScan.nextLine();
      out.println("What is the title of your y-axis?");
      yLabel = bgScan.nextLine();
      do
      {
      out.println("How many bars does your graph need?(input a whole number from 1-14)");
      amtBars = bgScan.nextInt(); 
      } while (amtBars < 1 || amtBars > 14); 
      do
      {
      out.println("What would you like the maximum value on your y-axis to be?[range of 0-?]{>0 but <10 million}(input a whole number)");
      yMax = bgScan.nextInt();
      } while (yMax <= 0 || yMax >= 10000000);
      do
      {
      out.println("What would you like your y-axis to increase by?[0.5's, 1's, 2's, 5's, 10's, 50's, 100's, etc.](input number less than max(" + yMax + "))");
      yScale = bgScan.nextDouble();
      } while (yScale > yMax);
      while( (yScale/yMax) < (1.0/20) )
      {
         out.println("Please pick a larger scale for your y-axis.");
         yScale = bgScan.nextDouble();
      }
      bgScan.nextLine();
   }
   
   private void bgDimAdj()
   {
      if(amtBars>=13)
      {
         barWidth=20;
         spaceBtwBars=30;
         barStart=160;
      }
         else if(amtBars>=10)
         {
            barWidth=20;
            spaceBtwBars=35;
            barStart=165;
         }
            else if(amtBars>=7)
            {
               barWidth=25;
               spaceBtwBars=45;
               barStart=170;
            }
               else if(amtBars>=4)
               {
                  barWidth=30;
                  spaceBtwBars=65;
                  barStart=190;
               }
                  else
                  {
                    barWidth=50;
                    spaceBtwBars=100;
                    barStart=240;
                  } 
      
      if(  (yMax >= 1000000) || ( (yMax == 999999) && (yMax%yScale != 0) )  )
      {
         axisFS = 9;
         axisStart = 100;
         offset = 7;
      }
         else if(  (yMax >= 100000) || ( (yMax == 99999) && (yMax%yScale != 0) )  )
         {
            axisFS = 10;
            axisStart = 100;
            offset = 7;
         }
            else if(  (yMax >= 10000) || ( (yMax == 9999) && (yMax%yScale != 0) )  )
            {
               axisFS = 10;
               axisStart = 105;
               offset = 7;
            }
               else if(  (yMax >= 1000) || ( (yMax == 999) && (yMax%yScale != 0) )  )
               {
                  axisFS = 11;
                  axisStart = 110;
                  offset = 8;
               }
                  else
                  {
                     axisFS = 14;
                     axisStart = 110;
                     offset = 10;
                  }
   }
   
   private void bgDraw()
   {
      pen.setColor(Color.WHITE);
      
      setLineWidth(2);
      pen.drawLine(150,50,150,500);
      pen.drawLine(150,500,570,500);
      setFontSize(axisFS);
      if(( yMax%yScale) == 0)
      {
         amtPoints = (int)(yMax/yScale);
      }
      else
      {
         amtPoints = (int)(yMax/yScale) + 1;
      }
      spaceBtwPoints= (int)(440/amtPoints);
      double x = yScale;
      for(int y = 500-spaceBtwPoints; y >=60; y -= spaceBtwPoints)
      {
         axisPoints.add(x);
         yValues.add(y);
         pen.drawString("" + x, axisStart,y);
         x+=yScale;
      }
      
      setFontSize(20);
      pen.drawString(title,150,30);
      
      setFontSize(16);
      pen.drawString(xLabel,150,530);
      
      setFontSize(15);
      for (int i = 0; i < yLabel.length(); i++)
      {
         pen.drawString(yLabel.substring(i,i+1),20,60 + 15*i); 
      }
      setFontSize(12);
       if(!source.equalsIgnoreCase(""))
      {
         pen.drawString("source: " + source,150,550);
      }
      
      
      
      for (int i = 0; i < amtBars; i++)
      {
         out.println("Enter the name of bar number " + (i + 1) + ": ");
         barLabel = bgScan.nextLine();
         do 
         {
            out.println("Enter the the desired value of " + barLabel + ": ");
            barHeightNum = bgScan.nextDouble();
         }while(barHeightNum < 0 || barHeightNum > yMax);
         bgScan.nextLine();
         
         if(barHeightNum==0)
         {
            barHeight=0;
         }
            else if(barHeightNum < axisPoints.get(0))
            {
               percent = barHeightNum/axisPoints.get(0);
               tempHeight = Math.round( ( (500 - yValues.get(0)) * percent ) );
               barHeight = (int)(tempHeight) + offset;
            }
               else
               {
                  for(int w = axisPoints.size()-1; w >= 0; w--)
                  {
                     if(axisPoints.get(w) >= barHeightNum)
                     {
                        above=axisPoints.get(w);
                     }
                  }     
                  cent = barHeightNum / above;
                  index = axisPoints.indexOf(above);
                  tempHeight = Math.round( ( (500 - yValues.get(index)) * cent ) );
                  barHeight = (int)(tempHeight) + offset;
               }

        pen.setColor(getRandomColor());
        pen.fillRect((barStart + spaceBtwBars * i), 500-barHeight, barWidth, barHeight-1);
        
        pen.fillRect(590,20 + 25 * i,13,13);
        setFontSize(17);
        pen.drawString(barLabel + ": " + barHeightNum, 605, 30 + 25*i);
      }
         
   }
}

