package did;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JApplet;

public class maze extends JApplet implements Runnable {
	
Thread t= new Thread (this);


static final int windowsize=300;
static final int n=8;


static final int mapsize=n*2+1;
static final int bsize=(int)(windowsize/mapsize);


static block[][]map=new block[mapsize][mapsize];
static int [][]m=new int[mapsize][mapsize];
ArrayList<block> list = new ArrayList<block>();
public maze(){
	
}
public void init(){
	for (int i=0;i<mapsize;i++){
		for (int j=0;j<mapsize;j++){
			map[i][j]=new block(i,j,false);
		}
	}

setSize(mapsize*bsize,mapsize*bsize);
setVisible(true);

generatemap();

}

public static void main(String[] args) {
	new maze();
}

public void run(){
	while(true){
		
	}
}

public void generatemap(){
	int randx=(int)(Math.random()*n)*2+1;
	int randy=(int)(Math.random()*n)*2+1;
	map[randy][randx].visited=true;
	
	System.out.println(randx+" "+randy+" "+map.length+" "+n);
	
	if(randx-1!=0){
		list.add(map[randy][randx-1]);
	}
	if(randx+1!=mapsize){
		list.add(map[randy][randx+1]);
	}
	if(randy-1!=0){
		list.add(map[randy-1][randx]);
	}
	if(randy+1!=mapsize){
		list.add(map[randy+1][randx]);
	}
	
	
	while(!list.isEmpty()){
		int index=(int)(Math.random()*list.size());
		
		block wall=list.get(index);
		
		if(wall.y%2==1){
		if(wall.x-1!=0&&map[wall.y][wall.x-1].visited==false){
			map[wall.y][wall.x-1].visited=true;
			map[wall.y][wall.x].visited=true;
			
			if(wall.x-2!=0){
				list.add(map[wall.y][wall.x-2]);
			}
			if(wall.y-1!=0){
				list.add(map[wall.y-1][wall.x-1]);
			}
			if(wall.y+1!=0){
				list.add(map[wall.y+1][wall.x-1]);
			}
		}else
			if(wall.x+1<=mapsize-1&&map[wall.y][wall.x+1].visited==false){
				map[wall.y][wall.x+1].visited=true;
				map[wall.y][wall.x].visited=true;
				
				if(wall.x+2!=0){
					list.add(map[wall.y][wall.x+2]);
				}
				if(wall.y-1!=0){
					list.add(map[wall.y-1][wall.x+1]);
				}
				if(wall.y+1!=0){
					list.add(map[wall.y+1][wall.x+1]);
				}
			}
		}else{
		if(wall.y-1!=0&&map[wall.y-1][wall.x].visited==false){
			map[wall.y-1][wall.x].visited=true;
			map[wall.y][wall.x].visited=true;
			
			if(wall.y-2!=0){
				list.add(map[wall.y-2][wall.x]);
			}
			if(wall.x-1!=0){
				list.add(map[wall.y-1][wall.x-1]);
			}
			if(wall.x+1!=0){
				list.add(map[wall.y-1][wall.x+1]);
			}
		}else
			if(wall.y+1<=mapsize-1&&map[wall.y+1][wall.x].visited==false){
				map[wall.y+1][wall.x].visited=true;
				map[wall.y][wall.x].visited=true;
				
				if(wall.y+2!=0){
					list.add(map[wall.y+2][wall.x]);
				}
				if(wall.x-1!=0){
					list.add(map[wall.y+1][wall.x-1]);
				}
				if(wall.x+1!=0){
					list.add(map[wall.y+1][wall.x+1]);
				}
			}
	}
	list.remove(index);
}
for (int i=0;i<mapsize;i++){
	for (int j=0;j<mapsize;j++){
		if(map[i][j].visited==false){
			if(i%2==1){
				if(j%2==0){
					m[i][j]=1;
				}
			}else{
				m[i][j]=1;
			}
		}
	}
}
for (int i=0;i<mapsize;i++){
	m[i][mapsize-1]=1;
	m[i][0]=1;
	
	m[mapsize-1][i]=1;
	m[0][i]=1;

	}

m[0][1]=0;
m[mapsize-1][mapsize-2]=0;

for (int i=0;i<mapsize;i++){
	for (int j=0;j<mapsize;j++){
		System.out.print(m[i][j]+" ");
		}
	System.out.println();
	}
}
public void paint(Graphics g){
	for (int i=0;i<mapsize;i++){
		for (int j=0;j<mapsize;j++){
			if(m[i][j]==1)drawBlock(g,j,i);
		}
	}
}
public void drawBlock(Graphics g, int x, int y){
	g.setColor(Color.black);

Color t=new Color(100,100,50);
g.setColor(t);
g.fillRect(x*bsize, y*bsize, bsize,bsize);
}
}
class block{
	int x;
	int y;
	boolean visited;
	public block(int y, int x, boolean visited){
		this.x=x;
		this.y=y;
		this.visited=visited;
	}
	public String toString(){
		return "x="+x+" y="+y+" visit="+visited+"\n";
	}

		
	
}