

import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File read = new File("/Users/jaysonnegron/Documents/workspace/AlwaysTurnLeft/src/B-small-practice.in.txt"); //make sure to change the path of where the file is loacted.
        File write = new File("B-small-practice.out.txt");
        BufferedReader reader = new BufferedReader(new FileReader(read));
        BufferedWriter writer = new BufferedWriter(new FileWriter(write));
        String note = null;
        note  = reader.readLine();
        int n=Integer.parseInt(note);
        for(int j=1;j<=n;j++){
            note = reader.readLine();
            String[] g=note.split(" ");
            int x=0,y=0,p=0,m=0,r=0,d=0;
            for(int i=1;i<g[0].length()-1;i++){
                if(g[0].charAt(i)=='W'){
                    if(d==0){
                        y++;
                    }else if(d==1){
                        x--;
                    }else if(d==2){
                        y--;
                    }else if(d==3){
                        x++;
                    }
                    if(x<m)
                        m=x;
                    if(x>r)
                        r=x;
                    if(y>p)
                        p=y;
                }else if(g[0].charAt(i)=='R'){
                    d=(d+1)%4;
                }else if(g[0].charAt(i)=='L'){
                    d=(d+3)%4;
                }
            }
            int dd=(d+2)%4;
            int xx=x;
            int yy=y;
            d=dd;
            for(int i=1;i<g[1].length()-1;i++){
                if(g[1].charAt(i)=='W'){
                    if(d==0){
                        y++;
                    }else if(d==1){
                        x--;
                    }else if(d==2){
                        y--;
                    }else if(d==3){
                        x++;
                    }
                    if(x<m)
                        m=x;
                    if(x>r)
                        r=x;
                    if(y>p)
                        p=y;
                }else if(g[1].charAt(i)=='R'){
                    d=(d+1)%4;
                }else if(g[1].charAt(i)=='L'){
                    d=(d+3)%4;
                }
            }
            p++;
            xx-=m;
            int w=r-m+1;
            int sx=0-m;
            int[][] map=new int[w][p];
            for(int i=0;i<w;i++)
                for(int k=0;k<p;k++)
                    map[i][k]=0;
            map[sx][0]|=1;
            if(dd==2)
                map[xx][yy]|=2;
            else if(dd==3)
                map[xx][yy]|=4;
            else if(dd==0)
                map[xx][yy]|=1;
            else if(dd==1)
                map[xx][yy]|=8;            
            x=sx;
            y=0;
            d=0;
            for(int i=1;i<g[0].length()-1;i++){
                if(g[0].charAt(i)=='W'){
                    if(d==0){
                        map[x][y]|=2;
                        map[x][y+1]|=1;
                        y++;
                    }else if(d==1){
                        map[x][y]|=4;
                        map[x-1][y]|=8;
                        x--;
                    }else if(d==2){
                        map[x][y]|=1;
                        map[x][y-1]|=2;
                        y--;
                    }else if(d==3){
                        map[x][y]|=8;
                        map[x+1][y]|=4;
                        x++;
                    }
                }else if(g[0].charAt(i)=='R'){
                    d=(d+1)%4;
                }else if(g[0].charAt(i)=='L'){
                    d=(d+3)%4;
                }
            }
            x=xx;
            y=yy;
            d=dd;
            for(int i=1;i<g[1].length()-1;i++){
                if(g[1].charAt(i)=='W'){
                    if(d==0){
                        map[x][y]|=2;
                        map[x][y+1]|=1;
                        y++;
                    }else if(d==1){
                        map[x][y]|=4;
                        map[x-1][y]|=8;
                        x--;
                    }else if(d==2){
                        map[x][y]|=1;
                        map[x][y-1]|=2;
                        y--;
                    }else if(d==3){
                        map[x][y]|=8;
                        if(x==2&&map.length==3)
                            System.out.print("");
                        map[x+1][y]|=4;
                        x++;
                    }
                }else if(g[1].charAt(i)=='R'){
                    d=(d+1)%4;
                }else if(g[1].charAt(i)=='L'){
                    d=(d+3)%4;
                }
            }            
            writer.write("Case #"+j+": "+"\n");
            for(int i=0;i<p;i++){
                for(int k=0;k<w;k++)
                    if(map[k][i]<10)
                        writer.write(""+map[k][i]);
                    else
                        writer.write('a'+(map[k][i]-10));
                writer.write("\n");
            }
        }
        writer.close ();
        reader.close ();
    }

}