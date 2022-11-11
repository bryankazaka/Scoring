import java.io.*;
import java.util.*;
import java.math.*;

class Scoring
{
    public static void main(String [] args)
    {
    List<Integer> list = new ArrayList<Integer>();
    List<String> operands = new ArrayList<String>();
    Scanner in = new Scanner(System.in);
    int list_len = in.nextInt();
    int sum = 1;
    int max_sum = 0;
    for(int i=0; i<list_len;i++)
    {
        list.add(in.nextInt());
    }
    int target = in.nextInt();
    for(int p=0; p<(Math.pow(2,list_len)); p++)
    {
        operands.add(Integer.toBinaryString(p));
    }
    String s_temp = "";
    int counter = 0;

    
    for(String index : operands)
    {
        for(int ch = 0; ch < index.length(); ch++)
        {

            if(Character.compare(index.charAt(ch),"0".charAt(0)) == 1)
            {
                s_temp += "+";
            }
            else
            {
                s_temp+= "*";
            }      
        }
        while(s_temp.length()<list_len)
        {
            s_temp = "*"+s_temp;
            if(s_temp.length()==list_len)
            {
                break;
            }
        }
        operands.set(counter, s_temp);
        counter++;
        s_temp = "";
    }
    for(String s : operands)
    {
        for(int k = 0; k<list_len; k++)
        {
            if (Character.compare(s.charAt(k), "*".charAt(0))==1)
            {
                sum*=list.get(k);
            }
            else
            {
                sum+=list.get(k);
            }
        }  
        if(sum>max_sum)
        {
            if(sum<target)
            {
                max_sum = sum;
            }
        }
        sum = 1;
    }
    System.out.println(Integer.valueOf(max_sum));
    
}}
