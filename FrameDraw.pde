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
  void reset()
  {
    doneHorFirst=false;
    lengthx=0;
    longy=0;
  }



  void frameDraw(int startPosX, int startPosY, int sizeX, int sizeY, int speed, SpriteAnimation quickStore, int frameRateVar, int spriteAdjustX, int spriteAdjustY)
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
