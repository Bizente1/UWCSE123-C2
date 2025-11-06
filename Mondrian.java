import java.util.*;
import java.awt.*;

public class Mondrian {

    private final static Color[] COLOR = {Color.RED, Color.YELLOW, Color.CYAN, Color.WHITE};
    private final static Random RAND = new Random();

    Mondrian(){}

    public void paintBasicMondrian(Color[][] pixels){
        argumentChecker(pixels);
        paintBasicMondrian(pixels, 0, pixels.length,0 , pixels[0].length);
    }

    private void paintBasicMondrian(Color[][] pixels,  int startX, int endX, int startY, int endY){

        int splitX = RAND.nextInt(endX-startX)+startX;
        int splitY = RAND.nextInt(endY-startY)+startY;
        int[][] splits = {{startX, splitX, startY, splitY}, {splitX, endX, startY, splitY}, 
                            {startX, splitX, splitY, endY}, {splitX, endX, splitY, endY}};

        if(endX-startX >= pixels.length/4 && endY-startY >= pixels[0].length/4){
            for(int[] lines: splits){
                paintBasicMondrian(pixels, lines[0], lines[1], lines[2], lines[3]);
            }

        }else if(endY - startY >= pixels[0].length/4){
            paintBasicMondrian(pixels, startX, endX, startY, splitY);   // top
            paintBasicMondrian(pixels, startX, endX, splitY, endY);   // bottom 
        }else if(endX - startX >= pixels.length/4){
            paintBasicMondrian(pixels,  startX, splitX, startY, endY); // left
            paintBasicMondrian(pixels, splitX, endX, startY, endY);   // right
        }else{
            fill(pixels, startX, endX, startY, endY);
        }
    }

    public void paintComplexMondrian(Color[][] pixels){
        argumentChecker(pixels);
        paintComplexMondrian(pixels, 0, pixels.length,0 , pixels[0].length);
    }

    private void paintComplexMondrian(Color[][] pixels,  int startX, int endX, int startY, int endY){
        int splitX = RAND.nextInt(endX-startX)+startX;
        int splitY = RAND.nextInt(endY-startY)+startY;

        if(endX-startX >= pixels.length/4 && endY-startY >= pixels[0].length/4){
            int splitX2 = RAND.nextInt(endX-splitX)+splitX;
            int splitY2 = RAND.nextInt(splitY-startY)+startY;
            int[][] splits = {{startX, splitX, startY, splitY}, {splitX, endX, startY, splitY}, 
                                {startX, splitX, splitY, endY}, {splitX, endX, splitY, endY}};
            int numOfSplits = RAND.nextInt(4) +1;

            for(int i = 0; i < numOfSplits; i++){
                //paintComplexMondrian();
            }

            
            
        }else if(endY - startY >= pixels[0].length/4){
            paintBasicMondrian(pixels, startX, endX, startY, splitY);   // top
            paintBasicMondrian(pixels, startX, endX, splitY, endY);   // bottom 
        }else if(endX - startX >= pixels.length/4){
            paintBasicMondrian(pixels,  startX, splitX, startY, endY); // left
            paintBasicMondrian(pixels, splitX, endX, startY, endY);   // right
        }else{
            fill(pixels, startX, endX, startY, endY);
        }
    }

    private void argumentChecker(Color[][] pixels){
        if(pixels == null || pixels.length < 300 || pixels[0].length < 300){
            throw new IllegalArgumentException();
        }
    }

    private static void fill(Color[][] pixels, int x1, int x2, int y1, int y2){

        Color colorPicked = COLOR[RAND.nextInt(4)];
        for(int i = x1 + 2; i < x2 -2; i++){
            for(int j = y1 + 2; j < y2 -2; j++){
                pixels[i][j] = colorPicked;
            }
        }
    }

}
