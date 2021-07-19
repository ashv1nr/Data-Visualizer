
import static java.lang.System.*;
import java.awt.*;
import java.util.*;

public class Scatterplot extends JDrawingFrame
{
   Scanner spScan = new Scanner(in);
   
   private String title, xLabel, yLabel, barLabel, source="", yOrN;
   private int amtLines, spaceBtwLines,barStart, yMax, amtPoints, spaceBtwPoints, axisFS, axisStart,  barHeight, index, offset, endX, maxLines, amtDots, plotX, plotY;
   private double  yScale, barHeightNum, above, tempHeight, percent, cent, xMin, xMax, xScale, xCor, yCor, xTemp, xAbove;
   private boolean compatScale = false, prime=false;
   private ArrayList<Double> axisPoints = new ArrayList<Double>();
   private ArrayList<Integer> yValues = new ArrayList<Integer>();
   private ArrayList<Double> xAxisPoints = new ArrayList<Double>();
   private ArrayList<Integer> xValues = new ArrayList<Integer>();
   
   public void spMain()
   {
      spIntro();
      yAxisAdj();
      spDraw();
   }
   
   private void spIntro()
   {
      out.println("What is the title of your scatterplot?");
      title = spScan.nextLine();
      out.println("Are you adding a source to your scatterplot?(Yes or No)");
      yOrN = spScan.next();
      spScan.nextLine();
      if(yOrN.equalsIgnoreCase("Yes"))
      {
         out.println("What is the source for your scatterplot?");
         source=spScan.nextLine();
      }
      out.println("What is the title of your x-axis?");
      xLabel = spScan.nextLine();
      out.println("What is the title of your y-axis?");
      yLabel = spScan.nextLine(); 
      do
      {
      out.println("How many points are you graphing?(input a positive whole number)");
      amtDots = spScan.nextInt();
      }while(amtDots<1);
      do
      {
      out.println("What would you like the maximum value on your x-axis to be?(<= 1 million)");
      xMax = spScan.nextDouble();
      } while (xMax  > 1000000.0);
      if(xMax>=1)
      {
      
      int count=0;
      for(int i = 2; i < xMax; i++)
      {  
         if(xMax%i==0.0)
         {
            count++;
         }
      }
      if(count==0)
      {
         prime=true;
      }
      
      }
      xAxisAdj(); 
      do
      {
      out.println("What would you like the maximum value on your y-axis to be?[range of 0-?]{>0 but <10 million}(input a whole number)");
      yMax = spScan.nextInt();
      } while (yMax <= 0 || yMax >= 10000000);
      do
      {
      out.println("What would you like your y-axis to increase by?[0.5's, 1's, 2's, 5's, 10's, 50's, 100's, etc.](input number less than max(" + yMax + "))");
      yScale = spScan.nextDouble();
      } while (yScale > yMax);
      while( (yScale/yMax) < (1.0/20) )
      {
         out.println("Please pick a larger scale for your y-axis.");
         yScale = spScan.nextDouble();
      }
      spScan.nextLine();
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
      String tempMax = "" + xMax;
      
      if( tempMax.length() >= 9 )
      {
         maxLines = 6;
         endX = 700;
      }
         else if(  tempMax.length() >= 8 )
         {
            maxLines = 7;
            endX = 690; 
         }
            else if(  tempMax.length() >= 7 )
            {
               maxLines = 8;
               endX = 710;
            }
               else if(  tempMax.length() >= 6 )
               {
                  maxLines = 9;
                  endX = 670; 
               }
               else if(  tempMax.length() >= 5 )
               {
                  maxLines = 11;
                  endX = 700; 
               } 
                  else if(  tempMax.length() >= 4 )
                  {
                     maxLines = 14;
                     endX = 735; 
                  } 
                     else
                     {
                        maxLines = 18;
                        endX = 745; 
                     } 
                     
         if(prime==false)
         {
         
         do
         {           
         out.println("What would you like your x-axis to increase by?");
         xScale = spScan.nextDouble();
         }while(xScale > xMax);
         if( (xMax%xScale == 0.0) || (xMax%xScale == -0.0) )
         {
            if( (xScale*maxLines) >= xMax)
            {
               compatScale = true;
            }
         }
         
         while(compatScale == false)
         {
            out.println("Your selected scale must be a factor of " + xMax + " and be at least 1/" + maxLines + " of " + xMax + ". Please pick a new scale.");
            xScale = spScan.nextDouble();
            if( (xMax%xScale == 0.0) || (xMax%xScale == -0.0) )
            {
               if( (xScale*maxLines) >= xMax)
               {
                  compatScale = true;
               }
            }
         }
         
         }
         else
         {
            if(maxLines >= 10)
            {
               xScale = xMax/10;
            }
            else
            {
               xScale = xMax/5;
            }
         }
         
         amtLines = (int)( ( xMax / xScale ));
         spaceBtwLines = (int)((endX-150)/amtLines);
   } 
   
