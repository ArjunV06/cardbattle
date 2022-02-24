import processing.sound.*;
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

void setup() {
  
  frameInit=new SoundFile(this,"framesoundnew.mp3");
  selectScreenMusic = new SoundFile(this,"selectScreenMusic.mp3");
  frameRate(60);
  bigFont = createFont("standardFont.otf",100);
  size(1920, 1080, P2D);
  
  
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
float soundVar=0.000; //posistion of soundtrack in seconds
boolean testboy1=false;
boolean testboy2=false;
void draw() {
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
void musicThreadSelectScreen()
{
  selectScreenMusicPlay();
}
boolean chooseRandomDone=false;
boolean selectScreenStopped=false;
void selectScreenMusicStop()
{
  if(selectScreenStopped==false)
  {
    selectScreenMusic.stop();
    selectScreenStopped=true;

  }
}
void chooseRandom()
{
  
  textFont(bigFont);
  i1=(int)random(5);
  i2=(int)(random(5));
  i3=(int)random(5);
  chooseRandomDone=true;
  
  
}
void keyPressed()
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
void selectScreenMusicPlay()
{
  if (selectPlaying==false)
  {
    selectScreenMusic.play();
    selectPlaying=true;
  }
  
}


void soundThread()
{
  
  
  
  println("done");
  frameInit.play();
    
  
}