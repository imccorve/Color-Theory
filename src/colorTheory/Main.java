package colorTheory;

import java.awt.*;

import javax.swing.JOptionPane;


public class Main {
	
	public static void main(String[] args) throws InterruptedException{

		boolean isOver = false;
		int firstTime = 0;
		while(isOver != true){
			if(firstTime != 0){
				Thread.sleep(1000);
				//JOptionPane.showConfirmDialog(null, "Restart?");
				
			}
			firstTime++;
			
			JOptionPane.showMessageDialog(null, "In this program, you will be prompted to input the rgb "
					+ "values of a specific color in three small windows. \n Then a gradient will appear showing the"
					+ " transformation from the color you chose to its \n complement based on the light additive"
					+ " color system. \n \n Press OK to continue.");
			
			
			int r = 0;
			int g = 0;
			int b = 0;
			
			r = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter an integer value for R (From 0 to 255)"
					+ "\n Then Press OK", 0));
			g = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter an integer value for G (From 0 to 255)"
					+ "\n Then Press OK", 0));;
			b = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter an integer value for B (From 0 to 255)"
					+ "\n Then Press OK", 0));;
			
			r = checkColor(r); 
			b = checkColor(b);
			g = checkColor(g);
					//System.out.println(r + "," + g + "," + b);
			int r1 = 255 - r;
			int b1 = 255 - b;
			int g1 = 255 - g;
			
			int N =  5; 
	        StdDraw.setXscale(0, N);
	        StdDraw.setYscale(0, N);

	        int numR;
	        int numB;
	        int numG;
	        
	        int first = 0;
	        for (int i = N; i >= 0; i--) {
	        	
	        	for (int j = 0; j < N; j++) {
	               
	              

	               // System.out.println("R:" + r + "G:" + g + "B:" + b); 
	                
	                StdDraw.setPenColor(new Color(r, g, b));
	                StdDraw.filledSquare(j + .5, i - .5, .5);
	        		if ( first == 0){
		                StdDraw.setPenColor();
		                StdDraw.text(j + .5, i - .5, "" + r + "," + g + "," + b);
		                StdDraw.show(90);
	        		}
	                if(first != 0){
	                StdDraw.setPenColor();
	                StdDraw.text(j + .5, i - .5, "" + r + "," + g + "," + b);
	                StdDraw.show(90);
	                }
	                if(i == 0 && j == N-1){
	                
	                }
	                numR = incrementUpDown(r1);
	                r += numR;
	                if(numR < 0){
	                	if(r < r1 )
	                		r = r1;
	                }
	                if(numR > 0){
	                	if(r > r1){
	                		r = r1;
	                	}
	                }
	                if(r < 0)
	                	r = 0;
	                
	                numB = incrementUpDown(b1);
	                b += numB;
	                if(numB < 0){
	                	if(b < b1 )
	                		b = b1;
	                }
	                if(numB > 0){
	                	if(b > b1){
	                		b = b1;
	                	}
	                }
	                if(b < 0)
	                	b = 0;
	                
	                numG = incrementUpDown(g1);
	                g += numG;
	                if(numG < 0){
	                	if(g < g1 )
	                		g = g1;
	                }
	                if(numG > 0){
	                	if(g > g1){
	                		g = g1;
	                	}
	                }
	                if(g < 0)
	                	g = 0;

	                first++;
	            }
	        }
	       int result = JOptionPane.showConfirmDialog(null,
		        "Do you want to quit the program?",
		        "Confirm Quit", JOptionPane.YES_NO_CANCEL_OPTION);
		if (result == JOptionPane.YES_OPTION) System.exit(0); 
		}
		

    }

	public static int incrementUpDown(int x){
		if(x >= 128){
			return 11;
		}
		else{
			return -11;
		}
		
	}
	public static int checkColor(int x){
		if(x > 255 || x < 0){
			x = 0;
		}
		return x;
	}
	
	

}
