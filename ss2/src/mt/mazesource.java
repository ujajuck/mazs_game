package mt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class mazesource {
public static void main(String[] args) {
	int[][] m=new int[18][18];
	String name=null;
	int r=(int) (Math.random()*3);System.out.println(r);
	switch(r){
		case 0: name="maze1";
		break;
		case 1: name="maze2";
		break;
		case 2: name="maze3";
		break;
	}

		try {
			Scanner s= new Scanner(new File(name));
			while(s.hasNext()){	
			for(int j=0;j<17;j++){
				for(int i=0;i<17;i++){
					m[j][i]=s.nextInt();
				}}}
			}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		}



Scanner s2=new Scanner(System.in);
	int i,j,k,l;

	 for(i=0;i<17;i++){
		 for(j=0;j<17;j++){
			 System.out.print(m[i][j]+" ");
		 }System.out.println();
	 }
	
	 try {
		 int t = 10;
		do{
		Thread.sleep(1000);
		System.out.printf(t+"sec ");
		t--;
		}while(t!=0);
		
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 
	 
	 System.out.println(" ");
	 
	 
	 double start=System.currentTimeMillis();
	 i=0;
	 j=1;
	 int player=7;
	 m[i][j]=player;
	 for(k=0;k<17;k++){
		 for(l=0;l<17;l++){if(l<=j+2&&k<=i+2){
			 System.out.print(m[k][l]+" ");}else{System.out.print("99");}
		 }System.out.println();
	 }
	
	 System.out.println(" ");
	 
	 
	 
	 do{
	 System.out.println("1.À§  2.¿À¸¥ÂÊ  3.¿ÞÂÊ   4.¾Æ·¡: ");
	 int vec=s2.nextInt();
	
	if(vec==1)
	{
		try{ if(m[i-1][j]==0||m[i-1][j]==7){
			 m[i-1][j]=player;
			 i=i-1;
			 for(k=0;k<17;k++){
				 for(l=0;l<17;l++){if(l<=j+2&&k<=i+2){
					 System.out.print(m[k][l]+" ");}else{System.out.print("99");}
				 }System.out.println();
			 }
		 }else{System.out.println("!");}}
	catch(ArrayIndexOutOfBoundsException e){}
	}
	 
	if(vec==2)
	 {
		try{ if(m[i][j+1]==0||m[i][j+1]==7){
			 m[i][j+1]=player;
			 j=j+1;
			 for(k=0;k<17;k++){
				 for(l=0;l<17;l++){if(l<=j+2&&k<=i+2){
					 System.out.print(m[k][l]+" ");}else{System.out.print("99");}
				 }System.out.println();
			 }
		 }else{System.out.println("!");
		 }}catch(ArrayIndexOutOfBoundsException e){}
	 }
	
	if(vec==3)
	 {
		 try{if(m[i][j-1]==0||m[i][j-1]==7){
			 m[i][j-1]=player;
			 j=j-1;
			 for(k=0;k<17;k++){
				 for(l=0;l<17;l++){if(l<=j+2&&k<=i+2){
					 System.out.print(m[k][l]+" ");}else{System.out.print("99");}
				 }System.out.println();
			 }
		 }else{System.out.println("!");}
		 }catch(ArrayIndexOutOfBoundsException e){}
	}

	if(vec==4)
		 {
			 try{
		 if(m[i+1][j]==0||m[i+1][j]==7){
			 m[i+1][j]=player;
			 i=i+1;
			 for(k=0;k<17;k++){
				 for(l=0;l<17;l++){if(l<=j+2&&k<=i+2){
					 System.out.print(m[k][l]+" ");}else{System.out.print("99");}
				 }System.out.println();
			 }
		 }else{System.out.println("!");}
		 }catch(ArrayIndexOutOfBoundsException e){continue;}
	 }
	double now=System.currentTimeMillis();
	double na=(now-start)/1000;
	System.out.println((int)na+"sec");
	 }while(m[10][9]!=player);
	 double end=System.currentTimeMillis();
System.out.println("Å»Ãâ!!!");
double time=(end-start)/1000;
System.out.println((int)time+"sec");
	 }
	

}


