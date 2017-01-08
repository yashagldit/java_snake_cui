import java.io.*;
import java.util.*;
class Snake
{
    public static void main(String args[])throws IOException, InterruptedException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int i,j,k,a,b,c;
        int wd=30;
        int l=80;
        char ch='w',chn='p';
        Random r= new Random();
        int obx = 1+r.nextInt(wd-1);
        int oby = 1+r.nextInt(l-1);
        //snake maker
        int snx[]=new int[100];
        int sny[]=new int[100];
        int sx,sy;
        int sl=0;
        sx=snx[0]=wd/2;
        sy=sny[0]=l/2;
        a=0;
        int t=0;
        System.out.println();
        while(ch!='e')
        {
            // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("\f");

            if(chn!='\n')
            {
                ch=chn;
                chn=(char)in.read();
                continue;
            }
            if(ch=='w')
            {
                sx--;
                if(sx==-1)
                 sx=wd-1;
                }
            if(ch=='d')
            {
                sy++;
                if(sy==l-1)
                     sy=1;
            }
            if(ch=='a')
            {
                sy--;
                if(sy==0)
                     sy=l-2;
            }
            if(ch=='s')
            {
                sx++;
                if(sx==wd)
                     sx=0;
            }
            a++;
            snx[0]=sx;
            sny[0]=sy;
            for(i=0;i<l;i++)
            {
                System.out.print("#");
            }
            System.out.println();
            k=0;
            for(i=0;i<wd;i++)
            {
                for(j=0;j<l;j++)
                {
                    if(snx[0]==i && sny[0]==j)
                    {
                        System.out.print("O");
                        k++;                        
                    }
                    else if(snx[k]==i && sny[k]==j && k<=sl)
                    {
                        System.out.print("o");
                        k++;                        
                    }
                    else if(obx==i && oby==j)
                    {
                        System.out.print("$");
                    }
                    else if(j==0)
                    {
                        System.out.print("#");
                    }
                    else if(j==l-1)
                    {
                        System.out.print("#");
                    }
                    else
                        System.out.print(" ");
                }
                System.out.println();
            
            }
            for(i=0;i<l;i++)
            {
                System.out.print("#");
            }
            if(sx==obx && sy==oby)
            {
                t=t+10;
                obx = 1+r.nextInt(wd-1);
                oby = 1+r.nextInt(l-1);
                sl++;
                
            }
            if(sl>0)
            {
                for(b=sl;b>0;b--)
                {
                    snx[b]=snx[b-1];
                    sny[b]=sny[b-1];
                }
            }
            System.out.println("\n\nTotal score = "+t);
            
            chn=(char)in.read();
            if(chn=='e')
            {
                System.out.println("\nLoop runned "+a+" times");
                break;
            }
        }
    }
    
}

