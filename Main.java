
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

// We observed a social issue amongst our peers that many of them struggle
// to utilize apps such Google Sheets and Microsoft Excel. As we progress into
// more advanced classes, knowledge of these apps is pivotal in organizing and
// representing data. So, we developed a program to visualize data from the
// user in a way that all the user has to do is input the information they
// have, and all the graphing is done by us thus simplifying the whole process.

// To compile our program, click the "GREEN PLUS SIGN", and then run the program by subsequently clicking on the "RED MAN".

public class Main
{
	public static void main(String[] args)
	{
   	Scanner mScan = new Scanner(in);
      String choice = "";
      
      do
      {
      out.println("Select which letter you want to represent your data in.");
      out.println("\t a) Pie Chart \n\t b) Bar Graph \n\t c) Histogram \n\t d) Scatterplot \n\t e) Box and Whisker Plot");
      choice = mScan.next();
      
      if(choice.equalsIgnoreCase("a"))
      {
         PieChart punner = new PieChart();
         punner.pcMain();
         punner.showFrame();
      }
         else if(choice.equalsIgnoreCase("b"))
         {
            BarGraph bunner = new BarGraph();
            bunner.bgMain();
            bunner.showFrame();
         }
            else if(choice.equalsIgnoreCase("c"))
            {
               Histogram hunner = new Histogram();
               hunner.hgMain();
               hunner.showFrame();
            }
               else if(choice.equalsIgnoreCase("d"))
               {
                  Scatterplot sunner = new Scatterplot();
                  sunner.spMain();
                  sunner.showFrame();
               }
                 else if(choice.equalsIgnoreCase("e"))
                  {
                     BoxAndWhisker wunner = new BoxAndWhisker();
                     wunner.bwMain();
                     wunner.showFrame();
                  }
                     else
                     {
                        choice = choice;
                     }
                   
       }while( (!choice.equalsIgnoreCase("a")) || (!choice.equalsIgnoreCase("b")) || (!choice.equalsIgnoreCase("c")) || (!choice.equalsIgnoreCase("d")) || (!choice.equalsIgnoreCase("e")) );
   }
}