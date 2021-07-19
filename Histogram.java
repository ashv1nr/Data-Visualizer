
import static java.lang.System.*;
import java.awt.*;
import java.util.*;

public class Histogram extends JDrawingFrame
{
   Scanner hgScan = new Scanner(in);
   
   private String title, xLabel, yLabel, barLabel, source="", yOrN;
   private int amtBars, barWidth,barStart, yMax, amtPoints, spaceBtwPoints, axisFS, axisStart,  barHeight, index, offset, endX, maxBars;
   private double  yScale, barHeightNum, above, tempHeight, percent, cent, xMin, xMax, xScale;
   private boolean compatScale = false, prime=false;
   private ArrayList<Double> axisPoints = new ArrayList<Double>();
   private ArrayList<Integer> yValues = new ArrayList<Integer>();
   
   public void hgMain()
   {
      hgIntro();
      yAxisAdj();
      hgDraw();
   }
   
   private void hgIntro()
   {
      out.println("What is the title of your histogram?");
      title = hgScan.nextLine();
      out.println("Are you adding a source to your histogram?(Yes or No)");
      yOrN = hgScan.next();
      hgScan.nextLine();
      if(yOrN.equalsIgnoreCase("Yes"))
      {
         out.println("What is the source for your histogram?");
         source=hgScan.nextLine();
      }
      out.println("What is the title of your x-axis?");
      xLabel = hgScan.nextLine();
      out.println("What is the title of your y-axis?");
      yLabel = hgScan.nextLine();
      do
      {
      out.println("What would you like the minimum value on your x-axis to be?(>= -1 million)");
      xMin = hgScan.nextDouble();
      } while (xMin < -1000000.0);
      do
      {
      out.println("What would you like the maximum value on your x-axis to be?(<= 1 million)");
      xMax = hgScan.nextDouble();
      } while (xMax  > 1000000.0 || xMax < xMin);
      if( (xMax-xMin) >= 1)
      {
      
      int cou=0;
      for(int i = 2; i < (xMax-xMin); i++)
      {  
         if( (xMax-xMin)%i==0.0)
         {
            cou++;
         }
      }
      if(cou==0)
      {
         prime=true;
      }
      
      }
      xAxisAdj(); 
      do
      {
      out.println("What would you like the maximum value on your y-axis to be?[range of 0-?]{>0 but <10 million}(input a whole number)");
      yMax = hgScan.nextInt();
      } while (yMax <= 0 || yMax >= 10000000);
      do
      {
      out.println("What would you like your y-axis to increase by?[0.5's, 1's, 2's, 5's, 10's, 50's, 100's, etc.](input number less than max(" + yMax + "))");
      yScale = hgScan.nextDouble();
      } while (yScale > yMax);
      while( (yScale/yMax) < (1.0/20) )
      {
         out.println("Please pick a larger scale for your y-axis.");
         yScale = hgScan.nextDouble();
      }
      hgScan.nextLine();
   }
   
