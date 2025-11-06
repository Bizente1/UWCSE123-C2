import java.util.*;
import java.awt.*;

public class Mondrian {

    Mondrian(){}

    public void paintBasicMondrian(Color[][] pixels){
        argumentChecker(pixels);
        paintBasicMondrian(pixels, 0, pixels.length,0 , pixels[0].length);
    }

    private void paintBasicMondrian(Color[][] pixels,  int startX, int endX, int startY, int endY){
            Random rand = new Random();
            // int splitX = (startX + endX) / 2;
            // int splitY = (startY + endY) / 2;
            int splitX = rand.nextInt(endX)+1;
            int splitY = rand.nextInt(endY)+1;
            System.out.println(endX);
        if(endX-startX >= pixels.length/4 && endY-startY >= pixels[0].length/4){

            paintBasicMondrian(pixels,  startX, splitX, startY, splitY); // top-left
            paintBasicMondrian(pixels, splitX, endX, startY, splitY);   // top-right
            paintBasicMondrian(pixels, startX, splitX, splitY, endY);   // bottom-left
            paintBasicMondrian(pixels, splitX, endX, splitY, endY);     // bottom-right
        }else if(endY - startY >= pixels[0].length/4){
            paintBasicMondrian(pixels, startX, endX, startY, splitY);   // top-right
            paintBasicMondrian(pixels, startX, endX, splitY, endY);   // bottom-left 
        }else if(endX - startX >= pixels.length/4){
            paintBasicMondrian(pixels,  startX, splitX, startY, endY); // top-left
            paintBasicMondrian(pixels, splitX, endX, startY, endY);   // top-right
        }else{
            fill(pixels, startX, endX, startY, endY);
        }
    }

    public void paintComplexMondrian(Color[][] pixels){
        argumentChecker(pixels);
        paintComplexMondrian(pixels, 0, pixels.length,0 , pixels[0].length);
    }

    private void paintComplexMondrian(Color[][] pixels,  int startX, int endX, int startY, int endY){
        
    }

    private void argumentChecker(Color[][] pixels){
        if(pixels == null || pixels.length < 300 || pixels[0].length < 300){
            throw new IllegalArgumentException();
        }
    }

    private static void fill(Color[][] pixels, int x1, int x2, int y1, int y2){
        System.out.println("test " + x2);
        for(int i = x1 + 2; i < x2 -2; i++){
            for(int j = y1 + 2; j < y2 -2; j++){
                pixels[j][i] = Color.WHITE;
            }
        }
    }

}
