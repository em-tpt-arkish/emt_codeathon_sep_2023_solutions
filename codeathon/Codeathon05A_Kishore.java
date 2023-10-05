/*
 * Core Java Problem Solving - Codeathon.
 * A.R. Kishore Kumar ~ (c) 2023 ~ -- ~ Tirupati, Andhra Pradesh, India ~
 *
 */
package codeathon;

import java.util.Scanner;

//Rectangle class (Super Class) with Setter/Getter and display() methods
class Rectangle
{
    private int width;
    private int height;
    public void display()
    {
        System.out.println(width + " " + height);
    }
    public int getWidth()
    {
        return width;
    }
    public void setWidth(int width)
    {
        this.width=width;
    }
    public int getHeight()
    {
        return height;
    }
    public void setHeight(int height)
    {
        this.height=height;
    }
}

//RectangleArea Sub Class with overrided display() method
class RectangleArea extends Rectangle
{
    public void read_input()
    {
        Scanner sc = new Scanner (System.in);
        setWidth(sc.nextInt());
        setHeight(sc.nextInt());
    }
    public void display()
    {
        super.display();
        System.out.println(getWidth()*getHeight());
    }
}
public class Codeathon05A_Kishore
{
    public static void main(String args[] )
    {
        RectangleArea rectangleArea = new RectangleArea();
        rectangleArea.read_input();
        rectangleArea.display();
    }
}