   private void spDraw()
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
      setLineWidth(1);
      for(int y = 500-spaceBtwPoints; y >=60; y -= spaceBtwPoints)
      {
         axisPoints.add(x);
         yValues.add(y);
         pen.drawString("" + x, axisStart,y);
         pen.drawLine(150,y-offset,endX,y-offset);
         x+=yScale;
      }
      
      pen.setColor(Color.WHITE);
      setFontSize(10);
      double f = xScale;
      for(int s = 1; s<= amtLines; s ++)
      {
        xAxisPoints.add(f);
        xValues.add(150 + spaceBtwLines * s);
        pen.drawLine((150 + spaceBtwLines * s), 500,(150 + spaceBtwLines * s) , 50);
        if(prime==true)
        {
            pen.drawString("" + String.format("%.3f", (s*xScale)), (150 + spaceBtwLines * s), 515); 
        }
        else
        {
            pen.drawString("" + (s*xScale), (150 + spaceBtwLines * s), 515);
        }
        f+= xScale;
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
      
      
      for (int i = 1; i <= amtDots; i++)
      {

            do 
            {
               out.println("Enter the x value for coordinate " + i );
               xCor = spScan.nextDouble();
            }while(xCor < 0 || xCor > xMax);
            spScan.nextLine();
            do 
            {
               out.println("Enter the y value for coordinate " + i );
               yCor = spScan.nextDouble();
            }while(yCor < 0 || yCor > yMax);

         
         if(yCor==0)
         {
            plotY=500-5;
         }
            else if(yCor < axisPoints.get(0))
            {
               percent = yCor/axisPoints.get(0);
               tempHeight = Math.round( ( (500 - yValues.get(0)) * percent ) );
               plotY = 500 - (int)(tempHeight) - offset-5;
            }
               else
               {
                  for(int w = axisPoints.size()-1; w >= 0; w--)
                  {
                     if(axisPoints.get(w) >= yCor)
                     {
                        above=axisPoints.get(w);
                     }
                  }     
                  cent = yCor / above;
                  index = axisPoints.indexOf(above);
                  tempHeight = Math.round( ( (500 - yValues.get(index)) * cent ) );
                  plotY = 500 - (int)(tempHeight) - offset-5;
               } 
               
         if(xCor==0)
         {
            plotX=150-5;
         }
            else if(xCor < xAxisPoints.get(0))
            {
               double per = xCor/xAxisPoints.get(0);
               xTemp = Math.round( ( xValues.get(0)-150) * per ) ;
               plotX = 150-5 + (int)xTemp;
            }
               else
               {
                  for(int w = xAxisPoints.size()-1; w >= 0; w--)
                  {
                     if(xAxisPoints.get(w) >= xCor)
                     {
                        xAbove= xAxisPoints.get(w);
                     }
                  }     
                  double cen = xCor / xAbove;
                  int ind = xAxisPoints.indexOf(xAbove);
                  xTemp = Math.round ( (xValues.get(ind) -150) * cen ) ;
                  plotX = 150-5 + (int)xTemp;
               } 
               
           pen.setColor(getRandomColor());
           pen.fillRect(plotX,plotY,10,10);
      } 
   }
}

