import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class cardbattle extends PApplet {


boolean testMode=false;
SoundFile frameInit;
SoundFile selectScreenMusic;
int screenState=1;
int lightningTrigger1=0;
int lightningTrigger2=0;
int lightningTrigger3=0;
int lightningTrigger4=0;
int lightningTrigger5=0;
int lightningTrigger6=0;
boolean isReturningOut;
BackgroundAnimation bubbleMaker3 = new BackgroundAnimation(18, "bubblemaker");
BackgroundAnimation bubbleMaker2 = new BackgroundAnimation(18,"bubblemaker");
BackgroundAnimation bubbleMaker = new BackgroundAnimation(18,"bubblemaker");
BackgroundAnimation distantLightning = new BackgroundAnimation(18, "distantlightning");
BackgroundAnimation largeLightning = new BackgroundAnimation(18,"largelightning");
BackgroundAnimation smallLightning = new BackgroundAnimation(18, "smalllightning");
SpriteAnimation swordweilderspawn  = new SpriteAnimation(9,"SwordWeilderSpawn");
SpriteAnimation swordweilderidle = new SpriteAnimation(6,"SwordWeilderIdle");
SpriteAnimation swordweilderspinattack = new SpriteAnimation(17, "SwordWeilerSpinAttack");
SpriteAnimation swordweilderdie = new SpriteAnimation(7,"SwordWeilderDie");
SpriteAnimation swordweilderdartattack = new SpriteAnimation(21,"SwordWeilderDartAttack");
SpriteAnimation swordweilderdashattack = new SpriteAnimation(6,"SwordWeilderDashAttack");
SpriteAnimation swordweilderdamage = new SpriteAnimation(2,"SwordWeilderDamage");
SpriteAnimation swordweildermove = new SpriteAnimation(6,"SwordWeilderMove");
SpriteAnimation quickStore=swordweilderidle;
//String testing= String.valueOf();
//String testing = swordweilderdamage + "";

//SpriteAnimation quickStore = swordweilderdie
//SpriteAnimation quickStore=swordweilderspawn;
FrameDraw frame1 = new FrameDraw();
FrameDraw frame2 = new FrameDraw();
FrameDraw frame3 = new FrameDraw();
//String[] doesthiswork={"test1", "test2", "test3"};
//SpriteAnimation test = new SpriteAnimation(17, "test",new String[]{"test1","test2"});
SpriteAnimation [] spriteChoose =
{
  swordweilderspawn,
  swordweilderidle,
  swordweilderspinattack,
  //swordweilderdie,
  swordweilderdartattack,
  swordweilderdashattack,
};
int [] xFrameOffsets =
{
  -210,
  -210,
  -210,
  //-210,
  -240,
  -210,
};
int[] yFrameOffsets =
{
  -210,
  -210,
  -210,
  //-180,
  -210,
  -210,
};


PImage photo;

PFont bigFont;
PFont usingFont;

int x=1920;
int y=1080;
Button frame1Button = new Button(x/2,y/2,500,600);
Button frame2Button = new Button(x/5,y/2,500,600);
Button frame3Button = new Button(x-x/5,y/2,500,600);

public void setup() {
  
  frameInit=new SoundFile(this,"framesoundnew.mp3");
  selectScreenMusic = new SoundFile(this,"selectScreenMusic.mp3");
  frameRate(60);
  bigFont = createFont("standardFont.otf",100);
  
  
  
  bubbleMaker3.Initialize(16,40);
  bubbleMaker2.Initialize(16,40);
  bubbleMaker.Initialize(16,40);
  largeLightning.Initialize(320,240);
  smallLightning.Initialize(160,160);
  distantLightning.Initialize(100,100);
  swordweilderspawn.Initialize(480,280);
  swordweilderidle.Initialize(480,280);
  swordweilderspinattack.Initialize(480,280);
  swordweilderdie.Initialize(480,280);
  swordweilderdartattack.Initialize(480,280);
  swordweilderdashattack.Initialize(480,280);
  swordweilderdamage.Initialize(480,280);
  swordweildermove.Initialize(480,280);
  
  photo = loadImage("background.png");
  photo.resize(width,height);
  println(frameInit.frames());
  //frameInit.jump(10.0);
  textAlign(CENTER, BOTTOM);
}

int i=0;
int i1;
int i2;
int i3;
boolean shopScreen;
boolean doneCircleAnimation;
float soundVar=0.000f; //posistion of soundtrack in seconds
boolean testboy1=false;
boolean testboy2=false;
public void draw() {
  //println(testing);
  //println(testing.charAt(0));
  
  //println(frameRate);
  //println(quickStore);




  //if(frameCount%4==0)
  if(screenState==0)
  {
    
    selectScreenMusic.pause();
    selectPlaying=false;
    frame1.reset();
    frame2.reset();
    frame3.reset();
    soundPlay=false;
    doneCircleAnimation=false;
    chooseRandomDone=false;
    backgroundDraw();
    //characterDraw(6);
    //swordweilderdamage.DisplayAnimation(800,500,6,false);
    
    
    println(swordweildermove.movePosCounter);
    if(!swordweildermove.complete)
    {
      swordweildermove.Move(800,200,600,2,true,quickStore);
    }
    if(swordweildermove.complete)
    {
      swordweilderidle.DisplayAnimation(800,600,6,false);
      
      fill(0,0,255);

      rect(100,100,100,100);
      
    }

    //isReturningOut=false;
    


    
  }
  else if (screenState==1)
  {
    //isReturningOut=true;
    
    if(i<width+200)
    {
      noStroke();
      i+=35;
      backgroundDraw();
      //println(i);
      fill(0,0,0);
      ellipse(width/2,height/2,i,i);
      swordweildermove.ResetMove();
      quickStore.Reset();
    }
    
    else
    {
      doneCircleAnimation=true;
    }
    if(doneCircleAnimation)
    {
      i=0;
      fill(255,0,0);
      rectMode(CENTER);
      stroke(255);
      strokeWeight(2);
      background(0);
      
      /*if(soundVar<frameInit.duration()-0.001)
      {
        soundVar=soundVar+(1/frameRate);
        frameInit.rate(1);
        frameInit.jump(soundVar);
      }
      */
      /*if(soundVar<frameInit.frames()-1)
      {
        soundVar++;
        println(soundVar);
      }
      */
      //println(soundVar);
      if(!soundPlay)
      {
      thread("soundThread");
      soundPlay=true;
      }
      
      //thread("musicThreadSelectScreen");
      selectScreenMusicPlay();
      if(selectScreenMusic.isPlaying()==false)
      {
        selectScreenMusic.play();
      }
      //thread("frameDrawThread");
      if(!chooseRandomDone)
      {
      thread("chooseRandom");
      }
      //int i1=(int)random(4);
      
      frame1.frameDraw(width/2,height/2,500,600,10,spriteChoose[i1],8,xFrameOffsets[i1],yFrameOffsets[i1]);
      //int i2=(int)random(4);
      frame2.frameDraw(width/5,height/2,500,600,10,spriteChoose[i2],8,xFrameOffsets[i2],yFrameOffsets[i2]);
      //int i3=(int)random(4);
      frame3.frameDraw(width-(width/5),height/2,500,600,10,spriteChoose[i3],8,xFrameOffsets[i3],yFrameOffsets[i3]);
      //frame1Button.ShowFrame();
      //frame2Button.ShowFrame();
      //frame3Button.ShowFrame();
      if(frame1Button.RightClick() || frame2Button.RightClick() || frame3Button.RightClick())
      {
        
        fill(255,0,0);
        rect(100,100,100,100);
      }
      /*if(frame1Button.LeftClick() || frame2Button.LeftClick() || frame3Button.LeftClick())
      {
        fill(0,255,0);
        rect(100,100,100,100);
        quickStore=spriteChoose[i1];
        println("SUCESS");
        screenState--;
      }
      */
      if(frame1Button.LeftClick())
      {
        quickStore=spriteChoose[i1];
        screenState--;
      }
      if(frame2Button.LeftClick())
      {
        quickStore=spriteChoose[i2];
        screenState--;
      }
      if(frame3Button.LeftClick())
      {
        quickStore=spriteChoose[i3];
        screenState--;
      }

      //characterDraw(6);
      
      
      
      
      text("Choose Your Move Wisely",width/2,150);
      

      
    }
    
    


  }
  
  






  if(testMode)
  {
  stroke(255,0,0);
  line(width,height/2,0,height/2);
  line(width/2,0,width/2,height);
  line(width/5,0,width/5,height);
  line(width-width/5,0,width-width/5,height);
  }

}
public void musicThreadSelectScreen()
{
  selectScreenMusicPlay();
}
boolean chooseRandomDone=false;
boolean selectScreenStopped=false;
public void selectScreenMusicStop()
{
  if(selectScreenStopped==false)
  {
    selectScreenMusic.stop();
    selectScreenStopped=true;

  }
}
public void chooseRandom()
{
  
  textFont(bigFont);
  i1=(int)random(5);
  i2=(int)(random(5));
  i3=(int)random(5);
  chooseRandomDone=true;
  
  
}
public void keyPressed()
{
  switch(key)
  {
  
  case 'a' :
  
    screenState++;
    break;

  case 's' :
  
    screenState--;
    break;
  
  case 't' :
    testMode=!testMode;
    break;
  
  case 'r' :
    swordweildermove.ResetMove();
    quickStore.Reset();
    screenState++;
    break;
  }
}
boolean soundPlay=false;
/*void soundThreadTest()
{
  frameInit.play();
}
*/
boolean selectPlaying=false;
public void selectScreenMusicPlay()
{
  if (selectPlaying==false)
  {
    selectScreenMusic.play();
    selectPlaying=true;
  }
  
}


public void soundThread()
{
  
  
  
  println("done");
  frameInit.play();
    
  
}

class BackgroundAnimation
{
    int frameNumberAll;
    String nameAll;
    int counter;
    BackgroundAnimation(int frameNumber, String name)
    {
        frameNumberAll=frameNumber;
        nameAll=name;
        counter=0;
    }

    PImage[] imageMatrix = new PImage[20];
    public void Initialize(int sizeX, int sizeY)
    {
        
        for(int i=0; i<frameNumberAll; i++)
        {
            PImage temp;
            temp=loadImage(nameAll+""+i+".png");
            temp.resize(sizeX,sizeY);
            imageMatrix[i]=temp;
        }
    }
    public void DisplayAnimation(int posX, int posY,int fps)
    {
        //println(counter);
        if(counter==0){image(imageMatrix[counter],posX,posY);}
        else{image(imageMatrix[counter-1],posX,posY);}
        if((float)frameCount%(float)fps==0)
        {
            if(counter<frameNumberAll)
            {
                counter++;
                //return true;
            }
            else 
            {
                counter=0;
                //return false;

            }
        }
    }
    public void DisplayStatic(int posX, int posY)
    {
        image(imageMatrix[17],posX,posY);
        
    }
    public boolean Running()
    {
        if(counter!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
class Button
{
    int localXpos;
    int localYpos;
    int localWidth;
    int localHeight;
    boolean rightClick;
    boolean leftClick;
    Button(int xPos, int yPos, int width, int height)
    {
        localXpos=xPos;
        localYpos=yPos;
        localHeight=height;
        localWidth=width;
        rightClick=false;
    }
    public void ShowFrame()
    {
        noFill();
        stroke(20);
        rectMode(CENTER);
        rect(localXpos,localYpos,localWidth,localHeight);
    }
    public boolean RightClick()
    {

        if (mousePressed && (mouseButton == RIGHT) && mouseX>(localXpos-localWidth/2) && mouseX<(localXpos+localWidth/2) && mouseY>(localYpos-localHeight/2) && mouseY<(localYpos+localHeight/2))
        {
            rightClick=true;
        }
        else
        {
            rightClick=false;
        }
        return rightClick;

    }
    public boolean LeftClick()
    {
        if (mousePressed && (mouseButton == LEFT) && mouseX>(localXpos-localWidth/2) && mouseX<(localXpos+localWidth/2) && mouseY>(localYpos-localHeight/2) && mouseY<(localYpos+localHeight/2))
        {
            leftClick=true;
        }
        else
        {
            leftClick=false;
        }
        return leftClick;
    }

}
public void characterDraw(int frameRateInput)
{
  //background(0);


  swordweilderdartattack.DisplayAnimation(200,200,frameRateInput,true);
  if(swordweilderdartattack.Done()==true)
  {
    swordweilderdie.DisplayAnimation(200,200,frameRateInput,true);
    if(swordweilderdie.Done()==true)
    {
      //swordweilderdartattack.Reset();
      swordweilderdie.Reset();
    }
    
  }
}

public void backgroundDraw()
{
  image(photo, 0, 0);
  
  if(largeLightning.Running()==false)
  {
    lightningTrigger1=(int)random(100);
    largeLightning.DisplayStatic(200,620);
  }  
  if(smallLightning.Running()==false)
  {
    lightningTrigger2=(int)random(100);
    smallLightning.DisplayStatic(1700,680);
  }

  if(distantLightning.Running()==false)
  {
    lightningTrigger3=(int)random(100);
    distantLightning.DisplayStatic(815,475);
  }
  if(bubbleMaker.Running()==false)
  {
    lightningTrigger4=(int)random(100);
    bubbleMaker.DisplayStatic(1100,800);
  }
  if(bubbleMaker2.Running()==false)
  {
    lightningTrigger5=(int)random(70);
    bubbleMaker2.DisplayStatic(1080,790);
  }
  if(bubbleMaker3.Running()==false)
  {
    lightningTrigger6=(int)random(90);
    bubbleMaker3.DisplayStatic(1120,790);
  }
    
  
  if(lightningTrigger1==1)
  {
    largeLightning.DisplayAnimation(200,620,6);
  }
  
  if(lightningTrigger2==2)
  {
    smallLightning.DisplayAnimation(1700,680,6);
  }

  if(lightningTrigger3==3)
  {
    distantLightning.DisplayAnimation(815,475,6);
  }
  
  if(lightningTrigger4==4)
  {
    bubbleMaker.DisplayAnimation(1100,800,4);
  }
  if(lightningTrigger5==5)
  {
    bubbleMaker2.DisplayAnimation(1080,790,4);
  }
  if(lightningTrigger6==6)
  {
    bubbleMaker3.DisplayAnimation(1120,790,4);
  }

}





class FrameDraw 
{
  int lengthx;
  int longy;
  boolean doneHorFirst;

  FrameDraw()
  { 
    lengthx = 0;
    longy = 0;
    doneHorFirst=false;
  }
  public void reset()
  {
    doneHorFirst=false;
    lengthx=0;
    longy=0;
  }



  public void frameDraw(int startPosX, int startPosY, int sizeX, int sizeY, int speed, SpriteAnimation quickStore, int frameRateVar, int spriteAdjustX, int spriteAdjustY)
  {
  
    

    
    
    if(lengthx<sizeX/2)
    {
      line((int)startPosX-lengthx,startPosY,(int)startPosX+lengthx,startPosY);
      lengthx+=speed;
      
    }
    else 
    {
      doneHorFirst=true;
    }
    
    if(doneHorFirst==true)
    {
      line(startPosX-lengthx,startPosY+longy,startPosX+lengthx,startPosY+longy);
      
      line(startPosX-lengthx,startPosY-longy,startPosX+lengthx,startPosY-longy);
      line(startPosX-lengthx,startPosY-longy,startPosX-lengthx,startPosY+longy);
      line(startPosX+lengthx,startPosY-longy,startPosX+lengthx,startPosY+longy);
      if(longy<sizeY/2)
      {
        longy+=speed;
      }
      else
      {
        quickStore.DisplayAnimation(startPosX+spriteAdjustX,startPosY+spriteAdjustY,frameRateVar,false);
        
        /*if(quickStore.Done())
        {
          if(quickStore.DisplayFirstFrame(startPosX+spriteAdjustX,startPosY+spriteAdjustY,100))
          {
            //delay(2000);
           quickStore.Reset();
          }
        }*/
      }
      
    }
  }
  
  
}

class SpriteAnimation
{
    int frameNumberAll;
    String nameAll;
    int counter;
    boolean finished;
    int howLongI;
    boolean howLongIBool;
    int movePos;
    int movePosCounter;
    boolean isReturning;
    boolean attacking;
    boolean delayDone;
    boolean complete;
    
    SpriteAnimation(int frameNumber, String name)
    {
        frameNumberAll=frameNumber;
        nameAll=name;
        counter=0;
        finished=false;
        howLongI=0;
        howLongIBool=false;
        movePosCounter=0;
        attacking=false;
        delayDone=false;
        complete=false;
        
    }
    
    PImage[] imageMatrix = new PImage[30];
    public void ResetMove()
    {
        movePosCounter=0;
        
        isReturningOut=false;
        isReturning=false;
        delayDone=false;
        complete=false;
    }
    public void Initialize(int sizeX, int sizeY)
    {
        for(int i=0; i<frameNumberAll; i=i+1)
        {
            PImage temp;
            temp=loadImage(nameAll+""+i+".png");
            temp.resize(sizeX,sizeY);
            imageMatrix[i]=temp;
            
        }
    }
    //work on the below method
    public boolean DisplayFirstFrame(int posX, int posY, int howLong)
    {
        if(howLongI<howLong)
        {
            image(imageMatrix[0],posX,posY);
            howLongI++;
            howLongIBool=false;
        }
        else
        {
            howLongI=0;
            howLongIBool=true;
            
        }
        return howLongIBool;
        
    }


    
    public void Move(int startX, int endX, int posY, int speed, boolean returning, SpriteAnimation using)
    {
        
        if(startX<=endX)
        {
            if(movePos<=endX && !isReturning)
            {
                this.movePosCounter+=speed;
                this.movePos=startX+movePosCounter;
            }
            else if(returning)
            {
        
                isReturning=false;
                if(!isReturning)
                {
                    attacking=true;
                    if(this.delayDone==false)
                    {
                        delay(1000);
                        this.delayDone=true;
                    }
                    using.DisplayAnimation(endX,posY,6,true);
                    
                    if(using.Done())
                    {
                        attacking=false;
                        isReturning=true;
                    }
                }
                if(movePos>=startX && isReturning)
                {
                    this.movePosCounter-=speed;
                    this.movePos=startX+movePosCounter;
                }
                if(movePos==startX && isReturning)
                {
                    this.complete=true;
                }

                

            }
        }
        else if(startX>=endX)
        {
            if(movePos>endX && !isReturning)
            {
                this.movePosCounter+=speed;
                this.movePos=startX-movePosCounter;
            }
            else if(returning)
            {
        
                isReturning=false;
                if(!isReturning)
                {
                    attacking=true;
                    if(this.delayDone==false)
                    {
                        delay(1000);
                        this.delayDone=true;
                    }
                    using.DisplayAnimation(endX,posY,6,true);
                    
                    if(using.Done())
                    {
                        attacking=false;
                        isReturning=true;
                    }
                }
                if(movePos<=startX && isReturning)
                {
                    this.movePosCounter-=speed;
                    this.movePos=startX+movePosCounter;
                }
                if(movePos==startX && isReturning)
                {
                    this.complete=true;
                }
            }
        }

        if(attacking==false)
        {
        if(counter==0){image(imageMatrix[counter],movePos,posY);}
        else{image(imageMatrix[counter-1],movePos,posY);}
        if((float)frameCount%6==0)
        {
            if(counter<frameNumberAll)
            {
                counter++;
            }
            else
            {
                counter=0;
                
            }
        }
        }
        
    }
    
    
    

    public void DisplayAnimation(int posX, int posY,int fps,boolean finishDependant)
    {
        if (finishDependant==true)
        {
            if(finished==false)
            {
                if(counter==0){image(imageMatrix[counter],posX,posY);}
                else{image(imageMatrix[counter-1],posX,posY);}
                if((float)frameCount%(float)fps==0)
                {
                    if(counter<frameNumberAll)
                    {
                        counter++;
                    }
                    else
                    {
                        counter=0;
                        finished=true;
                    }
                }
            }
        }
        else
        {
            //println(counter);
            if(counter==0){image(imageMatrix[counter],posX,posY);}
            else{image(imageMatrix[counter-1],posX,posY);}
            if((float)frameCount%(float)fps==0)
            {
                if(counter<frameNumberAll)
                {
                counter++;
                //return true;
                }
                else 
                {
                counter=0;
                
                //return false;

                }
            }
        }
    }

    public boolean Done()
    {
        return finished;
    }

    public void Reset()
    {
        finished=false;
        
        //isReturningOut=false;
    }
}
  public void settings() {  size(1920, 1080, P2D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "cardbattle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