   private void yAxisAdj()
   {  
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
   
   private void xAxisAdj()
   {
      String tempMin = "" + xMin;
      String tempMax = "" + xMax;
      
      if( (tempMin.length() >=9) || (tempMax.length() >= 9) )
      {
         barWidth = 110;
         maxBars = 5;
         endX = 700;
      }
         else if( (tempMin.length() >=8) || (tempMax.length() >= 8) )
         {
            barWidth = 90;
            maxBars = 6;
            endX = 690; 
         }
            else if( (tempMin.length() >=7) || (tempMax.length() >= 7) )
            {
               barWidth = 80;
               maxBars = 7;
               endX = 710;
            }
               else if( (tempMin.length() >=6) || (tempMax.length() >= 6) )
               {
                  barWidth = 65;
                  maxBars = 8;
                  endX = 670; 
               }
               else if( (tempMin.length() >=5) || (tempMax.length() >= 5) )
               {
                  barWidth = 55;
                  maxBars = 10;
                  endX = 700; 
               } 
                  else if( (tempMin.length() >=4) || (tempMax.length() >= 4) )
                  {
                     barWidth = 45;
                     maxBars = 13;
                     endX = 735; 
                  } 
                     else
                     {
                        barWidth = 35;
                        maxBars = 17;;
                        endX = 745; 
                     } 
                     
         if(prime==false)
         {
                              
         do
         {           
         out.println("What would you like your x-axis to increase by?");
         xScale = hgScan.nextDouble();
         }while(xScale > xMax);
         double tempSub = xMax-xMin;
         if( (tempSub%xScale == 0.0) || (tempSub%xScale == -0.0) )
         {
            if( (xMin + (xScale*maxBars)) >= xMax)
            {
               compatScale = true;
            }
         }
         
         while(compatScale == false)
         {
            out.println("Your selected scale must be a factor of " + (xMax-xMin) + " and be at least 1/" + maxBars + " of " + (xMax-xMin) + ". Please pick a new scale.");
            xScale = hgScan.nextDouble();
            double tempSubb = xMax-xMin;
            if( (tempSubb%xScale == 0.0) || (tempSubb%xScale == -0.0) )
            {
               if( (xMin + (xScale*maxBars)) >= xMax)
               {
                  compatScale = true;
               }
            }
         }
         
         }
         else
         {
            if(maxBars >= 10)
            {
               do
               {
                  out.println("Your range is prime. Here are your availible scales for your x-axis: " + ( (xMax-xMin) /10) + ", " + ( (xMax-xMin) /5) + ", " + ( (xMax-xMin) /4) + ", " + ( (xMax-xMin) /2) + ". What would you like your x-axis to increase by?" );
                  xScale = hgScan.nextDouble();
               } while( ( xScale!= ( (xMax-xMin) /10) ) && ( xScale!= ( (xMax-xMin) /5) ) && ( xScale!= ( (xMax-xMin) /4) ) && ( xScale!= ( (xMax-xMin) /2) ) );
            }
            else
            {
               do
               {
                  out.println("Your range is prime. Here are your availible scales for your x-axis: " + ( (xMax-xMin) /5) + ", " + ( (xMax-xMin) /4) + ", " + ( (xMax-xMin) /2) + ". What would you like your x-axis to increase by?" );
                  xScale = hgScan.nextDouble();
               } while( ( xScale!= ( (xMax-xMin) /5) ) && ( xScale!= ( (xMax-xMin) /4) ) && ( xScale!= ( (xMax-xMin) /2) ) );
            }
         }
         
         amtBars = (int)( ( (xMax-xMin) / xScale ) +1);
   } 
   
   private void hgDraw()
   {
      pen.setColor(Color.WHITE);
      
      setLineWidth(2);
      pen.drawLine(150,50,150,500);
      pen.drawLine(150,500,endX,500);
      
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
      
      setFontSize(17);
      pen.drawString(xLabel,150,545);
      
      setFontSize(15);
      for (int i = 0; i < yLabel.length(); i++)
      {
         pen.drawString(yLabel.substring(i,i+1),20,60 + 15*i); 
      }
      setFontSize(11);
       if(!source.equalsIgnoreCase(""))
      {
         pen.drawString("source: " + source,150,565);
      }
      
      
      
      for (int i = 0; i < amtBars; i++)
      {
         if( i == (amtBars-1) )
         {
            do 
            {
               out.println("Enter the occurrences for numbers in the range of " + xMax + " and higher." );
               barHeightNum = hgScan.nextDouble();
            }while(barHeightNum < 0 || barHeightNum > yMax);
            hgScan.nextLine();
         }
         else
         {
            do 
            {
               out.println("Enter the occurrences for numbers greater than or equal to " + (xMin + (i*xScale)) + ", but less than " + (xMin + ((i+1)*xScale)) );
               barHeightNum = hgScan.nextDouble();
            }while(barHeightNum < 0 || barHeightNum > yMax);
            hgScan.nextLine();
         }
         
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
        pen.fillRect((151+ barWidth * i), 500-barHeight, barWidth, barHeight-1);
        
        pen.setColor(Color.WHITE);
        setFontSize(10);
        if(prime==true)
        {
         pen.drawString("" + String.format("%.3f", (xMin + (i*xScale))), (151 + barWidth * i), 515); 
        }
        else
        {
         pen.drawString("" + (xMin + (i*xScale)), (151 + barWidth * i), 515);
        } 
      }
   }
}